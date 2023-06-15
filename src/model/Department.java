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
public class Department {
	private int departmentId;
	private String departmentName;

	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public Department() {

	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}

	public void saveToXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Department.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			File file = new File("/Department.xml");
			marshaller.marshal(this, file);
			System.out.println("Department saved to XML file successfully.");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public boolean validateXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Department.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ValidationEventHandler eventHandler = new ValidationEventHandler() {
				@Override
				public boolean handleEvent(ValidationEvent event) {
					System.out.println("Validation Error: " + event.getMessage());
					return false;
				}
			};
			unmarshaller.setEventHandler(eventHandler);

			unmarshaller.unmarshal(new File("/Beds. xml"));
			System.out.println("XML validation successful.");
			return true;
		} catch (JAXBException e) {
			System.out.println("XML validation failed. Error: " + e.getMessage());
			return false;
		}
	}

	public void parseXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Department.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			Department department = (Department) unmarshaller.unmarshal(new File("/Department.xml"));

			System.out.println("Parsed XML: " + department);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
