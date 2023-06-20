package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Doctor;

public interface DoctorDAO {
	@Insert("INSERT INTO doctors (name, specialization) VALUES (#{name}, #{specialization})")
	void createDoctor(Doctor doctor);

	@Select("SELECT * FROM doctors WHERE id = #{id}")
	Doctor getDoctorById(int id);

	@Select("SELECT * FROM doctors")
	List<Doctor> getAllDoctors();

	@Update("UPDATE doctors SET name = #{name}, specialization = #{specialization} WHERE id = #{id}")
	void updateDoctor(Doctor doctor);

	@Delete("DELETE FROM doctors WHERE id = #{id}")
	void deleteDoctor(Doctor doctor);
}
