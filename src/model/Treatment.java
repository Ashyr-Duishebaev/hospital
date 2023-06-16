package model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Treatment {
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

	public void saveToJson() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			File file = new File("/Treatment.json");
			objectMapper.writeValue(file, this);
			System.out.println("Treatment saved to JSON file successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parseJson() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Treatment treatment = objectMapper.readValue(new File("/Treatment.json"), Treatment.class);
			System.out.println("Parsed JSON: " + treatment);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

