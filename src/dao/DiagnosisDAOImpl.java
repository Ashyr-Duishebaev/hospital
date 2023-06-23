package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Diagnosis;

public class DiagnosisDAOImpl implements DiagnosisDAO {
	private final SqlSession sqlSession;

	private Connection connection;

	public DiagnosisDAOImpl(Connection connection) {
		this.connection = connection;
		this.sqlSession = null;
	}
	public DiagnosisDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void save(Diagnosis diagnosis) {
		DiagnosisDAO diagnosisDAO = sqlSession.getMapper(DiagnosisDAO.class);
		diagnosisDAO.save(diagnosis);
	}

	@Override
	public Diagnosis getDiagnosisById(int id) {
		DiagnosisDAO diagnosisDAO = sqlSession.getMapper(DiagnosisDAO.class);
		return diagnosisDAO.getDiagnosisById(id);
	}

	@Override
	public List<Diagnosis> getAllDiagnoses() {
		DiagnosisDAO diagnosisDAO = sqlSession.getMapper(DiagnosisDAO.class);
		return diagnosisDAO.getAllDiagnoses();
	}
}
