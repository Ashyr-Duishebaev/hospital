package services;

import java.util.List;

import dao.AppointmentDAO;
import dao.DiagnosisDAO;
import dao.PatientDAO;
import dao.PrescriptionDAO;
import dao.TreatmentDAO;
import model.Appointment;
import model.Diagnosis;
import model.Patient;
import model.Prescription;
import model.Treatment;

public class PatientServiceImpl implements PatientService {

	private PatientDAO patientDAO;

	public PatientServiceImpl(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	public PatientServiceImpl(PatientDAO patientDAO2, DiagnosisDAO diagnosisDAO, TreatmentDAO treatmentDAO,
			PrescriptionDAO prescriptionDAO, AppointmentDAO appointmentDAO) {
	}

	@Override
	public void createPatient(Patient patient) {
		patientDAO.createPatient(patient);
	}

	@Override
	public Patient getPatientById(int patient_id) {
		return patientDAO.getPatientById(patient_id);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientDAO.getAllPatients();
	}

	@Override
	public void updatePatient(Patient patient) {
		patientDAO.updatePatient(patient);
	}

	@Override
	public void deletePatient(Patient patient) {
		patientDAO.deletePatient(patient);
	}

	@Override
	public void assignDiagnosis(Patient patient, Diagnosis diagnosis) {
	}

	@Override
	public void prescribeTreatment(Patient patient, Treatment treatment) {
	}

	@Override
	public void writePrescription(Patient patient, Prescription prescription) {
	}

	@Override
	public void makeAppointment(Patient patient, Appointment appointment) {
	}

	@Override
	public void assignDiagnosis(int patient_id, String diagnosis) {
	}

	@Override
	public void prescribeTreatment(int patient_id, int treatmentId) {
	}

	@Override
	public void writePrescription(int patient_id, String prescription) {
	}

	@Override
	public void makeAppointment(int patient_id, int doctorId, String appointmentDate) {
	}
}

