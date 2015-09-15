package es.tri.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.math.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import es.mybatis.MyBatisConnectionFactory;
import es.tri.dao.TriTEjerciciosMapper;
import es.tri.dao.TriTEntrenosMapper;
import es.tri.dao.TriTiEntrenoUsuarioMapper;
import es.tri.dao.model.TriTEjercicios;
import es.tri.dao.model.TriTEntrenos;
import es.tri.dao.model.TriTEntrenosExample;
import es.tri.dao.model.TriTiEntrenoUsuario;
import es.tri.objetos.Constantes;

public class FuncionesComunesService {

	
	public static List<TriTEntrenos> cargaEntreno (List<TriTEntrenos> lista, Calendar fecha) {
		List <TriTEntrenos> listaFecha = new ArrayList <TriTEntrenos> ();
		Calendar FechaAux = Calendar.getInstance();
		for (TriTEntrenos entreno : lista){
			FechaAux.setTime(entreno.getFecha());
			
			if (FechaAux.after(fecha)){break;}
			if (FechaAux.get(Calendar.YEAR)== fecha.get(Calendar.YEAR) && FechaAux.get(Calendar.MONTH)== fecha.get(Calendar.MONTH) && FechaAux.get(Calendar.DAY_OF_MONTH)==fecha.get(Calendar.DAY_OF_MONTH)){
				listaFecha.add(entreno);
			}
			
		}
		
		return listaFecha;
		
	}
	
	public static List<String> obternerPorcentages(List<TriTEntrenos> lista){
		List <String> result = new ArrayList<>();
		int pr=0,pc=0,ps =0;
		TriTEjercicios triTEjercicios;

		
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		
		for (TriTEntrenos entreno : lista){
			SqlSession sqlSession = sqlMapper.openSession();
			
			try {
				TriTEjerciciosMapper mapper = sqlSession
						.getMapper(TriTEjerciciosMapper.class);					
					triTEjercicios= mapper.selectByPrimaryKey(entreno.getId_ejercicio());
					if (triTEjercicios.getId_tipo()==1) ps+=entreno.getDistancia();
					else if (triTEjercicios.getId_tipo()==2) pc+=entreno.getDistancia();
					else pr+=entreno.getDistancia();
					
				}
				finally {
					sqlSession.close();
				}
			}
		SqlSession sqlSession = sqlMapper.openSession();
		TriTiEntrenoUsuarioMapper mapper = sqlSession.getMapper(TriTiEntrenoUsuarioMapper.class);
		TriTiEntrenoUsuario triTiEntrenoUsuario = new TriTiEntrenoUsuario();
		triTiEntrenoUsuario= mapper.selectByPrimaryKey(lista.get(0).getId_entreno());
		
		if (triTiEntrenoUsuario.getId_tipo_entreno()==1){
			ps=ps/Constantes.DistNatSprintBase;
			pc=pc/Constantes.DistCycleSprintBase;
			pr=pr/Constantes.DistRunSprintBase;
		}
		else if (triTiEntrenoUsuario.getId_tipo_entreno()==2){
			ps=ps/Constantes.DistSwimOlimpicBase;
			pc=pc/Constantes.DistCycleOlimpicBase;
			pr=pr/Constantes.DistRunOlimpicBase ;
		}
		
		
		
		int total = pc+ps+pr;
		pc=(pc*100)/total;
		ps=(ps*100)/total;
		pr=(pr*100)/total;
		result.add(String.valueOf(ps));	
		result.add(String.valueOf(pc));	
		result.add(String.valueOf(pr));	
		sqlSession.close();
		return result;
	}
	public static double calcularPeso (List<TriTEntrenos> lista,double pesoInicial){
		double pesoAux=0;
		double retorno;
		for (TriTEntrenos entreno : lista){
			pesoAux=(entreno.getPeso()!=null)? entreno.getPeso():pesoAux;
		}
		
		if (pesoAux>0){ 
			retorno= ((pesoAux-pesoInicial) / pesoInicial)*100;
			return Math.round(retorno*Math.pow(10,1))/Math.pow(10,1);}
		else
			return 0;
	}
	
