package services;

import model.Diagnosis;
import model.Patient;

public interface DiagnosisService {
	void assignDiagnosis(Patient patient, Diagnosis diagnosis);

	Diagnosis getPatientDiagnosis(Patient patient);
}
