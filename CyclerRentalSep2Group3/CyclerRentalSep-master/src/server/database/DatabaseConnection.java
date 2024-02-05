package src.server.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    public Connection databaseLink;

    private String databaseName = "postgres";
    private String databaseUser = "postgres";
    private  String databasePassword = "krisdan29";
    private String currentSchema = "cyclerRental";
    private String url = "jdbc:postgresql://localhost:5432/"+databaseName+"?currentSchema="+ currentSchema;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return databaseLink;
    }

    public void addData(String sql){

    }

    public void updateData (String sql){

    }

    public void retrieveData(String sql){

    }

}
