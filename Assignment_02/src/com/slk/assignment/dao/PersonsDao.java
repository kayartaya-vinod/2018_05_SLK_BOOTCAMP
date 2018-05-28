package com.slk.assignment.dao;

import java.util.List;

import com.slk.assignment.entity.Person;

public interface PersonsDao {
	
	// CRUD OPERATIONS
	
	public Person addPerson(Person person) throws DaoException;
	
	public Person getById(Integer id) throws DaoException;

	public Person updatePerson(Person person) throws DaoException;

	public void deletePerson(Integer id) throws DaoException;
	
	// QUERIES
	
	public List<Person> getAll() throws DaoException;

	

}
