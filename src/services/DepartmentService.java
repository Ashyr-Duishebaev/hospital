package services;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Department;

public interface DepartmentService {
	@Select("SELECT * FROM departments WHERE department_id = #{id}")
	Department getDepartmentById(int id);

	@Select("SELECT * FROM departments")
	List<Department> getAllDepartments();

	@Insert("INSERT INTO departments (department_name) VALUES (#{departmentName})")
	void createDepartment(Department department);

	@Update("UPDATE departments SET department_name = #{departmentName} WHERE department_id = #{departmentId}")
	void updateDepartment(Department department);

	@Delete("DELETE FROM departments WHERE department_id = #{departmentId}")
	void deleteDepartment(Department department);

	@Insert("INSERT INTO departments (department_id, department_name) VALUES (#{departmentId}, #{departmentName})")
	void saveDepartment(Department department);
}
