package com.evelia.api_siat.services;

import com.evelia.api_siat.DataSource;
import com.evelia.api_siat.dto.AlertaComunicacionDto;
import com.evelia.api_siat.dto.PersonaDto;
import com.evelia.api_siat.entity.ParticipanteEntity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NotificacionesService {
	
    private final static Logger logger = LoggerFactory.getLogger(NotificacionesService.class);
       
    /**
     * Servicio que devuelve todos las alertas del aula y participande dados como parametro
     * @param Long idAula
     * @param Long idPersona
     * @return Json List<Evento> (Todo lo del calendario.) 
    */
    public List<AlertaComunicacionDto> obtenerAlertasComunicaciones(Long idAula, Long idPersona){
    	List<AlertaComunicacionDto> resultado = new ArrayList<>();
    	try {
	        	logger.info("Servicio: /obtenerAlertasComunicaciones");
	        	String SQL_QUERY = "select * from APP_MOVIL_ALERTAS as ama inner join APP_MOVIL_ALERTAS_USUARIO as amau on ama.ALERTA_ID=amau.ALERTA_ID where ama.AULA_ID='"+idAula+"' and amau.PERSONA_ID='"+idPersona+"' order by ama.FECHA DESC";
	        		        	
	        	Connection con = DataSource.getConnection();
	            PreparedStatement pst = con.prepareStatement( SQL_QUERY );
	            ResultSet rs = pst.executeQuery();
	        	
	            AlertaComunicacionDto alerta;
	            while ( rs.next() ) {
	            	alerta = new AlertaComunicacionDto();
	            	alerta.setTextoAlerta(rs.getString( "TEXTO_ALERTA" ));
	            	alerta.setFecha(rs.getTimestamp("FECHA"));
	            	alerta.setIdElemento(rs.getLong("REFERENCIA_ELEMENTO_ID"));
	            	alerta.setTextoAlerta(rs.getString("TEXTO_ALERTA"));
	            	alerta.setTipoElemento(rs.getString("TIPO_ELEMENTO"));
	                resultado.add( alerta );
	            }
	            
	            rs.close();
	            pst.close();
	            con.close();
	    	    
	        return resultado;
    	}catch(Exception ex){
    		return null;
    	}
    }
    
  

}