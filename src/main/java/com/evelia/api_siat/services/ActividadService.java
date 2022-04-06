package com.evelia.api_siat.services;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.evelia.api_siat.entity.ActividadEntity;
import com.evelia.api_siat.entity.NotaEntity;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.utils.ProcesosConArchivos;
import com.evelia.api_siat.utils.constantes.PARAMETROS;
import com.evelia.api_siat.utils.constantes.TIPO_PUBLICACION;

import comun.constantes.ARCHIVO_DE;
import comun.constantes.CARPETAS_ARCHIVOS_RECURSO;
import comun.constantes.ESTADO_NOTAS;
import comun.constantes.PARAMETROS_PAGINAS;
import comun.constantes.TIPO_ACTIVIDAD_EN_GRUPOS;
import dataBase.ActividadImpl;
import dataBase.NotaImpl;
import dataBase.PersonaImpl;
import persistencia.Persistencia;
import persistencia.dominio.Actividad;
import persistencia.dominio.Archivo;
import persistencia.dominio.Aula;
import persistencia.dominio.EstadoNota;
import persistencia.dominio.Nota;
import persistencia.dominio.Participante;
import persistencia.dominio.Persona;
import persistencia.dominio.Publicacion;
import server.actividades.ControlActividades;
import server.actividades.ControlActividadesGrupo;
import server.aula.ControlAula;
import server.datosPersonales.ControlConfiguracionPersonal;
import server.multiplesAdjuntos.ControlVersionado;
import utils.ProcesosEnLinux;
import utils.Utils;

@Service
public class ActividadService {
	
	private final static Logger logger = LoggerFactory.getLogger(ActividadService.class);
	  
	 @Autowired
	 FileStorageService fileStorageService;
	 Persistencia persistencia = null;
	 
	 @Value("${file.upload-dir}")
	 private String pathArchivos;
	 
