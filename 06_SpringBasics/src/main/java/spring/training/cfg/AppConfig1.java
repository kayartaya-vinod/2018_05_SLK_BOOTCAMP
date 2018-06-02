package spring.training.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.training.dao.ContactsDao;
import spring.training.dao.impl.ContactsDaoDummyImpl;
import spring.training.dao.impl.ContactsDaoJdbcImpl;

// this is a substitution for the beans.xml file
// the class --> <beans>...</beans>
@Configuration
public class AppConfig1 {

	// a method here is equivalent of <bean>...</bean>
	// if it is annotated with @Bean.
	// This method should return an object of a bean class and
	// generally a super type (or interface) is used as the return type
	@Scope("prototype")
	@Bean(name = "dummy-dao")
	public ContactsDao dummyDao() {
		return new ContactsDaoDummyImpl();
	}

	@Scope("prototype")
	@Bean(name = { "jdbc-dao", "jdbcDao" })
	public ContactsDao jdbcDao() {
		return new ContactsDaoJdbcImpl();
	}
}
