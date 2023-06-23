package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Appointment {
	private static final Logger logger = Logger.getLogger(Appointment.class.getName());

	@JsonProperty("id")
	private int id;

	@JsonProperty("patient_id")
	private int patientId;

	@JsonProperty("doctor_id")
	private int doctorId;

	@JsonProperty("appointment_date")
	private String appointmentDate;

	@JsonProperty("appointment_time")
	private String appointmentTime;

	public Appointment(int id, int patientId, int doctorId, LocalDate date, LocalTime time) {
		this.id = id;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
	}

	public Appointment() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", appointmentDate="
				+ appointmentDate + ", appointmentTime=" + appointmentTime + "]";
	}


}
