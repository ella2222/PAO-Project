package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCdatabase{
    private final Connection databaseConnection;

    public JDBCdatabase(){
        try {

            String url = "jdbc:mysql://127.0.0.1:3306/medicaldbschema";
            String user = "root";
            String password = "1234";
            databaseConnection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return databaseConnection;
    }

    public void stergebaza(){
        try {
            String query = "DELETE FROM programari";
            String query2 = "DELETE FROM pacienti";
            String query3 = "DELETE FROM medic";
            String query4 = "DELETE FROM cabinet";

            databaseConnection.createStatement().executeUpdate(query);
            databaseConnection.createStatement().executeUpdate(query2);
            databaseConnection.createStatement().executeUpdate(query3);
            databaseConnection.createStatement().executeUpdate(query4);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inchidecon(){
        try {
            databaseConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}