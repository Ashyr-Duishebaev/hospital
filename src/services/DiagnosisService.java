package services;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Diagnosis;
import model.Patient;

public interface DiagnosisService {
	@Insert("INSERT INTO diagnosis (patient_id, diagnosis_name) VALUES (#{patient.id}, #{diagnosis.name})")
	void assignDiagnosis(Patient patient, Diagnosis diagnosis);

	@Select("SELECT * FROM diagnosis WHERE patient_id = #{patient.id}")
	Diagnosis getPatientDiagnosis(Patient patient);
}
