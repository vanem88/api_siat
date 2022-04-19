package com.evelia.api_siat.services;

import java.io.File;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.evelia.api_siat.entity.ActividadEntity;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.utils.ProcesosConArchivos;
import com.evelia.api_siat.utils.Util;
import com.evelia.api_siat.utils.constantes.PARAMETROS;
import com.evelia.api_siat.utils.constantes.TIPOS_CALIFICACION;
import com.evelia.api_siat.utils.email.Mail;
import com.evelia.api_siat.utils.email.Plantilla;
import com.evelia.api_siat.utils.email.SendMail;
import comun.constantes.ARCHIVO_DE;
import comun.constantes.ESTADO_NOTAS;
import comun.constantes.PARAMETROS_PAGINAS;
import comun.constantes.RECURSOS;
import dataBase.ActividadImpl;
import dataBase.PersonaImpl;
import persistencia.Persistencia;
import persistencia.dominio.Actividad;
import persistencia.dominio.Archivo;
import persistencia.dominio.Aula;
import persistencia.dominio.ConfiguracionNotificacion;
import persistencia.dominio.ConfiguracionPorAula;
import persistencia.dominio.DatosGenerales;
import persistencia.dominio.EstadoNota;
import persistencia.dominio.Nota;
import persistencia.dominio.Participante;
import persistencia.dominio.Persona;
import persistencia.dominio.Publicacion;
import server.aula.ControlAula;
import server.multiplesAdjuntos.ControlVersionado;
import utils.Utils;

@Service
public class ActividadService {
	
	private final static Logger logger = LoggerFactory.getLogger(ActividadService.class);
	
	@Autowired
    private JavaMailSender javaMailSender;
	 
	@Value("${rutaHTTPServidor}")
    private String rutaHTTPServidor;
	
	@Value("${nombreServidor}")
    private String nombreServidor;
	
	@Value("${aplicacion}")
    private String aplicacion;
	
	Persistencia persistencia = null;
	 
	 @Value("${file.aplicacion-dir}"+"${file.archivos-dir}")
	 private String pathArchivos;	
	 
	 @Value("${spring.mail.username}")
	 private String from;
	 
	 @Value("${rutaHTTPServidor}"+"${nombreServidor}"+"/"+"${aplicacion}"+"/"+"${file.mail-dir}")
	 private String CIDimagenCabecera;
	  
	 @Value("${file.aplicacion-dir}"+"${file.antivirus-dir}")
	 private String antivirus;
	 
	 @Value("${file.aplicacion-dir}"+"${file.temporal-dir}")
	 private String temporal;
	 
