import java.sql.*;

public class QueryExecution {
    private static final String URL = "jdbc:postgresql://localhost:5432/InsuranceDomain";
    private static final String USER = "postgres";
    private static final String PASSWORD = "V!#eet@#$321789";

    public static void main(String[] args) {
        String query = "SELECT * FROM agents";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                int id = rs.getInt("agent_id");
                String first_Name = rs.getString("first_name");
                String last_Name = rs.getString("last_name");

                System.out.println(id +" " + first_Name + " " + last_Name);
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }
}
