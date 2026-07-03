package OOPS.One_inheritance;

public class Vehicle {
    String brand;
    int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Car(4, 2018, "audi");
        vehicle.vehicleInfo();
        vehicle.startEngine();
        vehicle.stopEngine();
    }

    public void startEngine() {
        System.out.println("Starting engine ...");
    }

    public void stopEngine() {
        System.out.println("Stopping engine ...");
    }

    public void vehicleInfo() {
        System.out.println("Vehicle info ..." + brand + " " + year);
    }
}

class Car extends Vehicle {
    int countOfWheels;

    public Car(int countOfWheels, int year, String brand) {
        super(brand, year);
        this.countOfWheels = countOfWheels;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting car engine ...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping car engine ...");
    }
}

class Bike extends Vehicle {
    int countOfwheel;

    public Bike(int countOfwheel, int year, String brand) {
        super(brand, year);
        this.countOfwheel = countOfwheel;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting bike engine ...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping bike engine ...");
    }
}