	 @Autowired
	 private TemplateEngine templateEngine;
		 
	 
	 /**
	  * Servicio que genera la entrega de una actividad por parte de un estudiante
	  */	 	 	
	 public String entregarActividad(Long idPersona,Long idActividad, String comentario, List<MultipartFile> archivosEnt) throws Exception {
		 logger.info("Servicio: /entregarActividad ");
		 try{		
			    //Tengo el id Largo, para usar jdo necesito el id corto.
			    PersonaImpl personaImpl = new PersonaImpl(); 
			    PersonaEntity personaEntity = (PersonaEntity)personaImpl.find("select * from PERSONA where PERSONA_ID=?",  new Object[] {idPersona});
			    ActividadImpl actividadImpl = new ActividadImpl();
			    ActividadEntity actividadEntity = (ActividadEntity)actividadImpl.find("select * from ACTIVIDAD where ACTIVIDAD_ID=?",  new Object[] {idActividad});
			    			    
			    if(personaEntity!=null && actividadEntity!=null) {			    
				    Long datetime = System.currentTimeMillis();
		    	    Timestamp fechaHoy = new Timestamp(datetime);
				    		    
	    		    persistencia = new Persistencia();	    
	    		    persistencia.setAislamiento(Connection.TRANSACTION_READ_COMMITTED);	    
				    persistencia.crearTransaccion();
	    		
				    Actividad actividad = (Actividad) persistencia.getObjectoPorId("persistencia.dominio.Actividad",actividadEntity.getId());
				    Publicacion publicacion = actividad.getPublicacion();
				 	ControlVersionado controlVersionado = new ControlVersionado(persistencia);
				 		 	
				 	if(publicacion!=null && (publicacion.getFechaApertura().before(fechaHoy) || publicacion.getFechaApertura()==null) && (publicacion.getFechaCierre().after(fechaHoy) || publicacion.getFechaCierre()==null)){
					 	 	Persona persona = (Persona) persistencia.getObjectoPorId("persistencia.dominio.Persona",personaEntity.getId());	
							// se debe controlar si ya tiene un trabajo enviado
							Nota nota = this.getNota(persona.getId(),actividad.getId());
							if (nota==null){ // si no tiene nota la creo
								nota= new Nota();
								EstadoNota en = (EstadoNota) (persistencia.getObjectosPorClase("persistencia.dominio.EstadoNota","","descripcion == \""+ESTADO_NOTAS.CERRADA+"\"","","",null,null,null)).elementAt(0);
								nota.setEstadoNota(en);
								persistencia.hacerPersistente(nota);							
							}else if(nota.getCalificacionIndividual()!=null && nota.getCalificacionIndividual().getEstadoCalificacion()!=null && nota.getCalificacionIndividual().getEstadoCalificacion().getNombre().compareTo(TIPOS_CALIFICACION.CALIFICADO)==0) 
										throw new Exception("La actividad ya está calificada.");	
									 	 				 	 	
							nota.setFecha(utils.Utils.hoySqlDate());
							nota.setActividad(actividad);
							nota.setPersona(persona);
							nota.setDescripcionAlumno(comentario); 
							String nombRehacer="";
							if(nota.getCalificacionIndividual()!=null && nota.getCalificacionIndividual().getEstadoCalificacion()!=null && nota.getCalificacionIndividual().getEstadoCalificacion().getNombre().compareTo("Rehacer")==0 && nota.getFechaProrroga()!=null)
								nombRehacer="REHACER_"+nota.getFechaProrroga()+"_";
							
							String pathArchivoEntregado = PARAMETROS.ID_AULA+actividad.getAula().getAulaCompuesta().getId()+"/"+PARAMETROS.ACTIVIDADES+"/"+actividad.getId();
							String nombreReal=nota.getId()+"_"+persona.getNombreYApellido();  
							String nombreArchivo =  Utils.obtenerNombreArchivo(persona,ARCHIVO_DE.ACTIVIDAD+nombRehacer,"Entrega");
													
							Archivo archivo = nota.getArchivo();
							boolean creoArchivoVersionado=false;							
														
							if (archivo==null){ // si no tiene archivo lo creo
								archivo = new Archivo();
								archivo.setAutor(persona);
								persistencia.hacerPersistente(archivo);
							}else {
								String nombreVersionado=nota.getId()+"_"+persona.getNombreYApellido(); 								
								if(controlVersionado.existeArchivoVersionado(nombreVersionado,pathArchivos+pathArchivoEntregado)){
									archivo=controlVersionado.versionarArchivo(nombreVersionado,pathArchivos+pathArchivoEntregado);
									creoArchivoVersionado=true;
								}	
							}
							
							if(archivosEnt.size()>1){
								if(!ProcesosConArchivos.comprimeArchivos(archivosEnt, persona, pathArchivos+pathArchivoEntregado, nombreArchivo ,ARCHIVO_DE.ACTIVIDAD_ALUMNO)) {
									if(creoArchivoVersionado) controlVersionado.eliminarArchivoVersion(archivo.getId(), archivo.getCantidadArchivosVersionados());
									throw new Exception("No se pudo comprimir los archivos.");
								} 
								archivo.setEscaneadoOk(Boolean.valueOf(true)); 
								nombreArchivo +=".zip";
							}else{													
								try {
									File localFile = new File(pathArchivos+pathArchivoEntregado+"/"+archivosEnt.get(0).getOriginalFilename());
									archivosEnt.get(0).transferTo(localFile);
							    	String nombreArchivoEnt = StringUtils.cleanPath(archivosEnt.get(0).getOriginalFilename());
									Float tamFile=new Float(archivosEnt.get(0).getSize()/1000.0);
									archivo.setTamanio(tamFile);
									
									int e=nombreArchivoEnt.lastIndexOf(".");
									String ext = nombreArchivoEnt.substring(e, nombreArchivoEnt.length());
									nombreArchivo +=ext;
									if(!ProcesosConArchivos.renombrarArchivo(pathArchivos+pathArchivoEntregado+"/"+nombreArchivoEnt,pathArchivos+pathArchivoEntregado+"/"+nombreArchivo)) {
										if(creoArchivoVersionado) controlVersionado.eliminarArchivoVersion(archivo.getId(), archivo.getCantidadArchivosVersionados());
										throw new Exception("No se pudo renombrar el archivo, controle su nombre.");
									}		  	
							    	
							    } catch (IllegalStateException e) {
							    	if(creoArchivoVersionado) controlVersionado.eliminarArchivoVersion(archivo.getId(), archivo.getCantidadArchivosVersionados());
									throw new Exception("No se pudo subir el archivo, controle su nombre.");
							    }			
								
							}
							
							archivo.setPath(pathArchivos+pathArchivoEntregado);
							archivo.setNombre(nombreArchivo);
							archivo.setCantidadDownloads(new Integer(0));
							archivo.setFechaUp(utils.Utils.hoySqlDate());
							archivo.setTiempoEstimado("ver que poner");
							archivo.setNombreReal(nombreReal);
							nota.setArchivo(archivo);
							
							DatosGenerales dato = (DatosGenerales)persistencia.getObjectosPorClase("persistencia.dominio.DatosGenerales").elementAt(0);
							if(dato==null) {
								dato = new DatosGenerales();
								dato.setHabilitarMensajeriaInterna(false);
								dato.setNotificarPorMail(true);
								dato.setNotificarPorMensajeInterno(false);
								dato.setSaludoMailGenerico("");
				 	        } 							
							notificaEncargadosDeComision(actividad,persona,dato);						
							
							persistencia.commit();
							return "ok";						
				 		}else
				 			return "fecha actividad fuera de tiempo";
			    }else
			    	return "Los parametros enviados son incorrectos.";
			}catch(Exception ee){
				persistencia.rollback();
				return "Exception... "+ee.getMessage();								
			}
		}
	 
	 
	 /**
	 * devuelve la nota asociada a la actividad y la persona, si no tiene nota asociada retorna null
	 */
	@SuppressWarnings("unchecked")
	private Nota getNota(Long idPersona, Long idActividad) throws Exception {
		try{
			String filtro = "persona.id == "+idPersona+" & actividad.id == "+idActividad;
			Vector<Nota> notas = persistencia.getObjectosPorClase("persistencia.dominio.Nota","",filtro,"","",null,null,null);
			if(notas!= null && !notas.isEmpty()) return (Nota)notas.elementAt(0);
			else return null;
		}catch(Exception ee){
			Utils.generarExcepcion(ee,this.getClass().getSimpleName()+".java","getNota");
		}
		return null;
	 }
	 
		
	 /**
	 * Envia un mail a los responsables del aula notificando que un estudiantes entregoo una actividad
	 * @throws Exception 
	 */	
	 private void notificaEncargadosDeComision(Actividad actividad,Persona persona,DatosGenerales datos) throws Exception {
	 	ControlAula controlAula = new ControlAula(persistencia);
		Long idComision=actividad.getAula().getId();
		Vector tutores = controlAula.getParticipantesEncargadoComision(idComision);
		if(tutores.size()>0){ //Se notifica a los tutores de la entrega
			Vector personasNotifMsjInt=new Vector();
			int cantPers=0;
			String mails=""; //Contiene todas las personas con el envio de mail habilitado y el mail correcto.
			for(Iterator iter = tutores.iterator(); iter.hasNext();) {
				Participante pc = (Participante) iter.next();
				Persona tutor = pc.getPersona();
				ConfiguracionNotificacion confNotPers=(ConfiguracionNotificacion) getConfiguracionNotificacion(tutor.getId(), idComision);//ver si es comision o aula
				boolean enviarNotif=false;
				if(confNotPers==null) enviarNotif=true;//Si no existe una configuracion de notificaciones que haga el envio igual
					else if(!confNotPers.isDesactivarNotificaciones()) //Si existe una configuracion de notificaciones si no estan desactivadas verifica si esta habilitado en envio dependiendo del tipo de notificacion que se quiera efectuar.
						enviarNotif=confNotPers.isActividadCreada();
					
				if(enviarNotif){
					personasNotifMsjInt.add(tutor);
					String mailPersona=tutor.getEmail();
					if(mailPersona.compareTo("")!=0){
						if(cantPers==0) mails+=mailPersona;
						else mails+=","+mailPersona;
						cantPers++;
					}
				}								
			}
			
			Long idCom = actividad.getAula().getId();
			Aula aula = actividad.getAula().getAulaCompuesta();
			Aula organizacion = aula.getAulaCompuesta();							
			
			String param=PARAMETROS_PAGINAS.REDIRECCIONAR_RECURSO+"="+RECURSOS.RECIBIR_Y_EVALUAR_ACTIVIDADES;
			if(organizacion.getId()!=null)	 param +="&"+PARAMETROS_PAGINAS.REDIRECCIONAR_ORGANIZACION+"="+organizacion.getId();
			if(aula.getId()!=null) param +="&"+PARAMETROS_PAGINAS.REDIRECCIONAR_AULA+"="+aula.getId();
			if(idCom!=null)  param +="&"+PARAMETROS_PAGINAS.REDIRECCIONAR_COMISION+"="+idCom;
			
			if(datos.isNotificarPorMail()){
				if(mails.compareTo("")!=0){
					SendMail sendMail = new SendMail();
					
					String asunto = "Nueva entrega de actividad";
					Mail mail = new Mail();
				    mail.setTo(mails);
				    mail.setSubject(asunto);
								    
				    String cuerpo = "Ud. posee una entrega de la actividad:"+actividad.getDescripcion()+"<br/>";
				    cuerpo +=	"efectuada por: "+persona.getNombreYApellido()+"<br/>";
				    cuerpo +=	"Correspondiente al aula virtual: "+ actividad.getAula().getAulaCompuesta().getNombre()+"<br/>";
				    String ref = rutaHTTPServidor+nombreServidor+"/"+aplicacion+"/index.jsp?"+param;
				    cuerpo +=	"Para visualizar la entrega presione el siguiente enlace <a target=\"_blank\" href=\""+ref+"\">Ver Actividad</a><br/><br/>";
				    cuerpo += datos.getSaludoMailGenerico();
				    				    			    
				    String urlSIAT = rutaHTTPServidor+nombreServidor+"/"+aplicacion;				    
				   
				  /*  Context context = new Context();
				    context.setVariable("urlSIAT", urlSIAT);				    
				    context.setVariable("CIDimagenCabecera", CIDimagenCabecera+"/cabecera.png");
				    context.setVariable("titulo", asunto);
				    //context.setVariable("contenido", cuerpo);
				    context.setVariable("actividad", actividad.getDescripcion());
				    context.setVariable("persona", persona.getNombreYApellido());
				    context.setVariable("aula", actividad.getAula().getAulaCompuesta().getNombre());
				    String ref = rutaHTTPServidor+nombreServidor+"/"+aplicacion+"/index.jsp?"+param;
				    context.setVariable("ref", ref);
				    
				    context.setVariable("telefono", datos.getTelefonoOficina());
				    context.setVariable("correo", datos.getMailContacto());
				    context.setVariable("oficina", Util.convert(datos.getUbicacionOficina()));
				    context.setVariable("siglaInstitucion", datos.getSiglaInstitucion());
				    context.setVariable("anio", utils.Utils.anioHoy());
				    context.setVariable("nombreInstitucion", Util.convert(datos.getNombreInstitucion()));
				    context.setVariable("version", datos.getVersionSistema());				    
				    String emailContent = templateEngine.process("envioMail", context);
				    mail.setText(emailContent);
		            */
		            
				    				   
			        mail.setText(cuerpo);
				    mail.setSendDate(new Date());
				    
				    //ajunto
				  /*  File file1 = new File("//var//lib//tomcat9//webapps//montagna//archivos//manuales//folleto-siat.pdf");
				    Vector archivos = new Vector();
				    archivos.add(file1);
				    mail.setFile(archivos);*/
				    
				    sendMail.sendHtmlMail(javaMailSender,mail,from,datos,CIDimagenCabecera, urlSIAT);
				}
			}
			
			/*if(DATOS_GENERALES.NOTIFICAR_POR_MENSAJE_INT){
				if(personasNotifMsjInt.size()>0){
					String[] destino = new String[personasNotifMsjInt.size()];
					for(int i=0;i<personasNotifMsjInt.size();i++){
						Persona pers=(Persona) personasNotifMsjInt.elementAt(i);
						destino[i] = pers.getId().toString();
					}
					String cuerpoMsjInt=ManejoString.transformaSimbolosAHTML(cuerpo)+ ((param!=null)?"presione el siguiente enlace "+UtilsGenerarHtml.enlaceRedireccion(false,param):"")+"<br/><br/>"+DATOS_GENERALES.SALUDO_MAIL_GENERICO;
					ControlMensajeriaInterna controlMensajeriaInterna= new ControlMensajeriaInterna(persistencia);
					controlMensajeriaInterna.agregarMensaje(null,destino,"Nueva entrega de actividad",cuerpoMsjInt,new Vector(),"",null);
				}
			}*/
			
		}		
	 }
	 
	 
	 private ConfiguracionNotificacion getConfiguracionNotificacion(Long idPers,Long idAula) throws Exception {
			ConfiguracionNotificacion confNot=null;
			try{
				//si el idAula nulo, verifico si existe en la confPersonal.
				if(idAula==null){
					confNot = getConfiguracionNotificacionEnPersona(idPers);
				}else{  //Verifico por el aula primero, si no existe verif por persona
					confNot = getConfiguracionNotificacionEnAula(idPers,idAula);
					if(confNot==null)
						confNot = getConfiguracionNotificacionEnPersona(idPers);
				}
			}catch(Exception ee){
				Utils.generarExcepcion(ee,this.getClass().getSimpleName()+".java","getConfiguracionNotificacion");
			}
			return confNot;
		}
	 
