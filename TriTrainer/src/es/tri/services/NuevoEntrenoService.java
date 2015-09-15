package es.tri.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import es.mybatis.MyBatisConnectionFactory;
import es.tri.dao.TriTBioUsuarioMapper;
import es.tri.dao.TriTEjerciciosMapper;
import es.tri.dao.TriTEntrenosMapper;
import es.tri.dao.TriTHistoricoMapper;
import es.tri.dao.TriTModeloconocimientoMapper;
import es.tri.dao.TriTTestMapper;
import es.tri.dao.TriTiEntrenoUsuarioMapper;
import es.tri.dao.model.TriTBioUsuarioExample;
import es.tri.dao.model.TriTEjercicios;
import es.tri.dao.model.TriTEjerciciosExample;
import es.tri.dao.model.TriTEntrenos;
import es.tri.dao.model.TriTEntrenosExample;
import es.tri.dao.model.TriTHistorico;
import es.tri.dao.model.TriTHistoricoExample;
import es.tri.dao.model.TriTModeloconocimiento;
import es.tri.dao.model.TriTModeloconocimientoExample;
import es.tri.dao.model.TriTTest;
import es.tri.dao.model.TriTTestExample;
import es.tri.dao.model.TriTiEntrenoUsuario;
import es.tri.dao.model.TriTiEntrenoUsuarioExample;
import es.tri.objetos.Constantes;

public class NuevoEntrenoService {

	public static Boolean tieneEntrenos(Integer idUser) {
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		try {

			TriTiEntrenoUsuarioMapper mapper = sqlSession
					.getMapper(TriTiEntrenoUsuarioMapper.class);

			TriTiEntrenoUsuarioExample usuarioEntrenoExample = new TriTiEntrenoUsuarioExample();
			usuarioEntrenoExample.createCriteria().andId_usuarioEqualTo(idUser).andFecha_bajaIsNull();
			
			if (mapper.selectByExample(usuarioEntrenoExample).size() > 0)
				return true;
			else
				return false;
		} finally {
			sqlSession.close();
		}

	}

	public static int dameSeriesSwim(TriTModeloconocimiento modeloConocimiento) {
		if (modeloConocimiento.getBoolFuerza() != null) {
			if (modeloConocimiento.getBoolFuerza() == 1) {
				return 200;
			}
			if (modeloConocimiento.getBoolVelocidad() == 1) {
				return 50;
			}
			if (modeloConocimiento.getBoolRitmo() == 1) {
				return 500;
			}
		}
		return 100;

	}

	public static int dameSeriesRun(TriTModeloconocimiento modeloConocimiento) {
		if (modeloConocimiento.getBoolFuerza() != null) {
			if (modeloConocimiento.getBoolFuerza() == 1) {
				return 800;
			}
			if (modeloConocimiento.getBoolVelocidad() == 1) {
				return 400;
			}
			if (modeloConocimiento.getBoolRitmo() == 1) {
				return 1000;
			}
		}
		return 600;

	}

	public static int dameSeriesCycle(TriTModeloconocimiento modeloConocimiento) {

		if (modeloConocimiento.getBoolFuerza() != null) {
			if (modeloConocimiento.getBoolFuerza() == 1) {
				return 2000;
			}
			if (modeloConocimiento.getBoolVelocidad() == 1) {
				return 1000;
			}
			if (modeloConocimiento.getBoolRitmo() == 1) {
				return 5000;
			}
		}
		return 1000;

	}

	public static int dameDistancia(int distaciaRunTemp, int size,
			int diferencia, int medida) {

		if ((distaciaRunTemp / Math.min(3, size)) % medida > (diferencia))

			return (distaciaRunTemp / Math.min(3, size))
					+ (100 - ((distaciaRunTemp / Math.min(3, size)) % medida));
		else
			return (distaciaRunTemp / Math.min(3, size))
					- ((distaciaRunTemp / Math.min(3, size)) % medida);

	}

	public static int dameRepeticiones(int distaciaRunTemp, int size,
			int diferencia) {

		return (distaciaRunTemp / size)
				+ ((distaciaRunTemp % size > diferencia) ? 1 : 0);
	}

	public static int idEntreno(Integer idUser) {
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		try {

			TriTiEntrenoUsuarioMapper mapper = sqlSession
					.getMapper(TriTiEntrenoUsuarioMapper.class);

			TriTiEntrenoUsuarioExample usuarioEntrenoExample = new TriTiEntrenoUsuarioExample();
			usuarioEntrenoExample.createCriteria().andId_usuarioEqualTo(idUser)
					.andFecha_bajaIsNull();

			TriTiEntrenoUsuario entrenoUsuario = mapper.selectByExample(
					usuarioEntrenoExample).get(0);
			if (entrenoUsuario.getId_entreno() > 0)
				return entrenoUsuario.getId_entreno();
			else
				return 0;
		} finally {
			sqlSession.close();
		}

	}

	public static void darBajaEntrenosPrevios(Integer idUser) {
		TriTiEntrenoUsuario triTiEntrenoUsuario;

		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		try {

			TriTiEntrenoUsuarioMapper mapper = sqlSession
					.getMapper(TriTiEntrenoUsuarioMapper.class);

			TriTiEntrenoUsuarioExample usuarioEntrenoExample = new TriTiEntrenoUsuarioExample();
			usuarioEntrenoExample.createCriteria().andId_usuarioEqualTo(idUser)
					.andFecha_bajaIsNull();

			for (int i = 0; i < mapper.selectByExample(usuarioEntrenoExample)
					.size(); i++) {
				triTiEntrenoUsuario = mapper.selectByExample(
						usuarioEntrenoExample).get(i);

				triTiEntrenoUsuario.setFecha_baja(Calendar.getInstance()
						.getTime());
				mapper.updateByPrimaryKey(triTiEntrenoUsuario);
				TriTHistoricoMapper mapperH = sqlSession
						.getMapper(TriTHistoricoMapper.class);
				TriTHistoricoExample HistorticoExample = new TriTHistoricoExample();
				TriTHistorico historico = new TriTHistorico();
				historico.setDescripcion("User "
						+ triTiEntrenoUsuario.getId_usuario()
						+ " has deleted the training"
						+ triTiEntrenoUsuario.getId_entreno() + ".");
				mapperH.insert(historico);
			}
			sqlSession.commit();

		} finally {
			sqlSession.close();
		}

	}

	public static int dameNiveles(Integer minutos, Integer distance) {
		int minimo = 0;
		int pAdaptacion = 0;
		int minAmateur = 0, minMedio = 0, minPro = 0;
		switch (distance) {
		case 1:
			minAmateur = Constantes.mASprint;
			minMedio = Constantes.mMSprint;
			minPro = Constantes.mpSprint;
			break;
		case 2:
			minAmateur = Constantes.mAOlimpic;
			minMedio = Constantes.mMOlimpic;
			minPro = Constantes.mpOlimpic;
			break;
		case 3:
			minAmateur = Constantes.mAHalf;
			minMedio = Constantes.mMHalf;
			minPro = Constantes.mpHalf;
			break;
		}

		minimo = Math.min(
				Math.abs(minutos - minAmateur),
				Math.min(Math.abs(minutos - minMedio),
						Math.abs(minutos - minPro)));

		if (minutos >= minAmateur) {
			pAdaptacion = 20;

		}

		else if (Math.abs(minutos - minAmateur) < Math.abs(minutos - minMedio)) {
			pAdaptacion = (int) (Constantes.pAmateur + ((minimo * 0.2) / (minAmateur - minMedio)));

		} else if (Math.abs(minutos - minAmateur) > Math
				.abs(minutos - minMedio)
				&& Math.abs(minutos - minMedio) < Math.abs(minutos - minPro)
				&& (Math.abs(minutos - minAmateur) < Math.abs(minutos - minPro))) {
			pAdaptacion = (int) (Constantes.pMedio + ((minimo * 0.1) / (minAmateur - minMedio)));

		} else if (Math.abs(minutos - minAmateur) > Math
				.abs(minutos - minMedio)
				&& Math.abs(minutos - minMedio) < Math.abs(minutos - minPro)
				&& Math.abs(minutos - minAmateur) > Math.abs(minutos - minPro)) {
			pAdaptacion = (int) (Constantes.pMedio + ((minimo * 0.1) / (minMedio - minPro)));

		} else if (minutos == minMedio) {
			pAdaptacion = 10;

		} else if (Math.abs(minutos - minPro) < Math.abs(minutos - minMedio)) {
			pAdaptacion = (int) (Constantes.pPro + ((minimo) / (minMedio - minPro)));

		} else if (minutos <= minPro) {
			pAdaptacion = 0;

		}
		return pAdaptacion;

	}

