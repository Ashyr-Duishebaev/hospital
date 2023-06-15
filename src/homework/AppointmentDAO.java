package homework;

import java.util.List;

public interface AppointmentDAO {
	void createAppointment(Appointment appointment);

	Appointment getAppointmentById(int id);

	List<Appointment> getAllAppointments();

	void updateAppointment(Appointment appointment);

	void deleteAppointment(Appointment appointment);
}



