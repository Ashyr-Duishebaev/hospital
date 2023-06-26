package services;

import java.util.List;

import model.Appointment;
import model.Diagnosis;
import model.Patient;
import model.Prescription;
import model.Treatment;

public interface PatientServiceMapper {
    void createPatient(Patient patient);

	Patient getPatientById(int patientId);

    List<Patient> getAllPatients();

    void updatePatient(Patient patient);

    void deletePatient(Patient patient);

	void assignDiagnosis(int patientId, Diagnosis diagnosis);

	void prescribeTreatment(int patientId, Treatment treatment);

	void writePrescription(Patient patient, Prescription prescription);

	void makeAppointment(Patient patient, Appointment appointment);

	void writePrescription(int patient_id, String prescription);

	void makeAppointment(int patient_id, int doctorId, String appointmentDate);

	void updatePatientInformation(int patientId, String newName, String newContactDetails, String newMedicalHistory);

	void prescribeTreatment(Patient patient, Treatment treatment);

	void prescribeTreatment(int patient_id, int treatmentId);
}