	public static void entrenoAdaptacion(int semanas, int distance,
			int idEntreno, Calendar FechaInicio) {
		// TODO Auto-generated method stub
		List<TriTEjercicios> listaEjerciciosNatacion, listaTestNatacion = new ArrayList<TriTEjercicios>();
		List<TriTEjercicios> listaEjerciciosRunning, listaTestRunning = new ArrayList<TriTEjercicios>();
		List<TriTEjercicios> listaEjerciciosCycle, listaTestCycle = new ArrayList<TriTEjercicios>();
		Calendar fechaEjercicio = FechaInicio;
		int distaciaRun = 0, distaciaSwim = 0, distaciaCycle = 0;
		TriTEjercicios ejercicio = new TriTEjercicios();
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		Random rn = new Random();
		try {
			switch (distance) {
			case 1:
				distaciaRun = Constantes.DistRunSprintBase;
				distaciaCycle = Constantes.DistCycleSprintBase;
				distaciaSwim = Constantes.DistNatSprintBase;
				break;

			case 2:
				distaciaRun = Constantes.DistRunOlimpicBase;
				distaciaCycle = Constantes.DistCycleOlimpicBase;
				distaciaSwim = Constantes.DistSwimOlimpicBase;
				break;
			case 3:
				distaciaRun = Constantes.DistRunHalfcBase;
				distaciaCycle = Constantes.DistCycleHalfBase;
				distaciaSwim = Constantes.DistSwimHalfcBase;
				break;
			}

			for (int i = 0; i < semanas; i++) {
				// cada semana
				listaEjerciciosNatacion = DameEjercicios(1, 1);
				listaEjerciciosCycle = DameEjercicios(1, 2);
				listaEjerciciosRunning = DameEjercicios(1, 3);
				int diaSemana = 0;

				for (int j = 0; j < 2; j++) {
					// cada dia de la semana

					// Natacion
					if (listaEjerciciosNatacion.size() == 0) {
						listaEjerciciosNatacion = DameEjercicios(1, 1);
					}
					TriTEntrenosMapper mapper = sqlSession
							.getMapper(TriTEntrenosMapper.class);
					TriTEntrenosExample entrenoExample = new TriTEntrenosExample();

					TriTEntrenos entreno = new TriTEntrenos();

					if (i + 1 == semanas && j + 1 == 2) {
						// si es la ultima semana y los tres ultimos dias se
						// añade un test para ver calcular la base del
						// entrenamientos
						listaTestNatacion = DameEjerciciosTest(4, 1);
						entreno.setId_entreno(idEntreno);
						entreno.setDiaSemana(diaSemana);
						entreno.setSemana(i);
						entreno.setFecha(fechaEjercicio.getTime());
						entreno.setDistancia(distaciaSwim);
						entreno.setIntensidad(1);
						ejercicio = listaTestNatacion.get(0);
						entreno.setId_ejercicio(ejercicio.getId_ejercicio());
						entreno.setSeries(0);
						entreno.setRepeticiones(1);
						mapper.insert(entreno);
					} else {
						for (int h = 0; h < 6; h++) {
							entreno.setId_entreno(idEntreno);
							entreno.setDiaSemana(diaSemana);
							entreno.setSemana(i);
							entreno.setFecha(fechaEjercicio.getTime());
							entreno.setDistancia(distaciaSwim / 6);
							entreno.setIntensidad(1);
							ejercicio = listaEjerciciosNatacion.get(rn
									.nextInt(listaEjerciciosNatacion.size()));
							entreno.setId_ejercicio(ejercicio.getId_ejercicio());
							listaEjerciciosNatacion.remove(ejercicio);
							entreno.setSeries((ejercicio.getEnSeries() == 1) ? 100
									: 0);
							entreno.setRepeticiones((ejercicio.getEnSeries() == 1) ? (distaciaSwim / 6) / 100
									: 1);
							mapper.insert(entreno);
							if (listaEjerciciosNatacion.size() == 0) {
								listaEjerciciosNatacion = DameEjercicios(1, 1);
							}
						}
					}
					diaSemana++;
					fechaEjercicio.add(Calendar.DATE, 1);
					// RUNNING
					if (listaEjerciciosRunning.size() == 0) {
						listaEjerciciosRunning = DameEjercicios(1, 3);
					}

					if (i + 1 == semanas && j + 1 == 2) {
						// si es la ultima semana y los tres ultimos dias se
						// añade un test para ver calcular la base del
						// entrenamientos
						listaTestRunning = DameEjerciciosTest(4, 3);
						entreno.setId_entreno(idEntreno);
						entreno.setDiaSemana(diaSemana);
						entreno.setSemana(i);
						entreno.setFecha(fechaEjercicio.getTime());
						entreno.setDistancia(distaciaRun);
						entreno.setIntensidad(1);
						ejercicio = listaTestRunning.get(0);
						entreno.setId_ejercicio(ejercicio.getId_ejercicio());
						entreno.setSeries(0);
						entreno.setRepeticiones(1);
						mapper.insert(entreno);
					} else {
						entreno = new TriTEntrenos();
						for (int h = 0; h < 3; h++) {

							entreno.setId_entreno(idEntreno);
							entreno.setDiaSemana(diaSemana);
							entreno.setSemana(i);
							entreno.setFecha(fechaEjercicio.getTime());
							entreno.setDistancia(distaciaRun
									/ Math.min(3, listaEjerciciosRunning.size()));
							entreno.setIntensidad(1);
							ejercicio = listaEjerciciosRunning.get(rn
									.nextInt(listaEjerciciosRunning.size()));
							entreno.setId_ejercicio(ejercicio.getId_ejercicio());

							entreno.setSeries((ejercicio.getEnSeries() == 1) ? 1000
									: 0);
							entreno.setRepeticiones((ejercicio.getEnSeries() == 1) ? (distaciaRun / Math
									.min(3, listaEjerciciosRunning.size()))
									/ entreno.getSeries() : 1);
							mapper.insert(entreno);
							listaEjerciciosRunning.remove(ejercicio);
							if (listaEjerciciosRunning.size() == 0) {
								break;
							}

						}
					}
					diaSemana++;
					fechaEjercicio.add(Calendar.DATE, 1);
					// Cycle
					if (listaEjerciciosCycle.size() == 0) {
						listaEjerciciosCycle = DameEjercicios(1, 2);
					}

					if (i + 1 == semanas && j + 1 == 2) {
						// si es la ultima semana y los tres ultimos dias se
						// añade un test para ver calcular la base del
						// entrenamientos
						listaTestCycle = DameEjerciciosTest(4, 2);
						entreno.setId_entreno(idEntreno);
						entreno.setDiaSemana(diaSemana);
						entreno.setSemana(i);
						entreno.setFecha(fechaEjercicio.getTime());
						entreno.setDistancia(distaciaCycle);
						entreno.setIntensidad(1);
						ejercicio = listaTestCycle.get(0);
						entreno.setId_ejercicio(ejercicio.getId_ejercicio());
						entreno.setSeries(0);
						entreno.setRepeticiones(1);
						mapper.insert(entreno);
					} else {
						entreno = new TriTEntrenos();
						for (int h = 0; h < 3; h++) {
							entreno.setId_entreno(idEntreno);
							entreno.setDiaSemana(diaSemana);
							entreno.setSemana(i);
							entreno.setFecha(fechaEjercicio.getTime());
							entreno.setDistancia(distaciaCycle
									/ Math.min(3, listaEjerciciosCycle.size()));
							entreno.setIntensidad(1);
							ejercicio = listaEjerciciosCycle.get(rn
									.nextInt(listaEjerciciosCycle.size()));
							entreno.setId_ejercicio(ejercicio.getId_ejercicio());

							entreno.setSeries((ejercicio.getEnSeries() == 1) ? 1000
									: 0);
							entreno.setRepeticiones((ejercicio.getEnSeries() == 1) ? (distaciaCycle / Math
									.min(3, listaEjerciciosCycle.size()))
									/ entreno.getSeries() : 1);
							mapper.insert(entreno);
							listaEjerciciosCycle.remove(ejercicio);
							if (listaEjerciciosRunning.size() == 0) {
								break;
							}
						}
					}
					diaSemana++;
					fechaEjercicio.add(Calendar.DATE, 1);
				}
				
				fechaEjercicio.add(Calendar.DATE, 1);
			}
			sqlSession.commit();

		} catch (Exception e) {
			// TODO: handle exception
			throw e;

		} finally {
			sqlSession.close();
		}
	}

