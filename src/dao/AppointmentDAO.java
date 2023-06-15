package dao;

import java.util.List;

import model.Appointment;

public interface AppointmentDAO {
	void createAppointment(Appointment appointment);

	Appointment getAppointmentById(int id);

	List<Appointment> getAllAppointments();

	void updateAppointment(Appointment appointment);

	void deleteAppointment(Appointment appointment);
}



