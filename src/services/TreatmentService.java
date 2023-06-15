package services;

import model.Patient;
import model.Treatment;

public interface TreatmentService {
	void prescribeTreatment(Patient patient, Treatment treatment);

	Treatment getPrescribedTreatment(Patient patient);
}
