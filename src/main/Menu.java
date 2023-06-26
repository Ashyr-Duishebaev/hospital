package main;

import java.util.Scanner;
import java.util.logging.Logger;

import abstractFactory.DiagnosisFactory;
import abstractFactory.SimpleDiagnosisFactory;
import abstractFactory.SimpleTreatmentFactory;
import abstractFactory.TreatmentFactory;
import model.Diagnosis;
import model.Treatment;
import services.PatientServiceMapper;

public class Menu {

	private final PatientServiceMapper patientService;
	private final Logger logger = Logger.getLogger(Menu.class.getName());
	private final Scanner scanner;
	private final DiagnosisFactory diagnosisFactory;
	private final TreatmentFactory treatmentFactory;

	public Menu(PatientServiceMapper patientService) {
		this.patientService = patientService;
		this.scanner = new Scanner(System.in);
		this.diagnosisFactory = new SimpleDiagnosisFactory();
		this.treatmentFactory = new SimpleTreatmentFactory();
	}

	public void displayMenu() {
		boolean exit = false;
		while (!exit) {
			logger.info("Hospital Management System");
			logger.info("-------------------------");
			logger.info("1. Assign Diagnosis");
			logger.info("2. Prescribe Treatment");
			logger.info("3. Write Prescription");
			logger.info("4. Make Appointment");
			logger.info("5. Update Patient Information");
			logger.info("0. Exit");
			logger.info("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				assignDiagnosis();
				break;
			case 2:
				prescribeTreatment();
				break;
			case 3:
				writePrescription();
				break;
			case 4:
				makeAppointment();
				break;
			case 5:
				updateInformation();
				break;
			case 0:
				exit = true;
				break;
			default:
				logger.info("Invalid choice. Please try again.");
			}
		}
	}

	private void assignDiagnosis() {
		logger.info("Enter patient ID: ");
		int patientId = scanner.nextInt();
		scanner.nextLine();

		logger.info("Enter diagnosis: ");
		String diagnosis = scanner.nextLine();

		DiagnosisFactory diagnosisFactory = new SimpleDiagnosisFactory();
		Diagnosis assignedDiagnosis = diagnosisFactory.createDiagnosis();
		patientService.assignDiagnosis(patientId, assignedDiagnosis);
		logger.info("Diagnosis assigned successfully.");
	}

	private void prescribeTreatment() {
	    logger.info("Enter patient ID: ");
	    int patientId = scanner.nextInt();
	    scanner.nextLine();

	    logger.info("Enter treatment ID: ");
	    int treatmentId = scanner.nextInt();
	    scanner.nextLine();

		TreatmentFactory treatmentFactory = new SimpleTreatmentFactory();

		Treatment prescribedTreatment = treatmentFactory.createTreatment();
		patientService.prescribeTreatment(patientId, prescribedTreatment);
	    logger.info("Treatment prescribed successfully.");
	}


	private void writePrescription() {
		logger.info("Enter patient ID: ");
		int patientId = scanner.nextInt();
		scanner.nextLine();

		logger.info("Enter prescription: ");
		String prescription = scanner.nextLine();

		patientService.writePrescription(patientId, prescription);
		logger.info("Prescription written successfully.");
	}

	private void makeAppointment() {
		logger.info("Enter patient ID: ");
		int patientId = scanner.nextInt();
		scanner.nextLine();

		logger.info("Enter doctor ID: ");
		int doctorId = scanner.nextInt();
		scanner.nextLine();

		logger.info("Enter appointment date (yyyy-MM-dd): ");
		String appointmentDate = scanner.nextLine();

		patientService.makeAppointment(patientId, doctorId, appointmentDate);
		logger.info("Appointment made successfully.");
	}

	private void updateInformation() {
		logger.info("Enter the ID of the patient to update: ");
		int patientId = scanner.nextInt();
		scanner.nextLine();

		logger.info("Enter the new name: ");
		String newName = scanner.nextLine();

		logger.info("Enter the new contact details: ");
		String newContactDetails = scanner.nextLine();

		logger.info("Enter the new medical history: ");
		String newMedicalHistory = scanner.nextLine();

		patientService.updatePatientInformation(patientId, newName, newContactDetails, newMedicalHistory);
		logger.info("Patient information updated successfully.");
	}
}
