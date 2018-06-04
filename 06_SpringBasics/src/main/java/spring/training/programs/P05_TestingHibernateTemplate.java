package spring.training.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import spring.training.cfg.AppConfig5;
import spring.training.entity.Contact;

public class P05_TestingHibernateTemplate {

	static HibernateTemplate template;

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig5.class);

		template = ctx.getBean(HibernateTemplate.class);

		// printContactById(76); // id = 76
		// updateEmail(76, "vinod@kwit.com");

		printContactsFromState("Florida");

		ctx.close();
	}

	static void printContactsFromState(String state) {
		List<Contact> list = (List<Contact>) template.find("from Contact where state = ?", state);
		for (Contact c : list) {
			System.out.println(c.getFirstname() + " --> " + c.getCity() + ", " + c.getState());
		}
	}

	static void updateEmail(int id, String newEmail) {
		Contact c1 = template.get(Contact.class, id);
		if (c1 == null) {
			System.out.println("Invalid id " + id);
		} else {
			c1.setEmail(newEmail);
			template.merge(c1);
			System.out.println("Email updated1");
		}
	}

	static void printContactById(int id) {
		Contact c1 = template.get(Contact.class, id);
		System.out.println(c1);
	}

}
