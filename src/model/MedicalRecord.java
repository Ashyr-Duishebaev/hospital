package model;

public class MedicalRecord {
	private String recordId;
	private String patientId;
	private String doctorId;
	private String dateOfVisit;
	private String diagnosis;
	private String treatment;

	public MedicalRecord(String recordId, String patientId, String doctorId, String dateOfVisit, String diagnosis,
			String treatment) {
		super();
		this.recordId = recordId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.dateOfVisit = dateOfVisit;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
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

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	@Override
	public String toString() {
		return "MedicalRecord [recordId=" + recordId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", dateOfVisit=" + dateOfVisit + ", diagnosis=" + diagnosis + ", treatment=" + treatment + "]";
	}

}
