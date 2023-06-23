package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import model.Patient;

@Mapper
public interface PatientMapper {

	void createPatient(Patient patient);

	Patient getPatientById(@Param("patientId") int patientId);

	List<Patient> getAllPatients();

	void updatePatient(Patient patient);

	void deletePatient(@Param("patientId") int patientId);

	void save(Patient patient);
}
