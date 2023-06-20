package model;

import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Treatment {
	private static final Logger logger = Logger.getLogger(Treatment.class.getName());
	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	public Treatment(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Treatment [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}

