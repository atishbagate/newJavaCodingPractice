package DesignPatterns.BehavioralPatterns.StrategyPattern;

/**
 * STRATEGY PATTERN
 * <p>
 * Intent:
 * Strategy is a behavioral design pattern that lets you define a family of algorithms,
 * put each of them into a separate class, and make their objects interchangeable.
 * <p>
 * Problem it solves:
 * You have a class that does something specific in a lot of different ways.
 * Instead of having multiple conditional statements (if-else or switch) to choose
 * the correct behavior, you extract all of these algorithms into separate classes
 * called strategies.
 * <p>
 * How it works:
 * - Strategy Interface: Defines a common interface for all supported algorithms. (e.g., PaymentStrategy)
 * - Concrete Strategies: Implements the algorithm using the Strategy interface. (e.g., CreditCardPayment, UpiPayment, DebitCardPayment)
 * - Context: Maintains a reference to a Strategy object and delegates the work to it. (e.g., PaymentService)
 * <p>
 * Benefits:
 * - You can swap algorithms used inside an object at runtime.
 * - You can isolate the implementation details of an algorithm from the code that uses it.
 * - Open/Closed Principle: You can introduce new strategies without having to change the context.
 */
interface PaymentStrategy {
    void makePayment();
}

class PaymentService {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment() {
        paymentStrategy.makePayment(); // polymophic pattern.
    }
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void makePayment() {
        System.out.println("Payment made via Credit Card.");
    }
}

class UpiPayment implements PaymentStrategy {
    @Override
    public void makePayment() {
        System.out.println("Payment made via UPI.");
    }
}

class DebitCardPayment implements PaymentStrategy {
    @Override
    public void makePayment() {
        System.out.println("Payment made via Debit Card.");
    }

}

public class StrategyPatternExampleOne {
    public static void main(String[] args) {
        System.out.println("Strategy pattern");
        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentStrategy(new CreditCardPayment());
        paymentService.makePayment();

        paymentService.setPaymentStrategy(new UpiPayment());
        paymentService.makePayment();

        paymentService.setPaymentStrategy(new DebitCardPayment());
        paymentService.makePayment();

    }
}