	public static double calcularFCM (List<TriTEntrenos> lista,double fcmInicial){
		double fcmAux=0;
		double retorno;
		for (TriTEntrenos entreno : lista){
			fcmAux=(entreno.getPulsaciones()!=null)? entreno.getPulsaciones():fcmAux;
		}
		
		if (fcmAux>0){ 
			retorno= ((fcmAux-fcmInicial) / fcmInicial)*100;
			return Math.round(retorno*Math.pow(10,1))/Math.pow(10,1);}
		else
			return 0;
	}
	
	public static double calcularRun (List<TriTEntrenos> lista, int opcion){
		double runAux=0;
		double metros = 0;
		int dia=0;
		double retorno=5000;
		double tipo=0;
		switch (opcion){
			case 1: tipo=100;
			case 2: tipo=20000;	
			case 3: tipo=1000;
		}
		
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		TriTEjerciciosMapper mapper = sqlSession.getMapper(TriTEjerciciosMapper.class);
		TriTEjercicios ejercicios = new TriTEjercicios();
		
		for (TriTEntrenos entreno : lista){
			ejercicios= mapper.selectByPrimaryKey(entreno.getId_ejercicio());
			dia=entreno.getDiaSemana();
			if (ejercicios.getId_tipo().equals(opcion)){
					runAux+=(entreno.getTiempo()==null)?0:entreno.getTiempo();
					metros+=(entreno.getDistancia()==null)?0:entreno.getDistancia();			
				}
			else{
				if (runAux>0 && metros>0){
					retorno=(retorno>(runAux*tipo)/metros )? (runAux*tipo)/metros:retorno;
					
				}
				runAux=0;
				metros=0;
				
			}
		}
		
			sqlSession.close();
		
		return Math.round(retorno*Math.pow(10,1))/Math.pow(10,1);
	}
	
	public static int[] rellenarArray(List<TriTEntrenos> lista, String opcion) {
		int[] retorno = {0,0,0,0,0,0,0};
		
		int dia = Integer.MAX_VALUE;
		List<Integer> valores = new ArrayList<Integer>();
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		TriTEjerciciosMapper mapper = sqlSession
				.getMapper(TriTEjerciciosMapper.class);
		TriTEjercicios ejercicios = new TriTEjercicios();

		for (TriTEntrenos entreno : lista) {
			ejercicios = mapper.selectByPrimaryKey(entreno.getId_ejercicio());
			
			if (dia != entreno.getDiaSemana()) {
				switch (opcion) {
				case "peso":
					if (entreno.getPeso() != null){
						valores.add(entreno.getPeso());
						dia = entreno.getDiaSemana();}
					break;
				case "FCM":
					if (entreno.getPulsacionesMedias() != null){
						valores.add(entreno.getPulsacionesMedias());
						dia = entreno.getDiaSemana();}
					break;
				case "FCR":
					if (entreno.getPulsaciones() != null){
						valores.add(entreno.getPulsaciones());
						dia = entreno.getDiaSemana();}
					break;
				case "run":
					if (ejercicios.getId_tipo().equals(3)) {
						if (entreno.getTiempo() != null
								&& entreno.getDistancia() != null){
							valores.add((entreno.getTiempo() * 1000)
									/ entreno.getDistancia());
							dia = entreno.getDiaSemana();}
					}
					break;

				case "swim":
					if (ejercicios.getId_tipo().equals(1)) {
						if (entreno.getTiempo() != null
								&& entreno.getDistancia() != null){
							valores.add((entreno.getTiempo() * 100)
									/ entreno.getDistancia());
							dia = entreno.getDiaSemana();}
					}
					break;
				case "cycle":
					if (ejercicios.getId_tipo().equals(2)) {
						if (entreno.getTiempo() != null
								&& entreno.getDistancia() != null){
							valores.add((entreno.getTiempo() * 1000)
									/ entreno.getDistancia());
							dia = entreno.getDiaSemana();}
					}
					break;
				}
			}
			
		}
		for (int i = 0; i < 7; i++) {
			if (valores.size()>i)
				retorno[i] = valores.get((valores.size() - 1) - i);
			else
				retorno[i] = 0;
		}
		sqlSession.close();
		return retorno;

	}
	
