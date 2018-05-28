package com.slk.assignment.programs;

import java.util.List;

import com.slk.assignment.dao.DaoFactory;
import com.slk.assignment.dao.DaoTypes;
import com.slk.assignment.dao.PersonsDao;
import com.slk.assignment.entity.Person;

public class TestPersonsDaoOperations {

	public static void main(String[] args) throws Exception {
		
		PersonsDao dao = DaoFactory.getPersonsDao(DaoTypes.JDBC);
		System.out.println("dao is an instanceof " + dao.getClass());
		
		Person p1 = new Person("Ramnath", "Nishadh", "ramnathnishadh@example.com", "8474464644");
		p1 = dao.addPerson(p1);
		System.out.println("p1 = " + p1);
		
		System.out.println();
		
		dao.deletePerson(4);
		
		List<Person> list = dao.getAll();
		for(Person p: list) {
			System.out.println(p);
		}
		
		System.out.println();
		
		
		
	}
}
