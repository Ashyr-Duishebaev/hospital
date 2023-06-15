package homework;

public class Ward {
	private String wardId;
	private String wardName;
	private String departmentId;

	public Ward(String wardId, String wardName, String departmentId) {
		super();
		this.wardId = wardId;
		this.wardName = wardName;
		this.departmentId = departmentId;
	}

	public String getWardId() {
		return wardId;
	}

	public void setWardId(String wardId) {
		this.wardId = wardId;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Ward [wardId=" + wardId + ", wardName=" + wardName + ", departmentId=" + departmentId + "]";
	}

}

