package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("--------- Welcome to our ATM ---------");

            System.out.print("Enter your username: ");
            String username = sc.nextLine();

            System.out.print("Enter your password: ");
            String password = sc.nextLine();

            if (!Authentication.login(username, password)) {
                System.out.println("Invalid username or password.");
                return;
            }

            while (true) {
                System.out.println(
                        "Choose an option:\n1. Transaction History\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Quit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        TransactionHistory.getHistory(username);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        long withdrawAmount = sc.nextLong();
                        Withdraw.withdraw(username, withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        long depositAmount = sc.nextLong();
                        Deposit.deposit(username, depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient username: ");
                        String recipient = sc.next();
                        System.out.print("Enter amount to transfer: ");
                        long transferAmount = sc.nextLong();
                        Transfer.transfer(username, recipient, transferAmount);
                        break;
                    case 5:
                        System.out.println("Thank you for using our ATM.");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}