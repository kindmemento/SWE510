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

    public void deposit(double amount) {
        balance += amount; // Amount parameter is the total amount that is to be added to the existing balance, therefore we increment balance value by amount value.
    };
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!"); // If amount is greater than existing balance, user/owner wants to withdraw more money than they possess. So we display an error message.
        } else {
            balance -= amount; // If they have sufficient funds, we decrement the amount to be withdrawn from existing balance.
        }
    };
    public double getBalance() { return 0.0; }; // placeholder value
    public static int getTotalAccounts() { return 1; }; // placeholder value
}