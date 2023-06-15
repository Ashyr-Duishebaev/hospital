package dao;

import java.util.List;

import model.Diagnosis;

public interface DiagnosisDAO {
	void save(Diagnosis diagnosis);

	Diagnosis getDiagnosisById(int id);

	List<Diagnosis> getAllDiagnoses();
}
