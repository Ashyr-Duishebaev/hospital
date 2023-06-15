package homework;

public class LabTest {
	private String testId;
	private String testName;
	private String testDescription;

	public LabTest(String testId, String testName, String testDescription) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testDescription = testDescription;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	@Override
	public String toString() {
		return "LabTest [testId=" + testId + ", testName=" + testName + ", testDescription=" + testDescription + "]";
	}

}
