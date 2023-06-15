package dao;

import java.util.List;

import model.Treatment;

public interface TreatmentDAO {
	void save(Treatment treatment);

	Treatment getTreatmentById(int id);

	List<Treatment> getAllTreatments();
}
