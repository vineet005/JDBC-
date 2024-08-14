import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/InsuranceDomain";
    private static final String USER = "postgres";
    private static final String PASSWORD = "V!#eet@#$321789";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
            System.out.println("Connection Established with Database.");
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
    }
 }
