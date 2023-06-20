package services;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Prescription;

public interface PrescriptionService {
	@Insert("INSERT INTO prescriptions (prescription_id, patient_id, description) VALUES (#{prescriptionId}, #{patientId}, #{description})")
	void savePrescription(Prescription prescription);

	@Select("SELECT * FROM prescriptions WHERE prescription_id = #{prescriptionId}")
	Prescription getPrescriptionById(int prescriptionId);

	@Select("SELECT * FROM prescriptions WHERE patient_id = #{patientId}")
	List<Prescription> getPrescriptionsByPatientId(int patientId);

	@Delete("DELETE FROM prescriptions WHERE prescription_id = #{prescriptionId}")
	void deletePrescription(int prescriptionId);
}
