package homework;

import java.util.List;

public class Prescription {
	private String prescriptionId;
	private String patientId;
	private String doctorId;
	private String appointmentId;
	private List<Medicine> medicines;
	private String prescriptionDate;

	public Prescription(String prescriptionId, String patientId, String doctorId, String appointmentId,
			List<Medicine> medicines, String prescriptionDate) {
		super();
		this.prescriptionId = prescriptionId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentId = appointmentId;
		this.medicines = medicines;
		this.prescriptionDate = prescriptionDate;
	}

	public String getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
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


}
