package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.evelia.api_siat.entity.NotaEntity;

public class NotaImpl extends BaseDao{
	
	public NotaImpl(){}
	
	@SuppressWarnings("unchecked")
	protected Object rowMapper(ResultSet rs) throws SQLException {
		NotaEntity nota = new NotaEntity();
		nota.setNotaId(rs.getLong("NOTA_ID"));
		nota.setActividadId(rs.getLong("ACTIVIDAD_ID"));
		nota.setArchivoId(rs.getLong("ARCHIVO_ID"));
		nota.setEstadoNotaId(rs.getLong("ESTADO_NOTA_ID"));
		nota.setFecha(rs.getTimestamp("FECHA"));
		nota.setId(rs.getLong("ID"));
		nota.setObservaciones(rs.getString("OBSERVACIONES"));
		nota.setPersonaId(rs.getLong("PERSONA_ID"));
		nota.setPersonaRealizoEntregaId(rs.getLong("PERSONA_REALIZO_ENTREGA_ID"));
		nota.setFechaProrroga(rs.getTimestamp("FECHA_PRORROGA"));
		nota.setDescripcionAlumno(rs.getBytes("DESCRIPCION_ALUMNO"));
		nota.setCalificacionIndividualId(rs.getLong("CALIFICACION_INDIVIDUAL_ID"));
		nota.setCalificacionGrupalId(rs.getLong("CALIFICACION_GRUPAL_ID"));			
		return nota;
	}

}
