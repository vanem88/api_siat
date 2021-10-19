package com.evelia.api_siat.controllers;

import com.evelia.api_siat.entity.ComisionEntity;
import com.evelia.api_siat.entity.ParticipanteComisionEntity;
import com.evelia.api_siat.entity.ParticipanteEntity;
import com.evelia.api_siat.repositories.ParticipanteComisionRepository;
import com.evelia.api_siat.repositories.ParticipanteRepository;
import com.evelia.api_siat.repositories.AulaRepository;
import com.evelia.api_siat.repositories.ComisionRepository;
import com.evelia.api_siat.services.AulaService;
import persistencia.Persistencia;
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
	
	////////////////////PRUEBA PERFORMANCE PERSISTENCIAS//////////////////////
    @Autowired
    ParticipanteRepository participanteRepository;
    
    @Autowired
    ParticipanteComisionRepository participanteCRepository;
    
    @Autowired
    ComisionRepository ComisionRepository;
    
    @Autowired
    AulaRepository AulaRepository;
    
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
    	//List<ParticipanteEntity> participantes = participanteRepository.findAll();
    	return "Cantidad de participantes: "+participantes.size();
    }
    
    
    @GetMapping( path = "/performanceTJDOParticipantesComision/{idComision}")
    public String performanceTJDOParticipantesComision(@PathVariable("idComision") Long idComision) {  
    	logger.info("Servicio: performanceTJDOParticipantesComision "+idComision);
        try{
	    	this.iniciarPersistencia();
			//String filtro="participante.persona.id == "+idPersona+" & comision.id == "+idComision;
	    	String filtro="comision.id == "+idComision;
			Vector participantes =  persistencia.getObjectosPorClaseYFiltro("persistencia.dominio.ParticipanteComision",filtro);
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
    
    
    
	///////////////////////////PARTICIPANTES DE UNA COMISION///////////////////////////////////////////////
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