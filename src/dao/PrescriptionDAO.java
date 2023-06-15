package dao;

import java.util.List;

import model.Prescription;

public interface PrescriptionDAO {
	void save(Prescription prescription);

	Prescription getPrescriptionById(int prescriptionId);

	List<Prescription> getPrescriptionsByPatientId(int patientId);

	void delete(int prescriptionId);
}
