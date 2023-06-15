package services;

import java.util.List;

import model.Department;

public interface DepartmentService {

	Department getDepartmentById(int id);

	List<Department> getAllDepartments();

	void createDepartment(Department department);

	void updateDepartment(Department department);

	void deleteDepartment(Department department);

	void saveDepartment(Department department);
}

