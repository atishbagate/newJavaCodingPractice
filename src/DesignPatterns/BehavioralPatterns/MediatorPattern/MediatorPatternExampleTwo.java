package DesignPatterns.BehavioralPatterns.MediatorPattern;

/**
 * MEDIATOR PATTERN - Simple Example
 * <p>
 * Here is a very simple example of an Air Traffic Control (ATC) system.
 * Airplanes do not communicate directly with each other to decide who lands next.
 * Instead, they all communicate with the ATC Tower (the Mediator), which coordinates
 * the landing process and ensures planes don't crash into each other.
 */

// 1. Mediator Interface
interface ATCMediator {
    void registerFlight(Flight flight);

    boolean isLandingOk();

    void setLandingStatus(boolean status);
}

// 3. Component (Colleague)
interface Command {
    void land();
}

// 2. Concrete Mediator
class ATCTower implements ATCMediator {
    private Flight currentFlight;
    private boolean isClearToLand;

    public ATCTower() {
        this.isClearToLand = true; // Initially, the runway is clear
    }

    @Override
    public void registerFlight(Flight flight) {
        this.currentFlight = flight;
    }

    @Override
    public boolean isLandingOk() {
        return isClearToLand;
    }

    @Override
    public void setLandingStatus(boolean status) {
        this.isClearToLand = status;
    }
}

// 4. Concrete Component
class Flight implements Command {
    private ATCMediator atcMediator;
    private String flightNumber;

    public Flight(ATCMediator atcMediator, String flightNumber) {
        this.atcMediator = atcMediator;
        this.flightNumber = flightNumber;
    }

    @Override
    public void land() {
        if (atcMediator.isLandingOk()) {
            System.out.println("Flight " + flightNumber + ": Cleared to land. Landing now.");
            atcMediator.setLandingStatus(false); // Occupy the runway
        } else {
            System.out.println("Flight " + flightNumber + ": Runway is occupied. Waiting for clearance.");
        }
    }

    public void finishedLanding() {
        System.out.println("Flight " + flightNumber + ": Landed successfully. Runway is now clear.");
        atcMediator.setLandingStatus(true); // Clear the runway
    }
}

public class MediatorPatternExampleTwo {
    public static void main(String[] args) {
        System.out.println("--- Air Traffic Control (ATC) System ---");

        // The Mediator
        ATCMediator atcTower = new ATCTower();

        // The Components (Flights)
        Flight flight1 = new Flight(atcTower, "Boeing 747");
        Flight flight2 = new Flight(atcTower, "Airbus A320");

        // Register flights (optional depending on implementation, here we just pass mediator via constructor)
        atcTower.registerFlight(flight1);

        // Flight 1 asks to land
        flight1.land();

        // Flight 2 tries to land at the same time
        flight2.land();

        // Flight 1 finishes landing, freeing up the runway
        flight1.finishedLanding();

        // Flight 2 tries again
        flight2.land();
    }
}
