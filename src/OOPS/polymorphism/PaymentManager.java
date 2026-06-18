package OOPS.polymorphism;


public class PaymentManager {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService();
        double cartValue = 1000.00;
        DiscountLogic NormalDiscount = new NormalDiscount();
        DiscountLogic PremiumDiscount = new PremiumDiscount();

        System.out.println("Premium Total: $" + checkoutService.executeCheckout(PremiumDiscount, cartValue));
        // Output: Premium Total: $900.0 (10% off)

        System.out.println("VIP Total: $" + checkoutService.executeCheckout(NormalDiscount, cartValue));

    }

    public interface DiscountLogic {
        double applyDiscount(double amount);
    }

    static class NormalDiscount implements DiscountLogic {
        @Override
        public double applyDiscount(double amount) {
            return amount * 0.05;
        }
    }

    static class PremiumDiscount implements DiscountLogic {
        @Override
        public double applyDiscount(double amount) {
            return amount * 0.20;
        }
    }

    public static class CheckoutService {
        public double executeCheckout(DiscountLogic discountLogic, double amount) {
            double discount = discountLogic.applyDiscount(amount);
            return amount - discount;
        }
    }
}
