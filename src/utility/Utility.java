package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;
import model.Patient;

public class Utility {

	private static final Logger logger = Logger.getLogger(Utility.class.getName());

	public static void saveObjectToJson(Object object, String filePath) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			File file = new File(filePath);
			objectMapper.writeValue(file, object);
			logger.info("Object saved to JSON file successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <T> T readObjectFromJson(String filePath, Class<T> objectType) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			File file = new File(filePath);
			return objectMapper.readValue(file, objectType);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void parseXml(String filePath, Class<?> objectType) {
		try {
			JAXBContext context = JAXBContext.newInstance(objectType);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Object object = unmarshaller.unmarshal(new File(filePath));
			logger.info("Parsed XML: " + object);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static <T> boolean validateXml(Class<T> clazz, String filePath) {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			ValidationEventHandler eventHandler = new ValidationEventHandler() {
				@Override
				public boolean handleEvent(ValidationEvent event) {
					logger.info("Validation Error: " + event.getMessage());
					return false;
				}
			};
			unmarshaller.setEventHandler(eventHandler);

			unmarshaller.unmarshal(new File(filePath));
			logger.info("XML validation successful.");
			return true;
		} catch (JAXBException e) {
			logger.info("XML validation failed. Error: " + e.getMessage());
			return false;
		}
	}

	public static Patient parseXmlUsingDOM(String filename) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(filename));

			Element root = document.getDocumentElement();
			Patient patient = new Patient();

			NodeList nodeList = root.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String nodeName = element.getNodeName();
					String nodeValue = element.getTextContent();
					// Map the XML data to the Patient object attributes
					if (nodeName.equals("firstName")) {
						patient.setFirstName(nodeValue);
					} else if (nodeName.equals("lastName")) {
						patient.setLastName(nodeValue);
					} else if (nodeName.equals("age")) {
						int age = Integer.parseInt(nodeValue);
						patient.setAge(age);
					}
					// Add more mappings for other attributes as needed
				}
			}

			return patient;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Patient parseXmlUsingStAX(String filename) {
		try {
			XMLInputFactory factory = XMLInputFactory.newFactory();
			XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(filename));

			Patient patient = null;
			String currentElement = "";
			String currentText = "";

			while (reader.hasNext()) {
				int event = reader.next();
				switch (event) {
				case XMLStreamConstants.START_ELEMENT:
					currentElement = reader.getLocalName();
					break;
				case XMLStreamConstants.CHARACTERS:
					currentText = reader.getText();
					break;
				case XMLStreamConstants.END_ELEMENT:
					if (reader.getLocalName().equals("patient")) {
						// Return the patient object once the end of the patient element is reached
						return patient;
					}
					if (patient == null) {
						patient = new Patient();
					} else {
						// Map the XML data to the Patient object attributes
						if (currentElement.equals("firstName")) {
							patient.setFirstName(currentText);
						} else if (currentElement.equals("lastName")) {
							patient.setLastName(currentText);
						} else if (currentElement.equals("age")) {
							int age = Integer.parseInt(currentText);
							patient.setAge(age);
						}
						// Add more mappings for other attributes as needed
					}
					break;
				}
			}

			return patient;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Patient parseXmlUsingSAX(String filename) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();

			PatientSAXHandler handler = new PatientSAXHandler();
			parser.parse(new File(filename), handler);

			return handler.getPatient();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static class PatientSAXHandler extends DefaultHandler {
		private Patient patient;
		private String currentElement;
		private StringBuilder currentText;

		public Patient getPatient() {
			return patient;
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			currentElement = qName;
			currentText = new StringBuilder();
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			currentText.append(ch, start, length);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equals("patient")) {
				return;
			}
			if (patient == null) {
				patient = new Patient();
			} else {
				// Map the XML data to the Patient object attributes
				if (currentElement.equals("firstName")) {
					patient.setFirstName(currentText.toString());
				} else if (currentElement.equals("lastName")) {
					patient.setLastName(currentText.toString());
				} else if (currentElement.equals("age")) {
					int age = Integer.parseInt(currentText.toString());
					patient.setAge(age);
				}
			}
		}
	}
}
