package model;

import java.util.List;

public class Prescription {
	private int prescriptionId;
	private int patientId;
	private String doctorId;
	private String appointmentId;
	private List<Medicine> medicines;
	private String prescriptionDate;

	public Prescription(int prescriptionId, int patientId, String doctorId, String appointmentId,
			List<Medicine> medicines, String prescriptionDate) {
		super();
		this.prescriptionId = prescriptionId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentId = appointmentId;
		this.medicines = medicines;
		this.prescriptionDate = prescriptionDate;
	}

	public Prescription(int prescriptionId2, int patientId2, String medication, String instructions) {
		// TODO Auto-generated constructor stub
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	public String getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(String prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	@Override
	public String toString() {
		return "Prescription [prescriptionId=" + prescriptionId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", appointmentId=" + appointmentId + ", medicines=" + medicines + ", prescriptionDate="
				+ prescriptionDate + "]";
	}

	public String getInstructions() {
		// TODO Auto-generated method stub
		return null;
	}

}
