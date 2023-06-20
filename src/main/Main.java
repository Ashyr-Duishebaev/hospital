package main;

import java.sql.Connection;
import java.sql.SQLException;

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
import services.PatientService;
import services.PatientServiceImpl;

public class Main {

	public static void main(String[] args) {

		try (Connection connection = DatabaseConnection.getConnection()) {
			PatientDAO patientDAO = new PatientDAOImpl(connection);
			DiagnosisDAO diagnosisDAO = new DiagnosisDAOImpl(connection);
			TreatmentDAO treatmentDAO = new TreatmentDAOImpl(connection);
			PrescriptionDAO prescriptionDAO = new PrescriptionDAOImpl(connection);
			AppointmentDAO appointmentDAO = new AppointmentDAOImpl(connection);

			PatientService patientService = new PatientServiceImpl(patientDAO, diagnosisDAO, treatmentDAO,
					prescriptionDAO, appointmentDAO);
			Menu menu = new Menu(patientService);
			menu.displayMenu();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
