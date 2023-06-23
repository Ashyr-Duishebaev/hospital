package model;

import java.util.logging.Logger;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Department {
	private static final Logger logger = Logger.getLogger(Department.class.getName());
	private int departmentId;
	private String departmentName;

	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public Department() {

	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}

}
