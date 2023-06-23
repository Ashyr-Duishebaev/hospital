package services;

import java.util.List;

import model.Appointment;
import model.Diagnosis;
import model.Patient;
import model.Prescription;
import model.Treatment;

public interface PatientService {
    void createPatient(Patient patient);

	Patient getPatientById(int patient_id);
    List<Patient> getAllPatients();
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);

	void assignDiagnosis(int patient_id, String diagnosis);

	void prescribeTreatment(int patient_id, int treatmentId);

	void writePrescription(int patient_id, String prescription);

	void makeAppointment(Patient patient, Appointment appointment);

	void makeAppointment(int patient_id, int doctorId, String appointmentDate);

	void assignDiagnosis(Patient patient, Diagnosis diagnosis);

	void prescribeTreatment(Patient patient, Treatment treatment);

	void writePrescription(Patient patient, Prescription prescription);

	void updatePatientInformation(int patientId, String newName, String newContactDetails, String newMedicalHistory);
}