	 public ConfiguracionNotificacion getConfiguracionNotificacionEnPersona(Long idPers)throws Exception {
			ConfiguracionNotificacion confNot=null;
			try{
				Persona pers = (Persona) persistencia.getObjectoPorId("persistencia.dominio.Persona", idPers);
				if(pers.getConfiguracionPersonal()!=null){
					if(pers.getConfiguracionPersonal().getConfiguracionNotificacion()!=null)
						confNot=pers.getConfiguracionPersonal().getConfiguracionNotificacion();
				}
			}catch(Exception ee){
				Utils.generarExcepcion(ee,this.getClass().getSimpleName()+".java","getConfiguracionNotificacionEnPersona");
			}
			return confNot;
		}
	 
	 
	 public ConfiguracionNotificacion getConfiguracionNotificacionEnAula(Long idPers, Long idAula)throws Exception {
			ConfiguracionNotificacion confNot=null;
			try{
				Persona pers = (Persona) persistencia.getObjectoPorId("persistencia.dominio.Persona", idPers);
				if(pers.getConfiguracionPersonal()!=null){ //es posible que haya conf por aula
					String filtro= "configuracionPersonal.id=="+pers.getConfiguracionPersonal().getId() +" && aula.id=="+idAula;
					Vector confsAula = (Vector) persistencia.getObjectosPorClaseYFiltro("persistencia.dominio.ConfiguracionPorAula", filtro);
					if(confsAula.size()>0){
						ConfiguracionPorAula confA = (ConfiguracionPorAula) confsAula.elementAt(0);
						if(confA.getConfiguracionNotificacion()!=null)			
							confNot=confA.getConfiguracionNotificacion();
					}
				}
			}catch(Exception ee){
				Utils.generarExcepcion(ee,this.getClass().getSimpleName()+".java","getConfiguracionNotificacionEnAula");
			}
			return confNot;
		}
	 
	 private String obtenerMailPersona(Persona persona) throws Exception {
			String mailPersona = "";
			if(persona.getEmail()!=null && persona.getEmail().trim().compareTo("")!=0 && persona.getEmail().trim().compareTo("NO_DISPONIBLE")!=0){
				boolean resultado=true;
				String str=persona.getEmail().trim();
				char at='@';
				char dot='.';
				int lat=str.indexOf(at);
				int lstr=str.length();
				if (str.indexOf(at)==-1){
					resultado=false;
				} else if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr-1){
					resultado=false;
				} else if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr-1){ 
					resultado=false;
				} else if (str.indexOf(at,(lat+1))!=-1){
					resultado=false;
				} else if (str.charAt(lat-1)==dot || str.charAt(lat+1)==dot){   
					resultado=false;    
				} else if (str.indexOf(dot,(lat+2))==-1){    
					resultado=false;
				} else if (str.indexOf(" ")!=-1){
					resultado=false;
				}
				if(resultado)
					mailPersona = persona.getEmail();
			}
			return mailPersona;
		}
	
	 
		 
	

	 
	 
	 
	 
	
	 
		

}
