package homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl extends AbstractDAO<Department> implements DepartmentDAO {

	public DepartmentDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	protected Department mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		int departmentId = resultSet.getInt("department_id");
		String departmentName = resultSet.getString("department_name");

		return new Department(departmentId, departmentName);
	}

	@Override
	public void createDepartment(Department department) {
		try (PreparedStatement statement = connection
				.prepareStatement("INSERT INTO departments (department_name) VALUES (?)")) {
			statement.setString(1, department.getDepartmentName());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Department getDepartmentById(int id) {
		try (PreparedStatement statement = connection
				.prepareStatement("SELECT * FROM departments WHERE department_id = ?")) {
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
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM departments")) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				departments.add(mapResultSetToEntity(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}

	@Override
	public void updateDepartment(Department department) {
		try (PreparedStatement statement = connection
				.prepareStatement("UPDATE departments SET department_name = ? WHERE department_id = ?")) {
			statement.setString(1, department.getDepartmentName());
			statement.setInt(2, department.getDepartmentId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDepartment(Department department) {
		try (PreparedStatement statement = connection
				.prepareStatement("DELETE FROM departments WHERE department_id = ?")) {
			statement.setInt(1, department.getDepartmentId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

