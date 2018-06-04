package spring.training.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // sample value: 74,
	@Column(name = "first_name")
	private String firstname; // sample value: "Kirby",
	@Column(name = "last_name")
	private String lastname; // sample value: "Wasielewicz",
	private String email; // sample value: "kwasielewicz21@wiley.com",
	private String gender; // sample value: "Male",
	private String phone; // sample value: "5121626862",
	private Date dob; // sample value: "1976-03-01",
	private String address; // sample value: "38 Hauk Road",
	private String city; // sample value: "Austin",
	private String state; // sample value: "Texas",
	private String country; // sample value: "United States",
	private String picture; // sample value: "http://kvinod.com/old_ci/randomdata/images/men/74.jpg"

	public Contact() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", gender=" + gender + ", phone=" + phone + ", dob=" + dob + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", picture=" + picture + "]";
	}

}