	public static int[] calcularEstadisticaEntrenos (){
		Calendar today = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		Calendar fecha = Calendar.getInstance();;
		Calendar fechaInicio = Calendar.getInstance();
		Calendar fechaFin = Calendar.getInstance();
		List<Integer> valores = new ArrayList<Integer>();
		int[] retorno = {0,0,0,0,0,0,0,0,0,0,0,0};
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		TriTEntrenosMapper mapper = sqlSession.getMapper(TriTEntrenosMapper.class);
		List<TriTEntrenos> ejercicios;
		TriTEntrenosExample	entrenosExample = new TriTEntrenosExample();
		try{
			for (int i=-5;i<7;i++){
				today = Calendar.getInstance();
				today.add(Calendar.MONTH, i);
				int dia = Integer.MAX_VALUE;
				
				fechaInicio.set(today.get(Calendar.YEAR),today.get(Calendar.MONTH) , today.getActualMinimum(Calendar.DAY_OF_MONTH));
				fechaFin.set(today.get(Calendar.YEAR),today.get(Calendar.MONTH) , today.getActualMaximum(Calendar.DAY_OF_MONTH),today.getMinimum(Calendar.HOUR_OF_DAY),today.getMinimum(Calendar.MINUTE),today.getMinimum(Calendar.SECOND));
				entrenosExample.createCriteria().andFecha_bajaIsNull();
				mapper = sqlSession.getMapper(TriTEntrenosMapper.class);
				ejercicios=mapper.selectByExample(entrenosExample);
				//se hace mediante código por que MyBatis tiene un Bug con la utilización de fechas calculadas.
				int contador=0;
				for (TriTEntrenos triTEntrenos : ejercicios) {
					if (dia != triTEntrenos.getDiaSemana()) {
						if (fechaInicio.getTime().before(triTEntrenos.getFecha()) && fechaFin.getTime().after(triTEntrenos.getFecha()))
							contador++;
							dia= triTEntrenos.getDiaSemana();
						}
					}
				valores.add(contador);
			}
		
			for (int i = 0; i < 12; i++) {
				retorno[i]=valores.get(i);
			}
			return retorno;
		}
		finally{
			sqlSession.close();
		}
	}
	
