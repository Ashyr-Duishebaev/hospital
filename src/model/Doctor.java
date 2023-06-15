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

public class Doctor {
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

	public Doctor(int id, String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialization = specialization;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public Doctor() {

	}

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

	public void saveToXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Doctor.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			File file = new File("/Doctor.xml");
			marshaller.marshal(this, file);
			System.out.println("Doctor saved to XML file successfully.");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public boolean validateXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Doctor.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ValidationEventHandler eventHandler = new ValidationEventHandler() {
				@Override
				public boolean handleEvent(ValidationEvent event) {
					System.out.println("Validation Error: " + event.getMessage());
					return false;
				}
			};
			unmarshaller.setEventHandler(eventHandler);

			unmarshaller.unmarshal(new File("/Doctor.xml"));
			System.out.println("XML validation successful.");
			return true;
		} catch (JAXBException e) {
			System.out.println("XML validation failed. Error: " + e.getMessage());
			return false;
		}
	}

	public void parseXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Doctor.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			Doctor doctor = (Doctor) unmarshaller.unmarshal(new File("/Doctor.xml"));

			System.out.println("Parsed XML: " + doctor);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void saveToJson() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			File file = new File("/Doctor.json");
			objectMapper.writeValue(file, this);
			System.out.println("Doctor saved to JSON file successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parseJson() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Doctor doctor = objectMapper.readValue(new File("/Doctor.json"), Doctor.class);
			System.out.println("Parsed JSON: " + doctor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
