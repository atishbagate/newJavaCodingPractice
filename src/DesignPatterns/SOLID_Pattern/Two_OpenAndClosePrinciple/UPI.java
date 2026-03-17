package DesignPatterns.SOLID_Pattern.Two_OpenAndClosePrinciple;

public class UPI implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("UPI amount " + amount);
    }
}
