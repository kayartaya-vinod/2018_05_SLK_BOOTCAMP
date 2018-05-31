package spring.training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.training.cfg.AppConfig2;
import spring.training.dao.ContactsDao;

public class P03_DependencyInjectionDemo {

	public static void main(String[] args) throws Exception {
		
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig2.class);
		
		ContactsDao dao = ctx.getBean(ContactsDao.class);
		int cc = dao.count();
		
		System.out.println("There are " + cc + " contacts\n");
		
		ctx.close();
	}
}
