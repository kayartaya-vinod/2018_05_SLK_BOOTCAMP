package com.slk.assignment.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.slk.assignment.dao.DaoException;
import com.slk.assignment.dao.PersonsDao;
import com.slk.assignment.entity.Person;
import com.slk.assignment.util.DbUtil;

public class PersonsDaoJdbcImpl implements PersonsDao {

	@Override
	public Person addPerson(Person person) throws DaoException {
		String sql = "insert into persons(firstname, lastname, email, phone) values(?,?,?,?)";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			stmt.setString(1, person.getFirstname());
			stmt.setString(2, person.getLastname());
			stmt.setString(3, person.getEmail());
			stmt.setString(4, person.getPhone());

			stmt.executeUpdate();

			ResultSet keys = stmt.getGeneratedKeys();
			keys.next();
			Integer id = keys.getInt(1);
			person.setId(id);
			return person;
		} catch (SQLException | ClassNotFoundException e) {
			throw new DaoException(e);
		}
	}


	@Override
	public void deletePerson(Integer id) throws DaoException {
		String sql = "delete from persons where id=?";
		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, id);
			if (stmt.executeUpdate() == 0) {
				throw new DaoException("Invalid id for deletion - " + id);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Person> getAll() throws DaoException {
		String sql = "select * from persons";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			List<Person> persons = new ArrayList<Person>();
			while (rs.next()) {
				Person p = personFromResultSet(rs);
				persons.add(p);
			}
			return persons;
		} catch (SQLException | ClassNotFoundException e) {
			throw new DaoException(e);
		}
	}

	private Person personFromResultSet(ResultSet rs) throws SQLException {
		Person p = new Person();
		p.setId(rs.getInt("id"));
		p.setFirstname(rs.getString("firstname"));
		p.setLastname(rs.getString("lastname"));
		p.setEmail(rs.getString("email"));
		p.setPhone(rs.getString("phone"));
		return p;
	}

}