	public static void entrenoGeneral(int semanas, int distance, int idEntreno,
			Calendar FechaInicio, int idusuario) {
		int aumentoRun = 0, aumentoCycle = 0, aumentoSwim = 0;
		int distaciaRun = 0, distaciaSwim = 0, distaciaCycle = 0;
		Random rn = new Random();
		Calendar fechaEjercicio = FechaInicio;
		List<TriTEjercicios> listaEjerciciosNatacion , listaTestNatacion,listaTestRunning,listaTestCycle= new ArrayList<TriTEjercicios>();
		List<TriTEjercicios> listaEjerciciosRunning = new ArrayList<TriTEjercicios>();
		List<TriTEjercicios> listaEjerciciosCycle = new ArrayList<TriTEjercicios>();

		int pulSwim = 0, pulCycle = 0, pulrun = 0, tswim = 0, tcycle = 0, trun = 0, pulsaciones = 0, ctswim = 0, ctcycle = 0, ctrun = 0, size = 0;
		int usuarioSwim = 0,usuarioCycle=0,usuarioRun=0;
		switch (distance) {
		case 1:
			ctswim = Constantes.tiempoTestSwimSprint;
			ctcycle = Constantes.tiempoTestCycleSprint;
			ctrun = Constantes.tiempoTestRunSprint;
			break;

		case 2:
			ctswim = Constantes.tiempoTestSwimOlimpic;
			ctcycle = Constantes.tiempoTestCycleOlimpic;
			ctrun = Constantes.tiempoTestRunOlimpic;
			break;
		case 3:
			ctswim = Constantes.tiempoTestSwimHalf;
			ctcycle = Constantes.tiempoTestCycleHalf;
			ctrun = Constantes.tiempoTestRunHalf;
			break;
		}

		TriTEjercicios ejercicio = new TriTEjercicios();
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		TriTModeloconocimiento modeloconocimientoSwim = new TriTModeloconocimiento();
		TriTModeloconocimiento modeloconocimientoCycle = new TriTModeloconocimiento();
		TriTModeloconocimiento modeloconocimientoRun = new TriTModeloconocimiento();
		TriTTestMapper tTestMapper = sqlSession.getMapper(TriTTestMapper.class);

		TriTTestExample triTTestExample = new TriTTestExample();
		triTTestExample.createCriteria().andIdEntrenoEqualTo(idEntreno)
				.andFecha_bajaIsNull();
		switch (distance) {
		case 1:
			aumentoRun = (Constantes.DistRunSprintGeneral - Constantes.DistRunSprintBase)
					/ semanas;
			aumentoCycle = (Constantes.DistCycleSprintGeneral - Constantes.DistCycleSprintBase)
					/ semanas;
			aumentoSwim = (Constantes.DistNatSprintGeneral - Constantes.DistNatSprintBase)
					/ semanas;
			distaciaRun = Constantes.DistRunSprintBase;
			distaciaCycle = Constantes.DistCycleSprintBase;
			distaciaSwim = Constantes.DistNatSprintBase;
			usuarioSwim=500;
			usuarioCycle=20000;
			usuarioRun=5000;
			break;

		case 2:
			aumentoRun = (Constantes.DistRunOlimpicGeneral - Constantes.DistRunOlimpicBase)
					/ semanas;
			aumentoCycle = (Constantes.DistCycleOlimpicGeneral - Constantes.DistCycleOlimpicBase)
					/ semanas;
			aumentoSwim = (Constantes.DistSwimOlimpicGeneral - Constantes.DistSwimOlimpicBase)
					/ semanas;
			distaciaRun = Constantes.DistRunOlimpicBase;
			distaciaCycle = Constantes.DistCycleOlimpicBase;
			distaciaSwim = Constantes.DistSwimOlimpicBase;
			usuarioSwim=750;
			usuarioCycle=40000;
			usuarioRun=10000;
			break;
		case 3:
			aumentoRun = (Constantes.DistRunHalfGeneral - Constantes.DistRunHalfcBase)
					/ semanas;
			aumentoCycle = (Constantes.DistCycleHalfGeneral - Constantes.DistCycleHalfBase)
					/ semanas;
			aumentoSwim = (Constantes.DistSwimHalfGeneral - Constantes.DistSwimHalfcBase)
					/ semanas;
			distaciaRun = Constantes.DistRunHalfcBase;
			distaciaCycle = Constantes.DistCycleHalfBase;
			distaciaSwim = Constantes.DistSwimHalfcBase;
			usuarioSwim=1500;
			usuarioCycle=90000;
			usuarioRun=21000;
			break;
		}
		if (tTestMapper.selectByExample(triTTestExample).size() > 0) {
			List<TriTTest> listaTest = tTestMapper
					.selectByExample(triTTestExample);
			for (TriTTest test : listaTest) {
				switch (test.getId_tipo_test()) {
				case 1:
					tswim = test.getTiempo();
					pulSwim = test.getFCMax();
					break;

				case 2:
					tcycle = test.getTiempo();
					pulCycle = test.getFCMax();
					break;

				case 3:
					trun = test.getTiempo();
					pulrun = test.getFCMax();
					break;
				}
			}
			// TriTBioUsuario bioUsuario =
			// sqlSession.getMapper(TriTBioUsuario.class);
			TriTBioUsuarioExample bioUsuarioExample = new TriTBioUsuarioExample();
			bioUsuarioExample.createCriteria().andId_usuarioEqualTo(idusuario);
			TriTBioUsuarioMapper tBioUsuarioMapper = sqlSession
					.getMapper(TriTBioUsuarioMapper.class);

			pulsaciones = (int) (205.8 - (0.685 * tBioUsuarioMapper
					.selectByExample(bioUsuarioExample).get(0).getEdad()
					.intValue()));

			// Modelo de conocimiento segun test
			TriTModeloconocimientoMapper modeloconocimientoMapper = sqlSession
					.getMapper(TriTModeloconocimientoMapper.class);

			TriTModeloconocimientoExample modeloconocimientoExample = new TriTModeloconocimientoExample();

			modeloconocimientoExample
					.createCriteria()
					.andBoolTiempoEqualTo((distaciaSwim/(tswim*60) <= usuarioSwim/ctswim) ? 0 : 1)
					.andBoolUmbralAerobioEqualTo(
							(pulSwim <= pulsaciones*0.8) ? 1 : 0);
			modeloconocimientoSwim = modeloconocimientoMapper.selectByExample(
					modeloconocimientoExample).get(0);

			modeloconocimientoExample
					.createCriteria()
					.andBoolTiempoEqualTo((distaciaCycle/(tcycle*60) <= usuarioCycle/ctcycle) ? 0 : 1)
					.andBoolUmbralAerobioEqualTo(
							(pulCycle <= pulsaciones*0.8) ? 1 : 0);
			modeloconocimientoCycle = modeloconocimientoMapper.selectByExample(
					modeloconocimientoExample).get(0);

			modeloconocimientoExample
					.createCriteria()
					.andBoolTiempoEqualTo((distaciaRun/(trun*60) <= usuarioRun/ctrun) ? 1 : 0)
					.andBoolUmbralAerobioEqualTo(
							(pulrun <= pulsaciones*0.8) ? 1 : 0);
			modeloconocimientoRun = modeloconocimientoMapper.selectByExample(
					modeloconocimientoExample).get(0);

		}

		try {
			

			for (int i = 0; i < semanas; i++) {

				if (modeloconocimientoSwim.getIdInferencia() != null)
					listaEjerciciosNatacion = DameEjercicios(2, 1,
							modeloconocimientoSwim);
				else
					listaEjerciciosNatacion = DameEjercicios(2, 1);

				if (modeloconocimientoCycle.getIdInferencia() != null)
					listaEjerciciosCycle = DameEjercicios(2, 2,
							modeloconocimientoCycle);
				else
					listaEjerciciosCycle = DameEjercicios(2, 2);

				if (modeloconocimientoRun.getIdInferencia() != null)
					listaEjerciciosRunning = DameEjercicios(2, 3,
							modeloconocimientoRun);
				else
					listaEjerciciosRunning = DameEjercicios(2, 3);

				int diaSemana = 0;
				// modificar añadiendo temporales para cada semana
				int distaciaRunTemp = ((((i + 1) * aumentoRun) / 100) * 100)
						+ distaciaRun;
				int distaciaCycleTemp = ((((i + 1) * aumentoCycle) / 1000) * 1000)
						+ distaciaCycle;
				int distaciaSwimTemp = ((((i + 1) * aumentoSwim) / 100) * 100)
						+ distaciaSwim;
				for (int j = 0; j < 2; j++) {
					// cada dia de la semana

					// Natacion
					if (listaEjerciciosNatacion.size() == 0) {
						if (modeloconocimientoSwim.getIdInferencia() != null)
							listaEjerciciosNatacion = DameEjercicios(2, 1,
									modeloconocimientoSwim);
						else
							listaEjerciciosNatacion = DameEjercicios(2, 1);
					}
					TriTEntrenosMapper mapper = sqlSession
							.getMapper(TriTEntrenosMapper.class);
					TriTEntrenosExample entrenoExample = new TriTEntrenosExample();
					int series = dameSeriesSwim(modeloconocimientoSwim);

					TriTEntrenos entreno = new TriTEntrenos();
					if (i + 1 == semanas && j + 1 == 2) {
						// si es la ultima semana y los tres ultimos dias se
						// añade un test para ver calcular la base del
						// entrenamientos
						listaTestNatacion = DameEjerciciosTest(4, 1);
						entreno.setId_entreno(idEntreno);
						entreno.setDiaSemana(diaSemana);
						entreno.setSemana(i);
						entreno.setFecha(fechaEjercicio.getTime());
						entreno.setDistancia(distaciaSwim);
						entreno.setIntensidad(1);
						ejercicio = listaTestNatacion.get(0);
						entreno.setId_ejercicio(ejercicio.getId_ejercicio());
						entreno.setSeries(0);
						entreno.setRepeticiones(1);
						mapper.insert(entreno);
					} else {
					for (int h = 0; h < 5; h++) {
						entreno.setId_entreno(idEntreno);
						entreno.setDiaSemana(diaSemana);
						entreno.setSemana(i);
						entreno.setFecha(fechaEjercicio.getTime());
						// entreno.setDistancia(distaciaSwimTemp / 5);
						entreno.setIntensidad(1);
						ejercicio = listaEjerciciosNatacion.get(rn
								.nextInt(listaEjerciciosNatacion.size()));
						entreno.setId_ejercicio(ejercicio.getId_ejercicio());
						listaEjerciciosNatacion.remove(ejercicio);
						entreno.setSeries((ejercicio.getEnSeries() == 1) ? series
								: 0);
						// entreno.setRepeticiones((ejercicio.getEnSeries() ==
						// 1) ?(distaciaSwimTemp / 5) / 100:1);
						entreno.setRepeticiones((ejercicio.getEnSeries() == 1) ? dameRepeticiones(
								dameDistancia(distaciaSwimTemp, 5, 25, 100),
								entreno.getSeries(), entreno.getSeries() / 2)
								: 1);
						entreno.setDistancia((ejercicio.getEnSeries() == 1) ? series
								* entreno.getRepeticiones()
								: dameDistancia(distaciaSwimTemp, 5, 25, 100));

						mapper.insert(entreno);
						if (listaEjerciciosNatacion.size() == 0) {
							if (modeloconocimientoSwim.getIdInferencia() != null)
								listaEjerciciosNatacion = DameEjercicios(2, 1,
										modeloconocimientoSwim);
							else
								listaEjerciciosNatacion = DameEjercicios(2, 1);
						}
					}
					}
					diaSemana++;
					fechaEjercicio.add(Calendar.DATE, 1);

					// RUNNING
					if (listaEjerciciosRunning.size() == 0) {
						if (modeloconocimientoRun.getIdInferencia() != null)
							listaEjerciciosRunning = DameEjercicios(2, 3,
									modeloconocimientoRun);
						else
							listaEjerciciosRunning = DameEjercicios(2, 3);
					}
					series = dameSeriesRun(modeloconocimientoRun);
					size = listaEjerciciosRunning.size();
					if (i + 1 == semanas && j + 1 == 2) {
						// si es la ultima semana y los tres ultimos dias se
						// añade un test para ver calcular la base del
						// entrenamientos
						listaTestRunning = DameEjerciciosTest(4, 3);
						entreno.setId_entreno(idEntreno);
						entreno.setDiaSemana(diaSemana);
						entreno.setSemana(i);
						entreno.setFecha(fechaEjercicio.getTime());
						entreno.setDistancia(distaciaRun);
						entreno.setIntensidad(1);
						ejercicio = listaTestRunning.get(0);
						entreno.setId_ejercicio(ejercicio.getId_ejercicio());
						entreno.setSeries(0);
						entreno.setRepeticiones(1);
						mapper.insert(entreno);
					} else {
					entreno = new TriTEntrenos();
					for (int h = 0; h < 3; h++) {

						entreno.setId_entreno(idEntreno);
						entreno.setDiaSemana(diaSemana);
						entreno.setSemana(i);
						entreno.setFecha(fechaEjercicio.getTime());

						entreno.setIntensidad(1);
						ejercicio = listaEjerciciosRunning.get(rn
								.nextInt(listaEjerciciosRunning.size()));
						entreno.setId_ejercicio(ejercicio.getId_ejercicio());

						entreno.setSeries((ejercicio.getEnSeries() == 1) ? series
								: 0);
						entreno.setRepeticiones((ejercicio.getEnSeries() == 1) ? dameRepeticiones(
								dameDistancia(distaciaRunTemp, size, 50, 100),
								entreno.getSeries(), entreno.getSeries() / 2)
								: 1);
						entreno.setDistancia((ejercicio.getEnSeries() == 1) ? series
								* entreno.getRepeticiones()
								: dameDistancia(distaciaRunTemp, size, 50, 100));

						mapper.insert(entreno);
						listaEjerciciosRunning.remove(ejercicio);
						if (listaEjerciciosRunning.size() == 0) {
							break;
						}

					}
					}
					diaSemana++;
					fechaEjercicio.add(Calendar.DATE, 1);
					// Cycle
					if (listaEjerciciosCycle.size() == 0) {
						if (modeloconocimientoCycle.getIdInferencia() != null)
							listaEjerciciosCycle = DameEjercicios(2, 2,
									modeloconocimientoCycle);
						else
							listaEjerciciosCycle = DameEjercicios(2, 2);
					}
					series = dameSeriesCycle(modeloconocimientoCycle);
					size = listaEjerciciosCycle.size();
					if (i + 1 == semanas && j + 1 == 2) {
						// si es la ultima semana y los tres ultimos dias se
						// añade un test para ver calcular la base del
						// entrenamientos
						listaTestCycle = DameEjerciciosTest(4, 2);
						entreno.setId_entreno(idEntreno);
						entreno.setDiaSemana(diaSemana);
						entreno.setSemana(i);
						entreno.setFecha(fechaEjercicio.getTime());
						entreno.setDistancia(distaciaCycle);
						entreno.setIntensidad(1);
						ejercicio = listaTestCycle.get(0);
						entreno.setId_ejercicio(ejercicio.getId_ejercicio());
						entreno.setSeries(0);
						entreno.setRepeticiones(1);
						mapper.insert(entreno);
					} else {
					entreno = new TriTEntrenos();
					for (int h = 0; h < 3; h++) {
						entreno.setId_entreno(idEntreno);
						entreno.setDiaSemana(diaSemana);
						entreno.setSemana(i);
						entreno.setFecha(fechaEjercicio.getTime());
						entreno.setDistancia(dameDistancia(distaciaCycleTemp,
								size, 500, 1000));
						entreno.setIntensidad(1);
						ejercicio = listaEjerciciosCycle.get(rn
								.nextInt(listaEjerciciosCycle.size()));
						entreno.setId_ejercicio(ejercicio.getId_ejercicio());

						entreno.setSeries((ejercicio.getEnSeries() == 1) ? series
								: 0);
						entreno.setRepeticiones((ejercicio.getEnSeries() == 1) ? dameRepeticiones(
								dameDistancia(distaciaCycleTemp, size, 500,
										1000), entreno.getSeries(), entreno
										.getSeries() / 2) : 1);
						entreno.setDistancia((ejercicio.getEnSeries() == 1) ? series
								* entreno.getRepeticiones()
								: dameDistancia(distaciaCycleTemp, size, 500,
										1000));

						mapper.insert(entreno);
						listaEjerciciosCycle.remove(ejercicio);
						if (listaEjerciciosRunning.size() == 0) {
							break;
						}
					}
					}
					diaSemana++;
					fechaEjercicio.add(Calendar.DATE, 1);
				}
				fechaEjercicio.add(Calendar.DATE, 1);
			}
			sqlSession.commit();

		} catch (Exception e) {
			// TODO: handle exception
			throw e;

		} finally {
			sqlSession.close();
		}
	}

