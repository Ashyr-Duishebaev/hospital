package services;

import java.util.List;

import dao.DoctorDAO;
import model.Doctor;

public class DoctorServiceImpl implements DoctorService {

	private DoctorDAO doctorDAO;

	public DoctorServiceImpl(DoctorDAO doctorDAO) {
		this.doctorDAO = doctorDAO;
	}

	@Override
	public void createDoctor(Doctor doctor) {
		doctorDAO.createDoctor(doctor);
	}

	@Override
	public Doctor getDoctorById(int id) {
		return doctorDAO.getDoctorById(id);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorDAO.getAllDoctors();
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		doctorDAO.updateDoctor(doctor);
	}

	@Override
	public void deleteDoctor(Doctor doctor) {
		doctorDAO.deleteDoctor(doctor);
	}
}