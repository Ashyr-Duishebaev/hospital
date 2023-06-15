package homework;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDAO departmentDAO;

	public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	@Override
	public Department getDepartmentById(int id) {
		return departmentDAO.findById(id);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentDAO.findAll();
	}

	@Override
	public void createDepartment(Department department) {
		departmentDAO.save(department);
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDAO.update(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		departmentDAO.delete(department);
	}

	@Override
	public void saveDepartment(Department department) {
		departmentDAO.save(department);
	}
}
