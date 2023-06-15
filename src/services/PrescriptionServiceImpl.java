package services;

import java.util.List;

import dao.PrescriptionDAO;
import model.Prescription;

public class PrescriptionServiceImpl implements PrescriptionService {
	private PrescriptionDAO prescriptionDAO;

	public PrescriptionServiceImpl(PrescriptionDAO prescriptionDAO) {
		this.prescriptionDAO = prescriptionDAO;
	}

	@Override
	public void savePrescription(Prescription prescription) {
		prescriptionDAO.save(prescription);
	}

	@Override
	public Prescription getPrescriptionById(int prescriptionId) {
		return prescriptionDAO.getPrescriptionById(prescriptionId);
	}

	@Override
	public List<Prescription> getPrescriptionsByPatientId(int patientId) {
		return prescriptionDAO.getPrescriptionsByPatientId(patientId);
	}

	@Override
	public void deletePrescription(int prescriptionId) {
		prescriptionDAO.delete(prescriptionId);
	}
}
