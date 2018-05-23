package com.slk.training.programs;

import java.util.InputMismatchException;
import java.util.List;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.dao.DaoFactory;
import com.slk.training.entity.Contact;
import com.slk.training.util.KeyboardUtil;

public class App {

	static final String DAO_FACTORY_TYPE = "JDBC";
	ContactsDao dao;

	public App() {
		try {
			dao = DaoFactory.getContactsDao(DAO_FACTORY_TYPE);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
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

	private void editContact() {
		try {
			int id = KeyboardUtil.getInt("Enter id: ");
			Contact c = dao.getContact(id);
			if (c == null) {
				System.out.println("No contact found for id " + id);
				return;
			}

			String inputStr;
			inputStr = KeyboardUtil.getUpdatedString("Firstname", c.getFirstname());
			c.setFirstname(inputStr);

			inputStr = KeyboardUtil.getUpdatedString("Lastname", c.getLastname());
			c.setLastname(inputStr);

			inputStr = KeyboardUtil.getUpdatedString("Email id", c.getEmail());
			c.setEmail(inputStr);

			inputStr = KeyboardUtil.getUpdatedString("Phone #", c.getPhone());
			c.setPhone(inputStr);

			dao.updateContact(c);

			System.out.println(c);
		} catch (InputMismatchException e) {
			System.out.println("Invalid value.");
		} catch (Exception e) {

		}
	}

	private void addNewContact() {
		try {
			int id = KeyboardUtil.getInt("Enter id: ");
			Contact c = new Contact();
			c.setId(id);

			String inputStr;
			inputStr = KeyboardUtil.getUpdatedString("Firstname", c.getFirstname());
			c.setFirstname(inputStr);

			inputStr = KeyboardUtil.getUpdatedString("Lastname", c.getLastname());
			c.setLastname(inputStr);

			inputStr = KeyboardUtil.getUpdatedString("Gender", c.getGender());
			c.setLastname(inputStr);

			inputStr = KeyboardUtil.getUpdatedString("Email id", c.getEmail());
			c.setEmail(inputStr);

			inputStr = KeyboardUtil.getUpdatedString("Phone #", c.getPhone());
			c.setPhone(inputStr);

			dao.addContact(c);

		} catch (InputMismatchException e) {
			System.out.println("Invalid value.");
		} catch (Exception e) {

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

	private void printContactDetails(Contact c) {
		String fullname = String.format("%s %s %s",
				c.getGender() != null && c.getGender().equals("Female") ? "Ms." : "Mr.", c.getFirstname(),
				c.getLastname());

		System.out.println("Name      : " + fullname);
		System.out.println("Email id  : " + c.getEmail());
		System.out.println("Phone#    : " + c.getPhone());
		System.out.printf("From      : %s %s %s\n", c.getCity(), c.getState(), c.getCountry());
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

}
