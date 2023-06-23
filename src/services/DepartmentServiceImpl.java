package services;

import java.util.List;

import dao.DepartmentDAO;
import model.Department;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDAO departmentDAO;

	public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
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
	public void createDepartment(Department department) {
		departmentDAO.createDepartment(department);
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDAO.updateDepartment(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		departmentDAO.deleteDepartment(department);
	}

	@Override
	public void saveDepartment(Department department) {
		departmentDAO.createDepartment(department);
	}
}
