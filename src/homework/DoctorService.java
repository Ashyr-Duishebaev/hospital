package homework;

import java.util.List;

public interface DoctorService {
	void createDoctor(Doctor doctor);

	Doctor getDoctorById(int id);

	List<Doctor> getAllDoctors();

	void updateDoctor(Doctor doctor);

	void deleteDoctor(Doctor doctor);
}