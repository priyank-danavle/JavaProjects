package ATM;

import java.sql.*;


public class Withdraw {
    public static void withdraw(String username, long amount) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            String balanceQuery = "SELECT balance FROM Accounts WHERE username = ?";
            PreparedStatement balanceStmt = conn.prepareStatement(balanceQuery);
            balanceStmt.setString(1, username);
            ResultSet rs = balanceStmt.executeQuery();

            if (rs.next()) {
                long balance = rs.getLong("balance");
                if (balance < amount) {
                    throw new Exception("Insufficient funds.");
                }

                String updateQuery = "UPDATE Accounts SET balance = balance - ? WHERE username = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setLong(1, amount);
                updateStmt.setString(2, username);
                updateStmt.executeUpdate();

                String transactionQuery = "INSERT INTO Transactions (username, timestamp, description) VALUES (?, NOW(), ?)";
                PreparedStatement transactionStmt = conn.prepareStatement(transactionQuery);
                transactionStmt.setString(1, username);
                transactionStmt.setString(2, "Debited - " + amount);
                transactionStmt.executeUpdate();

                conn.commit();
            }
        }
    }
}
