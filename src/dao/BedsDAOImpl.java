package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Beds;

public class BedsDAOImpl implements BedsDAO {

	private final SqlSession sqlSession;
	private final BedsDAO bedsDAO;

	private Connection connection;

	public BedsDAOImpl(Connection connection) {
		this.connection = connection;
		this.sqlSession = null;
		this.bedsDAO = null;
	}

	public BedsDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		this.bedsDAO = sqlSession.getMapper(BedsDAO.class);
	}

	@Override
	public void createBed(Beds bed) {
		bedsDAO.createBed(bed);
		sqlSession.commit();
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
		sqlSession.commit();
	}

	@Override
	public void deleteBed(Beds bed) {
		bedsDAO.deleteBed(bed);
		sqlSession.commit();
	}
}
