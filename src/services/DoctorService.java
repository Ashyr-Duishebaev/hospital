package services;

import java.util.List;

import model.Doctor;

public interface DoctorService {
	void createDoctor(Doctor doctor);

	Doctor getDoctorById(int id);

	List<Doctor> getAllDoctors();

	void updateDoctor(Doctor doctor);

	void deleteDoctor(Doctor doctor);
}