package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.evelia.api_siat.entity.PublicacionEntity;


public class PublicacionImpl extends BaseDao{

	public PublicacionImpl() {}
		
	@SuppressWarnings("unchecked")
	protected Object rowMapper(ResultSet rs) throws SQLException {
		PublicacionEntity publicacion = new PublicacionEntity();
		
		publicacion.setPublicacionId(rs.getLong("PUBLICACION_ID"));
		publicacion.setBorrador(rs.getBoolean( "BORRADOR" ));
		publicacion.setTipoPublicacion(rs.getString( "TIPO_PUBLICACION" ));
		publicacion.setFechaApertura(rs.getTimestamp("FECHA_APERTURA"));
		publicacion.setFechaCierre(rs.getTimestamp("FECHA_CIERRE"));
		publicacion.setGeneradoPor(rs.getString("GENERADO_POR"));		
		publicacion.setIdsGenera(rs.getString("IDS_GENERA"));
			
		return publicacion;
	}
}