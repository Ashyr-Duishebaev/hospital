package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Treatment;

public class TreatmentDAOImpl implements TreatmentDAO {
	private final SqlSession sqlSession;

	private Connection connection;

	public TreatmentDAOImpl(Connection connection) {
		this.connection = connection;
		this.sqlSession = null;
	}
	public TreatmentDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void save(Treatment treatment) {
		sqlSession.insert("dao.TreatmentDAO.save", treatment);
	}

	@Override
	public Treatment getTreatmentById(int id) {
		return sqlSession.selectOne("dao.TreatmentDAO.getTreatmentById", id);
	}

	@Override
	public List<Treatment> getAllTreatments() {
		return sqlSession.selectList("dao.TreatmentDAO.getAllTreatments");
	}
}
