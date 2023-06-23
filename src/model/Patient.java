package model;

import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Patient {
	private static final Logger logger = Logger.getLogger(Patient.class.getName());

	@JsonProperty("patientId")
	private int patientId;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("dateOfBirth")
	private String dateOfBirth;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("contactNumber")
	private String contactNumber;

	@JsonProperty("address")
	private String address;

	public Patient(int patientId, String firstName, String lastName, String dateOfBirth, String gender,
			String contact_number,
			String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public Patient() {
	}

	public int getId() {
		return patientId;
	}

	public void setId(int patientId) {
		this.patientId = patientId;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [id=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", contactNumber=" + contactNumber + ", address=" + address
				+ "]";
	}


	public void setDiagnosis(Diagnosis diagnosis) {

	}

	public Diagnosis getDiagnosis() {
		return null;
	}

	public void setPrescribedTreatment(Treatment treatment) {
	}

	public Treatment getPrescribedTreatment() {
		return null;
	}

	public void setAge(int age) {
	}

	public void setMedicalHistory(String newMedicalHistory) {
	}

}
