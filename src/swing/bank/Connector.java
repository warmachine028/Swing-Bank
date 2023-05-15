package swing.bank;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Register the Driver
 * 2. Create Connection
 * 3. Create Statement
 * 4. Execute a query
 * 5. Close Connection
 */

public class Connector {
    Dotenv dotenv = Dotenv.configure().filename(".env.local").load();
    Connection connection;
    Statement statement;

    public Connector() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql:///SwingBank",
                    "root",
                    dotenv.get("MYSQL_PASSWORD")
            );
            statement = connection.createStatement();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void initialize() {
        /*
        CREATE DATABASE IF NOT EXISTS SwingBank;

        SHOW DATABASES;

        USE swingbank;

        CREATE TABLE IF NOT EXISTS SignUpForms (
            formNo INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(255) NOT NULL,
            fName VARCHAR(255) NOT NULL,
            dob DATE NOT NULL,
            gender ENUM('Male', 'Female') NOT NULL,
            email VARCHAR(255) NOT NULL,
            maritalStatus ENUM('Married', 'Single', 'Other') NOT NULL,
            address VARCHAR(255) NOT NULL,
            city VARCHAR(100) NOT NULL,
            state VARCHAR(100) NOT NULL,
            pinCode VARCHAR(20) NOT NULL
        );

        */
    }
}
