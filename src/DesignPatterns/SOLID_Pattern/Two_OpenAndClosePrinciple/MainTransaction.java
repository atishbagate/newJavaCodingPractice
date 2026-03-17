package DesignPatterns.SOLID_Pattern.Two_OpenAndClosePrinciple;

//2. Open/Closed Principle (OCP)
//"Software entities should be open for extension, but closed for modification."
//
//The Theory: You should be able to add new features without changing the existing code. You achieve this using Interfaces or Abstract classes.
//
//The Logic: If you have a PaymentProcessor and you need to add "Google Pay,"
//you shouldn't have to go inside the existing process() method and add an if/else block. You should create a new class that implements a Payment interface.
//
//Interview Tip: This principle is the foundation for the Strategy Design Pattern.

public class MainTransaction {

    public static void main(String[] args) {

//    first9 transaction
        UPI upiPayment = new UPI();
        CreditCard creditCardPayment = new CreditCard();

        makeTransaction makeTransactionOne = new makeTransaction();

        makeTransactionOne.makeTransaction(upiPayment, 100);
        makeTransactionOne.makeTransaction(creditCardPayment, 200);

    }

    public static class makeTransaction {
        public void makeTransaction(PaymentMethod paymentMethod, double amount) {
            paymentMethod.pay(amount);
        }
    }

}
