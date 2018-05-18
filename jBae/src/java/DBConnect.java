import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author japji and the databaes
 */
public class DBConnect {

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "postgres"); //not actual password

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public DBConnect() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;
        }
    }
}
