package spring.training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.training.cfg.AppConfig1;
import spring.training.dao.ContactsDao;
import spring.training.dao.DaoException;

public class P02_SpringAsFactoryOfBeans {

	public static void main(String[] args) throws DaoException {

		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
		
		ContactsDao dao;
		dao = ctx.getBean("jdbc-dao", ContactsDao.class);
		ContactsDao dao1 = ctx.getBean("jdbc-dao", ContactsDao.class);
		System.out.println("dao==dao1 is "+ (dao==dao1));
		System.out.printf("There are %d contacts\n", dao.count());
		
		ctx.close();
	}

}
