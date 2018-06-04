package spring.training.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import spring.training.dao.ContactsDao;
import spring.training.dao.DaoException;
import spring.training.entity.Contact;

@Component("hibernateTemplateDao")
public class ContactsDaoHibernateTemplateImpl implements ContactsDao {

	
	@Autowired(required = false)
	HibernateTemplate template;

	@Override
	public void addContact(Contact contact) throws DaoException {
		template.persist(contact);
	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		return template.get(Contact.class, id);
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		template.update(contact);
	}

	@Override
	public void deleteContact(Integer id) throws DaoException {
		template.delete(getContact(id));
	}

	@Override
	public List<Contact> getAll() throws DaoException {
		return (List<Contact>) template.find("from Contact");
	}

	@Override
	public List<Contact> getContactsFromCity(String city) throws DaoException {
		return (List<Contact>) template.find("from Contact where city=?", city);
	}

	@Override
	public int count() throws DaoException {
		return 0;
	}

}
