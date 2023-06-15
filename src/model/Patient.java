package model;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {

	private int patient_id;
	private String firstName;
	private String lastName;
	private String date_of_birth;
	private String gender;
	private String contact_number;
	private String address;

	public Patient(int patient_id, String firstName, String lastName, String date_of_birth, String gender,
			String contact_number,
			String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.contact_number = contact_number;
		this.address = address;
	}

	public Patient() {
	}

	public int getId() {
		return patient_id;
	}

	public void setId(int patient_id) {
		this.patient_id = patient_id;
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
		return date_of_birth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.date_of_birth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contact_number;
	}

	public void setContactNumber(String contactNumber) {
		this.contact_number = contact_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [id=" + patient_id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ date_of_birth + ", gender=" + gender + ", contactNumber=" + contact_number + ", address=" + address
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
}

//int patientId = 1; // Replace with the desired patient ID
//Patient patient = patientDAO.getPatientById(patientId);
//System.out.println("Retrieved Patient: " + patient);