package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Beds;

public class BedsDAOImpl implements BedsDAO {

	private Connection connection;

	public BedsDAOImpl(Connection connection) {
		this.connection = connection;
	}

	protected Beds mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		int bedId = resultSet.getInt("bed_id");
		String bedType = resultSet.getString("bed_type");
		boolean isOccupied = resultSet.getBoolean("is_occupied");

		return new Beds(bedId, bedType, isOccupied);
	}

	@Override
	public void createBed(Beds bed) {
		try (PreparedStatement statement = connection
				.prepareStatement("INSERT INTO beds (bed_type, is_occupied) VALUES (?, ?)")) {
			statement.setString(1, bed.getBedType());
			statement.setBoolean(2, bed.isOccupied());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Beds getBedById(int id) {
		try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM beds WHERE bed_id = ?")) {
			statement.setInt(1, id);
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
	public List<Beds> getAllBeds() {
		List<Beds> beds = new ArrayList<>();
		try (Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery("SELECT * FROM beds")) {
				while (resultSet.next()) {
					beds.add(mapResultSetToEntity(resultSet));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beds;
	}

	@Override
	public void updateBed(Beds bed) {
		try (PreparedStatement statement = connection
				.prepareStatement("UPDATE beds SET bed_type = ?, is_occupied = ? WHERE bed_id = ?")) {
			statement.setString(1, bed.getBedType());
			statement.setBoolean(2, bed.isOccupied());
			statement.setInt(3, bed.getBedId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBed(Beds bed) {
		try (PreparedStatement statement = connection.prepareStatement("DELETE FROM beds WHERE bed_id = ?")) {
			statement.setInt(1, bed.getBedId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
