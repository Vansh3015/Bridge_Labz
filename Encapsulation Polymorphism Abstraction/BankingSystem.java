package Encapsulation_Polymorphism_Abstraction;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    // Display details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Subclass SavingsAccount
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate; // annual interest rate

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println(getHolderName() + " applied for a loan of: " + amount + " [Approved]");
        } else {
            System.out.println(getHolderName() + " applied for a loan of: " + amount + " [Rejected]");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000; // Eligible if balance >= 5000
    }
}

// Subclass CurrentAccount
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; // Current accounts usually don't earn interest
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println(getHolderName() + " withdrew: " + amount + " (Overdraft considered)");
        } else {
            System.out.println("Exceeds overdraft limit or invalid amount!");
        }
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println(getHolderName() + " applied for a loan of: " + amount + " [Approved]");
        } else {
            System.out.println(getHolderName() + " applied for a loan of: " + amount + " [Rejected]");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 2000 || overdraftLimit >= 1000; 
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SAV123", "Alice", 10000, 5.0);
        BankAccount acc2 = new CurrentAccount("CUR456", "Bob", 3000, 2000);

        BankAccount[] accounts = {acc1, acc2};

        // Polymorphism in action
        for (BankAccount acc : accounts) {
            acc.displayAccountDetails();
            System.out.println("Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(5000);
            }

            System.out.println("-------------------------");
        }

        // Deposit & Withdraw
        acc1.deposit(2000);
        acc1.withdraw(1500);

        acc2.deposit(1000);
        acc2.withdraw(6000); // Uses overdraft

        System.out.println("After Transactions:");
        acc1.displayAccountDetails();
        acc2.displayAccountDetails();
    }
}
