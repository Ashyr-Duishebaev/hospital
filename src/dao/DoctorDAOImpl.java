package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Doctor;

public class DoctorDAOImpl implements DoctorDAO {
	private final SqlSession sqlSession;

	private Connection connection;

	public DoctorDAOImpl(Connection connection) {
		this.connection = connection;
		this.sqlSession = null;
	}

	public DoctorDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void createDoctor(Doctor doctor) {
		sqlSession.insert("createDoctor", doctor);
	}

	@Override
	public Doctor getDoctorById(int id) {
		return sqlSession.selectOne("getDoctorById", id);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return sqlSession.selectList("getAllDoctors");
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		sqlSession.update("updateDoctor", doctor);
	}

	@Override
	public void deleteDoctor(Doctor doctor) {
		sqlSession.delete("deleteDoctor", doctor);
	}
}
