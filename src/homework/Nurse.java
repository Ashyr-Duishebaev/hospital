package homework;

public class Nurse {
	private String nurseId;
	private String firstName;
	private String lastName;
	private String department;
	private String contactNumber;
	private String address;

	public Nurse(String nurseId, String firstName, String lastName, String department, String contactNumber,
			String address) {
		super();
		this.nurseId = nurseId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public String getNurseId() {
		return nurseId;
	}

	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Nurse [nurseId=" + nurseId + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + ", contactNumber=" + contactNumber + ", address=" + address + "]";
	}


}