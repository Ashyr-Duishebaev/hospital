package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Patient;

public class PatientDAOImpl implements PatientDAO {
	private final SqlSession sqlSession;
	private final PatientDAO patientDAO;

	private Connection connection;

	public PatientDAOImpl(Connection connection) {
		this.connection = connection;
		this.sqlSession = null;
		this.patientDAO = null;
	}

	public PatientDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		this.patientDAO = sqlSession.getMapper(PatientDAO.class);
	}

	@Override
	public void createPatient(Patient patient) {
		patientDAO.createPatient(patient);
		sqlSession.commit();
	}

	@Override
	public Patient getPatientById(int patient_id) {
		return patientDAO.getPatientById(patient_id);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientDAO.getAllPatients();
	}

	@Override
	public void updatePatient(Patient patient) {
		patientDAO.updatePatient(patient);
		sqlSession.commit();
	}

	@Override
	public void deletePatient(Patient patient) {
		patientDAO.deletePatient(patient);
		sqlSession.commit();
	}

	@Override
	public void save(Patient patient) {
		// TODO: Implement the save method using MyBatis
	}

	@Override
	public void deletePatient(int patientId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignDiagnosis(int patientId, int diagnosisId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prescribeTreatment(int patientId, int treatmentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void writePrescription(int patientId, int prescriptionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeAppointment(int patientId, int appointmentId) {
		// TODO Auto-generated method stub

	}
}
