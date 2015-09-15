package es.tri.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.catalina.Session;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import es.mybatis.MyBatisConnectionFactory;
import es.tri.dao.TriTEjerciciosMapper;
import es.tri.dao.TriTEntrenosMapper;
import es.tri.dao.TriTHistoricoMapper;
import es.tri.dao.TriTTestMapper;
import es.tri.dao.TriTiEntrenoUsuarioMapper;
import es.tri.dao.model.TriTEjercicios;
import es.tri.dao.model.TriTEntrenos;
import es.tri.dao.model.TriTEntrenosExample;
import es.tri.dao.model.TriTHistorico;
import es.tri.dao.model.TriTHistoricoExample;
import es.tri.dao.model.TriTTest;
import es.tri.dao.model.TriTTestExample;
import es.tri.dao.model.TriTUsuarios;
import es.tri.dao.model.TriTiEntrenoUsuario;
import es.tri.dao.model.TriTiEntrenoUsuarioExample;
import es.tri.objetos.Entrenamiento;
import es.tri.services.FuncionesComunesService;
import es.tri.services.NuevoEntrenoService;

public class GuardarAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pulsaciones;
	private Integer tiempo;
	private Integer sensation;
	private Integer conseguido;
	private Integer Weight; 
	private Date	fecha,fechaA,fechaH,fechaM;
	private Integer AvHR;

	
	private List <Entrenamiento> entrenamientoAyer, entrenamientoHoy, entrenamientoMayana;
	private Integer id_entreno_ejercicioManyana, id_entreno_ejercicioHoy, id_entreno_ejercicioAyer;
	



	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	public String execute() {
		Integer peso = getPeso();
		Integer pulsaciones = getPulsaciones();
		Integer tiempo  = getTiempo() ;
		Integer sensation  = getSensation();
		Integer conseguido  = getConseguido();
		Integer id_entreno_ejercicioManyana = getId_entreno_ejercicioManyana();
		Integer id_entreno_ejercicioHoy = getId_entreno_ejercicioHoy();
		Integer id_entreno_ejercicioAyer = getId_entreno_ejercicioAyer();
		Integer AvHR = getAvHR();
		Date fecha=  getFecha();
		Boolean redirect =false;
		
		
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		Integer idEntreno;
		if (id_entreno_ejercicioManyana==null) {
			if (id_entreno_ejercicioHoy==null){
				idEntreno = id_entreno_ejercicioAyer;
				
			}
			else {
				idEntreno = id_entreno_ejercicioHoy;
			    }
		}
		else{
			idEntreno = id_entreno_ejercicioManyana;
			
		}
		
	
		try {
			//Para guardarlo en la tabla de entrenos
			TriTEntrenosMapper mapper = sqlSession
					.getMapper(TriTEntrenosMapper.class);
			TriTEntrenosExample triTEntrenosExample = new TriTEntrenosExample();
			triTEntrenosExample.createCriteria().andFechaEqualTo(fecha);
			TriTEntrenos entreno = new TriTEntrenos();
			entreno.setPulsaciones(pulsaciones);
			entreno.setConseguido(conseguido);
			entreno.setSensacion(sensation);
			entreno.setTiempo(tiempo);
			entreno.setPeso(peso);
			entreno.setId_entreno_ejercicio(idEntreno);
			entreno.setFecha(fecha); 
			entreno.setPulsacionesMedias(AvHR);
			
			//Para guardarlo en la tabla de test
			
			TriTTestMapper mapperTest = sqlSession
					.getMapper(TriTTestMapper.class);
			TriTTestExample triTTestExample = new TriTTestExample();
			triTTestExample.createCriteria().andId_entreno_ejercicioEqualTo(idEntreno);
			TriTTest test = new TriTTest();
			
			TriTEntrenosMapper entrenoMapper = sqlSession.getMapper(TriTEntrenosMapper.class);
			
			TriTEntrenos entrenoAux= entrenoMapper.selectByPrimaryKey(idEntreno);
			if (entrenoAux.getId_ejercicio()>28 && entrenoAux.getId_ejercicio()<32){
				test.setFCMax(pulsaciones);
				test.setId_entreno_ejercicio(idEntreno);
				test.setTiempo(tiempo);
				test.setFCMedia(AvHR);
				test.setIdEntreno(entrenoAux.getId_entreno());
				TriTEjerciciosMapper ejerciciosMapper = sqlSession.getMapper(TriTEjerciciosMapper.class);
				TriTEjercicios ejercicioAux= ejerciciosMapper.selectByPrimaryKey(entrenoAux.getId_ejercicio());
				test.setId_tipo_test(ejercicioAux.getId_tipo());
				mapperTest.insert(test);
					
			}
			TriTiEntrenoUsuarioMapper mapperUser = sqlSession.getMapper(TriTiEntrenoUsuarioMapper.class);
			TriTiEntrenoUsuario triTEntrenoUsuario = mapperUser.selectByPrimaryKey(entrenoAux.getId_entreno());
			int result = mapper.updateByPrimaryKeySelective(entreno);
			sqlSession.commit();
			redirect = (entrenoAux.getId_ejercicio()==30)?FuncionesComunesService.calculoProgreso(triTEntrenoUsuario.getId_usuario(), entrenoAux.getId_entreno()):false;
			if (result > 0) {
				TriTHistoricoMapper mapperH = sqlSession.getMapper(TriTHistoricoMapper.class);
				TriTHistoricoExample HistorticoExample = new TriTHistoricoExample();
				TriTHistorico historico = new TriTHistorico();
				historico.setDescripcion("Training "+ entreno.getId_entreno()+" has been updated with: Conseguido =" + entreno.getConseguido() +" Sensation = " +entreno.getSensacion() + ".");
				mapperH.insert(historico);
				sqlSession.commit();
				if (redirect) {
					//return "redireccion";
					
					sqlSession = sqlMapper.openSession();					
					mapperUser = sqlSession.getMapper(TriTiEntrenoUsuarioMapper.class);

					
					
					TriTEntrenosExample entrenosExample= new TriTEntrenosExample();
					entrenosExample.createCriteria().andId_entreno_ejercicioEqualTo(idEntreno);
					entrenosExample.setOrderByClause("Fecha");
					List<TriTEntrenos> triTEntrenos = entrenoMapper.selectByExample(entrenosExample);
					entrenoAux= triTEntrenos.get(0);
					
					triTEntrenoUsuario = mapperUser.selectByPrimaryKey(entrenoAux.getId_entreno());
					
					entrenosExample= new TriTEntrenosExample();
					entrenosExample.createCriteria().andId_entrenoEqualTo(entrenoAux.getId_entreno());
					entrenosExample.setOrderByClause("Fecha");
					List<TriTEntrenos> triTEntrenosTotal = entrenoMapper.selectByExample(entrenosExample);
					Calendar fechaFin  = Calendar.getInstance() ;
					Calendar fechaIni = Calendar.getInstance();
					fechaFin.setTime(triTEntrenosTotal.get(triTEntrenosTotal.size()-1).getFecha());
					
					int weekFin = fechaFin.get(Calendar.WEEK_OF_YEAR);
					int weekIni = fechaIni.get(Calendar.WEEK_OF_YEAR);
					int semanas = Math.abs( weekFin - weekIni);
					
					NuevoEntrenoService.regenarEntreno(triTEntrenoUsuario,triTEntrenosTotal.get(0),semanas);
					
					sqlSession.commit();
					return "success";
				}
				else
					return "success";
			} else
				return "error";
		}
		finally{
			sqlSession.close();
		}
		
	}
	

	public Date getFechaA() {
		return fechaA;
	}


	public void setFechaA(Date fechaA) {
		this.fechaA = fechaA;
	}


	public Date getFechaH() {
		return fechaH;
	}


	public void setFechaH(Date fechaH) {
		this.fechaH = fechaH;
	}


	public Date getFechaM() {
		return fechaM;
	}


	public void setFechaM(Date fechaM) {
		this.fechaM = fechaM;
	}


	public Integer getAvHR() {
		return AvHR;
	}


	public void setAvHR(Integer avHR) {
		AvHR = avHR;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Integer getPeso() {
		return Weight;
	}


	public void setPeso(Integer peso) {
		this.Weight = peso;
	}


	public Integer getId_entreno_ejercicioAyer() {
		return id_entreno_ejercicioAyer;
	}
	public void setId_entreno_ejercicioAyer(Integer id_entreno_ejercicioAyer) {
		this.id_entreno_ejercicioAyer = id_entreno_ejercicioAyer;
	}
	public Integer getId_entreno_ejercicioHoy() {
		return id_entreno_ejercicioHoy;
	}
	public void setId_entreno_ejercicioHoy(Integer id_entreno_ejercicioHoy) {
		this.id_entreno_ejercicioHoy = id_entreno_ejercicioHoy;
	}
	public Integer getId_entreno_ejercicioManyana() {
		return id_entreno_ejercicioManyana;
	}
	public void setId_entreno_ejercicioManyana(Integer id_entreno_ejercicioManyana) {
		this.id_entreno_ejercicioManyana = id_entreno_ejercicioManyana;
	}
	public Integer getPulsaciones() {
		return pulsaciones;
	}
	public void setPulsaciones(Integer pulsaciones) {
		this.pulsaciones = pulsaciones;
	}
	public Integer getTiempo() {
		return tiempo;
	}
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}
	public Integer getSensation() {
		return sensation;
	}
	public void setSensation(Integer sensation) {
		this.sensation = sensation;
	}
	public Integer getConseguido() {
		return conseguido;
	}
	public void setConseguido(Integer conseguido) {
		this.conseguido = conseguido;
	}
	public List<Entrenamiento> getEntrenamientoAyer() {
		return entrenamientoAyer;
	}
	public void setEntrenamientoAyer(List<Entrenamiento> entrenamientoAyer) {
		this.entrenamientoAyer = entrenamientoAyer;
	}
	public List<Entrenamiento> getEntrenamientoHoy() {
		return entrenamientoHoy;
	}
	public void setEntrenamientoHoy(List<Entrenamiento> entrenamientoHoy) {
		this.entrenamientoHoy = entrenamientoHoy;
	}
	public List<Entrenamiento> getEntrenamientoMayana() {
		return entrenamientoMayana;
	}
	public void setEntrenamientoMayana(List<Entrenamiento> entrenamientoMayana) {
		this.entrenamientoMayana = entrenamientoMayana;
	}
	

}
