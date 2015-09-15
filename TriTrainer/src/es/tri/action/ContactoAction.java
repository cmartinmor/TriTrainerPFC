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

public class ContactoAction  extends ActionSupport {

	   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String email;
		private TriTUsuarios triTUsuarios,redirectAction;
		private String from;
	    private String to;	  
	    private String first_name;
	    private String last_name;


		private String comments;



	   public String execute() 
	   {
		   Map sessionInicio = ActionContext.getContext().getSession();
		   redirectAction=(TriTUsuarios)sessionInicio.get("usuario");
	      String ret = SUCCESS;
	      String email = getEmail();
	      String body = "Contact from "+email+":"+getComments();
		  String first_name= getFirst_name();
		  String last_name=getLast_name();
	      try
	      {
	    	  EnvioCorreo.enviaMail("tritrainer229@gmail.com",body,email,"Contact from "+first_name+" "+last_name);
	    	 
	      }
	      catch(Exception e)
	      {
	         ret = ERROR;
	         e.printStackTrace();
	      }
	      finally{
	    	  
	 
	      }
	      return ret;
	   }

	   public String getFrom() {
	      return from;
	   }

	   public void setFrom(String from) {
	      this.from = from;
	   }




	   public String getEmail() {
		return email;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	 
	    public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
	}
