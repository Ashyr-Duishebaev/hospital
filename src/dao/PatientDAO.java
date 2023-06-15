package dao;

import java.util.List;

import model.Patient;

public interface PatientDAO {
	void createPatient(Patient patient);

	Patient getPatientById(int patient_id);

	List<Patient> getAllPatients();

	void updatePatient(Patient patient);

	void deletePatient(Patient patient);

	void save(Patient patient);
}

