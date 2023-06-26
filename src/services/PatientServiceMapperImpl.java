package services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.PatientDAO;
import model.Appointment;
import model.Diagnosis;
import model.Patient;
import model.Prescription;
import model.Treatment;

public class PatientServiceMapperImpl implements PatientServiceMapper {
    private PatientDAO patientDAO;
	private SqlSessionFactory sqlSessionFactory;

	public PatientServiceMapperImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
		this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void createPatient(Patient patient) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			patientDAO.setSqlSession(sqlSession);
			patientDAO.createPatient(patient);
			sqlSession.commit();
		}
    }

    @Override
    public Patient getPatientById(int patientId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			patientDAO.setSqlSession(sqlSession);
			return patientDAO.getPatientById(patientId);
		}
    }

    @Override
    public List<Patient> getAllPatients() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			patientDAO.setSqlSession(sqlSession);
			return patientDAO.getAllPatients();
		}
    }

    @Override
    public void updatePatient(Patient patient) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			patientDAO.setSqlSession(sqlSession);
			patientDAO.updatePatient(patient);
			sqlSession.commit();
		}
    }

    @Override
    public void deletePatient(Patient patient) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			patientDAO.setSqlSession(sqlSession);
			patientDAO.deletePatient(patient);
			sqlSession.commit();
		}
    }

    public void assignDiagnosis(Patient patient, Diagnosis diagnosis) {
		// Implement the logic to assign a diagnosis to a patient using MyBatis API
    }

	@Override
    public void prescribeTreatment(Patient patient, Treatment treatment) {
		// Implement the logic to prescribe a treatment to a patient using MyBatis API
    }

    @Override
    public void writePrescription(Patient patient, Prescription prescription) {
		// Implement the logic to write a prescription for a patient using MyBatis API
    }

    @Override
    public void makeAppointment(Patient patient, Appointment appointment) {
		// Implement the logic to make an appointment for a patient using MyBatis API
    }

    @Override
	public void prescribeTreatment(int patient_id, int treatmentId) {
		// Implement the logic to prescribe a treatment to a patient using MyBatis API
    }

    @Override
	public void writePrescription(int patient_id, String prescription) {
		// Implement the logic to write a prescription for a patient using MyBatis API
    }

    @Override
	public void makeAppointment(int patient_id, int doctorId, String appointmentDate) {
		// Implement the logic to make an appointment for a patient using MyBatis API
    }

    @Override
    public void updatePatientInformation(int patientId, String newName, String newContactDetails,
            String newMedicalHistory) {
		// Implement the logic to update patient information using MyBatis API
    }

	@Override
	public void prescribeTreatment(int patientId, Treatment treatment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignDiagnosis(int patientId, Diagnosis diagnosis) {
		// TODO Auto-generated method stub

	}
}
