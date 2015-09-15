package es.tri.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvioCorreo {
   public static void enviaMail(String email, String body,String from,String Subject){
	   try
       {
	   Properties props = new Properties();
       props.setProperty("mail.smtp.host", "smtp.gmail.com");
       props.setProperty("mail.smtp.starttls.enable", "true");
       props.setProperty("mail.smtp.port", "587");
       props.setProperty("mail.smtp.user", from);
       props.setProperty("mail.smtp.auth", "true");

       // Preparamos la sesion
       Session session = Session.getDefaultInstance(props);

       // Construimos el mensaje
       MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress(from));
       message.addRecipient(
           Message.RecipientType.TO,
           new InternetAddress(email));
       message.setSubject(Subject);
       message.setText(body);

       // Lo enviamos.
       Transport t = session.getTransport("smtp");
       t.connect("tritrainer229@gmail.com", "redclaw85");
       t.sendMessage(message, message.getAllRecipients());

       // Cierre.
       t.close();
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
   }
}
