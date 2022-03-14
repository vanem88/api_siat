package com.evelia.api_siat.services;

import com.evelia.api_siat.dto.AlertaComunicacionDto;
import com.evelia.api_siat.dto.ArchivoDto;
import com.evelia.api_siat.dto.ComentarioDto;
import com.evelia.api_siat.dto.TextoDto;
import com.evelia.api_siat.entity.AppMovilAlertasEntity;
import com.evelia.api_siat.entity.ArchivoEntity;
import com.evelia.api_siat.entity.ComentarioEntity;
import com.evelia.api_siat.entity.PersonaEntity;
import com.evelia.api_siat.entity.PublicacionEntity;
import com.evelia.api_siat.entity.TextoEntity;
import com.evelia.api_siat.utils.Util;
import dataBase.AlertaImpl;
import dataBase.ArchivoImpl;
import dataBase.ComentarioImpl;
import dataBase.PersonaImpl;
import dataBase.PublicacionImpl;
import dataBase.TextoImpl;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NotificacionesService  {
			
	private final static Logger logger = LoggerFactory.getLogger(NotificacionesService.class);
	     
    /**
     * Servicio que devuelve todos las alertas generadas para un aula (o comision) y un participante pasados como parametro
     * @param Long idAula
     * @param Long idComision
     * @param Long idPersona
     * @return Json List<AlertaComunicacionDto>
    */
  	public List<AlertaComunicacionDto> obtenerAlertasComunicaciones2(Long idAula,Long idComision, Long idPersona){
  	    	List<AlertaComunicacionDto> resultado = new ArrayList<>();
  	    	    	
  	      	try {
  	      		logger.info("Servicio: /obtenerAlertasComunicaciones2");
          		String SQL_QUERY = "";
  	           	String tipoNivelEvento = "";
  	           	Object[] args = null;
  	           	ArchivoDto archivoDto = null;
          		TextoDto textoDto = null;
          		ComentarioDto comentarioDto =null;
  	           	
  	           	boolean retornoAlerta = false;
  	        	Long datetime = System.currentTimeMillis();
          		Timestamp fechaHoy = new Timestamp(datetime);
          		
              	if(idComision==null) {
  	        		SQL_QUERY = "select DISTINCT * from APP_MOVIL_ALERTAS as ama inner join APP_MOVIL_ALERTAS_USUARIO as amau on ama.ALERTA_ID=amau.ALERTA_ID where ama.AULA_ID=? and amau.PERSONA_ID=? and amau.VISUALIZADA = '0' order by ama.FECHA DESC";
              		args = new Object[] { idAula,idPersona };
              		tipoNivelEvento = "E";
              	}else {
  	        		SQL_QUERY = "select DISTINCT * from APP_MOVIL_ALERTAS as ama inner join APP_MOVIL_ALERTAS_USUARIO as amau on ama.ALERTA_ID=amau.ALERTA_ID where ama.AULA_ID=? and ama.COMISION_ID=? and amau.PERSONA_ID=? and amau.VISUALIZADA = '0'  order by ama.FECHA DESC";
  	        		args = new Object[] { idAula,idComision,idPersona };
  	        		tipoNivelEvento = "EC";
              	}
              	
              	Long idAlerta;
              	AlertaImpl AlertaImpl = new AlertaImpl();
              	List<AppMovilAlertasEntity> list = AlertaImpl.list(SQL_QUERY, args);
              	for (AppMovilAlertasEntity alert : list) {
          			//Retona todas las alertas de los materiales nuevos
  	        		if(alert.getTipoElemento().compareTo("ARCHIVO")==0) {
  	            		archivoDto = ObtenerArchivo(alert.getReferenciaElementoId());
  	            		if(archivoDto !=null) retornoAlerta = true;		            	
  	            	}else {
  	            		//Retorno solo las alertas de las comunicaciones cuyas fechas de publicacion estan habilitadas.
  		            	if(alert.getTipoElemento().compareTo("COMENTARIO NOTICIA")==0) {	
  		            		comentarioDto = ObtenerComentario(alert.getReferenciaElementoId());
  		            		if(comentarioDto!=null) retornoAlerta = true;			     	            			            		
  		        		}else {	
  		        			textoDto = ObtenerPublicacion(alert.getReferenciaElementoId(),fechaHoy,tipoNivelEvento);
  		        			if(textoDto!=null) retornoAlerta = true;	
  		        		}
  	            	}
  	        		
  	        		if(retornoAlerta) {		    
  	        			AlertaComunicacionDto alertaDto = new AlertaComunicacionDto();
  	        			alertaDto.setTextoAlerta(alert.getTextoAlerta());
  	        			alertaDto.setFecha(alert.getFecha());
  	        			alertaDto.setTipoElemento(alert.getTipoElemento());
  	        			alertaDto.setAlertId(alert.getAlertaId());  	        		  	        			
  	        			alertaDto.setArchivo(archivoDto);
  	        			alertaDto.setPublicacion(textoDto);
  	        			alertaDto.setComentario(comentarioDto);
  		        		resultado.add(alertaDto);
  		        		
  		        		try {
  			        		idAlerta = alert.getAlertaId();
  			        		String SQL_DELETE = "DELETE FROM APP_MOVIL_ALERTAS_USUARIO WHERE ALERTA_ID= ? and PERSONA_ID =? ";
  			        		args = new Object[] { idAlerta,idPersona };
  			        		AlertaImpl.update(SQL_DELETE, args);
  			        		
  			        		SQL_QUERY = "SELECT ALERTA_USUARIOS_ID from APP_MOVIL_ALERTAS_USUARIO where ALERTA_ID=?";
  			        		args = new Object[] { idAlerta };
  			        		List<AlertaComunicacionDto> listAlertasUsuario = AlertaImpl.list(SQL_QUERY, args);
  			        		
  			        		if (listAlertasUsuario!=null && listAlertasUsuario.size()==0) 
  			        			AlertaImpl.update("DELETE FROM APP_MOVIL_ALERTAS WHERE ALERTA_ID=?", args);				        			
  		        		}catch(Exception e){
  		        			logger.error("Exception borrando alertas");
  		        		}
  		        		
  	        		}
  	            	retornoAlerta = false; 
  	            	archivoDto = null;
  	        		textoDto = null;
  	        		comentarioDto = null;			        			     			
          		}
          			          
  	            return resultado;	      	      	        	
  	    	}catch(Exception ex){
  	    	    System.out.println("Exception obtenerAlertasComunicaciones2");
  	    		return null;
  	    	} 		          		
  	}
  	 
  	/**
     * Genera el texto dto con el resultado obtenido de la base de datos.
     * Si es una alerta de un comentario retorna la pubicacion con el comentario modificado.
     * @param Connection con
     * @param long idReferenciaElemento
     * @param Timestamp fechaHoy
     * @param long idAula
     * @param long idComentario
     * @return TextoDto
    */
     private TextoDto ObtenerPublicacion(long idReferenciaElemento,Timestamp fechaHoy, String tipoEvento) {    	
     	try{
     		String SQL_QUERY = "SELECT * FROM TEXTO t inner join PUBLICACION p on t.PUBLICACION_ID = p.PUBLICACION_ID WHERE t.TEXTO_ID= ? AND t.ELIMINADO = 0 AND (p.fecha_Apertura <= ? OR p.fecha_Apertura IS NULL) AND (p.fecha_Cierre >= ? OR p.fecha_Cierre IS NULL)";
     		Object[] args = new Object[] { idReferenciaElemento,fechaHoy,fechaHoy };
     		
     		TextoImpl textoImpl = new TextoImpl();
     		TextoEntity texto = textoImpl.find(SQL_QUERY, args);    		
     		if( texto!=null ) {     			
     			TextoDto textoDto = new TextoDto();        		
    			textoDto.setId(texto.getTextoId());
	    		textoDto.setTitulo(texto.getTitulo());
	    		String str1 = new String(texto.getContenido());
	    		textoDto.setContenido(Util.convert(str1));
	    		textoDto.setFechaCreacion(texto.getFecha());
	    		textoDto.setFechaUltimaModificacion(texto.getFecha());	    		
	    		textoDto.setEliminado(texto.isEliminado());
	    		textoDto.setGenerarAlerta(texto.isGenerarAlerta());
	    		textoDto.setTipoEventoNivel(tipoEvento);
	    			    		
	    		args = new Object[] { texto.getPersonaId() };
	    		PersonaImpl personaImpl = new PersonaImpl();
	    		PersonaEntity persona = personaImpl.find("SELECT * FROM PERSONA WHERE PERSONA_ID= ?", args);    		
	    		if(persona!=null) {
	    			textoDto.setNombreApellidoPersona(persona.getNombre()+" "+persona.getApellido());
	    			textoDto.setPathFoto(persona.getPathFoto());
	    		}
	    		
	    		args = new Object[] { texto.getPublicacionId() };
	    		PublicacionImpl publicacionImpl = new PublicacionImpl();
	    		PublicacionEntity publicacion = publicacionImpl.find("SELECT * FROM PUBLICACION WHERE PUBLICACION_ID= ?", args);    		
	    		if(publicacion!=null) {
	    			textoDto.setTipoPublicacion(publicacion.getTipoPublicacion());
	    			textoDto.setDisponibleDesde(publicacion.getFechaApertura());
	    			textoDto.setDisponibleHasta(publicacion.getFechaCierre());
	    		}
	    		
	    		args = new Object[] { texto.getArchivoId() };
	    		ArchivoImpl archivoImpl = new ArchivoImpl();
	    		ArchivoEntity archivo = archivoImpl.find("SELECT * FROM ARCHIVO WHERE ARCHIVO_ID= ?", args);    		
	    		if(archivo!=null) 
	    			textoDto.setPathArchivo(archivo.getPath());
	    			    		
	    		textoDto.setComentarios(obtenerComentariosHijos(texto.getTextoId()));
	    			    		
 	    		return textoDto;
     		}else 
     			return null;
     	}catch(Exception ex){
     		logger.error("Exception ResultToTextoDto");
     		return null;
     	}
     }
           
     /**
      * Genera un comentario dto con el resultado obtenido de la base de datos.
      * @param Connection con
      * @param long idReferenciaElemento
      * @return ArchivoDto
     */
     private ComentarioDto ObtenerComentario(long idReferenciaElemento) {    
     	try{
     		String SQLQuery = "SELECT * FROM COMENTARIO where comentario_ID=?";
     		Object[] args = new Object[] {idReferenciaElemento};     		
     		ComentarioImpl comentarioImpl = new ComentarioImpl();
     		ComentarioEntity comentario =  comentarioImpl.find(SQLQuery, args);
     		if(comentario!=null) {
	     		ComentarioDto comentarioDto = new ComentarioDto();
	     		comentarioDto.setId(comentario.getComentarioId());
	     		String str1 = new String(comentario.getContenido());
	    		comentarioDto.setContenido(Util.convert(str1));
	    		comentarioDto.setComentarioPadreId(comentario.getComentPadreId());
	 			comentarioDto.setTextoPadreId(comentario.getTextoPadreId());
				comentarioDto.setFecha(comentario.getFecha());
				 			        			
				PersonaImpl personaImpl = new PersonaImpl();
	 			args = new Object[] { comentario.getPersonaId() };
	    		PersonaEntity personaComentario = personaImpl.find("SELECT * FROM PERSONA WHERE PERSONA_ID= ?", args);    		
	    		if(personaComentario!=null) {
	    			comentarioDto.setNombreApellidoPersona(personaComentario.getNombre()+" "+personaComentario.getApellido());
	    			comentarioDto.setPathfotoperfil(personaComentario.getPathFoto());
	    		}     
	    		return comentarioDto;
     		}else
     			return null;
			    		
         }catch(Exception ex){
     		logger.error("Exception ObtenerComentario");
     		return null;
     	}
     }

     /**
      * Genera un archivo dto con el resultado obtenido de la base de datos.
      * @param Connection con
      * @param long idReferenciaElemento
      * @return ArchivoDto
     */
     private ArchivoDto ObtenerArchivo(long idReferenciaElemento) {    	
     	try{
     		Object[] args = new Object[] {idReferenciaElemento};     		
     		ArchivoImpl archivoImpl = new ArchivoImpl();
     		ArchivoEntity archivo =  archivoImpl.find("select * from ARCHIVO where ARCHIVO_ID=?", args);
     		if( archivo!=null ) {
     			ArchivoDto archivoDto = new ArchivoDto();
     			archivoDto.setId(archivo.getArchivoId());
     			archivoDto.setDescripcion(archivo.getDescripcion());
 	    		archivoDto.setFechaUP(archivo.getFechaUp());
 	    		archivoDto.setNombre(archivo.getNombre());
 	    		archivoDto.setTamanio(archivo.getTamanio());
 	    		archivoDto.setURL(archivo.getPath()); 
 	    		return archivoDto;
     		}else 
     			return null;        	
     	}catch(Exception ex){
     		logger.error("Exception ObtenerArchivo");
     		return null;
     	}
     }
     
     /**
      * Obtiene todos los comentarios sina nidar de la publicacion dada como parametro
      * @param con
      * @param idPublicacion
      * @param idPadre
      * @return Collection<ComentarioDto>
      */
     private List<ComentarioDto> obtenerComentariosHijos(long idPublicacion){
    	 try{
	    	 List<ComentarioDto> comentariosDto = new ArrayList<>();
	    	 Object[]args = new Object[] { idPublicacion };
	 		 ComentarioImpl comentarioImpl = new ComentarioImpl();
	 		 List<ComentarioEntity> comentarios = comentarioImpl.list("SELECT * FROM COMENTARIO WHERE TEXTO_PADRE_ID= ?", args);    	
	 		 String str1;
	 		 PersonaImpl personaImpl = new PersonaImpl();
	 		 for(ComentarioEntity comentario : comentarios) { 
				ComentarioDto comentarioDto = new ComentarioDto();
	 			Long idComentario = comentario.getComentarioId();
	 			comentarioDto.setId(idComentario);
	 			str1 = new String(comentario.getContenido());
		    	comentarioDto.setContenido(Util.convert(str1));
	 			comentarioDto.setComentarioPadreId(comentario.getComentPadreId());
	 			comentarioDto.setTextoPadreId(comentario.getTextoPadreId());
	 			comentarioDto.setFecha(comentario.getFecha());
	 			        			
	 			args = new Object[] { comentario.getPersonaId() };
	    		PersonaEntity personaComentario = personaImpl.find("SELECT * FROM PERSONA WHERE PERSONA_ID= ?", args);    		
	    		if(personaComentario!=null) {
	    			comentarioDto.setNombreApellidoPersona(personaComentario.getNombre()+" "+personaComentario.getApellido());
	    			comentarioDto.setPathfotoperfil(personaComentario.getPathFoto());
	    		}        			
	 			comentariosDto.add(comentarioDto);    		
	 		 }
	 		 return comentariosDto;
    	 }catch(Exception ex){
      		logger.error("Exception obtenerComentariosHijos");
      		return null;
      	}
     }

     /**
      * Elimina todas las alertas no visualizadas por todos los usuarios
      * despues de una determinada cantidad de dias
      */
     public void eliminaAlertasNoVisualizadas(int cantDias){
     	try {
     		logger.info("Servicio: /eliminaAlertasNoVisualizadas");
     		
     		Calendar c = Calendar.getInstance();
             c.add(Calendar.DATE, -cantDias);
             Date date = c.getTime();	 
             Timestamp ts = new Timestamp(date.getTime());  
             
             AlertaImpl alertaImpl = new AlertaImpl();
             Object[] args = new Object[] { ts };
	 		 List<AppMovilAlertasEntity> alertas = alertaImpl.list("SELECT * from APP_MOVIL_ALERTAS where FECHA < ?", args);    	
	 		
	 		 for(AppMovilAlertasEntity alerta : alertas) {
            	 args = new Object[] { alerta.getAlertaId() };
            	 alertaImpl.update("DELETE FROM APP_MOVIL_ALERTAS WHERE ALERTA_ID = ?", args);
             }             	
  	            
     	}catch(Exception ex){
     		logger.error("Exception eliminaAlertasNoVisualizadas");    		
     	}
     }

     
     
     
     /*public List<AlertaComunicacionDto> obtenerAlertasComunicaciones(Long idAula,Long idComision, Long idPersona){
 	List<AlertaComunicacionDto> resultado = new ArrayList<>();
	        	       	
	    //Codigo usando sql directo con HIkari (Manejo de conexiones JDBC)
 	Connection con = null;
 	    	
 	//ResultSet rsFechaUltimoAcceso = null;
 	ResultSet rsAlertas = null;
 	ResultSet rsEliminarAlertas = null;
 	    	
   	try {
     		logger.info("Servicio: /obtenerAlertasComunicaciones");
     		con = DataSource.getConnection();
	                    		
	            String SQL_QUERY = "";
	        	//Selecciono ultima fecha de acceso.
	            String SQL_QUERY = "select MAX(FECHA_HORA_ENTRADA) as fecha from ACCESO_PAGINA where PERSONA_ID='"+idPersona+"'";	
	            rsFechaUltimoAcceso = pst.executeQuery(SQL_QUERY);        
	            if (rsFechaUltimoAcceso.next()) {
	            		            	
	            	//Busco alertas segun ultima fecha de acceso
	            	//Timestamp ultimaFechaAcceso = rsFechaUltimoAcceso.getTimestamp("fecha");	
	            	String tipoNivelEvento = "";
	            	if(idComision==null) {
		        		//SQL_QUERY = "select DISTINCT * from APP_MOVIL_ALERTAS as ama inner join APP_MOVIL_ALERTAS_USUARIO as amau on ama.ALERTA_ID=amau.ALERTA_ID where ama.AULA_ID='"+idAula+"' and amau.PERSONA_ID='"+idPersona+"' and ama.FECHA >= '"+ultimaFechaAcceso+"' and amau.VISUALIZADA = '0' order by ama.FECHA DESC";
	            		SQL_QUERY = "select DISTINCT * from APP_MOVIL_ALERTAS as ama inner join APP_MOVIL_ALERTAS_USUARIO as amau on ama.ALERTA_ID=amau.ALERTA_ID where ama.AULA_ID='"+idAula+"' and amau.PERSONA_ID='"+idPersona+"' and amau.VISUALIZADA = '0' order by ama.FECHA DESC";
	            		tipoNivelEvento = "E";
	            	}else {
		        		//SQL_QUERY = "select DISTINCT * from APP_MOVIL_ALERTAS as ama inner join APP_MOVIL_ALERTAS_USUARIO as amau on ama.ALERTA_ID=amau.ALERTA_ID where ama.AULA_ID='"+idAula+"' and ama.COMISION_ID='"+idComision+"' and amau.PERSONA_ID='"+idPersona+"' and ama.FECHA >= '"+ultimaFechaAcceso+"' and amau.VISUALIZADA = '0'  order by ama.FECHA DESC";
		        		SQL_QUERY = "select DISTINCT * from APP_MOVIL_ALERTAS as ama inner join APP_MOVIL_ALERTAS_USUARIO as amau on ama.ALERTA_ID=amau.ALERTA_ID where ama.AULA_ID='"+idAula+"' and ama.COMISION_ID='"+idComision+"' and amau.PERSONA_ID='"+idPersona+"' and amau.VISUALIZADA = '0'  order by ama.FECHA DESC";
		        		tipoNivelEvento = "EC";
	            	}
		        	//if (rsFechaUltimoAcceso != null)  rsFechaUltimoAcceso.close();
	            	
	            	rsAlertas = DataSource.ejecutarSQLSelect(con, SQL_QUERY);
	               	boolean retornoAlerta = false;	
		        	Long datetime = System.currentTimeMillis();
	        		Timestamp fechaHoy = new Timestamp(datetime);
	        		
	        		ArchivoDto archivoDto = null;
	        		TextoDto textoDto = null;
	        		ComentarioDto comentarioDto =null;
	        		
	        		Long idAlerta;
		        	while ( rsAlertas.next() ) {
		        		//Retona todas las alertas de los materiales nuevos
		        		if(rsAlertas.getString("TIPO_ELEMENTO").compareTo("ARCHIVO")==0) {
		            		archivoDto = ResultToArchivoDto(con, rsAlertas.getLong("REFERENCIA_ELEMENTO_ID"));
		            		if(archivoDto !=null) retornoAlerta = true;		            	
		            	}else {
		            		//Retorno solo las alertas de las comunicaciones cuyas fechas de publicacion estan habilitadas.
			            	if(rsAlertas.getString("TIPO_ELEMENTO").compareTo("COMENTARIO NOTICIA")==0) {	
			            		comentarioDto = ResultToComentarioDto(con, rsAlertas.getLong("REFERENCIA_ELEMENTO_ID"));
			            		if(comentarioDto!=null) retornoAlerta = true;			     	            			            		
			        		}else {	
			        			textoDto = ResultToTextoDto(con, rsAlertas.getLong("REFERENCIA_ELEMENTO_ID"),fechaHoy,tipoNivelEvento);
			        			if(textoDto!=null) retornoAlerta = true;	
			        		}
		            	}
		        		
		        		if(retornoAlerta) {
			        		AlertaComunicacionDto alertaDto = new AlertaComunicacionDto();
			        		alertaDto.setTextoAlerta(rsAlertas.getString( "TEXTO_ALERTA" ));
			        		alertaDto.setFecha(rsAlertas.getTimestamp("FECHA"));
			        		alertaDto.setTipoElemento(rsAlertas.getString("TIPO_ELEMENTO"));	        			        		
			        		alertaDto.setArchivo(archivoDto);
			        		alertaDto.setPublicacion(textoDto);
			        		alertaDto.setComentario(comentarioDto);
			        		resultado.add(alertaDto);
			        		
			        		try {
				        		idAlerta = rsAlertas.getLong("ALERTA_ID");
				        		//pstDelete.executeUpdate("UPDATE APP_MOVIL_ALERTAS_USUARIO SET VISUALIZADA = 1 WHERE ALERTA_ID="+rsAlertas.getLong("ALERTA_ID") +" and PERSONA_ID = "+idPersona);
				           		DataSource.ejecutarSQLUpdate(con, "DELETE FROM APP_MOVIL_ALERTAS_USUARIO WHERE ALERTA_ID="+idAlerta+" and PERSONA_ID = "+idPersona);
				           		rsEliminarAlertas = DataSource.ejecutarSQLSelect(con, "SELECT ALERTA_USUARIOS_ID from APP_MOVIL_ALERTAS_USUARIO where ALERTA_ID="+idAlerta);
				        		//Elimino la alerta si ya todos los usuarios la han visualizado
				        		if (!rsEliminarAlertas.next()) 
				        			DataSource.ejecutarSQLUpdate(con, "DELETE FROM APP_MOVIL_ALERTAS WHERE ALERTA_ID="+idAlerta);
			        		}catch(Exception e){
			        			logger.error("Exception borrando alertas");
			        		}
			        		
		        		}
		            	retornoAlerta = false; 
		            	archivoDto = null;
		        		textoDto = null;
		        		comentarioDto = null;		        			  
		            }//while          
	           // }            
	          
	            return resultado;	      	      	        	
 	}catch(Exception ex){
 		logger.error("Exception obtenerAlertasComunicaciones");
 		return null;
 	}finally {
 		try {
 			DataSource.cierraConexiones(con, rsAlertas.getStatement(), rsAlertas);
 		}catch(Exception ex){
 			DataSource.cierraConexiones(con, null, rsAlertas);
 		}  
 		try {
 			DataSource.cierraConexiones(con, rsEliminarAlertas.getStatement(), rsEliminarAlertas);
 		}catch(Exception ex){
 			DataSource.cierraConexiones(con, null, rsEliminarAlertas);
 		}  
     } 
 }
     
 private ArchivoDto ResultToArchivoDto(Connection con,long idReferenciaElemento) {    	
 	ResultSet rsArchivo = null;
 	try{
 		rsArchivo = DataSource.ejecutarSQLSelect(con, "select * from ARCHIVO where ARCHIVO_ID='"+idReferenciaElemento+"'");
 		if( rsArchivo.next() ) {
 			ArchivoDto archivoDto = new ArchivoDto();
	    		archivoDto.setDescripcion(rsArchivo.getString( "DESCRIPCION" ));
	    		archivoDto.setFechaUP(rsArchivo.getTimestamp("FECHA_UP"));
	    		archivoDto.setNombre(rsArchivo.getString("NOMBRE"));
	    		archivoDto.setTamanio(rsArchivo.getDouble("TAMANIO"));
	    		archivoDto.setURL(rsArchivo.getString( "PATH" )); 
	    		return archivoDto;
 		}else 
 			return null;        	
 	}catch(Exception ex){
 		logger.error("Exception ResultToArchivoDtTO");
 		return null;
 	}finally {
 		try {
 			DataSource.cierraConexiones(null, rsArchivo.getStatement(), rsArchivo);
 		}catch(Exception ex){
 			DataSource.cierraConexiones(null, null, rsArchivo);
 		} 
     }   	
 }
     
 private ComentarioDto ResultToComentarioDto(Connection con,long idReferenciaElemento) {    	
 	ResultSet rsComentario = null;
 	try{
 		rsComentario = DataSource.ejecutarSQLSelect(con, "SELECT * FROM COMENTARIO where comentario_ID='"+idReferenciaElemento+"'");
 		if (rsComentario.next()) {
 			ComentarioDto comentarioDto = new ComentarioDto();
 			comentarioDto.setContenido(rsComentario.getString("CONTENIDO"));
 			comentarioDto.setFecha(rsComentario.getTimestamp("FECHA"));
 			//comentarioDto.setComentarios(obtenerComentarios(con,rsComentario.getLong("COMENTARIO_ID")));
 			
 			
 			Long idPersona = rsComentario.getLong("PERSONA_ID");
 			rsComentario = DataSource.ejecutarSQLSelect(con, "SELECT * FROM PERSONA WHERE PERSONA_ID= '"+idPersona+"'");
 			if (rsComentario.next()) {
     			comentarioDto.setNombreApellidoPersona(rsComentario.getString("NOMBRE")+" "+rsComentario.getString("APELLIDO"));
     			comentarioDto.setPathfotoperfil(rsComentario.getString("PATH_FOTO"));
 			}
 			
 			return comentarioDto;    		
 		}else 
 			return null;
     }catch(Exception ex){
 		logger.error("Exception ResultToComentarioDto");
 		return null;
 	}finally {
 		try {
 			DataSource.cierraConexiones(null, rsComentario.getStatement(), rsComentario);
 		}catch(Exception ex){
 			DataSource.cierraConexiones(null, null, rsComentario);
 		} 
     }   	
 }
     
 private TextoDto ResultToTextoDto(Connection con, long idReferenciaElemento,Timestamp fechaHoy, String tipoEvento) {    	
 	ResultSet rs = null;
 
 	try{
 		String SQL_QUERY = "SELECT * FROM TEXTO t inner join PUBLICACION p on t.PUBLICACION_ID = p.PUBLICACION_ID WHERE t.TEXTO_ID= '"+idReferenciaElemento+"' AND t.ELIMINADO = 0 AND (p.fecha_Apertura <= '"+fechaHoy+"' OR p.fecha_Apertura IS NULL) AND (p.fecha_Cierre >= '"+fechaHoy+"' OR p.fecha_Cierre IS NULL)";
 		rs =  DataSource.ejecutarSQLSelect(con, SQL_QUERY);
 		
 		if( rs.next() ) {
 			
 			TextoDto textoDto = new TextoDto();
 		
 			textoDto.setId(rs.getLong("TEXTO_ID"));
	    		textoDto.setTitulo(rs.getString( "TITULO" ));
	    		textoDto.setContenido(rs.getString( "CONTENIDO" ));
	    		textoDto.setFechaCreacion(rs.getTimestamp("FECHA"));
	    		textoDto.setFechaUltimaModificacion(rs.getTimestamp("FECHA"));
	    		
	    		textoDto.setEliminado(rs.getBoolean("ELIMINADO"));
	    		textoDto.setGenerarAlerta(rs.getBoolean("GENERAR_ALERTA"));
	    		textoDto.setTipoEventoNivel(tipoEvento);
	    		    			    		
	    		String SQL_QUERY_PERSONA = "SELECT * FROM PERSONA WHERE PERSONA_ID= '"+rs.getLong("PERSONA_ID")+"'";
	    		String SQL_QUERY_FECHAS = "SELECT * FROM PUBLICACION WHERE PUBLICACION_ID= '"+rs.getLong("PUBLICACION_ID")+"'";
	    		String SQL_QUERY_ARCHIVO = "SELECT * FROM ARCHIVO WHERE ARCHIVO_ID= '"+rs.getLong("ARCHIVO_ID")+"'";
	    		
	    		rs = DataSource.ejecutarSQLSelect(con, SQL_QUERY_PERSONA);
	    		if(rs.next()) {
	    			textoDto.setNombreApellidoPersona(rs.getString("NOMBRE") + " "+rs.getString("APELLIDO"));
	    			textoDto.setPathFoto(rs.getString("PATH_FOTO"));
	    		}
	    		    		
	    		rs = DataSource.ejecutarSQLSelect(con, SQL_QUERY_FECHAS);
	    		if(rs.next()) {
	    			textoDto.setTipoPublicacion(rs.getString("TIPO_PUBLICACION"));
	    			textoDto.setDisponibleDesde(rs.getTimestamp("FECHA_APERTURA"));
	    			textoDto.setDisponibleHasta(rs.getTimestamp("FECHA_CIERRE"));	 
	    		}
	    		
	    		rs = DataSource.ejecutarSQLSelect(con, SQL_QUERY_ARCHIVO);
	    		if(rs.next()) 
	    			textoDto.setPathArchivo(rs.getString("PATH"));   				 
	    		
	    		textoDto.setComentarios(obtenerComentarios(con,idReferenciaElemento));
	    		
	    		return textoDto;
 		}else 
 			return null;
 	}catch(Exception ex){
 		logger.error("Exception ResultToTextoDto");
 		return null;
 	}finally {
 		try {
				DataSource.cierraConexiones(null, rs.getStatement(), rs);
 		}catch(Exception ex){
 			DataSource.cierraConexiones(null, null, rs);
 		}
     } 
 }
 
 private Collection<ComentarioDto> obtenerComentarios(Connection con, long idPublicacion, boolean idPadre){
 	Collection<ComentarioDto> comentarios = new HashSet();
 	ResultSet rsComentario = null;
 	ResultSet rsComentarioPersona = null;
 	try {
 		String SQL_QUERY_COMENTARIOS = "";
 		if(idPadre)
 			SQL_QUERY_COMENTARIOS = "SELECT * FROM COMENTARIO WHERE TEXTO_PADRE_ID= '"+idPublicacion+"' AND COMENT_PADRE_ID IS NULL";
 		else
 			SQL_QUERY_COMENTARIOS = "SELECT * FROM COMENTARIO WHERE COMENT_PADRE_ID= '"+idPublicacion+"'";
 		
 		rsComentario = DataSource.ejecutarSQLSelect(con, SQL_QUERY_COMENTARIOS);    		
 		while(rsComentario.next()) {
 			ComentarioDto comentarioDto = new ComentarioDto();
 			Long idComentario = rsComentario.getLong("COMENTARIO_ID");
 			comentarioDto.setId(idComentario);
 			comentarioDto.setContenido(rsComentario.getString("CONTENIDO"));
 			comentarioDto.setComentarioPadreId(rsComentario.getLong("COMENT_PADRE_ID"));
 			comentarioDto.setTextoPadreId(rsComentario.getLong("TEXTO_PADRE_ID"));
 			comentarioDto.setFecha(rsComentario.getTimestamp("FECHA"));    			      			
 			rsComentarioPersona = DataSource.ejecutarSQLSelect(con, "SELECT * FROM PERSONA WHERE PERSONA_ID= '"+rsComentario.getLong("PERSONA_ID")+"'");
 			if (rsComentarioPersona.next()) {
     			comentarioDto.setNombreApellidoPersona(rsComentarioPersona.getString("NOMBRE")+" "+rsComentarioPersona.getString("APELLIDO"));
     			comentarioDto.setPathfotoperfil(rsComentarioPersona.getString("PATH_FOTO"));
 			}
 			Collection<ComentarioDto> comentariosHijo = new HashSet();    			
 			comentariosHijo = obtenerComentarios(con, idComentario,false);
 			comentarioDto.setComentarios(comentariosHijo);
 			comentarios.add(comentarioDto);    		
 		}
 		return comentarios;
 	}catch(Exception e) {
 		logger.error("Exception obtenerComentarios "+ e.getMessage());
 		return null;
 	}finally {
 		try {
 			try {
 				DataSource.cierraConexiones(null, rsComentarioPersona.getStatement(), rsComentarioPersona);
     		}catch(Exception ex){
     			DataSource.cierraConexiones(null, null, rsComentarioPersona);
     		}
 			try {
 				DataSource.cierraConexiones(null, rsComentario.getStatement(), rsComentario);
 			}catch(Exception ex){
     			DataSource.cierraConexiones(null, null, rsComentario);
 			}    			 
 		}catch(Exception ex){}    		
     }     	
 }
 
 private List<ComentarioDto> obtenerComentarios(Connection con, long idPublicacion){
 	List<ComentarioDto> comentarios = new ArrayList<ComentarioDto>();
 	ResultSet rsComentario = null;
 	ResultSet rsComentarioPersona = null;
 	try {
 		rsComentario = DataSource.ejecutarSQLSelect(con, "SELECT * FROM COMENTARIO WHERE TEXTO_PADRE_ID= '"+idPublicacion+"'");    		
 		while(rsComentario.next()) {
 			ComentarioDto comentarioDto = new ComentarioDto();
 			Long idComentario = rsComentario.getLong("COMENTARIO_ID");
 			comentarioDto.setId(idComentario);
 			comentarioDto.setContenido(rsComentario.getString("CONTENIDO"));
 			comentarioDto.setComentarioPadreId(rsComentario.getLong("COMENT_PADRE_ID"));
 			comentarioDto.setTextoPadreId(rsComentario.getLong("TEXTO_PADRE_ID"));
 			comentarioDto.setFecha(rsComentario.getTimestamp("FECHA"));    			      			
 			rsComentarioPersona = DataSource.ejecutarSQLSelect(con, "SELECT * FROM PERSONA WHERE PERSONA_ID= '"+rsComentario.getLong("PERSONA_ID")+"'");
 			if (rsComentarioPersona.next()) {
     			comentarioDto.setNombreApellidoPersona(rsComentarioPersona.getString("NOMBRE")+" "+rsComentarioPersona.getString("APELLIDO"));
     			comentarioDto.setPathfotoperfil(rsComentarioPersona.getString("PATH_FOTO"));
 			}
 			comentarios.add(comentarioDto);    		
 		}
 		return comentarios;
 	}catch(Exception e) {
 		logger.error("Exception obtenerComentarios "+ e.getMessage());
 		return null;
 	}finally {
 		try {
 			try {
 				DataSource.cierraConexiones(null, rsComentarioPersona.getStatement(), rsComentarioPersona);
     		}catch(Exception ex){
     			DataSource.cierraConexiones(null, null, rsComentarioPersona);
     		}
 			try {
 				DataSource.cierraConexiones(null, rsComentario.getStatement(), rsComentario);
 			}catch(Exception ex){
     			DataSource.cierraConexiones(null, null, rsComentario);
 			}    			 
 		}catch(Exception ex){}    		
     }     	
 }

 public void eliminaAlertas(int cantDias){
 	Connection con = null;
 	ResultSet rs = null;
 	    	
   	try {
 		logger.info("Servicio: /eliminaAlertas");
 		
 		Calendar c = Calendar.getInstance();
         c.add(Calendar.DATE, -cantDias);
         Date date = c.getTime();	 
         Timestamp ts=new Timestamp(date.getTime());  
        
 		con = DataSource.getConnection();
 		rs = DataSource.ejecutarSQLSelect(con, "SELECT ALERTA_ID from APP_MOVIL_ALERTAS where FECHA < '"+ts+"'");
        	while(rs.next()) 	            
         	DataSource.ejecutarSQLUpdate(con, "DELETE FROM APP_MOVIL_ALERTAS WHERE ALERTA_ID = "+rs.getLong("ALERTA_ID")); 
	            
 	}catch(Exception ex){
 		logger.error("Exception eliminaAlertas");    		
 	}finally {
 		try {
 			DataSource.cierraConexiones(con, rs.getStatement(), rs);
 		}catch(Exception ex){
 			DataSource.cierraConexiones(con, null, rs);
 		}    		
     } 
 }*/
 
 
}