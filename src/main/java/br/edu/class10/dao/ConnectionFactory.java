package br.edu.class10.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable {
    private static Connection connection;
    private static PreparedStatement stmt;

    private ConnectionFactory() {
    }

    public static Connection createConnection() throws SQLException {
        if(connection == null)
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        return connection;
    }

    public static PreparedStatement createPreparedStatement(String sql) throws SQLException {
        stmt = createConnection().prepareStatement(sql);
        return stmt;
    }

    public void closeConnection() throws SQLException {
        if(connection != null)
            connection.close();
    }

    @Override
    public void close() throws SQLException {
        if (stmt != null)
            stmt.close();
        }
}
