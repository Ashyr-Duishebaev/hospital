package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Department;

public class DepartmentDAOImpl implements DepartmentDAO {
	private final SqlSession sqlSession;
	private final DepartmentDAO departmentDAO;

	public DepartmentDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		this.departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
	}

	@Override
	public void createDepartment(Department department) {
		departmentDAO.createDepartment(department);
		sqlSession.commit();
	}

	@Override
	public Department getDepartmentById(int id) {
		return departmentDAO.getDepartmentById(id);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentDAO.getAllDepartments();
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDAO.updateDepartment(department);
		sqlSession.commit();
	}

	@Override
	public void deleteDepartment(Department department) {
		departmentDAO.deleteDepartment(department);
		sqlSession.commit();
	}

	@Override
	public Department findById(int id) {
		return departmentDAO.findById(id);
	}

	@Override
	public List<Department> findAll() {
		return departmentDAO.findAll();
	}

	@Override
	public void save(Department department) {
		departmentDAO.save(department);
		sqlSession.commit();
	}

	@Override
	public void update(Department department) {
		departmentDAO.update(department);
		sqlSession.commit();
	}

	@Override
	public void delete(Department department) {
		departmentDAO.delete(department);
		sqlSession.commit();
	}
}
