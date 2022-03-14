package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.evelia.api_siat.entity.ComentarioEntity;

public class ComentarioImpl extends BaseDao{
	
	public ComentarioImpl() {}

	@SuppressWarnings("unchecked")
	protected Object rowMapper(ResultSet rs) throws SQLException {
		ComentarioEntity comentario = new ComentarioEntity();
		comentario.setComentarioId(rs.getLong("COMENTARIO_ID"));
		comentario.setFecha(rs.getTimestamp("FECHA"));
		comentario.setContenido(rs.getBytes("CONTENIDO"));
		comentario.setPersonaId(rs.getLong("PERSONA_ID"));
		comentario.setArchivoId(rs.getLong("ARCHIVO_ID"));
		comentario.setTextoPadreId(rs.getLong("TEXTO_PADRE_ID"));
	    comentario.setComentPadreId(rs.getLong("COMENT_PADRE_ID"));
	    comentario.setEliminado(rs.getBoolean("ELIMINADO"));
	    comentario.setPrincipal(rs.getBoolean("PRINCIPAL"));
	    
	    return comentario;
	}
}
