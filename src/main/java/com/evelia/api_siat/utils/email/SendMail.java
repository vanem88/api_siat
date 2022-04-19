package com.evelia.api_siat.utils.email;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.context.Context;

import persistencia.dominio.Archivo;
import persistencia.dominio.DatosGenerales;

public class SendMail {
	
	public SendMail(){}
	
	 private final static Logger logger = LoggerFactory.getLogger(SendMail.class);
    
    public void sendMail(JavaMailSender javaMailSender,String to, String subject, String body,String from) {    	
    	try {
	        SimpleMailMessage mail = new SimpleMailMessage();
	        mail.setFrom(from);
	        mail.setTo(to);
	        mail.setSubject(subject);
	        mail.setText(body);	       
	        javaMailSender.send(mail);	        
    	}catch(Exception e){
    		logger.info("Exception .... "+e.getMessage());
    	}
    }
    
  /*
   * Enviar un mensaje simple con solo título y contenido
   * */
    public Mail sendSimpleMail(JavaMailSender javaMailSender,Mail mail,String from) {
    	SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject(mail.getSubject());
        message.setText(mail.getText());
        message.setTo(mail.getTo());
        message.setSentDate(mail.getSendDate());
        try {
        	javaMailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
        return mail;
    }
    
    /*
     * Enviar un mensaje html con un archivo adjunto
     * */
    public void sendHtmlMail(JavaMailSender javaMailSender,Mail mail,String from,DatosGenerales datos,String CIDimagenCabecera, String urlSIAT) {
        try {
        	String nombre = "Content-Type";
 			String valor = "text/html; charset=UTF-8";
        	        				
        	MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setSubject(mail.getSubject());
          
            /*logger.info("mail.getFile()",mail.getFile());
            if(mail.getFile()!=null && mail.getFile().size()>0) {
            	
            	logger.info("mail.getFile()",mail.getFile().getFilename());
            	helper.addAttachment(mail.getFile().getFilename(), mail.getFile());
            }
            
            
			for(int i = 0;i < adjuntos.size();i++){
				Archivo archivoAdjunto = (Archivo)adjuntos.get(i);
				String pathArchivo = archivoAdjunto.getPath();
				String nombreArchivo = archivoAdjunto.getNombre();

				BodyPart adjunto = new MimeBodyPart();
				adjunto.setDataHandler(new DataHandler(new FileDataSource(nombreArchivo)));
				adjunto.setFileName(archivoAdjunto.getNombreReal());
				multiParte.addBodyPart(adjunto);					
			}*/
            
            message.setText(mail.getText(), "UTF-8", "html");
            message.setHeader(nombre, valor);	
            
            Plantilla plantilla = new Plantilla();
            message.setContent(plantilla.plantillaMail(mail.getSubject(),mail.getText(),datos,CIDimagenCabecera, urlSIAT));
           
            
            //Envio de multiples emails
            String mails = mail.getTo();
            String[] recipientList = mails.split(",");
            InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for (String recipient : recipientList) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            message.setRecipients(Message.RecipientType.TO, recipientAddress);
            javaMailSender.send(message);
            
        } catch (MessagingException e) {
            logger.error("¡Se produjo una excepción al enviar correo html!", e);
        }        
    }
    

}
