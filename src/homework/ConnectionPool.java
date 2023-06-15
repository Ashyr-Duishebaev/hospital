package homework;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionPool {

	private static BasicDataSource dataSource;

	static {
		dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://Laba:3306/hospital");
		dataSource.setUsername("root");
		dataSource.setPassword("T-MoSqLc2021");
		dataSource.setMinIdle(5);
		dataSource.setMaxIdle(10);
		dataSource.setMaxOpenPreparedStatements(100);
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static void releaseConnection(Connection connection) throws SQLException {
		connection.close();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}

