package homework;

import java.util.List;

public class BedsServiceImpl implements BedsService {

	private BedsDAO bedsDAO;

	public BedsServiceImpl(BedsDAO bedsDAO) {
		this.bedsDAO = bedsDAO;
	}

	@Override
	public void createBed(Beds bed) {
		bedsDAO.createBed(bed);
	}

	@Override
	public Beds getBedById(int id) {
		return bedsDAO.getBedById(id);
	}

	@Override
	public List<Beds> getAllBeds() {
		return bedsDAO.getAllBeds();
	}

	@Override
	public void updateBed(Beds bed) {
		bedsDAO.updateBed(bed);
	}

	@Override
	public void deleteBed(Beds bed) {
		bedsDAO.deleteBed(bed);
	}
}
