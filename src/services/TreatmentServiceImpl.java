package services;

import dao.TreatmentDAO;
import model.Patient;
import model.Treatment;

public class TreatmentServiceImpl implements TreatmentService {
	private final TreatmentDAO treatmentDAO;

	public TreatmentServiceImpl(TreatmentDAO treatmentDAO) {
		this.treatmentDAO = treatmentDAO;
	}

	@Override
	public void prescribeTreatment(Patient patient, Treatment treatment) {
		patient.setPrescribedTreatment(treatment);
	}

	@Override
	public Treatment getPrescribedTreatment(Patient patient) {
		return patient.getPrescribedTreatment();
	}
}
