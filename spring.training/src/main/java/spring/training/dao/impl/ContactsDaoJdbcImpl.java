package spring.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import spring.training.dao.ContactsDao;
import spring.training.dao.DaoException;

public class ContactsDaoJdbcImpl implements ContactsDao {

	// represents a connection pool
	private DataSource dataSource;
	
	// writable property for spring to do dependency injection
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public int count() throws DaoException {
		String sql = "select count(*) from phonebook";
		
		// get a connection from the pool
		try(Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();){
			
			rs.next();
			return rs.getInt(1);
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
	}

}
