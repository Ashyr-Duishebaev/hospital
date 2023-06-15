package homework;

import java.util.List;

public class PatientServiceImpl implements PatientService {

	private PatientDAO patientDAO;

	public PatientServiceImpl(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	@Override
	public void createPatient(Patient patient) {
		patientDAO.createPatient(patient);
	}

	@Override
	public Patient getPatientById(int id) {
		return patientDAO.getPatientById(id);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientDAO.getAllPatients();
	}

	@Override
	public void updatePatient(Patient patient) {
		patientDAO.updatePatient(patient);
	}

	@Override
	public void deletePatient(Patient patient) {
		patientDAO.deletePatient(patient);
	}
}

