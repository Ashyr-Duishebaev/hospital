package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Prescription;

public class PrescriptionDAOImpl implements PrescriptionDAO {
	private final SqlSessionFactory sessionFactory;

	private Connection connection;

	public PrescriptionDAOImpl(Connection connection) {
		this.sessionFactory = null;
		this.connection = connection;
	}

	public PrescriptionDAOImpl(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Prescription prescription) {
		try (SqlSession session = sessionFactory.openSession()) {
			PrescriptionDAO prescriptionDAO = session.getMapper(PrescriptionDAO.class);
			prescriptionDAO.save(prescription);
			session.commit();
		}
	}

	@Override
    public Prescription getPrescriptionById(int prescriptionId) {
		try (SqlSession session = sessionFactory.openSession()) {
			PrescriptionDAO prescriptionDAO = session.getMapper(PrescriptionDAO.class);
			return prescriptionDAO.getPrescriptionById(prescriptionId);
        }
    }

	@Override
    public List<Prescription> getPrescriptionsByPatientId(int patientId) {
		try (SqlSession session = sessionFactory.openSession()) {
			PrescriptionDAO prescriptionDAO = session.getMapper(PrescriptionDAO.class);
			return prescriptionDAO.getPrescriptionsByPatientId(patientId);
		}
	}

	@Override
	public void delete(int prescriptionId) {
		try (SqlSession session = sessionFactory.openSession()) {
			PrescriptionDAO prescriptionDAO = session.getMapper(PrescriptionDAO.class);
			prescriptionDAO.delete(prescriptionId);
			session.commit();
		}
	}
}
