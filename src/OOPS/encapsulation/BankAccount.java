package OOPS.encapsulation;

public class BankAccount {
    private long accountNumber;
    private double balance;

    public BankAccount(long accountNumber, double initBalance) {
        this.accountNumber = accountNumber;
        if (initBalance >= 0) {
            this.balance = initBalance;
        } else {
            this.balance = 0;
            System.out.println("META-INF");
        }
    }

    public double getBalance() {
        return balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void deposite(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("deposited amount " + amount);
        } else {
            System.out.println("invalid deposite amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("withdraw amount " + amount);
        } else {
            System.out.println("Transaction fail.");
        }
    }
        public static void main(String[] args) {
            BankAccount myAcc = new BankAccount(1, 10.3);
            System.out.println("account " + myAcc.getAccountNumber());
            myAcc.withdraw(4.0);
            System.out.println("Curr balance " + myAcc.getBalance());
        }
}