	public static String[] calcularMesesEntrenos (){
		List<String> valores = new ArrayList<String>();
		String[] retorno = {"0","0","0","0","0","0","0","0","0","0","0","0"};
		Calendar today ;
		for (int i=-5;i<7;i++){
			today = Calendar.getInstance();
			today.add(Calendar.MONTH, i);
			/*switch(today.get(Calendar.MONTH)){
			case 0: valores.add("January");break;
			case 1: valores.add("February");break;
			case 2: valores.add("March");break;
			case 3: valores.add("April");break;
			case 4: valores.add("May");break;
			case 5: valores.add("June");break;
			case 6: valores.add("July");break;
			case 7: valores.add("August");break;
			case 8: valores.add("September");break;
			case 9: valores.add("October");break;
			case 10: valores.add("November");break;
			case 11: valores.add("December");break;
			
			}*/
			valores.add(String.valueOf(today.get(Calendar.MONTH)+1));
		}
		
		for (int i = 0; i < 12; i++) {
			retorno[i]=valores.get(i);
		}
		return retorno;
	}
	public static boolean calculoProgreso(int idUsuario, int idEntreno){
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		boolean relanzar=false;
		double progresoSwim=0.0,progresoCycle=0.0,progresoRun=0.0;
		TriTEntrenos entreno = new TriTEntrenos();
		
		int dSwim=0,dCycle=0,dRun=0,tSwim=0,tCycle=0,tRun=0,swimD=0,cycleD=0,runD=0;
		try{
			TriTEjerciciosMapper ejerciciosMapper=sqlSession.getMapper(TriTEjerciciosMapper.class);
		TriTEntrenosMapper entrenoMapper = sqlSession.getMapper(TriTEntrenosMapper.class);
		TriTEntrenosExample entrenosExample= new TriTEntrenosExample();
		entrenosExample.createCriteria().andId_ejercicioBetween(28, 32).andId_entrenoEqualTo(idEntreno).andTiempoIsNotNull();
		entrenosExample.setOrderByClause("Fecha");
		List<TriTEntrenos> triTEntrenos = entrenoMapper.selectByExample(entrenosExample);
		
		TriTiEntrenoUsuarioMapper entrenoUsuarioMapper = sqlSession.getMapper(TriTiEntrenoUsuarioMapper.class);
		TriTiEntrenoUsuario entrenoUsuarios = entrenoUsuarioMapper.selectByPrimaryKey(idEntreno);
		switch (entrenoUsuarios.getId_tipo_entreno()){
		case 1:
			dSwim=750;
			dCycle=20000;
			dRun=5000;
			break;
		case 2:
			dSwim=1500;
			dCycle=40000;
			dRun=10000;
			break;
		case 3:
			dSwim=1900;
			dCycle=90000;
			dRun=21000;
			break;
		}
		for (int i=1;i<=3;i++){
		    entreno  =triTEntrenos.get(triTEntrenos.size()-i);
			switch (ejerciciosMapper.selectByPrimaryKey(entreno.getId_ejercicio()).getId_tipo()){
			case 1:
				tSwim=entreno.getTiempo();
				swimD=entreno.getDistancia();
				progresoSwim= 100- ((entreno.getDistancia()/entreno.getTiempo())*100/(dSwim/entrenoUsuarios.getTiempoSwim()));
				break;
			case 2:
				cycleD=entreno.getDistancia();
				tCycle=entreno.getTiempo();
				progresoCycle= 100- ((entreno.getDistancia()/entreno.getTiempo())*100/(dCycle/entrenoUsuarios.getTiempoCycle()));
				break;
			case 3:
				runD=entreno.getDistancia();
				tRun=entreno.getTiempo();
				progresoRun= 100- ((entreno.getDistancia()/entreno.getTiempo())*100/(dRun/entrenoUsuarios.getTiempoRun()));
				break;
				
			}
		}
		if (5.0>((progresoSwim+progresoCycle+progresoRun)/3)){
			TriTiEntrenoUsuario entrenoUsuario = new TriTiEntrenoUsuario();
			entrenoUsuario.setTiempoCycle((dCycle*tCycle)/cycleD);
			entrenoUsuario.setTiempoRun((dRun*tRun)/runD);
			entrenoUsuario.setTiempoSwim((dSwim*tSwim)/swimD);
			entrenoUsuario.setId_entreno(idEntreno);
			entrenoUsuario.setId_usuario(idUsuario);
			entrenoUsuario.setId_tipo_entreno(entrenoUsuarios.getId_tipo_entreno());
			entrenoUsuarioMapper.updateByPrimaryKey(entrenoUsuario);
			sqlSession.commit();
			return true;
		}
		else if(((progresoSwim+progresoCycle+progresoRun)/3)>5.0){
			TriTiEntrenoUsuario entrenoUsuario = new TriTiEntrenoUsuario();
			entrenoUsuario.setTiempoCycle((dCycle*tCycle)/cycleD);
			entrenoUsuario.setTiempoRun((dRun*tRun)/runD);
			entrenoUsuario.setTiempoSwim((dSwim*tSwim)/swimD);
			entrenoUsuario.setId_entreno(idEntreno);
			entrenoUsuario.setId_usuario(idUsuario);
			entrenoUsuario.setId_tipo_entreno(entrenoUsuarios.getId_tipo_entreno());
			entrenoUsuarioMapper.updateByPrimaryKey(entrenoUsuario);
			sqlSession.commit();
			return true;
		}
		else{
			TriTiEntrenoUsuario entrenoUsuario = new TriTiEntrenoUsuario();
			entrenoUsuario.setTiempoCycle((dCycle*tCycle)/cycleD);
			entrenoUsuario.setTiempoRun((dRun*tRun)/runD);
			entrenoUsuario.setTiempoSwim((dSwim*tSwim)/swimD);
			entrenoUsuario.setId_entreno(idEntreno);
			entrenoUsuario.setId_usuario(idUsuario);
			entrenoUsuario.setId_tipo_entreno(entrenoUsuarios.getId_tipo_entreno());
			entrenoUsuarioMapper.updateByPrimaryKey(entrenoUsuario);
			sqlSession.commit();
			return false;
			}
		}
		finally{
			sqlSession.close();
		}
		
		
	}
	
	
}
