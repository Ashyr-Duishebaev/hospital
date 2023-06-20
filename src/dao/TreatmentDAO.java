package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Treatment;

public interface TreatmentDAO {
	@Insert("INSERT INTO treatments (treatment_id, name) VALUES (#{id}, #{name})")
	void save(Treatment treatment);

	@Select("SELECT * FROM treatments WHERE treatment_id = #{id}")
	Treatment getTreatmentById(int id);

	@Select("SELECT * FROM treatments")
	List<Treatment> getAllTreatments();
}
