package es.tri.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import es.mybatis.MyBatisConnectionFactory;
import es.tri.dao.TriTBioUsuarioMapper;
import es.tri.dao.TriTEntrenosMapper;
import es.tri.dao.TriTHistoricoMapper;
import es.tri.dao.TriTTestMapper;
import es.tri.dao.TriTUsuariosMapper;
import es.tri.dao.TriTiEntrenoUsuarioMapper;
import es.tri.dao.model.TriTBioUsuarioExample;
import es.tri.dao.model.TriTEntrenos;
import es.tri.dao.model.TriTEntrenosExample;
import es.tri.dao.model.TriTHistorico;
import es.tri.dao.model.TriTHistoricoExample;
import es.tri.dao.model.TriTTest;
import es.tri.dao.model.TriTTestExample;
import es.tri.dao.model.TriTUsuarios;
import es.tri.dao.model.TriTUsuariosExample;
import es.tri.dao.model.TriTiEntrenoUsuario;
import es.tri.dao.model.TriTiEntrenoUsuarioExample;
import es.tri.objetos.Constantes;
import es.tri.objetos.Entrenamiento;
import es.tri.objetos.Historico;
import es.tri.objetos.Test;
import es.tri.security.Security;
import es.tri.services.FuncionesComunesService;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String email;
	

	private TriTUsuarios triTUsuarios,redirectAction;
	private TriTiEntrenoUsuario triTUsuarioEntreno;
	private List <TriTEntrenos> triTEntrenosList;	
	private String porcentageR = "0";
	private String porcentageS = "0";
	private String porcentageC = "0";
	private String totalUsers = "0";
	private String totalActiveUsers = "0";
	private String totalEntrenos = "0";
	private String totalTrainings = "0";
	
	private String DistNatSprintBase=Constantes.DistNatSprintBase + " metros";
	private String DistRunSprintBase= Constantes.DistRunSprintBase + " metros";
	private String DistCycleSprintBase = Constantes.DistCycleSprintBase + " metros";
	
	private String DistNatSprintGeneral = Constantes.DistNatSprintGeneral+ " metros";
	private String DistRunSprintGeneral = Constantes.DistRunSprintGeneral+ " metros";
	private String DistCycleSprintGeneral= Constantes.DistCycleSprintGeneral+ " metros";
	
	private String tiempoTestSwimSprint= Constantes.tiempoTestSwimSprint + " segundos";
	private String tiempoTestCycleSprint= Constantes.tiempoTestCycleSprint + " segundos";
	private String tiempoTestRunSprint= Constantes.tiempoTestRunSprint + " segundos";
	
	private String DistSwimOlimpicBase = Constantes.DistSwimOlimpicBase+ " metros";
	private String DistRunOlimpicBase = Constantes.DistRunOlimpicBase+ " metros";
	private String DistCycleOlimpicBase= Constantes.DistCycleOlimpicBase+ " metros";
	
	private String DistNatOlimpicGeneral = Constantes.DistSwimOlimpicGeneral+ " metros";
	private String DistRunOlimpicGeneral = Constantes.DistRunOlimpicGeneral+ " metros";
	private String DistCycleOlimpicGeneral= Constantes.DistCycleOlimpicGeneral+ " metros";
	
	private String tiempoTestSwimOlimpic= Constantes.tiempoTestSwimOlimpic + " segundos";
	private String tiempoTestCycleOlimpic= Constantes.tiempoTestCycleOlimpic + " segundos";
	private String tiempoTestRuOlimpic= Constantes.tiempoTestRunOlimpic + " segundos";
	
	private String DistSwimHalfBase = Constantes.DistSwimHalfcBase+ " metros";
	private String DistRunHalfBase = Constantes.DistRunHalfcBase+ " metros";
	private String DistCycleHalfBase= Constantes.DistCycleHalfBase+ " metros";
	
	private String DistNatHalfGeneral = Constantes.DistSwimHalfGeneral+ " metros";
	private String DistRunHalfGeneral = Constantes.DistRunHalfGeneral+ " metros";
	private String DistCycleHalfGeneral= Constantes.DistCycleHalfGeneral+ " metros";
	
	private String tiempoTestSwimHalf= Constantes.tiempoTestSwimHalf + " segundos";
	private String tiempoTestCycleHalf= Constantes.tiempoTestCycleHalf + " segundos";
	private String tiempoTestRuHalf= Constantes.tiempoTestRunHalf + " segundos";
	
	private Double peso=0.0;
	private Double FCM=0.0, FCR =0.0, mejorRun=0.0, mejorSwim=0.0, mejorCicle=0.0;
			
	
	
	



	private String totalKMSwim =  "0";
	private String totalKMCicle = "0";
	private String totalKMRun = "0";
	private int arrayPeso [] = { 0,0,0,0,0,0,0};
	private int arrayFCR [] = { 0,0,0,0,0,0,0};
	private int arrayFCM [] = { 0,0,0,0,0,0,0};
	private int arrayRun [] = { 0,0,0,0,0,0,0};
	private int arraySwim [] = {0,0,0,0,0,0,0};
	private int arrayCycle [] = { 0,0,0,0,0,0,0};
	private int arrayEntrenos [] = { 0,0,0,0,0,0,0,0,0,0,0,0};
	private String[] arrayMeses;
	
	
	
	




	private Calendar fecha = Calendar.getInstance();
	private List<TriTEntrenos>  entrenoAyer, entrenoMayana,entrenoHoy;
	private TriTEntrenos UnicoentrenoAyer;
	private List <Entrenamiento> entrenamientoAyer, entrenamientoHoy, entrenamientoMayana;
	private List<Test> test;
	private List<Historico> historico;
	private List<TriTHistorico> listaHistorico;
	private Date fechaA,fechaH,fechaM;
	private int idEjercicioA=0,idEjercicioO=0,idEjercicioM=0;
	private List <TriTTest> listaTest;
	private List <TriTHistorico> listaHistotico;
	   static Properties properties = new Properties();
	   static
	   {
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.socketFactory.port", "465");
	      properties.put("mail.smtp.socketFactory.class",
	                     "javax.net.ssl.SSLSocketFactory");
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.port", "465");
	   }


	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@SuppressWarnings("unchecked")
	public String execute() {
		Map sessionInicio = ActionContext.getContext().getSession();
		redirectAction=(TriTUsuarios)sessionInicio.get("usuario");
		String user = (String) (sessionInicio.get("usuario")!=null && getUsername()==null?redirectAction.getUsuario():getUsername());
		String pass = (String) (sessionInicio.get("usuario")!=null && getPassword()==null? redirectAction.getPassword():getPassword());
		String email = (String) (sessionInicio.get("email")!=null && getPassword()==null? redirectAction.getEmail():getEmail());
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		List<String> porcentages = new ArrayList();
	    
	    	
		try {
			
				TriTUsuariosMapper mapper = sqlSession
						.getMapper(TriTUsuariosMapper.class);
				TriTUsuariosExample userexample = new TriTUsuariosExample();
				userexample.createCriteria().andUsuarioEqualTo(user);

				TriTTestExample	TestExample	= new TriTTestExample();
				TestExample	= new TriTTestExample();
				//TriTUsuarios triTUsuarios = new TriTUsuarios();

				if (mapper.selectByExample(userexample).size()>0) {
					triTUsuarios=mapper.selectByExample(userexample).get(0);
					if (Security.esCorrecta(pass, triTUsuarios.getPassword())||redirectAction !=null) {
						if (triTUsuarios.getId_tipo_usuario()==3){
							Map session = ActionContext.getContext().getSession();
							session.put("usuario",triTUsuarios);

							TriTiEntrenoUsuarioExample entrenoUsuarioExample  = new TriTiEntrenoUsuarioExample();
							entrenoUsuarioExample.createCriteria().andId_usuarioEqualTo(triTUsuarios.getId_usuario()).andFecha_bajaIsNull();
							TriTiEntrenoUsuarioMapper mapperEntreno = sqlSession.getMapper(TriTiEntrenoUsuarioMapper.class);
							if (mapperEntreno.selectByExample(entrenoUsuarioExample).size()>0){
								triTUsuarioEntreno = mapperEntreno.selectByExample(entrenoUsuarioExample).get(0);

								TriTEntrenosExample	entrenosExample	= new TriTEntrenosExample();
								entrenosExample.createCriteria().andId_entrenoEqualTo(triTUsuarioEntreno.getId_entreno()).andFecha_bajaIsNull();
								TriTEntrenosMapper entrenosMapper = sqlSession.getMapper(TriTEntrenosMapper.class);
								triTEntrenosList = entrenosMapper.selectByExample(entrenosExample);	

								fecha.setTime(Calendar.getInstance().getTime());
								entrenosExample	= new TriTEntrenosExample();
								entrenosExample.createCriteria().andId_entrenoEqualTo(triTUsuarioEntreno.getId_entreno()).andFechaEqualTo(fecha.getTime()).andFecha_bajaIsNull();
								entrenosMapper = sqlSession.getMapper(TriTEntrenosMapper.class);
								entrenoHoy = entrenosMapper.selectByExample(entrenosExample);	
								idEjercicioO= (entrenoHoy.size()>0? entrenoHoy.get(0).getId_ejercicio() :32);
								fechaH=fecha.getTime();

								fecha.add(Calendar.DATE,-1);
								entrenosExample	= new TriTEntrenosExample();
								entrenosExample.createCriteria().andId_entrenoEqualTo(triTUsuarioEntreno.getId_entreno()).andFechaEqualTo(fecha.getTime()).andFecha_bajaIsNull();
								entrenosMapper = sqlSession.getMapper(TriTEntrenosMapper.class);
								entrenoAyer = entrenosMapper.selectByExample(entrenosExample);
								idEjercicioA= (entrenoAyer.size()>0? entrenoAyer.get(0).getId_ejercicio() :32);
								fechaA=fecha.getTime();						

								fecha.add(Calendar.DATE,2);
								entrenosExample	= new TriTEntrenosExample();
								entrenosExample.createCriteria().andId_entrenoEqualTo(triTUsuarioEntreno.getId_entreno()).andFechaEqualTo(fecha.getTime()).andFecha_bajaIsNull();
								entrenosMapper = sqlSession.getMapper(TriTEntrenosMapper.class);
								entrenoMayana = entrenosMapper.selectByExample(entrenosExample);
								idEjercicioM=  (entrenoMayana.size()>0? entrenoMayana.get(0).getId_ejercicio() :32);
								fechaM=fecha.getTime();


								entrenamientoAyer = Entrenamiento.setEntrenamiento(entrenoAyer);
								entrenamientoHoy  = Entrenamiento.setEntrenamiento(entrenoHoy);
								entrenamientoMayana  = Entrenamiento.setEntrenamiento(entrenoMayana);
								porcentages= FuncionesComunesService.obternerPorcentages(triTEntrenosList);
								porcentageS= porcentages.get(0);
								porcentageC= porcentages.get(1);
								porcentageR= porcentages.get(2);

								TriTBioUsuarioMapper bioUsuarioMapper = sqlSession.getMapper(TriTBioUsuarioMapper.class);
								TriTBioUsuarioExample bioUsuarioExample = new TriTBioUsuarioExample();
								bioUsuarioExample.createCriteria().andId_usuarioEqualTo(triTUsuarioEntreno.getId_usuario());
								entrenosExample	= new TriTEntrenosExample();
								entrenosExample.createCriteria().andId_entrenoEqualTo(triTUsuarioEntreno.getId_entreno());
								entrenosExample.setOrderByClause("id_entreno_ejercicio");
								triTEntrenosList=entrenosMapper.selectByExample(entrenosExample);
								peso = FuncionesComunesService.calcularPeso(triTEntrenosList,bioUsuarioMapper.selectByExample(bioUsuarioExample).get(0).getPeso());
								FCM =  FuncionesComunesService.calcularFCM(triTEntrenosList,bioUsuarioMapper.selectByExample(bioUsuarioExample).get(0).getPulsaciones_maximas().doubleValue());
								mejorSwim = FuncionesComunesService.calcularRun(triTEntrenosList,1);
								mejorCicle = FuncionesComunesService.calcularRun(triTEntrenosList,2);
								mejorRun = FuncionesComunesService.calcularRun(triTEntrenosList,3);


								arrayPeso=FuncionesComunesService.rellenarArray(triTEntrenosList,"peso");
								arrayFCM=FuncionesComunesService.rellenarArray(triTEntrenosList,"FCM");
								arrayFCR=FuncionesComunesService.rellenarArray(triTEntrenosList,"FCR");
								arrayRun=FuncionesComunesService.rellenarArray(triTEntrenosList,"run");
								arrayCycle=FuncionesComunesService.rellenarArray(triTEntrenosList,"cycle");
								arraySwim=FuncionesComunesService.rellenarArray(triTEntrenosList,"swim");
								TestExample.createCriteria().andIdEntrenoEqualTo(triTUsuarioEntreno.getId_entreno());
								TriTTestMapper TestMapper = sqlSession.getMapper(TriTTestMapper.class);
								TestMapper = sqlSession.getMapper(TriTTestMapper.class);

								listaTest= TestMapper.selectByExample(TestExample);
								test=Test.setTest(listaTest);

							}
							return "success";
						}
						else if(triTUsuarios.getId_tipo_usuario()==1){

							TriTUsuariosExample usuarioExample  = new TriTUsuariosExample();
							TriTUsuariosMapper mapperUser = sqlSession.getMapper(TriTUsuariosMapper.class);
							totalUsers= String.valueOf(mapperUser.selectByExample(usuarioExample).size());
							usuarioExample.createCriteria().andFecha_bajaIsNull();
							totalActiveUsers= String.valueOf(mapperUser.selectByExample(usuarioExample).size());
							TriTiEntrenoUsuarioExample entrenoUsuarioExample = new TriTiEntrenoUsuarioExample();
							TriTiEntrenoUsuarioMapper entrenoUsuarioMapper =sqlSession.getMapper(TriTiEntrenoUsuarioMapper.class);
							entrenoUsuarioExample.createCriteria().andFecha_bajaIsNull();
							totalEntrenos = String.valueOf(entrenoUsuarioMapper.selectByExample(entrenoUsuarioExample).size());
							entrenoUsuarioMapper =sqlSession.getMapper(TriTiEntrenoUsuarioMapper.class);
							totalTrainings= String.valueOf(entrenoUsuarioMapper.selectByExample(null).size());
							TriTHistoricoMapper historicoMapper  = sqlSession.getMapper(TriTHistoricoMapper.class);
							TriTHistoricoExample historicoExample = new TriTHistoricoExample();
							historicoExample.setOrderByClause("idHistorico DESC");
							listaHistorico= historicoMapper.selectByExample(historicoExample);
							historico= Historico.setHistorico(listaHistorico);
							arrayEntrenos= FuncionesComunesService.calcularEstadisticaEntrenos();
							arrayMeses=FuncionesComunesService.calcularMesesEntrenos();
							return "admin";
						}	
					}

				} 
				else {
					addActionError(getText("error.login"));
					return "error";
				}
			
		}
	    	
		finally {
			sqlSession.close();
		    }
		return "error";

	}
	
	public String recover() {
		
		return "error";
		
	}

	public String getTotalTrainings() {
		return totalTrainings;
	}

	public void setTotalTrainings(String totalTrainings) {
		this.totalTrainings = totalTrainings;
	}

	public List<Historico> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Historico> historico) {
		this.historico = historico;
	}

	public Double getMejorRun() {
		return mejorRun;
	}

	public void setMejorRun(Double mejorRun) {
		this.mejorRun = mejorRun;
	}

	public Double getMejorSwim() {
		return mejorSwim;
	}

	public void setMejorSwim(Double mejorSwim) {
		this.mejorSwim = mejorSwim;
	}

	public Double getMejorCicle() {
		return mejorCicle;
	}

	public void setMejorCicle(Double mejorCicle) {
		this.mejorCicle = mejorCicle;
	}

	public Double getFCM() {
		return FCM;
	}


	public void setFCM(Double fCM) {
		FCM = fCM;
	}


	public Double getFCR() {
		return FCR;
	}


	public void setFCR(Double fCR) {
		FCR = fCR;
	}

	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public List<Test> getTest() {
		return test;
	}


	public void setTest(List<Test> test) {
		this.test = test;
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


	public int getIdEjercicioA() {
		return idEjercicioA;
	}


	public void setIdEjercicioA(int idEjercicioA) {
		this.idEjercicioA = idEjercicioA;
	}


	public int getIdEjercicioO() {
		return idEjercicioO;
	}


	public void setIdEjercicioO(int idEjercicioO) {
		this.idEjercicioO = idEjercicioO;
	}


	public int getIdEjercicioM() {
		return idEjercicioM;
	}


	public void setIdEjercicioM(int idEjercicioM) {
		this.idEjercicioM = idEjercicioM;
	}


	public String getDistNatSprintBase() {
		return DistNatSprintBase;
	}


	public void setDistNatSprintBase(String distNatSprintBase) {
		DistNatSprintBase = distNatSprintBase;
	}


	public int[] getArrayFCR() {
		return arrayFCR;
	}


	public void setArrayFCR(int[] arrayFCR) {
		this.arrayFCR = arrayFCR;
	}


	public int[] getArrayFCM() {
		return arrayFCM;
	}


	public void setArrayFCM(int[] arrayFCM) {
		this.arrayFCM = arrayFCM;
	}


	public int[] getArrayRun() {
		return arrayRun;
	}


	public void setArrayRun(int[] arrayRun) {
		this.arrayRun = arrayRun;
	}


	public int[] getArraySwim() {
		return arraySwim;
	}


	public void setArraySwim(int[] arraySwim) {
		this.arraySwim = arraySwim;
	}


	public int[] getArrayCycle() {
		return arrayCycle;
	}


	public void setArrayCycle(int[] arrayCycle) {
		this.arrayCycle = arrayCycle;
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


	public TriTUsuarios getTriTUsuarios() {
		return triTUsuarios;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public TriTiEntrenoUsuario getTriTUsuarioEntreno() {
		return triTUsuarioEntreno;
	}


	public void setTriTUsuarioEntreno(TriTiEntrenoUsuario triTUsuarioEntreno) {
		this.triTUsuarioEntreno = triTUsuarioEntreno;
	}


	public List<TriTEntrenos> getTriTEntrenosList() {
		return triTEntrenosList;
	}


	public void setTriTEntrenosList(List<TriTEntrenos> triTEntrenosList) {
		this.triTEntrenosList = triTEntrenosList;
	}


	public Calendar getFecha() {
		return fecha;
	}


	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}


	public List<TriTEntrenos> getEntrenoAyer() {
		return entrenoAyer;
	}


	public void setEntrenoAyer(List<TriTEntrenos> entrenoAyer) {
		this.entrenoAyer = entrenoAyer;
	}


	public List<TriTEntrenos> getEntrenoMayana() {
		return entrenoMayana;
	}


	public void setEntrenoMayana(List<TriTEntrenos> entrenoMayana) {
		this.entrenoMayana = entrenoMayana;
	}


	public TriTEntrenos getUnicoentrenoAyer() {
		return UnicoentrenoAyer;
	}


	public void setUnicoentrenoAyer(TriTEntrenos unicoentrenoAyer) {
		UnicoentrenoAyer = unicoentrenoAyer;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setTriTUsuarios(TriTUsuarios triTUsuarios) {
		this.triTUsuarios = triTUsuarios;
	}


	public void setPorcentageR(String porcentageR) {
		this.porcentageR = porcentageR;
	}


	public void setPorcentageS(String porcentageS) {
		this.porcentageS = porcentageS;
	}


	public void setPorcentageC(String porcentageC) {
		this.porcentageC = porcentageC;
	}


	public String getPorcentageR() {
		return porcentageR;
	}

	public String getPorcentageS() {
		return porcentageS;
	}

	public String getPorcentageC() {
		return porcentageC;
	}

	public int[] getArrayPeso() {
		return arrayPeso;
	}

	public void setArrayPeso(int[] arrayPeso) {
		this.arrayPeso = arrayPeso;
	}


	public String getTotalUsers() {
		return totalUsers;
	}


	public void setTotalUsers(String totalUsers) {
		this.totalUsers = totalUsers;
	}


	public String getTotalEntrenos() {
		return totalEntrenos;
	}


	public void setTotalEntrenos(String totalEntrenos) {
		this.totalEntrenos = totalEntrenos;
	}


	public String getTotalKMSwim() {
		return totalKMSwim;
	}


	public void setTotalKMSwim(String totalKMSwim) {
		this.totalKMSwim = totalKMSwim;
	}


	public String getTotalKMCicle() {
		return totalKMCicle;
	}


	public void setTotalKMCicle(String totalKMCicle) {
		this.totalKMCicle = totalKMCicle;
	}


	public String getTotalKMRun() {
		return totalKMRun;
	}


	public void setTotalKMRun(String totalKMRun) {
		this.totalKMRun = totalKMRun;
	}


	public String getTotalActiveUsers() {
		return totalActiveUsers;
	}


	public void setTotalActiveUsers(String totalActiveUsers) {
		this.totalActiveUsers = totalActiveUsers;
	}
	public String getDistRunSprintBase() {
		return DistRunSprintBase;
	}


	public void setDistRunSprintBase(String distRunSprintBase) {
		DistRunSprintBase = distRunSprintBase;
	}


	public String getDistCycleSprintBase() {
		return DistCycleSprintBase;
	}


	public void setDistCycleSprintBase(String distCycleSprintBase) {
		DistCycleSprintBase = distCycleSprintBase;
	}


	public String getDistNatSprintGeneral() {
		return DistNatSprintGeneral;
	}


	public void setDistNatSprintGeneral(String distNatSprintGeneral) {
		DistNatSprintGeneral = distNatSprintGeneral;
	}


	public String getDistRunSprintGeneral() {
		return DistRunSprintGeneral;
	}


	public void setDistRunSprintGeneral(String distRunSprintGeneral) {
		DistRunSprintGeneral = distRunSprintGeneral;
	}


	public String getDistCycleSprintGeneral() {
		return DistCycleSprintGeneral;
	}


	public void setDistCycleSprintGeneral(String distCycleSprintGeneral) {
		DistCycleSprintGeneral = distCycleSprintGeneral;
	}


	public String getDistSwimOlimpicBase() {
		return DistSwimOlimpicBase;
	}


	public void setDistSwimOlimpicBase(String distSwimOlimpicBase) {
		DistSwimOlimpicBase = distSwimOlimpicBase;
	}


	public String getDistRunOlimpicBase() {
		return DistRunOlimpicBase;
	}


	public void setDistRunOlimpicBase(String distRunOlimpicBase) {
		DistRunOlimpicBase = distRunOlimpicBase;
	}


	public String getDistCycleOlimpicBase() {
		return DistCycleOlimpicBase;
	}


	public void setDistCycleOlimpicBase(String distCycleOlimpicBase) {
		DistCycleOlimpicBase = distCycleOlimpicBase;
	}


	public String getTiempoTestSwimSprint() {
		return tiempoTestSwimSprint;
	}


	public void setTiempoTestSwimSprint(String tiempoTestSwimSprint) {
		this.tiempoTestSwimSprint = tiempoTestSwimSprint;
	}


	public String getTiempoTestCycleSprint() {
		return tiempoTestCycleSprint;
	}


	public void setTiempoTestCycleSprint(String tiempoTestCycleSprint) {
		this.tiempoTestCycleSprint = tiempoTestCycleSprint;
	}


	public String getTiempoTestRunSprint() {
		return tiempoTestRunSprint;
	}


	public void setTiempoTestRunSprint(String tiempoTestRunSprint) {
		this.tiempoTestRunSprint = tiempoTestRunSprint;
	}
	public int[] getArrayEntrenos() {
		return arrayEntrenos;
	}

	public void setArrayEntrenos(int[] arrayEntrenos) {
		this.arrayEntrenos = arrayEntrenos;
	}

	public String[] getArrayMeses() {
		return arrayMeses;
	}

	public void setArrayMeses(String[] arrayMeses) {
		this.arrayMeses = arrayMeses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDistNatOlimpicGeneral() {
		return DistNatOlimpicGeneral;
	}

	public void setDistNatOlimpicGeneral(String distNatOlimpicGeneral) {
		DistNatOlimpicGeneral = distNatOlimpicGeneral;
	}

	public String getDistRunOlimpicGeneral() {
		return DistRunOlimpicGeneral;
	}

	public void setDistRunOlimpicGeneral(String distRunOlimpicGeneral) {
		DistRunOlimpicGeneral = distRunOlimpicGeneral;
	}

	public String getDistCycleOlimpicGeneral() {
		return DistCycleOlimpicGeneral;
	}

	public void setDistCycleOlimpicGeneral(String distCycleOlimpicGeneral) {
		DistCycleOlimpicGeneral = distCycleOlimpicGeneral;
	}

	public String getTiempoTestSwimOlimpic() {
		return tiempoTestSwimOlimpic;
	}

	public void setTiempoTestSwimOlimpic(String tiempoTestSwimOlimpic) {
		this.tiempoTestSwimOlimpic = tiempoTestSwimOlimpic;
	}

	public String getTiempoTestCycleOlimpic() {
		return tiempoTestCycleOlimpic;
	}

	public void setTiempoTestCycleOlimpic(String tiempoTestCycleOlimpic) {
		this.tiempoTestCycleOlimpic = tiempoTestCycleOlimpic;
	}

	public String getTiempoTestRuOlimpic() {
		return tiempoTestRuOlimpic;
	}

	public void setTiempoTestRuOlimpic(String tiempoTestRuOlimpic) {
		this.tiempoTestRuOlimpic = tiempoTestRuOlimpic;
	}

	public String getDistSwimHalfBase() {
		return DistSwimHalfBase;
	}

	public void setDistSwimHalfBase(String distSwimHalfBase) {
		DistSwimHalfBase = distSwimHalfBase;
	}

	public String getDistRunHalfBase() {
		return DistRunHalfBase;
	}

	public void setDistRunHalfBase(String distRunHalfBase) {
		DistRunHalfBase = distRunHalfBase;
	}

	public String getDistCycleHalfBase() {
		return DistCycleHalfBase;
	}

	public void setDistCycleHalfBase(String distCycleHalfBase) {
		DistCycleHalfBase = distCycleHalfBase;
	}

	public String getDistNatHalfGeneral() {
		return DistNatHalfGeneral;
	}

	public void setDistNatHalfGeneral(String distNatHalfGeneral) {
		DistNatHalfGeneral = distNatHalfGeneral;
	}

	public String getDistRunHalfGeneral() {
		return DistRunHalfGeneral;
	}

	public void setDistRunHalfGeneral(String distRunHalfGeneral) {
		DistRunHalfGeneral = distRunHalfGeneral;
	}

	public String getDistCycleHalfGeneral() {
		return DistCycleHalfGeneral;
	}

	public void setDistCycleHalfGeneral(String distCycleHalfGeneral) {
		DistCycleHalfGeneral = distCycleHalfGeneral;
	}

	public String getTiempoTestSwimHalf() {
		return tiempoTestSwimHalf;
	}

	public void setTiempoTestSwimHalf(String tiempoTestSwimHalf) {
		this.tiempoTestSwimHalf = tiempoTestSwimHalf;
	}

	public String getTiempoTestCycleHalf() {
		return tiempoTestCycleHalf;
	}

	public void setTiempoTestCycleHalf(String tiempoTestCycleHalf) {
		this.tiempoTestCycleHalf = tiempoTestCycleHalf;
	}

	public String getTiempoTestRuHalf() {
		return tiempoTestRuHalf;
	}

	public void setTiempoTestRuHalf(String tiempoTestRuHalf) {
		this.tiempoTestRuHalf = tiempoTestRuHalf;
	}

}
