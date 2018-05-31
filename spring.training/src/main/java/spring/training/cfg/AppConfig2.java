package spring.training.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.training.dao.ContactsDao;
import spring.training.dao.impl.ContactsDaoJdbcImpl;

@Configuration
public class AppConfig2 {
	
	// NOTE about the parameter of this function:
	// Spring invokes the dao(..) function and since there is
	// a paramter of type DataSource, Spring will find an object
	// of the same type and INJECTS it to the parameter
	@Bean
	public ContactsDao dao(DataSource ds) {
		ContactsDaoJdbcImpl impl= new ContactsDaoJdbcImpl();
		// assigning a bean to another is called WIRING
		// Can be MANUAL or AUTOMATIC
		impl.setDataSource(ds); // manual wiring
		return impl;
	}

	// connection pool
	@Bean
	public DataSource dbcp() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver"); // org.h2.Driver
		bds.setUrl("jdbc:mysql://localhost/slk_training"); // jdbc:h2:tcp://localhost/~/slk_training
		bds.setUsername("root");
		bds.setPassword("root");
		
		bds.setMaxTotal(50);
		bds.setInitialSize(5);
		bds.setMaxIdle(10);
		bds.setMinIdle(5);
		bds.setMaxWaitMillis(500);
		
		return bds;
	}
}
