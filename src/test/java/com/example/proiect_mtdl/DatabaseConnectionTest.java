package com.example.proiect_mtdl;

import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class DatabaseConnectionTest {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/filsscheduler";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "nutebaga";

    private DatabaseConnection databaseConnection;

    @Before
    public void setUp() {
        databaseConnection = DatabaseConnection.getInstance();
    }

    @Test
    public void testDatabaseConnection() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            assertNotNull("Connection object should not be null", connection);
        } catch (SQLException e) {
            fail("Failed to connect to the database: " + e.getMessage());
        }
    }
}
