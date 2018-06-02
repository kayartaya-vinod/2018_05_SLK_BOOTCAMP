package spring.training.programs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.training.cfg.AppConfig4;
import spring.training.entity.Contact;

public class P04_TestingJdbcTemplate {
	
	static JdbcTemplate tpl;
	
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig4.class);
		tpl = ctx.getBean(JdbcTemplate.class);
		
		// printContactsCount();
		// printNameForId(123); // id=123
		// printContactDetailsForId(123); // id=123
		// printContactsInCity("Dallas"); // city=Dallas
		// updateCityAndStateForId(123, "Dallas", "Texas");
		// getAndPrintContactObjectForId(70);
		getPeopleFromCity("Phoenix");
		
		ctx.close();
	}

	static void getPeopleFromCity(String city) {
		String sql = "select * from contacts where city = ?";
		List<Contact> list = tpl.query(sql, new ContactRowMapper(), city);
		
		for(Contact c: list) {
			System.out.println(c);
		}
	}

	static void getAndPrintContactObjectForId(int id) {
		String sql = "select * from contacts where id = ?";
		Contact c1 = tpl.queryForObject(sql,  new ContactRowMapper(), id);
		System.out.println(c1);
	}

	static void updateCityAndStateForId(int id, String city, String state) {
		String sql = "update contacts set city=?, state=? where id = ?";
		if(tpl.update(sql, city, state, id)==0) {
			System.out.println("No record found with id " + id + " for update!");
		}
		else {
			System.out.println("Record updated.");
		}
	}

	static void printContactsInCity(String city) {
		// the query results in multiple rows containing multiple columns
		// Use queryForList (List of Maps) function
		String sql = "select * from contacts where city = ?";
		List<Map<String, Object>> list = tpl.queryForList(sql, city);
		for(Map<String, Object> c: list) {
			System.out.println(c.get("first_name") + " --> " + c.get("email"));
		}
	}

	static void printContactDetailsForId(int id) {
		// the query results in 1 row multiple columns
		// use queryForMap
		String sql = "select first_name, last_name, email, phone from contacts where id = ?";
		Map<String, Object> map = tpl.queryForMap(sql, id);
		System.out.println("Firstname = " + map.get("first_name"));
		System.out.println("Lastname  = " + map.get("LAST_name"));
		System.out.println("Phone     = " + map.get("phone"));
		System.out.println("Email id  = " + map.get("email"));
		
	}

	static void printNameForId(int id) {
		String sql = "select concat_ws(' ', first_name, last_name) from contacts where id = ?";
		String name = tpl.queryForObject(sql, String.class, id);
		System.out.println("Name = " + name);
	}

	static void printContactsCount() {
		// Use queryForObject when the SQL results in exactly 1 row and 1 column
		int cc = tpl.queryForObject("select count(*) from contacts", Integer.class);
		System.out.println("There are "+ cc +" contacts");
	}
	
	// An object of this class knows how to convert a row (ResultSet's)
	// into a custom object (Contact), which is used by spring's methods
	static class ContactRowMapper implements RowMapper<Contact> {

		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getInt("id"));
			contact.setFirstname(rs.getString("first_name"));
			contact.setLastname(rs.getString("last_name"));
			contact.setGender(rs.getString("gender"));
			contact.setEmail(rs.getString("email"));
			contact.setPhone(rs.getString("phone"));
			contact.setDob(rs.getDate("dob"));
			contact.setAddress(rs.getString("address"));
			contact.setCity(rs.getString("city"));
			contact.setState(rs.getString("state"));
			contact.setCountry(rs.getString("country"));
			contact.setPicture(rs.getString("picture"));
			return contact;
		}
		
	}

}










