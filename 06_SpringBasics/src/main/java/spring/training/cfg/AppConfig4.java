package spring.training.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = { "spring.training.dao.impl", "spring.training.programs" })
public class AppConfig4 {

	@Bean // (autowire = Autowire.BY_NAME)
	public JdbcTemplate template(DataSource ds) {
		return new JdbcTemplate(ds);
	}

	@Bean(name = "dataSource")
	public DataSource dbcp() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver"); // org.h2.Driver
		bds.setUrl("jdbc:mysql://localhost/slk_training"); // jdbc:h2:tcp://localhost/~/slk_training
		bds.setUsername("root");
		bds.setPassword("root");
		return bds;
	}

}
