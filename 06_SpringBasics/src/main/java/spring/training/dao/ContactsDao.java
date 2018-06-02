package spring.training.dao;

import java.util.List;

import spring.training.entity.Contact;

public interface ContactsDao {

	public void addContact(Contact contact) throws DaoException;

	public Contact getContact(Integer id) throws DaoException;

	public void updateContact(Contact contact) throws DaoException;

	public void deleteContact(Integer id) throws DaoException;

	public List<Contact> getAll() throws DaoException;

	public List<Contact> getContactsFromCity(String city) throws DaoException;

	public int count() throws DaoException;

}
