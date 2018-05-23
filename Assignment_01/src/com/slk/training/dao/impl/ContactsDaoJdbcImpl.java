package com.slk.training.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.entity.Contact;
import com.slk.training.util.DbUtil;

public class ContactsDaoJdbcImpl implements ContactsDao {

	@Override
	public void addContact(Contact contact) throws DaoException {

	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		String sql = "select * from contacts where id = ?";
		try (Connection conn = DbUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);
		) {

			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					return resultSetToContact(rs);
				}
			}

			return null;
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		String sql = "update contacts set  first_name = ?, last_name = ?, email = ?, gender = ?, phone = ?, dob = ?, address = ?, city = ?, state = ?, country = ?, picture = ? where id = ?";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, contact.getFirstname());
			stmt.setString(2, contact.getLastname());
			stmt.setString(3, contact.getEmail());
			stmt.setString(4, contact.getGender());
			stmt.setString(5, contact.getPhone());
			
			Date dt = new Date(contact.getDob().getTime());
			stmt.setDate(6, dt);
			
			stmt.setString(7, contact.getAddress());
			stmt.setString(8, contact.getCity());
			stmt.setString(9, contact.getState());
			stmt.setString(10, contact.getCountry());
			stmt.setString(11, contact.getPicture());
			stmt.setInt(12, contact.getId());
			
			stmt.executeUpdate();

		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void deleteContact(Integer id) throws DaoException {

	}

	@Override
	public List<Contact> getAll() throws DaoException {
		String sql = "select * from contacts";
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			List<Contact> list = new ArrayList<>();
			while (rs.next()) {
				Contact c = resultSetToContact(rs);
				list.add(c);
			}

			return list;
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@Override
	public List<Contact> getContactsFromCity(String city) throws DaoException {

		String sql = "select * from contacts where city = ?";
		try (Connection conn = DbUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);

		) {

			stmt.setString(1, city);

			try (ResultSet rs = stmt.executeQuery();) {
				List<Contact> list = new ArrayList<>();
				while (rs.next()) {
					Contact c = resultSetToContact(rs);
					list.add(c);
				}

				return list;
			}

		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	private Contact resultSetToContact(ResultSet rs) throws SQLException {
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