	public static void entrenoEspecifico(int semanas, int distance,
			int idEntreno, Calendar FechaInicio, int idusuario) {
		// Dividir en dos ciclos carrera y bici mitad de semanas. Hacer una
		// ultima semana de descarga.
		int aumentoRun = 0, aumentoCycle = 0, aumentoSwim = 0;
		int usuarioSwim = 0,usuarioCycle=0,usuarioRun=0;
		List<TriTEjercicios> listaEjerciciosNatacion = new ArrayList<TriTEjercicios>();
		List<TriTEjercicios> listaEjerciciosRunning = new ArrayList<TriTEjercicios>();
		List<TriTEjercicios> listaEjerciciosCycle = new ArrayList<TriTEjercicios>();
		int distaciaRun = 0, distaciaSwim = 0, distaciaCycle = 0;
		Random rn = new Random();
		Calendar fechaEjercicio = FechaInicio;
		int pulSwim = 0, pulCycle = 0, pulrun = 0, tswim = 0, tcycle = 0, trun = 0, pulsaciones = 0, ctswim = 0, ctcycle = 0, ctrun = 0, size = 0;



		switch (distance) {
		case 1:
			ctswim = Constantes.tiempoTestSwimSprint;
			ctcycle = Constantes.tiempoTestCycleSprint;
			ctrun = Constantes.tiempoTestRunSprint;
			break;

		case 2:
			ctswim = Constantes.tiempoTestSwimOlimpic;
			ctcycle = Constantes.tiempoTestCycleOlimpic;
			ctrun = Constantes.tiempoTestRunOlimpic;
			break;
		
		case 3:
				ctswim = Constantes.tiempoTestSwimHalf;
				ctcycle = Constantes.tiempoTestCycleHalf;
				ctrun = Constantes.tiempoTestRunHalf;
				break;
			}

		TriTEjercicios ejercicio = new TriTEjercicios();
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		TriTModeloconocimiento modeloconocimientoSwim = new TriTModeloconocimiento();
		TriTModeloconocimiento modeloconocimientoCycle = new TriTModeloconocimiento();
		TriTModeloconocimiento modeloconocimientoRun = new TriTModeloconocimiento();
		TriTTestMapper tTestMapper = sqlSession.getMapper(TriTTestMapper.class);

		TriTTestExample triTTestExample = new TriTTestExample();
		triTTestExample.createCriteria().andIdEntrenoEqualTo(idEntreno)
				.andFecha_bajaIsNull();
		switch (distance) {
		case 1:
			aumentoRun = (Constantes.DistRunSprintGeneral - Constantes.DistRunSprintBase)
					/ semanas;
			aumentoCycle = (Constantes.DistCycleSprintGeneral - Constantes.DistCycleSprintBase)
					/ semanas;
			aumentoSwim = (Constantes.DistNatSprintGeneral - Constantes.DistNatSprintBase)
					/ semanas;
			distaciaRun = Constantes.DistRunSprintBase;
			distaciaCycle = Constantes.DistCycleSprintBase;
			distaciaSwim = Constantes.DistNatSprintBase;
			usuarioSwim=500;
			usuarioCycle=20000;
			usuarioRun=5000;
			break;

		case 2:
			aumentoRun = (Constantes.DistRunOlimpicGeneral - Constantes.DistRunOlimpicBase)
					/ semanas;
			aumentoCycle = (Constantes.DistCycleOlimpicGeneral - Constantes.DistCycleOlimpicBase)
					/ semanas;
			aumentoSwim = (Constantes.DistSwimOlimpicGeneral - Constantes.DistSwimOlimpicBase)
					/ semanas;
			distaciaRun = Constantes.DistRunOlimpicBase;
			distaciaCycle = Constantes.DistCycleOlimpicBase;
			distaciaSwim = Constantes.DistSwimOlimpicBase;
			usuarioSwim=750;
			usuarioCycle=40000;
			usuarioRun=10000;
			break;
		case 3:
			aumentoRun = (Constantes.DistRunHalfGeneral - Constantes.DistRunHalfcBase)
					/ semanas;
			aumentoCycle = (Constantes.DistCycleHalfGeneral - Constantes.DistCycleHalfBase)
					/ semanas;
			aumentoSwim = (Constantes.DistSwimHalfGeneral - Constantes.DistSwimHalfcBase)
					/ semanas;
			distaciaRun = Constantes.DistRunHalfcBase;
			distaciaCycle = Constantes.DistCycleHalfBase;
			distaciaSwim = Constantes.DistSwimHalfcBase;
			usuarioSwim=1500;
			usuarioCycle=90000;
			usuarioRun=21000;
			break;
		}
		if (tTestMapper.selectByExample(triTTestExample).size() > 0) {
			List<TriTTest> listaTest = tTestMapper
					.selectByExample(triTTestExample);
			for (TriTTest test : listaTest) {
				switch (test.getId_tipo_test()) {
				case 1:
					tswim = test.getTiempo();
					pulSwim = test.getFCMax();
					break;

				case 2:
					tcycle = test.getTiempo();
					pulCycle = test.getFCMax();
					break;

				case 3:
					trun = test.getTiempo();
					pulrun = test.getFCMax();
					break;
				}
			}
			// TriTBioUsuario bioUsuario =
			// sqlSession.getMapper(TriTBioUsuario.class);
			TriTBioUsuarioExample bioUsuarioExample = new TriTBioUsuarioExample();
			bioUsuarioExample.createCriteria().andId_usuarioEqualTo(idusuario);
			TriTBioUsuarioMapper tBioUsuarioMapper = sqlSession
					.getMapper(TriTBioUsuarioMapper.class);

			pulsaciones = (int) (205.8 - (0.685 * tBioUsuarioMapper
					.selectByExample(bioUsuarioExample).get(0).getEdad()
					.intValue()));

			// Modelo de conocimiento segun test
			TriTModeloconocimientoMapper modeloconocimientoMapper = sqlSession
					.getMapper(TriTModeloconocimientoMapper.class);

			TriTModeloconocimientoExample modeloconocimientoExample = new TriTModeloconocimientoExample();

			modeloconocimientoExample
			.createCriteria()
			.andBoolTiempoEqualTo((distaciaSwim/(tswim*60) <= usuarioSwim/ctswim) ? 0 : 1)
			.andBoolUmbralAerobioEqualTo(
					(pulSwim <= pulsaciones*0.8) ? 1 : 0);
	modeloconocimientoSwim = modeloconocimientoMapper.selectByExample(
			modeloconocimientoExample).get(0);

	modeloconocimientoExample
			.createCriteria()
			.andBoolTiempoEqualTo((distaciaCycle/(tcycle*60) <= usuarioCycle/ctcycle) ? 0 : 1)
			.andBoolUmbralAerobioEqualTo(
					(pulCycle <= pulsaciones*0.8) ? 1 : 0);
	modeloconocimientoCycle = modeloconocimientoMapper.selectByExample(
			modeloconocimientoExample).get(0);

	modeloconocimientoExample
			.createCriteria()
			.andBoolTiempoEqualTo((distaciaRun/(trun*60) <= usuarioRun/ctrun) ? 0 : 1)
			.andBoolUmbralAerobioEqualTo(
					(pulrun <= pulsaciones*0.8) ? 1 : 0);
	modeloconocimientoRun = modeloconocimientoMapper.selectByExample(
			modeloconocimientoExample).get(0);

		}

		try {
			
			for (int i = 0; i < semanas; i++) {

				if (modeloconocimientoSwim.getIdInferencia() != null)
					listaEjerciciosNatacion = DameEjercicios(2, 1,
							modeloconocimientoSwim);
				else
					listaEjerciciosNatacion = DameEjercicios(2, 1);

				if (modeloconocimientoCycle.getIdInferencia() != null)
					listaEjerciciosCycle = DameEjercicios(2, 2,
							modeloconocimientoCycle);
				else
					listaEjerciciosCycle = DameEjercicios(2, 2);

				if (modeloconocimientoRun.getIdInferencia() != null)
					listaEjerciciosRunning = DameEjercicios(2, 3,
							modeloconocimientoRun);
				else
					listaEjerciciosRunning = DameEjercicios(2, 3);

				int diaSemana = 0;
				// modificar añadiendo temporales para cada semana
				int distaciaRunTemp = ((((i + 1) * aumentoRun) / 100) * 100)
						+ distaciaRun;
				int distaciaCycleTemp = ((((i + 1) * aumentoCycle) / 1000) * 1000)
						+ distaciaCycle;
				int distaciaSwimTemp = ((((i + 1) * aumentoSwim) / 100) * 100)
						+ distaciaSwim;

				if (i <= (semanas / 2)) {// primer mitad se trabaja la bici
											// segunda la carrera
					for (int j = 0; j < 3; j++) {
						TriTEntrenos entreno = new TriTEntrenos();
						TriTEntrenosMapper mapper = sqlSession
								.getMapper(TriTEntrenosMapper.class);
						TriTEntrenosExample entrenoExample = new TriTEntrenosExample();
						int series = dameSeriesSwim(modeloconocimientoSwim);
						// cada dia de la semana
						if (i%2==0) {
							// Natacion
							if (listaEjerciciosNatacion.size() == 0) {
								if (modeloconocimientoSwim.getIdInferencia() != null)
									listaEjerciciosNatacion = DameEjercicios(2,
											1, modeloconocimientoSwim);
								else
									listaEjerciciosNatacion = DameEjercicios(2,
											1);
							}

							for (int h = 0; h < 5; h++) {
								entreno.setId_entreno(idEntreno);
								entreno.setDiaSemana(diaSemana);
								entreno.setSemana(i);
								entreno.setFecha(fechaEjercicio.getTime());
								// entreno.setDistancia(distaciaSwimTemp / 5);
								entreno.setIntensidad(1);
								ejercicio = listaEjerciciosNatacion
										.get(rn.nextInt(listaEjerciciosNatacion
												.size()));
								entreno.setId_ejercicio(ejercicio
										.getId_ejercicio());
								listaEjerciciosNatacion.remove(ejercicio);
								entreno.setSeries((ejercicio.getEnSeries() == 1) ? series
										: 0);
								// entreno.setRepeticiones((ejercicio.getEnSeries()
								// ==
								// 1) ?(distaciaSwimTemp / 5) / 100:1);
								entreno.setRepeticiones((ejercicio
										.getEnSeries() == 1) ? dameRepeticiones(
										dameDistancia(distaciaSwimTemp, 5, 25,
												100), entreno.getSeries(),
										entreno.getSeries() / 2) : 1);
								entreno.setDistancia((ejercicio.getEnSeries() == 1) ? series
										* entreno.getRepeticiones()
										: dameDistancia(distaciaSwimTemp, 5,
												25, 100));

								mapper.insert(entreno);
								if (listaEjerciciosNatacion.size() == 0) {
									if (modeloconocimientoSwim
											.getIdInferencia() != null)
										listaEjerciciosNatacion = DameEjercicios(
												2, 1, modeloconocimientoSwim);
									else
										listaEjerciciosNatacion = DameEjercicios(
												2, 1);
								}
							}
							diaSemana++;
							fechaEjercicio.add(Calendar.DATE, 1);
						} else {
							// RUNNING
							if (listaEjerciciosRunning.size() == 0) {
								if (modeloconocimientoRun.getIdInferencia() != null)
									listaEjerciciosRunning = DameEjercicios(2,
											3, modeloconocimientoRun);
								else
									listaEjerciciosRunning = DameEjercicios(2,
											3);
							}
							series = dameSeriesRun(modeloconocimientoRun);
							size = listaEjerciciosRunning.size();
							entreno = new TriTEntrenos();
							for (int h = 0; h < 3; h++) {

								entreno.setId_entreno(idEntreno);
								entreno.setDiaSemana(diaSemana);
								entreno.setSemana(i);
								entreno.setFecha(fechaEjercicio.getTime());

								entreno.setIntensidad(1);
								ejercicio = listaEjerciciosRunning
										.get(rn.nextInt(listaEjerciciosRunning
												.size()));
								entreno.setId_ejercicio(ejercicio
										.getId_ejercicio());

								entreno.setSeries((ejercicio.getEnSeries() == 1) ? series
										: 0);
								entreno.setRepeticiones((ejercicio
										.getEnSeries() == 1) ? dameRepeticiones(
										dameDistancia(distaciaRunTemp, size,
												50, 100), entreno.getSeries(),
										entreno.getSeries() / 2) : 1);
								entreno.setDistancia((ejercicio.getEnSeries() == 1) ? series
										* entreno.getRepeticiones()
										: dameDistancia(distaciaRunTemp, size,
												50, 100));

								mapper.insert(entreno);
								listaEjerciciosRunning.remove(ejercicio);
								if (listaEjerciciosRunning.size() == 0) {
									break;
								}

							}
							diaSemana++;
							fechaEjercicio.add(Calendar.DATE, 1);
						}
						// Cycle
						if (listaEjerciciosCycle.size() == 0) {
							if (modeloconocimientoCycle.getIdInferencia() != null)
								listaEjerciciosCycle = DameEjercicios(2, 2,
										modeloconocimientoCycle);
							else
								listaEjerciciosCycle = DameEjercicios(2, 2);
						}
						series = dameSeriesCycle(modeloconocimientoCycle);
						size = listaEjerciciosCycle.size();
						entreno = new TriTEntrenos();
						for (int h = 0; h < 3; h++) {
							entreno.setId_entreno(idEntreno);
							entreno.setDiaSemana(diaSemana);
							entreno.setSemana(i);
							entreno.setFecha(fechaEjercicio.getTime());
							entreno.setDistancia(dameDistancia(
									distaciaCycleTemp, size, 500, 1000));
							entreno.setIntensidad(1);
							ejercicio = listaEjerciciosCycle.get(rn
									.nextInt(listaEjerciciosCycle.size()));
							entreno.setId_ejercicio(ejercicio.getId_ejercicio());

							entreno.setSeries((ejercicio.getEnSeries() == 1) ? series
									: 0);
							entreno.setRepeticiones((ejercicio.getEnSeries() == 1) ? dameRepeticiones(
									dameDistancia(distaciaCycleTemp, size, 500,
											1000), entreno.getSeries(), entreno
											.getSeries() / 2) : 1);
							entreno.setDistancia((ejercicio.getEnSeries() == 1) ? series
									* entreno.getRepeticiones()
									: dameDistancia(distaciaCycleTemp, size,
											500, 1000));

							mapper.insert(entreno);
							listaEjerciciosCycle.remove(ejercicio);
							if (listaEjerciciosCycle.size() == 0) {
								break;
							}
						}

						diaSemana++;
						fechaEjercicio.add(Calendar.DATE, 1);
					}
				} else {
					//segunda mitad se entrena la carrera
					for (int j = 0; j < 2; j++) {
						TriTEntrenos entreno = new TriTEntrenos();
						TriTEntrenosMapper mapper = sqlSession
								.getMapper(TriTEntrenosMapper.class);
						TriTEntrenosExample entrenoExample = new TriTEntrenosExample();
						int series = dameSeriesSwim(modeloconocimientoSwim);
						// cada dia de la semana
						if (i%2==0) {
							// Natacion
							if (listaEjerciciosNatacion.size() == 0) {
								if (modeloconocimientoSwim.getIdInferencia() != null)
									listaEjerciciosNatacion = DameEjercicios(2,
											1, modeloconocimientoSwim);
								else
									listaEjerciciosNatacion = DameEjercicios(2,
											1);
							}

							for (int h = 0; h < 5; h++) {
								entreno.setId_entreno(idEntreno);
								entreno.setDiaSemana(diaSemana);
								entreno.setSemana(i);
								entreno.setFecha(fechaEjercicio.getTime());
								// entreno.setDistancia(distaciaSwimTemp / 5);
								entreno.setIntensidad(1);
								ejercicio = listaEjerciciosNatacion
										.get(rn.nextInt(listaEjerciciosNatacion
												.size()));
								entreno.setId_ejercicio(ejercicio
										.getId_ejercicio());
								listaEjerciciosNatacion.remove(ejercicio);
								entreno.setSeries((ejercicio.getEnSeries() == 1) ? series
										: 0);
								// entreno.setRepeticiones((ejercicio.getEnSeries()
								// ==
								// 1) ?(distaciaSwimTemp / 5) / 100:1);
								entreno.setRepeticiones((ejercicio
										.getEnSeries() == 1) ? dameRepeticiones(
										dameDistancia(distaciaSwimTemp, 5, 25,
												100), entreno.getSeries(),
										entreno.getSeries() / 2) : 1);
								entreno.setDistancia((ejercicio.getEnSeries() == 1) ? series
										* entreno.getRepeticiones()
										: dameDistancia(distaciaSwimTemp, 5,
												25, 100));

								mapper.insert(entreno);
								if (listaEjerciciosNatacion.size() == 0) {
									if (modeloconocimientoSwim
											.getIdInferencia() != null)
										listaEjerciciosNatacion = DameEjercicios(
												2, 1, modeloconocimientoSwim);
									else
										listaEjerciciosNatacion = DameEjercicios(
												2, 1);
								}
							}
							diaSemana++;
							fechaEjercicio.add(Calendar.DATE, 1);
						} else {
							if (listaEjerciciosCycle.size() == 0) {
								if (modeloconocimientoCycle.getIdInferencia() != null)
									listaEjerciciosCycle = DameEjercicios(2, 2,
											modeloconocimientoCycle);
								else
									listaEjerciciosCycle = DameEjercicios(2, 2);
							}
							series = dameSeriesCycle(modeloconocimientoCycle);
							size = listaEjerciciosCycle.size();
							entreno = new TriTEntrenos();
							for (int h = 0; h < 3; h++) {
								entreno.setId_entreno(idEntreno);
								entreno.setDiaSemana(diaSemana);
								entreno.setSemana(i);
								entreno.setFecha(fechaEjercicio.getTime());
								entreno.setDistancia(dameDistancia(
										distaciaCycleTemp, size, 500, 1000));
								entreno.setIntensidad(1);
								ejercicio = listaEjerciciosCycle.get(rn
										.nextInt(listaEjerciciosCycle.size()));
								entreno.setId_ejercicio(ejercicio.getId_ejercicio());

								entreno.setSeries((ejercicio.getEnSeries() == 1) ? series
										: 0);
								entreno.setRepeticiones((ejercicio.getEnSeries() == 1) ? dameRepeticiones(
										dameDistancia(distaciaCycleTemp, size, 500,
												1000), entreno.getSeries(), entreno
												.getSeries() / 2) : 1);
								entreno.setDistancia((ejercicio.getEnSeries() == 1) ? series
										* entreno.getRepeticiones()
										: dameDistancia(distaciaCycleTemp, size,
												500, 1000));

								mapper.insert(entreno);
								listaEjerciciosCycle.remove(ejercicio);
								if (listaEjerciciosCycle.size() == 0) {
									break;
								}
							}

							diaSemana++;
							fechaEjercicio.add(Calendar.DATE, 1);
						}
						// RUNNING
						if (listaEjerciciosRunning.size() == 0) {
							if (modeloconocimientoRun.getIdInferencia() != null)
								listaEjerciciosRunning = DameEjercicios(2,
										3, modeloconocimientoRun);
							else
								listaEjerciciosRunning = DameEjercicios(2,
										3);
						}
						series = dameSeriesRun(modeloconocimientoRun);
						size = listaEjerciciosRunning.size();
						entreno = new TriTEntrenos();
						for (int h = 0; h < 3; h++) {

							entreno.setId_entreno(idEntreno);
							entreno.setDiaSemana(diaSemana);
							entreno.setSemana(i);
							entreno.setFecha(fechaEjercicio.getTime());

							entreno.setIntensidad(1);
							ejercicio = listaEjerciciosRunning
									.get(rn.nextInt(listaEjerciciosRunning
											.size()));
							entreno.setId_ejercicio(ejercicio
									.getId_ejercicio());

							entreno.setSeries((ejercicio.getEnSeries() == 1) ? series
									: 0);
							entreno.setRepeticiones((ejercicio
									.getEnSeries() == 1) ? dameRepeticiones(
									dameDistancia(distaciaRunTemp, size,
											50, 100), entreno.getSeries(),
									entreno.getSeries() / 2) : 1);
							entreno.setDistancia((ejercicio.getEnSeries() == 1) ? series
									* entreno.getRepeticiones()
									: dameDistancia(distaciaRunTemp, size,
											50, 100));

							mapper.insert(entreno);
							listaEjerciciosRunning.remove(ejercicio);
							if (listaEjerciciosRunning.size() == 0) {
								break;
							}

						}
						diaSemana++;
						fechaEjercicio.add(Calendar.DATE, 1);
						
						// Cycle
						
					}

				}
				fechaEjercicio.add(Calendar.DATE, 1);
			}
			sqlSession.commit();

		} catch (Exception e) {
			// TODO: handle exception
			throw e;

		} finally {
			sqlSession.close();
		}
	}

