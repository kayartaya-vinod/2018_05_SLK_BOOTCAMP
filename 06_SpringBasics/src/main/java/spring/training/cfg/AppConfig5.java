package spring.training.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.training.entity.Contact;

@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = { "spring.training.dao", "spring.training.programs" })
public class AppConfig5 {
	
	@Bean
	public HibernateTransactionManager txMgr(SessionFactory sf) {
		return new HibernateTransactionManager(sf);
	}

	@Bean
	public HibernateTemplate ht(SessionFactory sf) {
		return new HibernateTemplate(sf);
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();

		lsfb.setDataSource(ds);
		lsfb.setAnnotatedClasses(Contact.class); // comma separated list of entity classes

		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		lsfb.setHibernateProperties(props);

		return lsfb;
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
