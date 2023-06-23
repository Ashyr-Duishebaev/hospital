package model;

import java.util.logging.Logger;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Beds {
	private static final Logger logger = Logger.getLogger(Beds.class.getName());
	private int bedId;
	private String bedType;
	private boolean isOccupied;

	public Beds(int bedId, String bedType, boolean isOccupied) {
		super();
		this.bedId = bedId;
		this.bedType = bedType;
		this.isOccupied = isOccupied;
	}

	public Beds() {

	}

	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

}