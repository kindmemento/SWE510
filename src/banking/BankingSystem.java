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
    }
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!"); // If amount is greater than existing balance, user/owner wants to withdraw more money than they possess. So we display an error message.
        } else {
            balance -= amount; // If they have sufficient funds, we decrement the amount to be withdrawn from existing balance.
        }
    }
    public double getBalance() {
        return balance;
        // We keep balance variable itself protected, and display balance through a public getBalance method,
        // because we don't want to grant access to the variable from outside the scope of the class, as that would expose it for modification/mutation from outside the class scope.
    }
    public static int getTotalAccounts() {
        return totalAccounts;
        // Similar to above, totalAccounts variable itself is kept protected within the scope of the class in order to not expose it for modification and mutation from outside the class.
        // Instead, the integer value of total number of accounts is accessible through this public getTotalAccounts method.
    }
}