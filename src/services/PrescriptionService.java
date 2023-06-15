package services;

import java.util.List;

import model.Prescription;

public interface PrescriptionService {
	void savePrescription(Prescription prescription);

	Prescription getPrescriptionById(int prescriptionId);

	List<Prescription> getPrescriptionsByPatientId(int patientId);

	void deletePrescription(int prescriptionId);
}
