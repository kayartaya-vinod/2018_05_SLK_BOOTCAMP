package spring.training.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import spring.training.dao.ContactsDao;
import spring.training.dao.DaoException;
import spring.training.entity.Contact;

@Component("dao")
public class ContactsDaoJdbcTemplateImpl implements ContactsDao {

	@Autowired(required = false)
	private JdbcTemplate template;

	private RowMapper<Contact> crm = new ContactRowMapper();

	@Override
	public void addContact(Contact contact) throws DaoException {
		String sql = "insert into contacts (first_name, last_name, email, gender, phone, dob, address, city, state, country, picture) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		template.update(sql, contact.getFirstname(), contact.getLastname(), contact.getEmail(), contact.getGender(),
				contact.getPhone(), contact.getDob(), contact.getAddress(), contact.getCity(), contact.getState(),
				contact.getCountry(), contact.getPicture());
	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		try {
			return template.queryForObject("select * from contacts where id = ?", crm, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void updateContact(Contact c) throws DaoException {
		System.out.println("Inside impl's updateContact() method.");
		String sql = "update contacts set first_name = ?, last_name = ?, "
				+ "email = ?, gender = ?, phone = ?, dob = ?, address = ?, "
				+ "city = ?, state = ?, country = ?, picture = ? where id = ?";
		template.update(sql, c.getFirstname(), c.getLastname(), c.getEmail(), c.getGender(), c.getPhone(), c.getDob(),
				c.getAddress(), c.getCity(), c.getState(), c.getCountry(), c.getPicture(), c.getId());
	}

	@Override
	public void deleteContact(Integer id) throws DaoException {
		if (template.update("delete from contacts where id = ?", id) == 0) {
			throw new DaoException("Invalid id for deletion: " + id);
		}
	}

	@Override
	public List<Contact> getAll() throws DaoException {
		return template.query("select * from contacts", crm);
	}

	@Override
	public List<Contact> getContactsFromCity(String city) throws DaoException {
		String sql = "select * from contacts where city = ?";
		return template.query(sql, crm, city);
	}

	@Override
	public int count() throws DaoException {
		return template.queryForObject("select count(*) from contacts", Integer.class);
	}

	class ContactRowMapper implements RowMapper<Contact> {

		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getInt("id"));
			contact.setFirstname(rs.getString("first_name"));
			contact.setLastname(rs.getString("last_name"));
			contact.setGender(rs.getString("gender"));
			contact.setEmail(rs.getString("email"));
			contact.setPhone(rs.getString("phone"));
			contact.setDob(rs.getDate("dob"));
			contact.setAddress(rs.getString("address"));
			contact.setCity(rs.getString("city"));
			contact.setState(rs.getString("state"));
			contact.setCountry(rs.getString("country"));
			contact.setPicture(rs.getString("picture"));
			return contact;
		}

	}
}
