package homework;

public class LabReport {
	private String reportId;
	private String patientId;
	private String testId;
	private String reportDate;
	private String result;

	public LabReport(String reportId, String patientId, String testId, String reportDate, String result) {
		super();
		this.reportId = reportId;
		this.patientId = patientId;
		this.testId = testId;
		this.reportDate = reportDate;
		this.result = result;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "LabReport [reportId=" + reportId + ", patientId=" + patientId + ", testId=" + testId + ", reportDate="
				+ reportDate + ", result=" + result + "]";
	}


}
