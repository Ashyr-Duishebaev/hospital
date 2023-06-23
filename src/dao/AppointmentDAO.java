package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Appointment;

public interface AppointmentDAO {
	@Insert("INSERT INTO appointments (appointment_id, patient_id, doctor_id, date, time) "
			+ "VALUES (#{id}, #{patientId}, #{doctorId}, #{appointmentDate}, #{appointmentTime})")
	void createAppointment(Appointment appointment);

	@Select("SELECT * FROM appointments WHERE appointment_id = #{id}")
	Appointment getAppointmentById(int id);

	@Select("SELECT * FROM appointments")
	List<Appointment> getAllAppointments();

	@Update("UPDATE appointments SET patient_id = #{patientId}, doctor_id = #{doctorId}, "
			+ "date = #{appointmentDate}, time = #{appointmentTime} WHERE appointment_id = #{id}")
	void updateAppointment(Appointment appointment);

	@Delete("DELETE FROM appointments WHERE appointment_id = #{id}")
	void deleteAppointment(Appointment appointment);
}