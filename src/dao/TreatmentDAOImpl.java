package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Treatment;

public class TreatmentDAOImpl implements TreatmentDAO {
	private Map<Integer, Treatment> treatmentMap;

	public TreatmentDAOImpl(Connection connection) {
		this.treatmentMap = new HashMap<>();
	}

	@Override
	public void save(Treatment treatment) {
		treatmentMap.put(treatment.getId(), treatment);
	}

	@Override
	public Treatment getTreatmentById(int id) {
		return treatmentMap.get(id);
	}

	@Override
	public List<Treatment> getAllTreatments() {
		return new ArrayList<>(treatmentMap.values());
	}
}
