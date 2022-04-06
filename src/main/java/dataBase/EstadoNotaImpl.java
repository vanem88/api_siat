package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.evelia.api_siat.entity.EstadoNotaEntity;

public class EstadoNotaImpl  extends BaseDao{
	
	public EstadoNotaImpl() {}
	
	protected Object rowMapper(ResultSet rs) throws SQLException {
		EstadoNotaEntity estadoNota = new EstadoNotaEntity();
		estadoNota.setEstadoNotaId(rs.getLong("ESTADO_NOTA_ID"));
		estadoNota.setDescripcion(rs.getString("DESCRIPCION"));
		estadoNota.setId(rs.getLong("ID"));
		return estadoNota;
	}

}
