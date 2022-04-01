package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.evelia.api_siat.entity.PersonaEntity;

public class PersonaImpl extends BaseDao{
	
	public PersonaImpl() {}

	@SuppressWarnings("unchecked")
	protected Object rowMapper(ResultSet rs) throws SQLException {
		PersonaEntity persona = new PersonaEntity();
		
		persona.setPersonaId(rs.getLong("PERSONA_ID"));
		persona.setNombre(rs.getString("NOMBRE"));
		persona.setApellido(rs.getString("APELLIDO"));
		persona.setEmail(rs.getString("EMAIL"));
		persona.setPathFoto(rs.getString("PATH_FOTO"));
		persona.setId(rs.getLong("ID"));
		
		return persona;
	}
}
