package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Doctor;

public class DoctorDAOImpl implements DoctorDAO {

	private Connection connection;

	public DoctorDAOImpl(Connection connection) {
		this.connection = connection;
	}

	protected Doctor mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		int doctorId = resultSet.getInt("doctor_id");
		String name = resultSet.getString("name");
		String specialization = resultSet.getString("specialization");

		return new Doctor(doctorId, name, specialization);
	}

	@Override
	public void createDoctor(Doctor doctor) {
		String query = "INSERT INTO doctors (name, specialization) VALUES (?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, doctor.getFirstName());
			statement.setString(2, doctor.getSpecialization());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Doctor getDoctorById(int id) {
		String query = "SELECT * FROM doctors WHERE doctor_id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return mapResultSetToEntity(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = new ArrayList<>();
		String query = "SELECT * FROM doctors";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				doctors.add(mapResultSetToEntity(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return doctors;
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		String query = "UPDATE doctors SET name = ?, specialization = ? WHERE doctor_id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, doctor.getFirstName());
			statement.setString(2, doctor.getSpecialization());
			statement.setInt(3, doctor.getId());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDoctor(Doctor doctor) {
		String query = "DELETE FROM doctors WHERE doctor_id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, doctor.getId());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
