import java.util.ArrayList;
import java.util.List;

class Account {
    String accNo;
    double balance;

    Account(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }
}

class Customer {
    String name;
    List<Account> accounts = new ArrayList<>();

    Customer(String name) { this.name = name; }

    void addAccount(String accNo, double balance) {
        accounts.add(new Account(accNo, balance));
    }

    void viewBalances() {
        System.out.println("Customer: " + name);
        for (Account a : accounts)
            System.out.println("Account: " + a.accNo + ", Balance: $" + a.balance);
    }
}

class Bank {
    String name;
    List<Customer> customers = new ArrayList<>();

    Bank(String name) { this.name = name; }

    void openAccount(Customer c, String accNo, double bal) {
        c.addAccount(accNo, bal);
        if (!customers.contains(c)) customers.add(c);
    }

    void showAllCustomers() {
        System.out.println("Bank: " + name);
        for (Customer c : customers) {
            c.viewBalances();
            System.out.println();
        }
    }
}

public class Bank_and_AccountHolders {
    public static void main(String[] args) {
        Bank bank = new Bank("State Bank");
        Customer c1 = new Customer("Lynda Princy");
        Customer c2 = new Customer("Prince Danish");

        bank.openAccount(c1, "ACC12345", 1000);
        bank.openAccount(c1, "ACC54321", 500);
        bank.openAccount(c2, "ACC67890", 1500);

        bank.showAllCustomers();
    }
}
