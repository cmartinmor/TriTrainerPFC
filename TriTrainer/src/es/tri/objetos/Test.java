package es.tri.objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import es.mybatis.MyBatisConnectionFactory;
import es.tri.dao.TriTEjerciciosMapper;
import es.tri.dao.TriTEntrenosMapper;
import es.tri.dao.TriTTestMapper;
import es.tri.dao.TriTTipoEjercicioMapper;
import es.tri.dao.model.TriTEjercicios;
import es.tri.dao.model.TriTEjerciciosExample;
import es.tri.dao.model.TriTEntrenos;
import es.tri.dao.model.TriTEntrenosExample;
import es.tri.dao.model.TriTTest;
import es.tri.dao.model.TriTTestExample;
import es.tri.dao.model.TriTTipoEjercicio;

public class Test {
	 	private Integer tiempo;

	    private Integer id_entreno;

	    private Integer FCMax;
	    
	    private Integer id_entreno_ejercicio;
	    
	    private Date fecha;
	    
	    private Integer distancia;
	    
	    private String tipoEjercicio;

		public String getTipoEjercicio() {
			return tipoEjercicio;
		}

		public void setTipoEjercicio(String tipoEjercicio) {
			this.tipoEjercicio = tipoEjercicio;
		}

		public Integer getDistancia() {
			return distancia;
		}

		public void setDistancia(Integer distancia) {
			this.distancia = distancia;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public Integer getTiempo() {
			return tiempo;
		}

		public void setTiempo(Integer tiempo) {
			this.tiempo = tiempo;
		}

		public Integer getId_entreno() {
			return id_entreno;
		}

		public void setId_entreno(Integer id_entreno) {
			this.id_entreno = id_entreno;
		}

		public Integer getFCMax() {
			return FCMax;
		}

		public void setFCMax(Integer fCMax) {
			FCMax = fCMax;
		}

		public Integer getId_entreno_ejercicio() {
			return id_entreno_ejercicio;
		}

		public void setId_entreno_ejercicio(Integer id_entreno_ejercicio) {
			this.id_entreno_ejercicio = id_entreno_ejercicio;
		}
	    
		  public static List<Test> setTest (List<TriTTest> test){
				
				List<Test> entrenamiento = new ArrayList<Test> ();
				Test testAux;
				
				SqlSessionFactory sqlMapper = MyBatisConnectionFactory
						.getSqlSessionFactory();
				TriTTestExample	TestExample	= new TriTTestExample();
				TestExample	= new TriTTestExample();
				TriTEntrenos triTEntrenos;
				TriTEjercicios ejercicios;
				TriTEntrenosExample entrenoExample= new TriTEntrenosExample();
				TriTTipoEjercicio tipoEjercicio;
				
				
				for (TriTTest lista : test){
					SqlSession sqlSession = sqlMapper.openSession();
					
					try {
						
						TriTEntrenosMapper entrenosMapper = sqlSession.getMapper(TriTEntrenosMapper.class);
						triTEntrenos = entrenosMapper.selectByPrimaryKey(lista.getId_entreno_ejercicio());	
						
						TriTEjerciciosMapper ejerciciosMapper = sqlSession.getMapper(TriTEjerciciosMapper.class);
						ejercicios = ejerciciosMapper.selectByPrimaryKey(triTEntrenos.getId_ejercicio());	
						
						TriTTipoEjercicioMapper ejercicioMapperTipoEjercicioMapper  = sqlSession.getMapper(TriTTipoEjercicioMapper.class);
						tipoEjercicio=ejercicioMapperTipoEjercicioMapper.selectByPrimaryKey(ejercicios.getId_tipo());
						
					}
				    finally {
					sqlSession.close();
					}
					testAux = new Test();
					testAux.setFCMax(lista.getFCMax());
					testAux.setId_entreno(lista.getIdEntreno());
					testAux.setId_entreno_ejercicio(lista.getId_entreno_ejercicio());
					testAux.setTiempo(lista.getTiempo());
					testAux.setFecha(triTEntrenos.getFecha());
					testAux.setDistancia(triTEntrenos.getDistancia());
					testAux.setTipoEjercicio(tipoEjercicio.getDescripcion());
					entrenamiento.add(testAux);
				}
				
				return entrenamiento;
				
			}
}