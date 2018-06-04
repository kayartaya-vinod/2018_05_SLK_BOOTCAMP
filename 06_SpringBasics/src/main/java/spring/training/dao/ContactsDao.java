package spring.training.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import spring.training.entity.Contact;

@Transactional(readOnly = true)
public interface ContactsDao {

	@Transactional(readOnly = false)
	public void addContact(Contact contact) throws DaoException;

	public Contact getContact(Integer id) throws DaoException;

	@Transactional(readOnly = false)
	public void updateContact(Contact contact) throws DaoException;

	@Transactional(readOnly = false)
	public void deleteContact(Integer id) throws DaoException;

	public List<Contact> getAll() throws DaoException;

	public List<Contact> getContactsFromCity(String city) throws DaoException;

	public int count() throws DaoException;

}
