package ATM;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Deposit {
    public static void deposit(String username, long amount) throws Exception {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            String updateQuery = "UPDATE Accounts SET balance = balance + ? WHERE username = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setLong(1, amount);
            updateStmt.setString(2, username);
            updateStmt.executeUpdate();

            String transactionQuery = "INSERT INTO Transactions (username, timestamp, description) VALUES (?, NOW(), ?)";
            PreparedStatement transactionStmt = conn.prepareStatement(transactionQuery);
            transactionStmt.setString(1, username);
            transactionStmt.setString(2, "Credited - " + amount);
            transactionStmt.executeUpdate();

            conn.commit();
        }
    }
}
