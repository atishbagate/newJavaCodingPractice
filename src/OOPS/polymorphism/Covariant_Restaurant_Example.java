package OOPS.polymorphism;

public class Covariant_Restaurant_Example {
    class Food{};
    class Pizza extends Food{};

    class Restaurant{
        Food serve(){
            System.out.println("Food serving general.");
            return new Food();
        }
    }

    class Pizzeria extends Restaurant{
        @Override
        Pizza serve(){
            System.out.println("Serving Pizza");
            return  new Pizza();
        }
    }

    public void main(String[] args) {
        Restaurant myRestaurant = new Pizzeria();

        // Even though the reference is 'Restaurant',
        // the actual object is 'Pizzeria'.
        Food food = myRestaurant.serve();


        // Why is this useful?
        // If we use the specific class directly, we don't need to cast!
        Pizzeria specificShop = new Pizzeria();
        Pizza myPizza = specificShop.serve(); // No type casting needed!
    }
}
