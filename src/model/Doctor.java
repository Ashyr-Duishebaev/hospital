package model;

import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

import abstractFactory.DiagnosisFactory;
import abstractFactory.TreatmentFactory;

public class Doctor {
	private static final Logger logger = Logger.getLogger(Doctor.class.getName());

	@JsonProperty("id")
	private int id;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("specialization")
	private String specialization;

	@JsonProperty("contactNumber")
	private String contactNumber;

	@JsonProperty("address")
	private String address;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", specialization="
				+ specialization + ", contactNumber=" + contactNumber + ", address=" + address + "]";
	}

	public void setDiagnosisFactory(DiagnosisFactory factory) {
		// Set the diagnosis factory for the doctor
	}

	public void setTreatmentFactory(TreatmentFactory factory) {
		// Set the treatment factory for the doctor
	}

	public Diagnosis createDiagnosis() {
		// Use the diagnosis factory to create a diagnosis
		return null;
	}

	public Treatment createTreatment() {
		// Use the treatment factory to create a treatment
		return null;
	}

}
