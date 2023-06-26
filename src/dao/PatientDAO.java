package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Patient;

public interface PatientDAO {
	void createPatient(Patient patient);

	Patient getPatientById(int patientId);

	List<Patient> getAllPatients();

	void updatePatient(Patient patient);

	void deletePatient(int patientId);

	void save(Patient patient);

	void deletePatient(Patient patient);

	void assignDiagnosis(int patientId, int diagnosisId);

	void prescribeTreatment(int patientId, int treatmentId);

	void writePrescription(int patientId, int prescriptionId);

	void makeAppointment(int patientId, int appointmentId);

	void setSqlSession(SqlSession sqlSession);
}
