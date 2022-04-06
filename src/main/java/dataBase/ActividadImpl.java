package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.evelia.api_siat.entity.ActividadEntity;

public class ActividadImpl extends BaseDao{
	
	public ActividadImpl() {}
	
	@SuppressWarnings("unchecked")
	protected Object rowMapper(ResultSet rs) throws SQLException {
		ActividadEntity actividad = new ActividadEntity();
		actividad.setActividadId(rs.getLong("ACTIVIDAD_ID"));
		actividad.setAulaId(rs.getLong("AULA_ID"));
		actividad.setDescripcion(rs.getString("DESCRIPCION"));
		actividad.setEventoFinalizacionId(rs.getLong("EVENTO_FINALIZACION_ID"));
		actividad.setFechaApertura(rs.getTimestamp("FECHA_APERTURA"));
		actividad.setFechaCierre(rs.getTimestamp("FECHA_CIERRE"));
		actividad.setId(rs.getLong("ID"));
		actividad.setTipoCalificacionId(rs.getLong("TIPO_CALIFICACION_ID"));
		actividad.setTipoActividadId(rs.getLong("TIPO_ACTIVIDAD_ID"));
		actividad.setAlcance(rs.getString( "ALCANCE" ));
		actividad.setParaQuien(rs.getString("PARA_QUIEN"));
		actividad.setModoRespuesta(rs.getString("MODO_RESPUESTA"));
		actividad.setBorrador(rs.getBoolean("BORRADOR"));
		actividad.setDetalles(rs.getBytes("DETALLES"));
		actividad.setNotaAprobarId(rs.getLong("NOTA_APROBAR_ID"));
		actividad.setPersonaId(rs.getLong("PERSONA_ID"));
		actividad.setGenerarEvento(rs.getBoolean("GENERAR_EVENTO"));
		actividad.setPublicacionId(rs.getLong("PUBLICACION_ID"));
		actividad.setDuplicado(rs.getBoolean("DUPLICADO"));
		return actividad;		
	}

}
