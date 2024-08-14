import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
    private static final String URL = "jdbc:postgresql://localhost:5432/InsuranceDomain";
    private static final String USER = "postgres";
    private static final String PASSWORD = "V!#eet@#$321789";

    public static void main(String[] args) {
        String withdrawQuery = "UPDATE claims SET claim_amount = claim_amount - ? WHERE claim_id = ?";
        String depositQuery = "UPDATE claims SET claim_amount = claim_amount + ? WHERE claim_id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement withdraw = con.prepareStatement(withdrawQuery);
             PreparedStatement deposit = con.prepareStatement(depositQuery)){
            con.setAutoCommit(false);

            withdraw.setDouble(1, 15);
            withdraw.setInt(2, 2);

            deposit.setDouble(1, 500);
            deposit.setInt(2, 2);

            int rowsEffectedWithdraw =  withdraw.executeUpdate();
            int rowsEffectedDeposit =  deposit.executeUpdate();

            if (rowsEffectedWithdraw == 1 && rowsEffectedDeposit == 1){
                con.commit();
                System.out.println("Transaction Successful!");
            }else {
                con.rollback();
                System.out.println("Transaction Un-Successful!");
            }

        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }
    }
}
