package es.tri.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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





import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction  extends ActionSupport {
	private String username;
	private String password;
	private TriTUsuarios triTUsuarios,redirectAction;
	@SuppressWarnings("unchecked")
	public String execute() {
		Map sessionInicio = ActionContext.getContext().getSession();
		redirectAction=(TriTUsuarios)sessionInicio.get("usuario");
		String user = (String) (sessionInicio.get("usuario")!=null && getUsername()==null?redirectAction.getUsuario():getUsername());
		String pass = (String) (sessionInicio.get("usuario")!=null && getPassword()==null? redirectAction.getPassword():getPassword());
		SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		List<String> porcentages = new ArrayList();
	
		try {
			return "success";
		}
		finally{}
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
	public TriTUsuarios getTriTUsuarios() {
		return triTUsuarios;
	}
	public void setTriTUsuarios(TriTUsuarios triTUsuarios) {
		this.triTUsuarios = triTUsuarios;
	}
	public TriTUsuarios getRedirectAction() {
		return redirectAction;
	}
	public void setRedirectAction(TriTUsuarios redirectAction) {
		this.redirectAction = redirectAction;
	}

}
