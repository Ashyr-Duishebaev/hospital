package services;

import java.util.List;

import model.Beds;

public interface BedsService {
	void createBed(Beds bed);

	Beds getBedById(int id);

	List<Beds> getAllBeds();

	void updateBed(Beds bed);

	void deleteBed(Beds bed);
}