package swing.bank;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

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
                    "jdbc:mysql:///SwingBank", "root",
                    dotenv.get("MYSQL_PASSWORD"));
            statement = connection.createStatement();
            execute("CREATE DATABASE IF NOT EXISTS SwingBank;");
            execute("USE SwingBank;");
            createTable();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    static long generateFormNumber() {
        String query = "SELECT IFNULL(MAX(formNo)+1, 1) AS NextFormNumber FROM Users;";
        Connector connector = new Connector();
        Statement statement = connector.statement;
        try (ResultSet result = statement.executeQuery(query)) {
            result.next();
            return result.getLong("NextFormNumber");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return -1;
    }

    void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS Users (" +
                "            formNo INT AUTO_INCREMENT PRIMARY KEY," +
                "            name VARCHAR(255) NOT NULL," +
                "            fName VARCHAR(255) NOT NULL," +
                "            dob DATE NOT NULL," +
                "            gender ENUM('Male', 'Female') NOT NULL," +
                "            email VARCHAR(255) NOT NULL," +
                "            maritalStatus ENUM('Married', 'Single', 'Other') NOT NULL," +
                "            address VARCHAR(255) NOT NULL," +
                "            city VARCHAR(100) NOT NULL," +
                "            state VARCHAR(100) NOT NULL," +
                "            pinCode VARCHAR(20) NOT NULL" +
                "        );";
        execute(query);
    }

    public boolean execute(String query) {
        try {
            return statement.execute(query);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }
}


/*
        CREATE DATABASE IF NOT EXISTS SwingBank;

        SHOW DATABASES;

        USE SwingBank;

        CREATE TABLE IF NOT EXISTS Users (
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
