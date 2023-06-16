package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Patient;

public class PatientDAOImpl implements PatientDAO {

	private Connection connection;

	public PatientDAOImpl(Connection connection) {
		this.connection = connection;
	}

	protected Patient mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("patient_id");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");
		String date_of_birth = resultSet.getString("date_of_birth");
		String gender = resultSet.getString("gender");
		String contact_number = resultSet.getString("contact_Number");
		String address = resultSet.getString("address");
		return new Patient(id, firstName, lastName, date_of_birth, gender, contact_number, address);
	}

	@Override
	public void createPatient(Patient patient) {
		try (PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO patients (first_name, last_name, birth_date, gender, phone_number, address) "
						+ "VALUES (?, ?, ?, ?, ?, ?)")) {
			statement.setString(1, patient.getFirstName());
			statement.setString(2, patient.getLastName());
			statement.setString(3, patient.getDateOfBirth());
			statement.setString(4, patient.getGender());
			statement.setString(5, patient.getContactNumber());
			statement.setString(6, patient.getAddress());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Patient getPatientById(int patient_id) {
		try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM patients WHERE patient_id = ?")) {
			statement.setInt(1, patient_id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return mapResultSetToEntity(resultSet);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		List<Patient> patients = new ArrayList<>();

		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM patients")) {
			while (resultSet.next()) {
				Patient patient = mapResultSetToEntity(resultSet);
				patients.add(patient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patients;
	}

	@Override
	public void updatePatient(Patient patient) {
		try (PreparedStatement statement = connection
				.prepareStatement("UPDATE patients SET first_name = ?, last_name = ?, birth_date = ?, gender = ?, "
						+ "phone_number = ?, address = ? WHERE id = ?")) {
			statement.setString(1, patient.getFirstName());
			statement.setString(2, patient.getLastName());
			statement.setString(3, patient.getDateOfBirth());
			statement.setString(4, patient.getGender());
			statement.setString(5, patient.getContactNumber());
			statement.setString(6, patient.getAddress());
			statement.setInt(7, patient.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePatient(Patient patient) {
		try (PreparedStatement statement = connection.prepareStatement("DELETE FROM patients WHERE id = ?")) {
			statement.setInt(1, patient.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(Patient patient) {
		// TODO Auto-generated method stub

	}
}
