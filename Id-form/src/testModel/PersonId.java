package testModel;

import javax.sql.rowset.serial.SerialBlob;

public class PersonId {
	
	private String firstName;
	private String lastName;
	private String birthDate;
	private String country;
	private String state;
	private String city;
	private String email;
	private SerialBlob photo;
	
	public PersonId(String firstName, String lastName, String  birthDate,
			String country, String state, String city, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.country = country;
		this.state = state;
		this.city = city;
		this.email = email;
		photo = null;
		//this.photo = photo;
	}

	public SerialBlob getPhoto() {
		return photo;
	}

	public void setPhoto(SerialBlob photo) {
		this.photo = photo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
