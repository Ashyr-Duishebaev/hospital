package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Diagnosis;

public class DiagnosisDAOImpl implements DiagnosisDAO {
	private Map<Integer, Diagnosis> diagnosisMap;

	public DiagnosisDAOImpl(Connection connection) {
		this.diagnosisMap = new HashMap<>();
	}

	@Override
	public void save(Diagnosis diagnosis) {
		diagnosisMap.put(diagnosis.getId(), diagnosis);
	}

	@Override
	public Diagnosis getDiagnosisById(int id) {
		return diagnosisMap.get(id);
	}

	@Override
	public List<Diagnosis> getAllDiagnoses() {
		return new ArrayList<>(diagnosisMap.values());
	}
}

