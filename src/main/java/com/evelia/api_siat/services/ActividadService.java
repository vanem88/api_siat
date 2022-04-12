package com.evelia.api_siat.services;

import java.io.File;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.evelia.api_siat.entity.ActividadEntity;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.utils.ProcesosConArchivos;
import com.evelia.api_siat.utils.constantes.PARAMETROS;
import com.evelia.api_siat.utils.constantes.RECURSOS;
import com.evelia.api_siat.utils.constantes.TIPOS_CALIFICACION;
import comun.constantes.ARCHIVO_DE;
import comun.constantes.DATOS_GENERALES;
import comun.constantes.ESTADO_NOTAS;
import comun.constantes.PARAMETROS_PAGINAS;
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
import server.Server;
import server.aula.ControlAula;
import server.datosGenerales.ControlDatosGenerales;
import server.datosPersonales.ControlConfiguracionPersonal;
import server.mensajeriaInterna.ControlMensajeriaInterna;
import server.multiplesAdjuntos.ControlVersionado;
import utils.ManejoString;
import utils.Utils;
import utils.UtilsGenerarHtml;
import utils.mail.EnviarMailGmail;

@Service
public class ActividadService {
	
	private final static Logger logger = LoggerFactory.getLogger(ActividadService.class);
	  
	Persistencia persistencia = null;
	 
	 @Value("${file.upload-dir}")
	 private String pathArchivos;	
	 	
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
				 	/*System.out.println("fechaHoy "+fechaHoy);
				 	System.out.println("publicacion.getFechaApertura() "+publicacion.getFechaApertura());
				 	System.out.println("publicacion.getFechaCierre() "+publicacion.getFechaCierre());
				 	*/
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
						
