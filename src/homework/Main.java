package homework;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Main {

	public static void main(String[] args) {

	String url = "jdbc:mysql://Laba:3306/hospital";
	String username = "root";
	String password = "T-MoSqLc2021";

	BasicDataSource dataSource = new BasicDataSource();dataSource.setUrl(url);dataSource.setUsername(username);dataSource.setPassword(password);

	try (Connection connection = dataSource.getConnection()) {

		DoctorDAO doctorDAO = new DoctorDAOImpl(connection);
		Doctor doctor = doctorDAO.getDoctorById(1);

		PatientDAO patientDAO = new PatientDAOImpl(connection);

		Patient patient = new Patient(1, "Peter", "Parker", "1999-12-12", "Male", "999888777", "101 Wall St");
		patientDAO.save(patient);

		// Homework 2
		Patient patient1 = new Patient(1, "Peter", "Parket", "1989-12-05", "Male", "99999999", "999 Wall Street");
		patient1.saveToXml();
		boolean isValid = patient1.validateXml();
		if (isValid) {
			patient1.parseXml();
		} else {
			System.out.println("XML validation failed. Unable to parse the XML file.");
		}

		ConnectionPool.releaseConnection(connection);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}


