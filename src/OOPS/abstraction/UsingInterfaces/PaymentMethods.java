package OOPS.abstraction.UsingInterfaces;

interface Payment {
    void ProcessPayment(double amount);
}

class BankAccount implements Payment {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void ProcessPayment(double amount) {
        balance += amount;
    }

    public double getAmount() {
        return balance;
    }
}

class UPIPayment implements Payment {
    private double amount;

    public UPIPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public void ProcessPayment(double amount) {
        this.amount += amount;
    }

    public double getAmount() {
        return amount;
    }
}

public class PaymentMethods {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        UPIPayment upiPayment = new UPIPayment(100);
        bankAccount.ProcessPayment(bankAccount.getAmount());
        System.out.println("Bank Account Balance: " + bankAccount.getAmount());
        upiPayment.ProcessPayment(upiPayment.getAmount());
        System.out.println("UPI Account Balance: " + upiPayment.getAmount());

    }
}
