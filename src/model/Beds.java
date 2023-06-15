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
public class Beds {
	private int bedId;
	private String bedType;
	private boolean isOccupied;

	public Beds(int bedId, String bedType, boolean isOccupied) {
		super();
		this.bedId = bedId;
		this.bedType = bedType;
		this.isOccupied = isOccupied;
	}

	public Beds() {

	}

	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public void saveToXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Beds.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			File file = new File("/Beds.xml");
			marshaller.marshal(this, file);
			System.out.println("Beds saved to XML file successfully.");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public boolean validateXml() {
		try {
			JAXBContext context = JAXBContext.newInstance(Beds.class);
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
			JAXBContext context = JAXBContext.newInstance(Beds.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			Beds beds = (Beds) unmarshaller.unmarshal(new File("/Beds.xml"));

			System.out.println("Parsed XML: " + beds);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}