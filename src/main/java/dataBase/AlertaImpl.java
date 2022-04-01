package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.evelia.api_siat.entity.AppMovilAlertasEntity;

public class AlertaImpl extends BaseDao{
		
	public AlertaImpl() {}
	
	@SuppressWarnings("unchecked")
	protected Object rowMapper(ResultSet rs) throws SQLException {
		AppMovilAlertasEntity alerta = new AppMovilAlertasEntity();
		alerta.setTextoAlerta(rs.getString( "TEXTO_ALERTA" ));
		alerta.setFecha(rs.getTimestamp("FECHA"));
		alerta.setTipoElemento(rs.getString("TIPO_ELEMENTO"));
		alerta.setAlertaId(rs.getLong("ALERTA_ID"));
		alerta.setReferenciaElementoId(rs.getLong("REFERENCIA_ELEMENTO_ID"));
		return alerta;		
	}
	
}
