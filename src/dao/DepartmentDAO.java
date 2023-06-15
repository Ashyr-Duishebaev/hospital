package dao;

import java.util.List;

import model.Department;

public interface DepartmentDAO {
	Department findById(int id);

	List<Department> findAll();

	void save(Department department);

	void update(Department department);

	void delete(Department department);

	void createDepartment(Department department);

	Department getDepartmentById(int id);

	List<Department> getAllDepartments();

	void updateDepartment(Department department);

	void deleteDepartment(Department department);

}
