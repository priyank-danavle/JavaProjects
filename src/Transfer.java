package src;

public class Transfer {
    public static void transfer(String fromUser, String toUser, long amount) throws Exception {
        Withdraw.withdraw(fromUser, amount);
        Deposit.deposit(toUser, amount);
    }
}
