package OOPS.abstraction.UsingAbstractClass;

public class SmartCar {

    public static void main(String[] args) {
        CarEngine carEngine = new TataCar("TATA", "Tiago");
        carEngine.performDrift();
        carEngine.displayStatus();

        CarEngine carEngine2 = new HyndaiCar("Hyundai", "i10");
        carEngine2.performDrift();
        carEngine2.displayStatus();

    }

    static abstract class CarEngine {
        String id;
        String name;
        boolean isOn;

        public CarEngine(String id, String name) {
            this.id = id;
            this.name = name;
            this.isOn = false;
        }

        void keyPress() {
            isOn = !isOn;
            System.out.println(name + " is now " + (isOn ? "ON" : "OFF"));
        }

        abstract void performDrift();

        void displayStatus() {
            System.out.println(name + " is now " + (isOn ? "ON" : "OFF"));
        }
    }

    static class TataCar extends CarEngine {
        TataCar(String id, String name) {
            super(id, name);
        }

        @Override
        void keyPress() {
            super.keyPress();
        }

        @Override
        void performDrift() {
            System.out.println(name + " is now " + (isOn ? "ON" : "OFF"));
        }
    }

    static class HyndaiCar extends CarEngine {
        HyndaiCar(String id, String name) {
            super(id, name);
        }

        @Override
        void keyPress() {
            super.keyPress();
        }

        @Override
        void performDrift() {
            System.out.println(name + " is now " + (isOn ? "ON" : "OFF"));
        }
    }
}
