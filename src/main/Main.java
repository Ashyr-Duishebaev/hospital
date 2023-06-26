package main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import connection.DatabaseConnection;
import dao.AppointmentDAO;
import dao.AppointmentDAOImpl;
import dao.DiagnosisDAO;
import dao.DiagnosisDAOImpl;
import dao.PatientDAO;
import dao.PatientDAOImpl;
import dao.PrescriptionDAO;
import dao.PrescriptionDAOImpl;
import dao.TreatmentDAO;
import dao.TreatmentDAOImpl;
import services.PatientServiceMapper;
import services.PatientServiceMapperImpl;

public class Main {

	public static void main(String[] args) {

		try (Connection connection = DatabaseConnection.getConnection()) {
			PatientDAO patientDAO = new PatientDAOImpl(connection);
			DiagnosisDAO diagnosisDAO = new DiagnosisDAOImpl(connection);
			TreatmentDAO treatmentDAO = new TreatmentDAOImpl(connection);
			PrescriptionDAO prescriptionDAO = new PrescriptionDAOImpl(connection);
			AppointmentDAO appointmentDAO = new AppointmentDAOImpl(connection);

			PatientServiceMapper patientService = new PatientServiceMapperImpl(patientDAO);

			String mybatisConfigFile = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFile);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			Menu menu = new Menu(patientService);
			menu.displayMenu();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