	private static List<TriTEjercicios> DameEjercicios(int nivelEntreno,
			int tipoEntreno) {

		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			TriTEjerciciosMapper mapper = sqlSession
					.getMapper(TriTEjerciciosMapper.class);

			TriTEjerciciosExample ejerciciosExample = new TriTEjerciciosExample();
			ejerciciosExample.createCriteria()
					.andId_nivelLessThanOrEqualTo(nivelEntreno)
					.andId_tipoEqualTo(tipoEntreno);
			return mapper.selectByExample(ejerciciosExample);

		} finally {
			sqlSession.close();
		}

	}

	private static List<TriTEjercicios> DameEjercicios(int nivelEntreno,
			int tipoEntreno, TriTModeloconocimiento modeloConcimiento) {

		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			TriTEjerciciosMapper mapper = sqlSession
					.getMapper(TriTEjerciciosMapper.class);

			TriTEjerciciosExample ejerciciosExample = new TriTEjerciciosExample();
			List<Integer> lista = new ArrayList<Integer>();
			if (modeloConcimiento.getBoolTecnica() == 1) {
				lista.add(1);
			}
			if (modeloConcimiento.getBoolFuerza() == 1) {
				lista.add(2);
			}
			if (modeloConcimiento.getBoolVelocidad() == 1) {
				lista.add(3);
			}
			if (modeloConcimiento.getBoolRitmo() == 1) {
				lista.add(4);
			}
			ejerciciosExample.createCriteria()
					.andId_nivelLessThanOrEqualTo(nivelEntreno)
					.andId_tipoEqualTo(tipoEntreno)
					.andId_clasificacion_ejercicioIn(lista);
			return mapper.selectByExample(ejerciciosExample);

		} finally {
			sqlSession.close();
		}

	}

	private static List<TriTEjercicios> DameEjerciciosTest(int nivelEntreno,
			int tipoEntreno) {

		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			TriTEjerciciosMapper mapper = sqlSession
					.getMapper(TriTEjerciciosMapper.class);

			TriTEjerciciosExample ejerciciosExample = new TriTEjerciciosExample();
			ejerciciosExample.createCriteria().andId_nivelEqualTo(nivelEntreno)
					.andId_tipoEqualTo(tipoEntreno);
			return mapper.selectByExample(ejerciciosExample);

		} finally {
			sqlSession.close();
		}

	}
	
	public static boolean regenarEntreno(TriTiEntrenoUsuario triTiEntrenoUsuario, TriTEntrenos triTEntrenos, int semanas){
		
		Calendar myCal = new GregorianCalendar();
		myCal.setTime(triTEntrenos.getFecha());
		
		
		Integer pAdaptacion=NuevoEntrenoService.dameNiveles(triTiEntrenoUsuario.getTiempoSwim()+triTiEntrenoUsuario.getTiempoCycle()+triTiEntrenoUsuario.getTiempoRun(),triTiEntrenoUsuario.getId_tipo_entreno());
		Integer pGeneral = (100-pAdaptacion)/2;
		Integer pEspecifico = (100-pAdaptacion)/2;
		

		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			    TriTEntrenosMapper entrenosMapper = sqlSession
						.getMapper(TriTEntrenosMapper.class);

			    
			    TriTEntrenosExample entrenosExample = new TriTEntrenosExample();
			    entrenosExample.createCriteria().andId_entrenoEqualTo(triTEntrenos.getId_entreno());
			    List <TriTEntrenos> list=entrenosMapper.selectByExample(entrenosExample);
			    for (TriTEntrenos triTEntrenos2 : list) {
					TriTEntrenos entrenos = new TriTEntrenos();
					entrenos.setId_entreno_ejercicio(triTEntrenos2.getId_entreno_ejercicio());
					entrenos.setConseguido(triTEntrenos2.getConseguido());
					entrenos.setDescanso(triTEntrenos2.getDescanso());
					entrenos.setDiaSemana(triTEntrenos2.getDiaSemana());
					entrenos.setDistancia(triTEntrenos2.getDistancia());
					entrenos.setFecha(triTEntrenos2.getFecha());
					entrenos.setId_ejercicio(triTEntrenos2.getId_ejercicio());
					entrenos.setId_entreno(triTEntrenos2.getId_entreno());
					entrenos.setIntensidad(triTEntrenos2.getIntensidad());
					entrenos.setPeso(triTEntrenos2.getPeso());
					entrenos.setPulsaciones(triTEntrenos2.getPulsaciones());
					entrenos.setPulsacionesMedias(triTEntrenos2.getPulsacionesMedias());
					
					entrenos.setFecha_baja(myCal.getTime());
					entrenosMapper.updateByPrimaryKey(entrenos);
				}
			    
				TriTHistoricoMapper mapperH = sqlSession
						.getMapper(TriTHistoricoMapper.class);
				TriTHistoricoExample HistorticoExample = new TriTHistoricoExample();
				TriTHistorico historico = new TriTHistorico();
				historico.setDescripcion("User "
						+ triTiEntrenoUsuario.getId_usuario()
						+ " has updated the training"
						+ triTiEntrenoUsuario.getId_entreno() + ".");
				mapperH.insert(historico);
			
			sqlSession.commit();
			Calendar FechaInicio=Calendar.getInstance();
			if (FechaInicio.get(Calendar.DAY_OF_WEEK)!=Calendar.MONDAY){
				FechaInicio.add(Calendar.DATE,(Calendar.MONDAY-FechaInicio.get(Calendar.DAY_OF_WEEK)));
				
			}
			
			NuevoEntrenoService.entrenoGeneral(((pGeneral* semanas)/100)+1,triTiEntrenoUsuario.getId_tipo_entreno(),NuevoEntrenoService.idEntreno(triTiEntrenoUsuario.getId_usuario()),FechaInicio,triTiEntrenoUsuario.getId_usuario());
			NuevoEntrenoService.entrenoEspecifico(((pGeneral* semanas)/100)+1,triTiEntrenoUsuario.getId_tipo_entreno(),NuevoEntrenoService.idEntreno(triTiEntrenoUsuario.getId_usuario()),FechaInicio,triTiEntrenoUsuario.getId_usuario());
			return true;

		} finally {
			sqlSession.close();
		}
		//NuevoEntrenoService.entrenoAdaptacion((pAdaptacion* semanas)/100,triTiEntrenoUsuario.getId_tipo_entreno(),NuevoEntrenoService.idEntreno(triTiEntrenoUsuario.getId_usuario()),FechaInicio);
		
	}

}
