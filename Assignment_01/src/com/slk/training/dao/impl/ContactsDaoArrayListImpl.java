package com.slk.training.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.entity.Contact;

public class ContactsDaoArrayListImpl implements ContactsDao {

	private List<Contact> contacts;

	public ContactsDaoArrayListImpl() {
		contacts = new ArrayList<>();
	}

	@Override
	public void addContact(Contact contact) throws DaoException {

		if (contact == null) {
			throw new DaoException("null value for contact is not acceptable");
		}
		if (contact.getFirstname() == null || contact.getFirstname().trim() == "") {
			throw new DaoException("firstname cannot be null or empty string");
		}
		if (contact.getEmail() == null || contact.getEmail().trim() == "") {
			throw new DaoException("email cannot be null or empty string");
		}
		if (contact.getPhone() == null || contact.getPhone().trim() == "") {
			throw new DaoException("phone cannot be null or empty string");
		}

		if (!contacts.contains(contact)) {
			contacts.add(contact);
		}
	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		if (id == null || id <= 0) {
			throw new DaoException("id cannot be null or zero or negative");
		}
		for (Contact c : contacts) {
			if (c.getId() == id) {
				return c;
			}
		}

		return null;
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {

	}

	@Override
	public void deleteContact(Integer id) throws DaoException {

	}

	@Override
	public List<Contact> getAll() throws DaoException {
		return contacts;
	}

	@Override
	public List<Contact> getContactsFromCity(String city) throws DaoException {
		return null;
	}

}
