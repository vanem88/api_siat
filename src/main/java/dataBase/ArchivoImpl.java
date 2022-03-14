package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.evelia.api_siat.entity.ArchivoEntity;

public class ArchivoImpl extends BaseDao{

	public ArchivoImpl() {}
		
	@SuppressWarnings("unchecked")
	protected Object rowMapper(ResultSet rs) throws SQLException {
		ArchivoEntity archivo = new ArchivoEntity();
		archivo.setArchivoId(rs.getLong("ARCHIVO_ID"));
		archivo.setCantidadDownloads(rs.getInt("CANTIDAD_DOWNLOADS"));
		archivo.setCarpetaId(rs.getLong("CARPETA_ID"));
		archivo.setDescripcion(rs.getString("DESCRIPCION"));
	    archivo.setFechaUp(rs.getTimestamp("FECHA_UP"));
	    archivo.setNombre(rs.getString("NOMBRE"));
	    archivo.setPath(rs.getString("PATH"));
	    archivo.setTamanio(rs.getDouble("TAMANIO"));
	    archivo.setTiempoEstimado(rs.getString("TIEMPO_ESTIMADO"));
	    archivo.setEscaneadoOk(rs.getByte("ESCANEADO_OK"));
	    archivo.setCompartido(rs.getByte("COMPARTIDO"));
	    archivo.setAutorId(rs.getLong("AUTOR_ID"));
	    archivo.setNombreReal(rs.getString("NOMBRE_REAL"));
	   
		return archivo;
	}
}
