package services;

import java.util.List;

import dao.AppointmentDAO;
import model.Appointment;

public class AppointmentServiceImpl implements AppointmentService {

	private AppointmentDAO appointmentDAO;

	public AppointmentServiceImpl(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	@Override
	public void createAppointment(Appointment appointment) {
		appointmentDAO.createAppointment(appointment);
	}

	@Override
	public Appointment getAppointmentById(int id) {
		return appointmentDAO.getAppointmentById(id);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentDAO.getAllAppointments();
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		appointmentDAO.updateAppointment(appointment);
	}

	@Override
	public void deleteAppointment(Appointment appointment) {
		appointmentDAO.deleteAppointment(appointment);
	}
}

