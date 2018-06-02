package spring.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.training.dao.ContactsDao;
import spring.training.dao.DaoException;
import spring.training.entity.Contact;

@Component
public class ContactsDaoJdbcImpl implements ContactsDao {

	// represents a connection pool
	@Autowired(required = false)
	@Qualifier("dbcp")
	private DataSource dataSource;

	// writable property for spring to do dependency injection
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int count() throws DaoException {
		String sql = "select count(*) from phonebook";

		// get a connection from the pool
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			rs.next();
			return rs.getInt(1);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public void addContact(Contact contact) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public void deleteContact(Integer id) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public List<Contact> getAll() throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

	@Override
	public List<Contact> getContactsFromCity(String city) throws DaoException {
		throw new DaoException("Not implemented yet!");
	}

}
