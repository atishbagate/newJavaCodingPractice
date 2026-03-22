package DesignPatterns.BehavioralPatterns.StrategyPattern;

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
