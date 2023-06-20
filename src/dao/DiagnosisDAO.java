package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Diagnosis;

public interface DiagnosisDAO {
	@Insert("INSERT INTO diagnoses (id, name) VALUES (#{id}, #{name})")
	void save(Diagnosis diagnosis);

	@Select("SELECT * FROM diagnoses WHERE id = #{id}")
	Diagnosis getDiagnosisById(int id);

	@Select("SELECT * FROM diagnoses")
	List<Diagnosis> getAllDiagnoses();
}
