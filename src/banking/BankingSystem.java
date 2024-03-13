package banking;

import java.util.Scanner; // Import Scanner class to receive input from user through Standard Input

// Main class for entire Banking System
public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[5];
        double initialDeposit = 0; // Set to 0 for now as default value - will be reassigned inside switch case statements.
        String name = ""; // Set to empty string for now as default value - will be reassigned inside switch case statements.

        // Menu loop
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View Balance");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt(); // User inputs their choice, we read it from Standard Input with Scanner class, and execute one of below operations based on the input.

            switch (choice) {
                case 1:
                    System.out.print("Enter owner's name: ");
                    scanner.nextLine(); // Consume newLine;
                    name = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    initialDeposit = scanner.nextDouble();
                    System.out.print("Enter interest rate: ");
                    double interestRate = scanner.nextDouble();
                    accounts[Account.getTotalAccounts()] = new SavingsAccount(name, initialDeposit, interestRate);
                    break;
                case 2:
                    System.out.print("Enter owner's name: ");
                    scanner.nextLine(); // Consume newLine
                    name = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    initialDeposit = scanner.nextDouble();
                    System.out.print("Enter overdraft limit: ");
                    double overdraftLimit = scanner.nextDouble();
                    accounts[Account.getTotalAccounts()] = new CheckingAccount(name, initialDeposit, overdraftLimit);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int accNumber = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    accounts[accNumber - 1].deposit(depositAmount); // We use accNumber - 1 because we increment totalAccounts value by 1 when assigning an accountNumber to a newly created Account in each instance. This is because array indexes start from 0.
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accNumber = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    accounts[accNumber - 1].withdraw(withdrawAmount); // Same reason as in case 3 - we decrement accNumber by 1 to retrieve the correct account from accounts array for the above reason.
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    accNumber = scanner.nextInt();
                    System.out.println("Balance: " + accounts[accNumber - 1].getBalance());
                    break;
                case 6:
                    exit = true; // When exit it set to true, it will break out of the while loop, meaning exiting the program.
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close(); // Close scanner before exiting.
    }
}

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

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String ownerName, double initialDeposit, double interestRate) {
        super(ownerName, initialDeposit); // We call super method because this is a subclass that extends a super class.
        this.interestRate = interestRate; // this.interestRate is the private interestRate variable declared inside the scope of this subclass. interestRate parameter is passed as input, and its value is assigned to this.interestRate;
    }

    public void calculateInterest() {
        double interest = balance * interestRate / 100; // This is where interest is calculated;
        deposit(interest); // deposit method is derived from super class Account;
    }

    static class InterestCalculator {
        public static void calculateCompoundInterest(SavingsAccount account) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of years: ");
            int years = scanner.nextInt();
            scanner.close();
            double compoundInterest = calculateInterestRecursive(account.balance, account.interestRate, years);
            System.out.println("Compound interest after " + years + " years: " + compoundInterest);
        }

        private static double calculateInterestRecursive(double principal, double rate, int years) {
            if (years == 0) return principal;
            return calculateInterestRecursive(principal * (1 + rate / 100), rate, years - 1);
            // Parameters change for the recursive call to update the state of the calculation for the subsequent recursive step.
            // (i + rate / 100) calculates the new principal after adding the interest earned in one year.
            // Interest rate remains constant, as it represents the annual interest rate in percentage terms.
            // Years parameter is decremented by 1 in each recursive call to represent the passing of time.
        }
    }
}

class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String ownerName, double initialDeposit, double overdraftLimit) {
        super(ownerName, initialDeposit); // We call super method because this is a subclass that extends a super class.
        this.overdraftLimit = overdraftLimit; // Similar to SavingsAccount subclass, this.overdraftLimit variable is declared inside the scope of this subclass, and overdraftLimit parameter is passed as input, and its value is assigned to the variable overdraftLimit, which itself is a member of this class.
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance + overdraftLimit) {
            System.out.println("Exceeds overdraft limit!"); // Amount to withdraw cannot be more than existing balance + overdraftLimit. If that is the case, we display an error message.
        } else {
            balance -= amount;
        }
    }
}
