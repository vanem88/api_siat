package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.evelia.api_siat.entity.TextoEntity;

public class TextoImpl extends BaseDao{

	public TextoImpl() {}
		
	@SuppressWarnings("unchecked")
	protected Object rowMapper(ResultSet rs) throws SQLException {
		TextoEntity texto = new TextoEntity();
		
		texto.setTextoId(rs.getLong("TEXTO_ID"));
		texto.setTitulo(rs.getString( "TITULO" ));
		texto.setContenido(rs.getBytes( "CONTENIDO" ));
		texto.setFecha(rs.getTimestamp("FECHA"));
		texto.setFechaEvento(rs.getTimestamp("FECHA_EVENTO"));
		texto.setFechaFinEvento(rs.getTimestamp("FECHA_FIN_EVENTO"));		
		texto.setEliminado(rs.getBoolean("ELIMINADO"));
		texto.setGenerarAlerta(rs.getBoolean("GENERAR_ALERTA"));
		texto.setPersonaId(rs.getLong("PERSONA_ID"));
		texto.setPublicacionId(rs.getLong("PUBLICACION_ID"));
			
		return texto;
	}
}
