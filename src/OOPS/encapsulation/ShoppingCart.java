package OOPS.encapsulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Immutable item representation
class CartItem {
    private final String name;
    private final double price;
    private final int quantity;

    public CartItem(String name, double price, int quantity) {
        if (price < 0 || quantity < 0) {
            throw new IllegalArgumentException("Price and quantity cannot be negative");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTotalPrice() {
        return String.format("%.2f", price * quantity);
    }
}

class Cart {
    // 1. Private internal state: external classes cannot clear or replace this list
    private final List<CartItem> cart;
    private double discountRate;

    public Cart() {
        this.cart = new ArrayList<>();
        this.discountRate = 0.0;
    }

    //control mutations
    public void addItem(CartItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        cart.add(item);
    }

    public boolean removeItem(String itemName) {
        return cart.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public void applyCoupon(String CouponCode) {
        // validation logic is encapsulated inside the class
        if ("SAVE10".equalsIgnoreCase(CouponCode)) {
            this.discountRate = 0.10;
        } else {
            System.out.println("invalid code");
        }
    }

    // 3. Encapsulating complex calculations
    public double CalculateTotalPrice() {
        double sum = 0.0;
        for (CartItem item : cart) {
            sum += item.getPrice();
        }
        return sum * (1.0 - discountRate);
    }

    // 4. Defensive copying: Return an unmodifiable view so callers can't bypass addItem()
    public List<CartItem> getItems() {
        return Collections.unmodifiableList(this.cart);
    }

}

public class ShoppingCart {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem(new CartItem("AAPL", 1, 1));
        cart.addItem(new CartItem("SMS", 1, 2));
        cart.applyCoupon("SAVE10");
        System.out.println("Total price: " + cart.CalculateTotalPrice());

    }
}
