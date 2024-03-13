import java.util.Scanner; // Import Scanner class to receive input from user through Standard Input

// Main class for entire Banking System
public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[5];
    }
}

// Empty Account class layout
class Account {
    protected int accountNumber;
    protected String ownerName;
    protected double balance;
    protected static int totalAccounts = 0;

    public Account(String ownerName, double initialDeposit) {
        this.ownerName = ownerName;
        this.balance = initialDeposit;
        this.accountNumber = totalAccounts++; // totalAccounts value is incremented by 1 in order to assign a unique account number to each newly created account.
    }

}