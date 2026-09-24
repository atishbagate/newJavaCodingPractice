package OOPS.abstraction.UsingAbstractClass.BankAccount;

class BankAccount {
    // private data
    private String name;
    private double balance;

    // constructor
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    //getter
    public String getAccountHolderName() {
        return name;
    }

    // getter
    public double getBalance() {
        return balance;
    }

    // getter and calculation
    public String Deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return "Deposited : " + amount;
        }
        return "Invalid amount";
    }

    // setter
    public String Withdraw(double amount) {
        if (amount <= 0) {
            return "Invalid amount";
        }
        balance -= amount;
        return "Withdrawn : " + amount;
    }
}

public class BankAccountEncapsulation {
    public static void main(String[] args) {
        BankAccount atish = new BankAccount("Atish", 1000);
        String deposit = atish.Deposit(500);
        System.out.println("deposit : " + deposit);
        String withdraw = atish.Withdraw(200);
        System.out.println("withdraw : " + withdraw);
        System.out.println("balance : " + atish.getBalance());


    }
}
