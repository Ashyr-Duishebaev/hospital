package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

	protected Connection connection;

	public AbstractDAO(Connection connection) {
		this.connection = connection;
	}

	protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

	@Override
	public T findById(int id) {
		T entity = null;
		String query = "SELECT * FROM hospital WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				entity = mapResultSetToEntity(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public List<T> findAll() {
		List<T> entities = new ArrayList<>();
		String query = "SELECT * FROM hospital";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				T entity = mapResultSetToEntity(resultSet);
				entities.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;
	}

	@Override
	public void save(T entity) {
		String query = "INSERT INTO hospital (...) VALUES (...)";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(T entity) {
		String query = "UPDATE hospital SET ... WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(T entity) {
		String query = "DELETE FROM hospital WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
