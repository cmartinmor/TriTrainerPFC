package es.tri.action;

import java.util.Map;
import java.util.Properties;
import java.util.Random;

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
import es.tri.dao.TriTUsuariosMapper;
import es.tri.dao.model.TriTUsuarios;
import es.tri.dao.model.TriTUsuariosExample;
import es.tri.security.Security;
import es.tri.services.EnvioCorreo;

public class EmailerAction extends ActionSupport {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private TriTUsuarios triTUsuarios,redirectAction;
	private String from="TriTrainer@gmail.com";
   private String password="newpass";
  
   private String subject="Recover pass";
   private String body="your new passwords is "+password;



   public String execute() 
   {
	   Map sessionInicio = ActionContext.getContext().getSession();
	   redirectAction=(TriTUsuarios)sessionInicio.get("usuario");
	  String email = (String) (sessionInicio.get("email")!=null && getPassword()==null? redirectAction.getEmail():getEmail());
      String ret = SUCCESS;
      SqlSessionFactory sqlMapper = MyBatisConnectionFactory
				.getSqlSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		
		Random rnd = new Random();
		String pass=String.valueOf(100000 + rnd.nextInt(900000)) ;
      try
      {
    	  
    	  TriTUsuariosMapper mapper = sqlSession
					.getMapper(TriTUsuariosMapper.class);
			TriTUsuariosExample userexample = new TriTUsuariosExample();
			userexample = new TriTUsuariosExample();
			userexample.createCriteria().andEmailEqualTo(email);
			TriTUsuarios usuario= new TriTUsuarios();
			TriTUsuarios usuarioAntiguo = new TriTUsuarios();
			if (mapper.selectByExample(userexample).size() == 1) {
				usuarioAntiguo=mapper.selectByExample(userexample).get(0);
				// registro del usuario
				//usuario.setId_tipo_usuario(3);
				//usuario.setEmail(email);
				usuario.setId_usuario(usuarioAntiguo.getId_usuario());
				//usuario.setUsuario(usuarioAntiguo.getUsuario());
				//usuario.setNombre(usuarioAntiguo.getNombre()+"aaaa");
				//usuario.setApellido(usuarioAntiguo.getApellido());
				usuario.setPassword(Security.encriptar(pass));
				
				int result=mapper.updateByPrimaryKeySelective(usuario);
		
				sqlSession.commit();
				
				EnvioCorreo.enviaMail(email,"Your user is: "+usuarioAntiguo.getUsuario()+" and your new pass is: "+pass,"tritrainer229@gmail.com","Recover pass");
			}
      }
      catch(Exception e)
      {
         ret = ERROR;
         e.printStackTrace();
      }
      finally{
    	  
    	  sqlSession.close();
      }
      return ret;
   }

   public String getFrom() {
      return from;
   }

   public void setFrom(String from) {
      this.from = from;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }


   public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getBody() {
      return body;
   }

   public void setBody(String body) {
      this.body = body;
   }

   
}