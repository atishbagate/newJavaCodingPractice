package DesignPatterns.SOLID_Pattern.Two_OpenAndClosePrinciple;

public class CreditCard implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("credit card amount " + amount);
    }
}