	 public String entregarActividad(Long idPersona,Long idActividad, String comentario, MultipartFile archivoEnt) throws Exception {
		 logger.info("Servicio: /entregarActividad ");
		 try{		
			    //Tengo el id Largo, para usar jdo necesito el id corto.
			    PersonaImpl personaImpl = new PersonaImpl(); 
			    PersonaEntity personaEntity = (PersonaEntity)personaImpl.find("select * from Persona where PERSONA_ID=?",  new Object[] {idPersona});
			    ActividadImpl actividadImpl = new ActividadImpl();
			    ActividadEntity actividadEntity = (ActividadEntity)actividadImpl.find("select * from Actividad where ACTIVIDAD_ID=?",  new Object[] {idActividad});
			   		    
			    Long datetime = System.currentTimeMillis();
	    	    Timestamp fechaHoy = new Timestamp(datetime);
			    		    
    		    persistencia = new Persistencia();	    
    		    persistencia.setAislamiento(Connection.TRANSACTION_READ_COMMITTED);	    
			    persistencia.crearTransaccion();
    		    
    		    
			  	//Long idOrg=pagina.getIdOrganizacion();
				//boolean historial =pagina.isHistorial();
				
				//Long idAula=pagina.getIdAula();
				//String anioHist=(String) pagina.getSession().getAttribute(ATRIBUTOS_SESSION.ULTIMO_ANIO_VISTO_HISTORIAL);
			  		    
			 	Actividad actividad = (Actividad) persistencia.getObjectoPorId("persistencia.dominio.Actividad",actividadEntity.getId());
			 	Publicacion publicacion = actividad.getPublicacion();
			 	
			 	System.out.println("fechaHoy "+fechaHoy);
			 	System.out.println("publicacion.getFechaApertura() "+publicacion.getFechaApertura());
			 	System.out.println("publicacion.getFechaCierre() "+publicacion.getFechaCierre());
			 	
			 	ControlVersionado controlVersionado = new ControlVersionado(persistencia);
			 	
			 	if(publicacion!=null && (publicacion.getFechaApertura().before(fechaHoy) || publicacion.getFechaApertura()==null) && (publicacion.getFechaCierre().after(fechaHoy) || publicacion.getFechaCierre()==null)){
				 	 	Persona persona = (Persona) persistencia.getObjectoPorId("persistencia.dominio.Persona",personaEntity.getId());						
						// se debe controlar si ya tiene un trabajo enviado
						Nota nota = this.getNota(persona.getId(),actividad.getId());
						System.out.println("nota "+nota);
				 	 	if (nota==null){ // si no tiene nota la creo
							nota= new Nota();
							EstadoNota en = (EstadoNota) (persistencia.getObjectosPorClase("persistencia.dominio.EstadoNota","","descripcion == \""+ESTADO_NOTAS.CERRADA+"\"","","",null,null,null)).elementAt(0);
							nota.setEstadoNota(en);
							persistencia.hacerPersistente(nota);							
						}
						nota.setFecha(utils.Utils.hoySqlDate());
						nota.setActividad(actividad);
						nota.setPersona(persona);
						nota.setDescripcionAlumno(comentario); 
						String nombRehacer="";
						if(nota.getCalificacionIndividual()!=null && nota.getCalificacionIndividual().getEstadoCalificacion()!=null && nota.getCalificacionIndividual().getEstadoCalificacion().getNombre().compareTo("Rehacer")==0 && nota.getFechaProrroga()!=null)
							nombRehacer="REHACER_"+nota.getFechaProrroga()+"_";
						
						String pathArchivoEntregado = PARAMETROS.ID_AULA+actividad.getAula().getAulaCompuesta().getId()+"/"+PARAMETROS.ACTIVIDADES+"/"+actividad.getId();
					
						// crear el obeto que tiene el archivo en la base de datos si no existia el archivo
						//if (archivosAdj.size()>0){
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
								System.out.println("nombreVersionado: "+nombreVersionado);								
								//String x = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/siat2/archivos/idAula82014247174/actividades/82014250144";
								//System.out.println("x: "+x);
								System.out.println("pathArchivos+pathArchivoEntregado: "+pathArchivos+pathArchivoEntregado);					
								String filtro = "nombreReal==\""+nombreVersionado+"\" & path==\""+pathArchivos+pathArchivoEntregado+"\"";
								Vector archivos = persistencia.getObjectosPorClaseYFiltro("persistencia.dominio.Archivo",filtro);
								System.out.println("archivos: "+archivos);
								if(!archivos.isEmpty()) {
								//if(controlVersionado.existeArchivoVersionado(nombreVersionado,x)){
									System.out.println("existe archivo versinado");
									archivo=controlVersionado.versionarArchivo(nombreVersionado,pathArchivos+pathArchivoEntregado);
									System.out.println("versioar archivo: "+archivo);
									creoArchivoVersionado=true;
								}	
							}
							/*int cantArchivos=archivosAdj.size();
							ControlMultiplesAdjuntos controlMultiplesArchivos= new ControlMultiplesAdjuntos(persistencia);
							boolean almacenando = true;
							if(cantArchivos>1){
								almacenando=controlMultiplesArchivos.almacenarComprimidoDeMultiplesAdjuntosNuevo(archivosAdj, persona, pathArchivoAbsoluto, nombreArchivo ,ARCHIVO_DE.ACTIVIDAD_ALUMNO); 
								archivo.setEscaneadoOk(Boolean.valueOf(true)); 
								nombreArchivo +=".zip";
							}else if (cantArchivos==1){
								String rutaNombreArch= (String)archivosAdj.elementAt(0);
								File file= new File((String)rutaNombreArch);
								Float tamFile=new Float(file.length()/1000.0);
								archivo.setTamanio(tamFile);
								int e=rutaNombreArch.lastIndexOf(".");
								String ext = rutaNombreArch.substring(e, rutaNombreArch.length());
								nombreArchivo +=ext;
								almacenando = ProcesosEnLinux.moverORenombrarMV(rutaNombreArch,pathArchivoAbsoluto+"/"+nombreArchivo);
							}
							if(!almacenando){
								//borrar el archivo versionado creado, no hace falta cambiar lo de renombre de archivos
								if(creoArchivoVersionado){
									controlVersionado.eliminarArchivoVersion(archivo.getId(), archivo.getCantidadArchivosVersionados());
								}
								return false;
							}	*/	
							
							//Subir archivo
							
							System.out.println("por subir archivo");
							if(fileStorageService.subirArchivo(archivoEnt,pathArchivoEntregado+"\\")) { 			
								System.out.println("sui archivo");
								String nombreArchivoEnt = StringUtils.cleanPath(archivoEnt.getOriginalFilename());
								int e=nombreArchivoEnt.lastIndexOf(".");
								String ext = nombreArchivoEnt.substring(e, nombreArchivoEnt.length());
								nombreArchivo +=ext;
								System.out.println("por renombrar");
								if(!ProcesosConArchivos.renombrarArchivo(pathArchivos+pathArchivoEntregado+"\\"+nombreArchivoEnt,pathArchivos+pathArchivoEntregado+"\\"+nombreArchivo)) {
									System.out.println("no movi");
									/*if(creoArchivoVersionado){
										System.out.println("eliminarArchivoVersion movi");
										controlVersionado.eliminarArchivoVersion(archivo.getId(), archivo.getCantidadArchivosVersionados());
									}*/
									throw new Exception();	
								}
								
							}else
								throw new Exception(); 					
							
							archivo.setPath(pathArchivos+pathArchivoEntregado);
							archivo.setNombre(nombreArchivo);
							archivo.setCantidadDownloads(new Integer(0));
							archivo.setFechaUp(utils.Utils.hoySqlDate());
							archivo.setTiempoEstimado("ver que poner");
							archivo.setNombreReal(nombreReal);
							nota.setArchivo(archivo);
						//}
		
						/*ControlAula controlAula = new ControlAula(persistencia);
						Long idComision=actividad.getAula().getId();
						System.out.println("idComision: "+idComision);
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
							Aula aulaPpal= (Aula) persistencia.getObjectoPorId("persistencia.dominio.Aula", idAula);
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
							String paramRedireccion=UtilsGenerarHtml.parametrosRedireccion(pagina,RECURSOS.RECIBIR_Y_EVALUAR_ACTIVIDADES,idOrg,aulaPpal.getId(),idCom,idGpo,historial,anioHist);
		     			}*/
						
						persistencia.commit();
						return "ok";
						
			 		}else
			 			return "fecha actividad fuera de tiempo";
			 
			}catch(Exception ee){
				persistencia.rollback();
				return "Exception "+ee.getMessage();
			}
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
				System.out.println("getNota: "+filtro);
				
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
