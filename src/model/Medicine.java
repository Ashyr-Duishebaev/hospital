package model;

public class Medicine {
	private String medicineId;
	private String medicineName;
	private String manufacturer;
	private String dosage;

	public Medicine(String medicineId, String medicineName, String manufacturer, String dosage) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.manufacturer = manufacturer;
		this.dosage = dosage;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", manufacturer="
				+ manufacturer + ", dosage=" + dosage + "]";
	}

}
