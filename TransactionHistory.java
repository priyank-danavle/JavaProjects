package ATM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionHistory {
    public static void getHistory(String username) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT timestamp, description FROM Transactions WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Transaction History:");
            while (rs.next()) {
                System.out.println(rs.getString("timestamp") + " - " + rs.getString("description"));
            }
        }
    }
}
