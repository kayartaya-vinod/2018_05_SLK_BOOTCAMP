package com.slk.assignment.dao;

import com.slk.assignment.dao.impl.PersonsDaoJdbcImpl;

public final class DaoFactory {

	private DaoFactory() {
	}

	public static PersonsDao getPersonsDao(DaoTypes type) throws DaoException {
		if (type == DaoTypes.JDBC) {
			return new PersonsDaoJdbcImpl();
		}

		throw new DaoException("Invalid type supplied - " + type);

	}

}
