package main;

import java.sql.SQLException;
import java.util.Scanner;

import model.Patient;
import services.PatientService;

public class Menu {
	private final PatientService patientService;

	public Menu(PatientService patientService) {
		this.patientService = patientService;
	}

	public void displayMenu() {
		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		while (!exit) {
			System.out.println("Hospital Management System");
			System.out.println("-------------------------");
			System.out.println("1. Assign Diagnosis");
			System.out.println("2. Prescribe Treatment");
			System.out.println("3. Write Prescription");
			System.out.println("4. Make Appointment");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				assignDiagnosis(scanner);
				break;
			case 2:
				prescribeTreatment(scanner);
				break;
			case 3:
				writePrescription(scanner);
				break;
			case 4:
				makeAppointment(scanner);
				break;
			case 0:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

		scanner.close();
	}

	private void assignDiagnosis(Scanner scanner) {
		System.out.print("Enter patient ID: ");
		int patient_id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter diagnosis: ");
		String diagnosis = scanner.nextLine();

		patientService.assignDiagnosis(patient_id, diagnosis);
		System.out.println("Diagnosis assigned successfully.");
	}

	private void prescribeTreatment(Scanner scanner) {
		System.out.print("Enter patient ID: ");
		int patient_id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter treatment ID: ");
		int treatmentId = scanner.nextInt();
		scanner.nextLine();

		patientService.prescribeTreatment(patient_id, treatmentId);
		System.out.println("Treatment prescribed successfully.");
	}

	private void writePrescription(Scanner scanner) {
		System.out.print("Enter patient ID: ");
		int patient_id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter prescription: ");
		String prescription = scanner.nextLine();

		patientService.writePrescription(patient_id, prescription);
		System.out.println("Prescription written successfully.");
	}

	private void makeAppointment(Scanner scanner) {
		System.out.print("Enter patient ID: ");
		int patient_id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter doctor ID: ");
		int doctorId = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter appointment date (yyyy-MM-dd): ");
		String appointmentDate = scanner.nextLine();

		patientService.makeAppointment(patient_id, doctorId, appointmentDate);
		System.out.println("Appointment made successfully.");
	}

	public void parseMe() throws SQLException {
		Patient patient1 = new Patient(1, "Peter", "Parker", "1989-12-05", "Male", "99999999", "999 Wall Street");
		patient1.saveToXml();
		boolean isValid = patient1.validateXml();
		if (isValid) {
			patient1.parseXml();
		} else {
			System.out.println("XML validation failed. Unable to parse the XML file.");
		}
	}
}
