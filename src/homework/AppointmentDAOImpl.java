package homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl extends AbstractDAO<Appointment> implements AppointmentDAO {

	public AppointmentDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	protected Appointment mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		int appointmentId = resultSet.getInt("appointment_id");
		int patientId = resultSet.getInt("patient_id");
		int doctorId = resultSet.getInt("doctor_id");
		LocalDate date = resultSet.getDate("date").toLocalDate();
		LocalTime time = resultSet.getTime("time").toLocalTime();

		return new Appointment(appointmentId, patientId, doctorId, date, time);
	}


	@Override
	public void createAppointment(Appointment appointment) {
		String query = "INSERT INTO appointments (appointment_id, patient_id, doctor_id, date, time) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, appointment.getId());
			statement.setInt(2, appointment.getPatientId());
			statement.setInt(3, appointment.getDoctorId());
			statement.setDate(4, java.sql.Date.valueOf(appointment.getAppointmentDate()));
			statement.setTime(5, java.sql.Time.valueOf(appointment.getAppointmentTime()));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Appointment getAppointmentById(int id) {
		String query = "SELECT * FROM appointments WHERE appointment_id = ?";
		Appointment appointment = null;

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				appointment = mapResultSetToEntity(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return appointment;
	}

	@Override
	public List<Appointment> getAllAppointments() {
		List<Appointment> appointments = new ArrayList<>();
		String query = "SELECT * FROM appointments";

		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

			while (resultSet.next()) {
				Appointment appointment = mapResultSetToEntity(resultSet);
				appointments.add(appointment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return appointments;
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		String query = "UPDATE appointments SET patient_id = ?, doctor_id = ?, date = ?, time = ? WHERE appointment_id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, appointment.getPatientId());
			statement.setInt(2, appointment.getDoctorId());
			statement.setDate(3, java.sql.Date.valueOf(appointment.getAppointmentDate()));
			statement.setTime(4, java.sql.Time.valueOf(appointment.getAppointmentTime()));
			statement.setInt(5, appointment.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAppointment(Appointment appointment) {
		String query = "DELETE FROM appointments WHERE appointment_id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, appointment.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

