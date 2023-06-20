package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Patient;

public interface PatientDAO {

	@Insert("INSERT INTO patients (first_name, last_name, birth_date, gender, phone_number, address) "
			+ "VALUES (#{firstName}, #{lastName}, #{dateOfBirth}, #{gender}, #{contactNumber}, #{address})")
	void createPatient(Patient patient);

	@Select("SELECT * FROM patients WHERE patient_id = #{patientId}")
	Patient getPatientById(int patientId);

	@Select("SELECT * FROM patients")
	List<Patient> getAllPatients();

	@Update("UPDATE patients SET first_name = #{firstName}, last_name = #{lastName}, "
			+ "birth_date = #{dateOfBirth}, gender = #{gender}, phone_number = #{contactNumber}, "
			+ "address = #{address} WHERE patient_id = #{patientId}")
	void updatePatient(Patient patient);

	@Delete("DELETE FROM patients WHERE patient_id = #{patientId}")
	void deletePatient(int patientId);

	@Insert("INSERT INTO patients (first_name, last_name, birth_date, gender, phone_number, address) "
			+ "VALUES (#{firstName}, #{lastName}, #{dateOfBirth}, #{gender}, #{contactNumber}, #{address})")
	void save(Patient patient);

	void deletePatient(Patient patient);

	@Update("UPDATE patients SET diagnosis_id = #{diagnosisId} WHERE patient_id = #{patientId}")
	void assignDiagnosis(int patientId, int diagnosisId);

	@Update("UPDATE patients SET treatment_id = #{treatmentId} WHERE patient_id = #{patientId}")
	void prescribeTreatment(int patientId, int treatmentId);

	@Update("UPDATE patients SET prescription_id = #{prescriptionId} WHERE patient_id = #{patientId}")
	void writePrescription(int patientId, int prescriptionId);

	@Update("UPDATE patients SET appointment_id = #{appointmentId} WHERE patient_id = #{patientId}")
	void makeAppointment(int patientId, int appointmentId);
}
