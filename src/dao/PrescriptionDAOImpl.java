package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prescription;

public class PrescriptionDAOImpl implements PrescriptionDAO {
	private Connection connection;

	public PrescriptionDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void save(Prescription prescription) {
		String query = "INSERT INTO prescriptions (prescription_id, patient_id, medication, instructions) VALUES (?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, prescription.getPrescriptionId());
			statement.setInt(2, prescription.getPatientId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
    public Prescription getPrescriptionById(int prescriptionId) {
        String query = "SELECT * FROM prescriptions WHERE prescription_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, prescriptionId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int patientId = resultSet.getInt("patient_id");
                String medication = resultSet.getString("medication");
                String instructions = resultSet.getString("instructions");

                return new Prescription(prescriptionId, patientId, medication, instructions);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

	@Override
    public List<Prescription> getPrescriptionsByPatientId(int patientId) {
        List<Prescription> prescriptions = new ArrayList<>();
        String query = "SELECT * FROM prescriptions WHERE patient_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, patientId);
            ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int prescriptionId = resultSet.getInt("prescription_id");
				String medication = resultSet.getString("medication");
				String instructions = resultSet.getString("instructions");

				Prescription prescription = new Prescription(prescriptionId, patientId, medication, instructions);
				prescriptions.add(prescription);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prescriptions;
	}

	@Override
	public void delete(int prescriptionId) {
		String query = "DELETE FROM prescriptions WHERE prescription_id = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, prescriptionId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

