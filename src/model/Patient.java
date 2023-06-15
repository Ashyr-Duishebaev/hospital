package model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;

public class Patient {

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

	public void saveToXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			File file = new File("resource/Patient.xml");
			marshaller.marshal(this, file);
			System.out.println("Patient saved to XML file successfully.");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public boolean validateXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ValidationEventHandler eventHandler = new ValidationEventHandler() {
				@Override
				public boolean handleEvent(ValidationEvent event) {
					System.out.println("Validation Error: " + event.getMessage());
					return false;
				}
			};
			unmarshaller.setEventHandler(eventHandler);

			unmarshaller.unmarshal(new File("resource/Patient.xml"));
			System.out.println("XML validation successful.");
			return true;
		} catch (JAXBException e) {
			System.out.println("XML validation failed. Error: " + e.getMessage());
			return false;
		}
	}

	public void parseXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			Patient patient = (Patient) unmarshaller.unmarshal(new File("resource/Patient.xml"));

			System.out.println("Parsed XML: " + patient);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void setDiagnosis(Diagnosis diagnosis) {

	}

	public Diagnosis getDiagnosis() {
		return null;
	}

	public void setPrescribedTreatment(Treatment treatment) {
		// TODO Auto-generated method stub

	}

	public Treatment getPrescribedTreatment() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveToJson() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			File file = new File("Patient.json");
			objectMapper.writeValue(file, this);
			System.out.println("Patient saved to JSON file successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Patient fromJsonFile(String filename) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			File file = new File(filename);
			return objectMapper.readValue(file, Patient.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

//int patientId = 1; // Replace with the desired patient ID
//Patient patient = patientDAO.getPatientById(patientId);
//System.out.println("Retrieved Patient: " + patient);