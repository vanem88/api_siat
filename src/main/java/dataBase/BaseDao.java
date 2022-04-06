package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Patrón de método de plantilla
 * **/
public abstract class BaseDao {
	
	/**
	 * Agregar, eliminar, cambiar métodos
	 * @param sql
	 * @param args parámetro sql
	 * @return
	 */
	public int update(String sql, Object[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DataSource.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			return ps.executeUpdate();
		} catch (SQLException e) {
			return -1;
			//throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				//JdbcUtils.free(rs, ps, conn);
				if (rs != null)  rs.close(); 
				if (ps != null)  ps.close(); 
				if (conn != null)  conn.close(); 
			}catch(Exception ex){}
		}
	}

	/**
	 * Devuelve un objeto
	 * @param <T>
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> T find(String sql, Object[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {			
			conn = DataSource.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) 				
				ps.setObject(i + 1, args[i]);
			
			rs = ps.executeQuery();
			T t = null;
			if (rs.next()) {
				t = rowMapper(rs);
			}
			return t;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				//JdbcUtils.free(rs, ps, conn);
				if (rs != null)  rs.close(); 
				if (ps != null)  ps.close(); 
				if (conn != null)  conn.close(); 
			}catch(Exception ex){}
		}
	}

	/**
	 * Devuelve una lista
	 * @param <T>
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T> list(String sql, Object[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DataSource.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			rs = ps.executeQuery();
			T t = null;
			List<T> list = new ArrayList<T>();
			while (rs.next()) {
				t = rowMapper(rs);
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				//JdbcUtils.free(rs, ps, conn);
				if (rs != null)  rs.close(); 
				if (ps != null)  ps.close(); 
				if (conn != null)  conn.close(); 
			}catch(Exception ex){}
		}
	}
	
	/************************************/
	/* PARA EL MANEJO DE TRANSACCIONES */
	/*************************************/
	
	public int update(Connection conn,String sql, Object[] args) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null)  rs.close(); 
				if (ps != null)  ps.close(); 
			}catch(Exception ex){}
		}
	}

	public <T> T find(Connection conn,String sql, Object[] args) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {			
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) 				
				ps.setObject(i + 1, args[i]);
			
			rs = ps.executeQuery();
			T t = null;
			if (rs.next()) {
				t = rowMapper(rs);
			}
			return t;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null)  rs.close(); 
				if (ps != null)  ps.close(); 				
			}catch(Exception ex){}
		}
	}

	public <T> List<T> list(Connection conn,String sql, Object[] args) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			rs = ps.executeQuery();
			T t = null;
			List<T> list = new ArrayList<T>();
			while (rs.next()) {
				t = rowMapper(rs);
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null)  rs.close(); 
				if (ps != null)  ps.close(); 				
			}catch(Exception ex){}
		}
	}
	
	
	

	abstract protected <T> T rowMapper(ResultSet rs) throws SQLException;

}