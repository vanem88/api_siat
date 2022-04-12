package com.evelia.api_siat.controllers;

import com.evelia.api_siat.entity.ComisionEntity;
import com.evelia.api_siat.entity.ParticipanteComisionEntity;
import com.evelia.api_siat.entity.ParticipanteEntity;

import com.evelia.api_siat.repositories.ParticipanteComisionRepository;
import com.evelia.api_siat.repositories.ParticipanteRepository;
import com.evelia.api_siat.repositories.PersonaRepository;
import com.evelia.api_siat.repositories.AulaRepository;
import com.evelia.api_siat.repositories.ComisionRepository;
import com.evelia.api_siat.services.AulaService;
import persistencia.Persistencia;
import persistencia.dominio.Aula;
import persistencia.dominio.Participante;
import persistencia.dominio.Persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestPerformanceController {
	
	@Autowired
    ParticipanteRepository participanteRepository;
    
    @Autowired
    ParticipanteComisionRepository participanteCRepository;
    
    @Autowired
    ComisionRepository ComisionRepository;
    
    @Autowired
    AulaRepository AulaRepository;
    
    @Autowired
    PersonaRepository personaRepository;
    
    private final static Logger logger = LoggerFactory.getLogger(AulaService.class);    
    private Persistencia persistencia = null;   
    
    
    ///////PARTICIPANTES DE UN AULA///////////////
    @GetMapping( path = "/performanceHibernate/{idAula}")
    public void performanceHibernate(@PathVariable("idAula") Long idAula) {  
    	logger.info("Servicio: performanceHibernate "+idAula);
    	List<ParticipanteEntity> participantes = participanteRepository.findByAulaId(idAula);
    	//List<ParticipanteEntity> participantes = participanteRepository.findAll();
    	logger.info("participantes: "+participantes.size());
    }
    
    @GetMapping( path = "/performanceTJDO/{idAula}")
    public void performanceTJDO(@PathVariable("idAula") Long idAula) {  
    	logger.info("Servicio: performanceTJDO "+idAula);
     	try{
			this.iniciarPersistencia();
			
					String filtro="aula.id == "+idAula;
		    Vector participantes = persistencia.getObjectosPorClaseYFiltro("persistencia.dominio.Participante","",filtro);
		    Participante a =  (Participante)participantes.elementAt(0);
		    logger.info("a: "+a);
		    Aula au = a.getAula();
		    logger.info("aula: "+au);
		    logger.info("participantes: "+participantes.size());
		    this.commit();
		} catch (Exception e) {
			this.rollback();
			logger.info("exception");
		}
    }   
    
    @GetMapping( path = "/performanceSQL/{idAula}")
    public void performanceSQL(@PathVariable("idAula") Long idAula) {  
    	logger.info("Servicio: performanceSQL "+idAula);
    	try {
    		String connectionUrl = "jdbc:mysql://localhost:3306/datosEveliaMinimo?useUnicode=true&characterEncoding=utf8";
    		Connection  conect = DriverManager.getConnection(connectionUrl,"root","");
    		String SQL = "select * from PARTICIPANTE where AULA_ID= "+idAula;
    	    Statement stmt = conect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    	    ResultSet rs = stmt.executeQuery(SQL);
    	    rs.last();
    	    int size = rs.getRow();
    	    rs.beforeFirst();
    	    logger.info("participantes: "+size);
    	    rs.close();
    	    stmt.close();
    	}catch (Exception e) {
    	  e.printStackTrace();
    	}
    }
    
    
    
    ///////////////////////////PARTICIPANTES DE UNA COMISION///////////////////////////////////////////////
    @GetMapping( path = "/performanceHibernateParticipantesComision/{idComision}")
    public String performanceHibernateParticipantesComision(@PathVariable("idComision") Long idComision) {  
    	logger.info("Servicio: performanceHibernateParticipantesComision "+idComision);
    	List<ParticipanteComisionEntity> participantes = participanteCRepository.findByComisionId(idComision);
    	return "Cantidad de participantes: "+participantes.size();
    }
    
	@GetMapping( path = "/getParticipantesSQLNativo/{idComision}")
		public String getParticipantesSPRINGSQL(@PathVariable("idComision") Long idComision) { 
		logger.info("Servicio: getParticipantesSPRINGSQL "+idComision+" "+idComision);
		List<ParticipanteComisionEntity> participantes = participanteCRepository.participantesDeUnaComision(idComision);
		return "participantes: "+participantes.size();
	}    
    
    @GetMapping( path = "/performanceTJDOParticipantesComision/{idComision}")
    public String performanceTJDOParticipantesComision(@PathVariable("idComision") Long idComision) {  
    	logger.info("Servicio: performanceTJDOParticipantesComision "+idComision);
        try{
	    	this.iniciarPersistencia();
			Vector participantes =  persistencia.getObjectosPorClaseYFiltro("persistencia.dominio.ParticipanteComision","comision.id == "+idComision);
			this.commit();
			return "Cantidad de participantes: "+participantes.size();
		} catch (Exception e) {
			this.rollback();
			return "Exception";
		}
    }
    
    @GetMapping( path = "/performanceSQLParticipantesComision/{idComision}")
    public String performanceSQLParticipantesComision(@PathVariable("idComision") Long idComision) {  
    	logger.info("Servicio: performanceSQLParticipantesComision "+idComision);
    	try {
    		String connectionUrl = "jdbc:mysql://localhost:3306/datosEveliaMinimo?useUnicode=true&characterEncoding=utf8";
    		Connection  conect = DriverManager.getConnection(connectionUrl,"root","");
    		String SQL = "select * from PARTICIPANTE_COMISION where COMISION_ID= "+idComision;
    	    Statement stmt = conect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    	    ResultSet rs = stmt.executeQuery(SQL);
    	    rs.last();
    	    int size = rs.getRow();
    	    rs.beforeFirst();
    	    rs.close();
    	    stmt.close();
    	    return "Cantidad de participantes: "+size;
    	}catch (Exception e) {
    		return "Exception";
    	}
    }
    
    
    
	///////////////////////////CANTIDAD DE  COMISIONES ///////////////////////////////////////////////
	@GetMapping( path = "/getComisionesPersonaHIBERNATE")
	public String getComisionesPersonaHIBERNATE(@RequestParam("idAula") Long idAula,@RequestParam("idPersona") Long idPersona) { 
		logger.info("Servicio: getComisionesPersonaHIBERNATE "+idAula+" "+idPersona);
		List<ComisionEntity> comisiones = ComisionRepository.findByParticipanteComisionsByComisionIdParticipanteByParticipanteIdPersonaByPersonaIdPersonaIdAndAulaByComisionIdAulaCompuestaId(idPersona,idAula);
		//List<ComisionEntity> comisiones = AulaRepository.EncontrarComisiones(idPersona,idAula);
		return "comisiones: "+comisiones.size();
	}
	
		
	@GetMapping( path = "/getComisionesPersonaTJDO")
	public String getComisionesPersonaTJDO(@RequestParam("idAula") Long idAula,@RequestParam("idPersona") Long idPersona) {  
		logger.info("Servicio: getComisionesPersonaTJDO "+idAula);
		try{
			this.iniciarPersistencia();
			String filtro="participanteComisiones.contains(participanteComision) " +
					"& participanteComision.participante.persona.id == "+idPersona+" & participanteComision.participante.aula.id == "+idAula;
			String vars= "persistencia.dominio.ParticipanteComision participanteComision";
			Vector comisiones = persistencia.getObjectosPorClaseYFiltro("persistencia.dominio.Comision","nombre",filtro,vars);
			this.commit();
			return "comisiones: "+comisiones.size();
		} catch (Exception e) {
			this.rollback();
			return "exception";
		}
	}
	
	@GetMapping( path = "/getComisionesPersonaSQL")
	public String getComisionesPersonaSQL(@RequestParam("idAula") Long idAula,@RequestParam("idPersona") Long idPersona) {  
		logger.info("Servicio: getComisionesPersonaSQL "+idAula);
		try {
			String connectionUrl = "jdbc:mysql://localhost:3306/datosEveliaMinimo?useUnicode=true&characterEncoding=utf8";
			Connection  conect = DriverManager.getConnection(connectionUrl,"root","");
			String SQL = "select PARTICIPANTE_COMISION.comision_id from PARTICIPANTE inner join PARTICIPANTE_COMISION on PARTICIPANTE_COMISION.PARTICIPANTE_ID = PARTICIPANTE.PARTICIPANTE_ID where PARTICIPANTE.PERSONA_ID = "+idPersona+" AND PARTICIPANTE.AULA_ID = "+idAula; 
			Statement stmt = conect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SQL);
			rs.last();
			int size = rs.getRow();
			rs.beforeFirst();
			rs.close();
			stmt.close();
			return "comisiones: "+size;
		}catch (Exception e) {
			return "exception";
		}
	}
	
	
	
	////////////ACTUALIZACION
	///////////////////////////CANTIDAD DE  COMISIONES ///////////////////////////////////////////////
	@PostMapping( path = "/actualizarUsuario")
	public String actualizarUsuarioHibernate(@RequestParam("dni") Long id,@RequestParam("nombre") String nombre) { 
		logger.info("Servicio: actualizarUsuario "+id+" "+nombre);
		personaRepository.actualizarUsuario(id,nombre);
		return "ok";
	}

	@PostMapping( path = "/actualizarUsuarioTJDO")
	public String actualizarUsuarioTJDO(@RequestParam("dni") Long id,@RequestParam("nombre") String nombre) {  
		logger.info("Servicio: actualizarUsuarioTJDO "+id+" "+nombre);
		try{
			this.iniciarPersistencia();			
			Persona p = (Persona)persistencia.getObjectoPorId("persistencia.dominio.Persona", id);
			p.setNombre(nombre);
			this.commit();
			return "ok";
		} catch (Exception e) {
			this.rollback();
			return "exception";
		}
	}
	
	@PostMapping( path = "/actualizarUsuarioSQL")
	public int actualizarUsuarioSQL(@RequestParam("dni") Long id,@RequestParam("nombre") String nombre) {  
		logger.info("Servicio: actualizarUsuarioSQL "+id+" "+nombre);
		try{
			String connectionUrl = "jdbc:mysql://localhost:3306/datosEveliaMinimo?useUnicode=true&characterEncoding=utf8";
			Connection  conect = DriverManager.getConnection(connectionUrl,"root","");
			String SQL = "UPDATE PERSONA p SET p.NOMBRE = '"+nombre+"' WHERE p.ID = "+id; 
			Statement stmt = conect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			int rs = stmt.executeUpdate(SQL);
			stmt.close();
			return rs;
		}catch (Exception e) {
			return -1000000000;
		}
	}

	
	///////////////////////////////////////////////////////////////////
	public void iniciarPersistencia(){
		 try {
			 if (persistencia !=null)
			     persistencia.commit();
			 persistencia = new Persistencia();
			 persistencia.setAislamiento(Connection.TRANSACTION_READ_COMMITTED);	    
			 persistencia.crearTransaccion();	    
		 } catch (Exception e) {}
	 } 
	 
	 public boolean commit(){
		 try {
			 persistencia.commit();
			 return true;
		 }catch (Exception ex) {
			 ex.printStackTrace();
			 persistencia.rollback();
			 return false;
		 }
	 }
	 
	 public boolean rollback(){
		 try {
			 persistencia.rollback();
			 return true;
		 }catch (Exception ex) {
			 ex.printStackTrace();
			 return false;
		 }
	 }
	 
	 
	    
	   
  
}