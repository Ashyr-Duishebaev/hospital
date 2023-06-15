package homework;

import java.util.List;

public interface DepartmentService {

	Department getDepartmentById(int id);

	List<Department> getAllDepartments();

	void createDepartment(Department department);

	void updateDepartment(Department department);

	void deleteDepartment(Department department);

	void saveDepartment(Department department);
}
