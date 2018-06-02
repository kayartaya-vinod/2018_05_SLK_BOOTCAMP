package spring.training.programs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.training.dao.ContactsDao;
import spring.training.dao.DaoException;

public class P01_SpringAsFactoryOfBeans {

	public static void main(String[] args) throws DaoException {

		// a variable representing spring container
		ClassPathXmlApplicationContext ctx;
		
		// an object representing the spring container
		// created using an XML found in the classpath (buildpath)
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		// at this time, spring instantiates all bean classes found in the XML
		// and keeps it in the container with specific names/ids
		
		ContactsDao dao;
		// ask spring for a bean using "name" and "type"
		dao = ctx.getBean("jdbc-dao", ContactsDao.class);
		
		ContactsDao dao1 = ctx.getBean("jdbc-dao", ContactsDao.class);
		
		System.out.println("dao==dao1 is "+ (dao==dao1));
		
		System.out.printf("There are %d contacts\n", dao.count());
		
		ctx.close();
	}

}
