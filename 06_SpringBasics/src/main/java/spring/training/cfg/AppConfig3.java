package spring.training.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"spring.training.dao.impl"})
public class AppConfig3 {

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
	
	@Bean
	public DataSource dbcp2() {
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
