package spring.training.programs;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.training.cfg.AppConfig4;
import spring.training.dao.ContactsDao;
import spring.training.dao.DaoException;
import spring.training.entity.Contact;
import spring.training.util.DateUtil;
import spring.training.util.KeyboardUtil;

public class App {

	ContactsDao dao;

	@SuppressWarnings("resource")
	public App() {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig4.class);
		dao = ctx.getBean("dao", ContactsDao.class);
	}

	public static void main(String[] args) {
		App app = new App();
		app.start();
	}

	public void start() {
		int choice;
		while ((choice = menu()) != 0) {
			switch (choice) {
			case 1:
				showAllContacts();
				break;
			case 2:
				showContactById();
				break;
			case 3:
				showContactsByCity();
				break;
			case 4:
				addNewContact();
				break;
			case 5:
				editContact();
			}
		}
		System.out.println("Thank you for using our app.");
	}

	public void showAllContacts() {
		try {
			for (Contact c : dao.getAll()) {
				printContactDetails(c);
			}
		} catch (DaoException e) {
			System.out.println("There was a proble while calling the getAll() method.");
			System.err.println(e.getMessage());
		}
	}

	private void showContactById() {

		try {
			int id = KeyboardUtil.getInt("Enter id: ");
			Contact contact = dao.getContact(id);
			if (contact == null) {
				System.out.println("No contact found for id " + id);
			} else {
				printContactDetails(contact);
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter only number.");
		} catch (DaoException e) {
			System.out.println("There was a proble while calling the getAll() method.");
			System.out.println(e.getMessage());
		}
	}

	private void showContactsByCity() {
		String city = KeyboardUtil.getString("Enter city: ");

		try {
			List<Contact> contacts = dao.getContactsFromCity(city);
			for (Contact c : contacts) {
				printContactDetails(c);
			}
		} catch (DaoException e) {

		}
	}

	private void addNewContact() {
		try {
			Contact contact = new Contact();
			acceptContactDetails(contact);
			dao.addContact(contact);
		} catch (InputMismatchException e) {
			System.out.println("Invalid value.");
		} catch (Exception e) {

		}
	}

	private void editContact() {
		System.out.println("Inside editContact()...");
		try {
			int id = KeyboardUtil.getInt("Enter id: ");
			Contact contact = dao.getContact(id);
			if (contact == null) {
				System.out.println("No contact found for id " + id);
				return;
			}
			acceptContactDetails(contact);
			dao.updateContact(contact);
		} catch (InputMismatchException e) {
			System.out.println("Invalid value.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void printContactDetails(Contact c) {
		String fullname = String.format("%s %s %s",
				c.getGender() != null && c.getGender().equals("Female") ? "Ms." : "Mr.", c.getFirstname(),
				c.getLastname());

		System.out.println("Name      : " + fullname);
		System.out.println("Email id  : " + c.getEmail());
		System.out.println("Phone#    : " + c.getPhone());
		System.out.println("Born on   : " + DateUtil.toString(c.getDob()));
		System.out.println("Address   : " + c.getAddress());
		System.out.printf("          : %s %s %s\n", c.getCity(), c.getState(), c.getCountry());
		System.out.println("Picture   : " + c.getPicture());
		System.out.println("-----------------------------------------------\n");
	}

	public int menu() {
		while (true) {
			System.out.println("Menu options:");
			System.out.println("-------------");
			System.out.println("1. View all contacts");
			System.out.println("2. Search by id");
			System.out.println("3. Search by city");
			System.out.println("4. Add a new contact");
			System.out.println("5. Search and edit contact");

			try {
				int choice = KeyboardUtil.getInt("Enter your choice (0 to exit): ");

				if (choice < 0 || choice > 5) {
					System.out.println("You must enter 0 to 4.");
				} else {
					return choice;
				}
			} catch (InputMismatchException e) {
				System.out.println("You must input an integer!");
			}

		}
	}

	private void acceptContactDetails(Contact contact) {
		String inputStr;
		inputStr = KeyboardUtil.getUpdatedString("Firstname", contact.getFirstname());
		contact.setFirstname(inputStr);

		inputStr = KeyboardUtil.getUpdatedString("Lastname", contact.getLastname());
		contact.setLastname(inputStr);

		inputStr = KeyboardUtil.getUpdatedString("Email id", contact.getEmail());
		contact.setEmail(inputStr);

		inputStr = KeyboardUtil.getUpdatedString("Phone #", contact.getPhone());
		contact.setPhone(inputStr);

		inputStr = KeyboardUtil.getUpdatedString("Gender", contact.getGender());
		contact.setGender(inputStr);

		inputStr = KeyboardUtil.getUpdatedString("D.O.B (YYYY-MM-DD)", DateUtil.toString(contact.getDob()));
		contact.setDob(DateUtil.toDate(inputStr));

		inputStr = KeyboardUtil.getUpdatedString("Address", contact.getAddress());
		contact.setAddress(inputStr);

		inputStr = KeyboardUtil.getUpdatedString("City", contact.getCity());
		contact.setCity(inputStr);

		inputStr = KeyboardUtil.getUpdatedString("State", contact.getState());
		contact.setState(inputStr);

		inputStr = KeyboardUtil.getUpdatedString("Country", contact.getCountry());
		contact.setCountry(inputStr);

		inputStr = KeyboardUtil.getUpdatedString("Picture", contact.getPicture());
		contact.setPicture(inputStr);
	}

}