						/*	logger.info("Servicio: /entregarActividad por empezar envio de mails");	
							
							ControlAula controlAula = new ControlAula(persistencia);
							Long idComision=actividad.getAula().getId();
							Vector tutores = controlAula.getParticipantesEncargadoComision(idComision);
							logger.info("Servicio: /entregarActividad tutores "+tutores);
							if(tutores.size()>0){ //Se notifica a los tutores de la entrega
								//Vector personasNotificar=new Vector();
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
											//enviarNotif=habilitadoEnvioTipoNotificacion(tipoNotificacion,confNotPers);
											enviarNotif=confNotPers.isActividadCreada();
										
									if(enviarNotif){
										personasNotifMsjInt.add(tutor);
										System.out.println("mail "+tutor.getEmail());
										String mailPersona=EnviarMailGmail.obtenerMailPersona(tutor);
										if(mailPersona.compareTo("")!=0){
											if(cantPers==0) mails+=mailPersona;
											else mails+=","+mailPersona;
											cantPers++;
										}
									}								
								}
								
								logger.info("Servicio: /entregarActividad mails "+mails);
								String cuerpo ="Ud. posee una entrega de la actividad: \""+actividad.getDescripcion()+"\"\n\n";
								cuerpo +="efectuada por: \""+persona.getNombre()+" "+persona.getApellido()+"\". \n\n";
								cuerpo +="Correspondiente al aula virtual: "+actividad.getAula().getNombre()+". \n\n";
								cuerpo +="Para visualizar la entrega ";
								
								Long idCom = actividad.getAula().getId();
								Aula aula = actividad.getAula().getAulaCompuesta();
								Aula organizacion = aula.getAulaCompuesta();							
								
								String param=PARAMETROS_PAGINAS.REDIRECCIONAR_RECURSO+"="+RECURSOS.RECIBIR_Y_EVALUAR_ACTIVIDADES;
								if(organizacion.getId()!=null)	 param +="&"+PARAMETROS_PAGINAS.REDIRECCIONAR_ORGANIZACION+"="+organizacion.getId();
								if(aula.getId()!=null) param +="&"+PARAMETROS_PAGINAS.REDIRECCIONAR_AULA+"="+aula.getId();
								if(idCom!=null)  param +="&"+PARAMETROS_PAGINAS.REDIRECCIONAR_COMISION+"="+idCom;
								//if(historial)    param +="&"+PARAMETROS_PAGINAS.HISTORIAL+"=true&idVerHistorial="+anio;							
						
								//String ref = Server.RUTA_HTTP_SERVIDOR+Server.NOMBRE_SERVIDOR+"/"+Server.APLICACION+"/index.jsp?"+param;
								//String redireccionar = "<a target=\"_blank\" href=\""+ref+"\" >Ver Informaci&oacute;n</a>";
							
								ControlDatosGenerales controlDatosGenerales = new ControlDatosGenerales(persistencia);
								DatosGenerales dato = controlDatosGenerales.obtenerDatosGenerales();
								
								
								if(dato.isNotificarPorMail()){
									logger.info("NOTIFICAR_POR_MAIL");
									if(mails.compareTo("")!=0){
										logger.info("mails.compareTo");										
										EnviarMailGmail enviarMailGmail = new EnviarMailGmail();
										logger.info("Servicio: /entregarActividad enviarMailGmail");
										String cuerpoMail=ManejoString.transformaSimbolosAHTML(cuerpo)+ ((param!=null)?"presione el siguiente enlace "+UtilsGenerarHtml.enlaceRedireccion(true,param):"")+"<br/><br/>"+DATOS_GENERALES.SALUDO_MAIL_GENERICO;
										logger.info("cuerpoMail: "+cuerpoMail);
										enviarMailGmail.enviandoMail(cantPers==1, mails, "Nueva entrega de actividad", cuerpoMail, "","");
									}
								}*/
								
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
								}
								
							}*/
							
							persistencia.commit();
							return "ok";						
				 		}else
				 			return "fecha actividad fuera de tiempo";
			    }else
			    	return "Los parametros enviados son incorrectos.";
			}catch(Exception ee){
				persistencia.rollback();
				return "Exception "+ee.getMessage();								
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
	
	 
		 
	 /**
		 * devuelve la nota asociada a la actividad y la persona, si no tiene nota asociada retorna null
		 * @param idPersona
		 * @param idActividad
		 * @return
		 * @throws Exception
		 */
		public Nota getNota(Long idPersona, Long idActividad) throws Exception {
			try{
				String filtro = "persona.id == "+idPersona+" & actividad.id == "+idActividad;
				Vector notas = persistencia.getObjectosPorClase("persistencia.dominio.Nota","",filtro,"","",null,null,null);
				if(notas!= null && !notas.isEmpty()) return (Nota)notas.elementAt(0);
				else return null;
			}catch(Exception ee){
				Utils.generarExcepcion(ee,this.getClass().getSimpleName()+".java","getNota");
			}
			return null;
		}

	 
	 
	 
	 
	/**
     * Servicio que genera la entrega de una actividad por parte de un estudiante
	*/	 
	 //ver de usar List<MultipartFile>
  /* 	public boolean entregarActividad1(Long idPersona,Long idActividad, String comentario, MultipartFile archivosEntregados) throws SQLException {
   		logger.info("Servicio: /entregarActividad ");
   		String pathArchivoAbsoluto ="";
   		//Vector archivosAdj = null;
   		   		
   		Connection conn = null;
   		try{
   			conn = DataSource.getConnection();
  		    conn.setAutoCommit(false);
  			
  		  	ActividadImpl actividadImpl = new ActividadImpl();
			ActividadEntity actividad = (ActividadEntity)actividadImpl.find(conn,"select * from Actividad where ACTIVIDAD_ID=?",  new Object[] {idActividad});
  		    PersonaImpl personaImpl = new PersonaImpl();
			PersonaEntity persona = (PersonaEntity)personaImpl.find(conn,"select * from Persona where PERSONA_ID=?",  new Object[] {idPersona});
			
			
			if(actividad.getAlcance()!= null && actividad.getAlcance().compareTo(TIPO_ACTIVIDAD_EN_GRUPOS.GRUPAL)==0){
				ControlActividadesGrupo controlActividadesGrupo = new ControlActividadesGrupo(this.persistencia);
				return controlActividadesGrupo.agregarTrabajoAlumno(persona,actividad,pathArchivoAbsoluto,descripcionAlumno,idGrupo,archivosAdj,pagina); //MLucero nuevo versionado
			}
			//ControlVersionado controlVersionado = new ControlVersionado(this.persistencia);
			// se debe controlar si ya tiene un trabajo enviado
			
			NotaImpl notaImpl = new NotaImpl();
			List<NotaEntity> notas = notaImpl.list(conn,"select * from Nota where PERSONA_ID=? & ACTIVIDAD_ID=?",  new Object[] {idPersona,idActividad});
			
			logger.info("notas: "+notas);
			NotaEntity nota = null;
			if(notas!= null && !notas.isEmpty()) nota = (NotaEntity)notas.get(0);			
			if (nota==null){ // si no tiene nota la creo
				logger.info("nota==null");
				nota= new NotaEntity();
				EstadoNotaImpl estadoNotaImpl = new EstadoNotaImpl();
				List<EstadoNotaEntity> estadoNotasEntity = estadoNotaImpl.list(conn,"select * from Estado_Nota where DESCRIPCION=?",  new Object[] {ESTADO_NOTAS.CERRADA});
				nota.setEstadoNotaId(estadoNotasEntity.get(0).getId());
				logger.info("hacerPersistente nota ");
				Nota notaJDO = new Nota();
				//notaJDO.setId(nota.getId());
				//notaJDO.set
				notaJDO.setObservaciones("observaciones");
				//persistencia.hacerPersistente(notaJDO);
			}	
			
			logger.info("hacerPersistente nota ");
			String nombRehacer="";
			//if(nota.getCalificacionIndividual()!=null && nota.getCalificacionIndividual().getEstadoCalificacion()!=null && nota.getCalificacionIndividual().getEstadoCalificacion().getNombre().compareTo("Rehacer")==0 && nota.getFechaProrroga()!=null)
			//	nombRehacer="REHACER_"+nota.getFechaProrroga()+"_";

			// crear el obeto que tiene el archivo en la base de datos si no existia el archivo
		   //if (archivosAdj.size()>0){
				String nombreVersionado=nota.getId()+"_"+persona.getApellido().trim()+", "+ persona.getNombre().trim();
				String nombreArchivo =  Util_Archivos.obtenerNombreArchivo(persona,ARCHIVO_DE.ACTIVIDAD+nombRehacer,"Entrega");
				ArchivoImpl archivoImpl = new ArchivoImpl();
				ArchivoEntity archivo = (ArchivoEntity)archivoImpl.find(conn,"select * from Archivo where ARCHIVO_ID=?",  new Object[] {nota.getArchivoId()});
				
				boolean creoArchivoVersionado=false;
				if (archivo==null){ // si no tiene archivo lo creo
					archivo = new ArchivoEntity();
					archivo.setAutorId(persona.getPersonaId());
					//persistencia.hacerPersistente(archivo);
					logger.info("hacerPersistente archivo ");
				} else {
					if(controlVersionado.existeArchivoVersionado(nombreVersionado,pathArchivoAbsoluto)){
						archivo=controlVersionado.versionarArchivo(nombreVersionado,pathArchivoAbsoluto);
						creoArchivoVersionado=true;
					}	
				}
				
				
				//ControlMultiplesAdjuntos controlMultiplesArchivos= new ControlMultiplesAdjuntos(this.persistencia);
				boolean almacenando = true;
				if(cantArchivos>1){
					almacenando=controlMultiplesArchivos.almacenarComprimidoDeMultiplesAdjuntosNuevo(archivosAdj, persona, pathArchivoAbsoluto, nombreArchivo ,ARCHIVO_DE.ACTIVIDAD_ALUMNO); 
					archivo.setEscaneadoOk(Boolean.valueOf(true)); 
					nombreArchivo +=".zip";
				}else //if (cantArchivos==1){
					String rutaNombreArch= (String)archivosAdj.elementAt(0);
					File file= new File((String)rutaNombreArch);
					Float tamFile=new Float(file.length()/1000.0);
					archivo.setTamanio(tamFile.doubleValue());
					int e = rutaNombreArch.lastIndexOf(".");
					String ext = rutaNombreArch.substring(e, rutaNombreArch.length());
					nombreArchivo +=ext;
				    logger.info("voy a mover archivo");
					almacenando = fileStorageService.subirArchivo(archivosEntregados,"idprueba//");
					//almacenando = ProcesosEnLinux.moverORenombrarMV(rutaNombreArch,pathArchivoAbsoluto+"/"+nombreArchivo);
				//}
				if(!almacenando){
					//borrar el archivo versionado creado, no hace falta cambiar lo de renombre de archivos
					if(creoArchivoVersionado){
						controlVersionado.eliminarArchivoVersion(archivo.getId(), archivo.getCantidadArchivosVersionados());
					}
					return comun.constantes.TEXTOS.ERROR_AL_GRABAR;
				}		
								
				Object[] arg = new Object[] {pathArchivoAbsoluto,nombreArchivo,0,Util_Fechas.hoySqlDate(),"ver que poner",nombreVersionado,nota.getArchivoId()};
				archivoImpl.update(conn,"update Archivo set PATH=?, NOMBRE=?,CANTIDAD_DOWNLOADS=?,FECHA_UP=?,TIEMPO_ESTIMADO=?,NOMBRE_REAL=? where ARCHIVO_ID=?", arg);
				logger.info("update Archivo");		
				arg = new Object[] {Util_Fechas.hoySqlDate(),idActividad,idPersona,comentario.getBytes(),archivo.getArchivoId(),nota.getNotaId()};
				notaImpl.update(conn,"update Nota set FECHA=?, ACTIVIDAD_ID=?,PERSONA_ID=?,DESCRIPCION_ALUMNO=?,ARCHIVO_ID=? where NOTA_ID=?", arg);		
				logger.info("update Nota");
			//}

			/*ControlAula controlAula = new ControlAula(persistencia);
			Vector tutores = controlAula.getParticipantesEncargadoComision(idComision);
			if(tutores.size()>0){ //Se notifica a los tutores de la entrega
				Vector personasNotificar=new Vector();
				for(Iterator iter = tutores.iterator(); iter.hasNext();) {
					Participante pc = (Participante) iter.next();
					boolean existe=false;
					for(int k=0;k<personasNotificar.size() && !existe;k++){
						Long p= (Long)personasNotificar.elementAt(k);
						if(pc.getPersona().getId().equals(p)){
							existe=true;
						}
					}
					if(!existe){
						personasNotificar.add(pc.getPersona().getId());
					}
				}
				ControlConfiguracionPersonal ctrlConfig= new ControlConfiguracionPersonal(persistencia);
				Aula aulaPpal= (Aula) this.persistencia.getObjectoPorId("persistencia.dominio.Aula", idAula);
				String comision="";
				Long idCom=null;
				Long idGpo=null;
				if(actividad.getAula() instanceof Comision){
					comision=" Comisión: \""+actividad.getAula().getNombre()+"\"";
					idCom=actividad.getAula().getId();
				}
				if(actividad.getAula() instanceof Grupo){		
					comision=" Grupo: \""+actividad.getAula().getNombre()+"\"";
					idGpo=actividad.getAula().getId();
				}
				String cuerpo ="Ud. posee una entrega de la actividad: \""+actividad.getDescripcion()+"\"\n\n";
				cuerpo +="efectuada por: \""+persona.getNombre()+" "+persona.getApellido()+"\". \n\n";
				cuerpo +="Correspondiente al aula virtual:  \"" + aulaPpal.getNombre()+"\" "+comision+". \n\n";
				cuerpo +="Para visualizar la entrega ";
				
				
			}
			
			//conn.commit();
			return true;
  		}catch(Exception e) {
   		   //conn.rollback();
   		   return false;
   		}finally {
			try {
				if (conn != null)  conn.close(); 
			}catch(Exception ex){}
		}
			}*/
		
		

}
