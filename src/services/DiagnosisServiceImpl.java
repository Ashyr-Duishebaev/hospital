package services;

import dao.DiagnosisDAO;
import model.Diagnosis;
import model.Patient;

public class DiagnosisServiceImpl implements DiagnosisService {
	private final DiagnosisDAO diagnosisDAO;

	public DiagnosisServiceImpl(DiagnosisDAO diagnosisDAO) {
		this.diagnosisDAO = diagnosisDAO;
	}

	@Override
	public void assignDiagnosis(Patient patient, Diagnosis diagnosis) {
		patient.setDiagnosis(diagnosis);
	}

	@Override
	public Diagnosis getPatientDiagnosis(Patient patient) {
		return patient.getDiagnosis();
	}
}

