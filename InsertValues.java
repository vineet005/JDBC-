import java.sql.*;

public class InsertValues {
    private static final String URL = "jdbc:postgresql://localhost:5432/InsuranceDomain";
    private static final String USER = "postgres";
    private static final String PASSWORD = "V!#eet@#$321789";

    public static void main(String[] args) {
        String query1 = "INSERT INTO agents(agent_id, first_name, last_name) VALUES(?, ?, ?)";
        String query2 = "SELECT * FROM agents";

        try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt1 = con.prepareStatement(query1);
            ){
            con.setAutoCommit(false);
            pstmt1.setInt(1, 10);
            pstmt1.setString(2, "Vineet");
            pstmt1.setString(3, "Thakran");
            pstmt1.executeUpdate();

            con.commit();
            PreparedStatement pstmt2 = con.prepareStatement(query2);
            ResultSet rs = pstmt2.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("agent_id");
                String first_Name = rs.getString("first_name");
                String last_Name = rs.getString("last_name");

                System.out.println(id + " " + first_Name + " " + last_Name);
            }

//

        }catch (SQLException e){
            e.getErrorCode();
        }
//        try {
//            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
//            PreparedStatement pstmt2 = con.prepareStatement(query2);
//            ResultSet rs = pstmt2.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("agent_id");
//                String first_Name = rs.getString("first_name");
//                String last_Name = rs.getString("last_name");
//
//                System.out.println(id + " " + first_Name + " " + last_Name);
//            }
//        }catch (SQLException e){
//            System.out.println(e.getErrorCode());
//        }
    }
}
