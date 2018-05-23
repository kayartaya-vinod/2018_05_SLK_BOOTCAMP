package com.slk.training.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.slk.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.entity.Contact;

public class ContactsDaoSerializableImpl implements ContactsDao {

	Map<Integer, Contact> map = new HashMap<>();

	final String filename = "contacts.data";
	
	public ContactsDaoSerializableImpl() throws DaoException {
		try(FileInputStream file = new FileInputStream(filename);
				ObjectInputStream<HashMap<Integer,Contact>> in = new ObjectInputStream<>(file);){
			
			map = in.readInstance();
		}
		catch(FileNotFoundException e) {
			// nothing to do here!
		}
		catch(Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void addContact(Contact contact) throws DaoException {
		map.put(contact.getId(), contact);
		serializeMap();
	}

	private void serializeMap() throws DaoException {
		try(FileOutputStream file = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(file);){
			
			out.writeObject(map);
			
		} catch(Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Contact getContact(Integer id) throws DaoException {
		if(map.containsKey(id)) {
			return map.get(id);
		}
		return null;
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		if(map.containsKey(contact.getId())) {
			map.put(contact.getId(), contact);
			serializeMap();
		}
		else {
			throw new DaoException("Invalid id " + contact.getId());
		}
	}

	@Override
	public void deleteContact(Integer id) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contact> getAll() throws DaoException {
		return new ArrayList<>(map.values());
	}

	@Override
	public List<Contact> getContactsFromCity(String city) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
