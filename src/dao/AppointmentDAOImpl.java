package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Appointment;

public class AppointmentDAOImpl implements AppointmentDAO {
	private final SqlSession sqlSession;

	private Connection connection;

	public AppointmentDAOImpl(Connection connection) {
		this.connection = connection;
		this.sqlSession = null;
	}

	@Override
	public void createAppointment(Appointment appointment) {
		AppointmentDAO appointmentDAO = sqlSession.getMapper(AppointmentDAO.class);
		appointmentDAO.createAppointment(appointment);
	}

	@Override
	public Appointment getAppointmentById(int id) {
		AppointmentDAO appointmentDAO = sqlSession.getMapper(AppointmentDAO.class);
		return appointmentDAO.getAppointmentById(id);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		AppointmentDAO appointmentDAO = sqlSession.getMapper(AppointmentDAO.class);
		return appointmentDAO.getAllAppointments();
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		AppointmentDAO appointmentDAO = sqlSession.getMapper(AppointmentDAO.class);
		appointmentDAO.updateAppointment(appointment);
	}

	@Override
	public void deleteAppointment(Appointment appointment) {
		AppointmentDAO appointmentDAO = sqlSession.getMapper(AppointmentDAO.class);
		appointmentDAO.deleteAppointment(appointment);
	}
}