package dao;

import java.util.List;

import model.Doctor;

public interface DoctorDAO {
	void createDoctor(Doctor doctor);

	Doctor getDoctorById(int id);

	List<Doctor> getAllDoctors();

	void updateDoctor(Doctor doctor);

	void deleteDoctor(Doctor doctor);
}