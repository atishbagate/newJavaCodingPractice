package DesignPatterns.BehavioralPatterns.StatePattern;

/**
 * STATE PATTERN
 * <p>
 * Intent:
 * State is a behavioral design pattern that lets an object alter its behavior when its
 * internal state changes. It appears as if the object changed its class.
 * <p>
 * Problem it solves:
 * You have an object that behaves differently depending on its current state, the number
 * of states is large, and the state-specific code changes often. This often results in
 * long, complex conditional statements (if/else or switch) that are hard to maintain.
 * <p>
 * How it works:
 * - Context: Stores a reference to an instance of a Concrete State and delegates all
 * state-specific work to it. The context provides a setter for passing it a new state object. (e.g., VendingMachine)
 * - State Interface: Defines a common interface for all concrete states. It declares methods
 * that the context will call. (e.g., VendingMachineState)
 * - Concrete States: Implement the State interface and provide their own implementations for
 * the state-specific methods. They can also transition the context to a new state.
 * (e.g., NoCoinState, HasCoinState, SoldState)
 * <p>
 * Benefits:
 * - Single Responsibility Principle: Organizes the code related to particular states into separate classes.
 * - Open/Closed Principle: You can introduce new states without changing existing state classes or the context.
 * - Simplifies Code: Eliminates large conditional blocks, making the context's code cleaner and easier to understand.
 */

// State Interface
interface VendingMachineState {
    void insertCoin();

    void pressButton();

    void dispense();
}

// Context Class
class VendingMachine {
    // All possible states
    private final VendingMachineState noCoinState;
    private final VendingMachineState hasCoinState;
    private final VendingMachineState soldState;
    private final VendingMachineState emptyState;
    private VendingMachineState currentState;
    private int stock = 5; // Number of items in the machine

    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        emptyState = new EmptyState(this);

        if (stock > 0) {
            currentState = noCoinState;
        } else {
            currentState = emptyState;
        }
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void pressButton() {
        currentState.pressButton();
    }

    public void dispense() {
        currentState.dispense();
    }

    // Getters and Setters for state and stock
    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public int getStock() {
        return stock;
    }

    public void releaseItem() {
        if (stock > 0) {
            stock--;
            System.out.println("An item is released.");
        }
    }

    public VendingMachineState getNoCoinState() {
        return noCoinState;
    }

    public VendingMachineState getHasCoinState() {
        return hasCoinState;
    }

    public VendingMachineState getSoldState() {
        return soldState;
    }

    public VendingMachineState getEmptyState() {
        return emptyState;
    }
}

// Concrete State 1: NoCoinState
class NoCoinState implements VendingMachineState {
    private final VendingMachine machine;

    public NoCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted.");
        machine.setCurrentState(machine.getHasCoinState());
    }

    @Override
    public void pressButton() {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public void dispense() {
        System.out.println("Cannot dispense. Please insert a coin and press the button.");
    }
}

// Concrete State 2: HasCoinState
class HasCoinState implements VendingMachineState {
    private final VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }

    @Override
    public void pressButton() {
        System.out.println("Button pressed, preparing to dispense...");
        machine.setCurrentState(machine.getSoldState());
        machine.dispense();
    }

    @Override
    public void dispense() {
        System.out.println("Cannot dispense yet. Press the button first.");
    }
}

// Concrete State 3: SoldState
class SoldState implements VendingMachineState {
    private final VendingMachine machine;

    public SoldState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, item is being dispensed.");
    }

    @Override
    public void pressButton() {
        System.out.println("Please wait, item is being dispensed.");
    }

    @Override
    public void dispense() {
        machine.releaseItem();
        if (machine.getStock() > 0) {
            machine.setCurrentState(machine.getNoCoinState());
        } else {
            System.out.println("Sorry, the machine is now empty.");
            machine.setCurrentState(machine.getEmptyState());
        }
    }
}

// Concrete State 4: EmptyState
class EmptyState implements VendingMachineState {
    public EmptyState(VendingMachine machine) {
    }

    @Override
    public void insertCoin() {
        System.out.println("Cannot insert coin, the machine is empty.");
    }

    @Override
    public void pressButton() {
        System.out.println("Cannot press button, the machine is empty.");
    }

    @Override
    public void dispense() {
        System.out.println("Cannot dispense, the machine is empty.");
    }
}


public class StatePatternExampleOne {
    public static void main(String[] args) {
        System.out.println("--- State Pattern Vending Machine ---");
        VendingMachine vendingMachine = new VendingMachine();

        System.out.println("Current State: " + vendingMachine.getCurrentState().getClass().getSimpleName());
        System.out.println("Stock: " + vendingMachine.getStock());

        System.out.println("\n1. Trying to press button without inserting coin:");
        vendingMachine.pressButton();

        System.out.println("\n2. Inserting a coin:");
        vendingMachine.insertCoin();
        System.out.println("Current State: " + vendingMachine.getCurrentState().getClass().getSimpleName());

        System.out.println("\n3. Trying to insert another coin:");
        vendingMachine.insertCoin();

        System.out.println("\n4. Pressing the button to get an item:");
        vendingMachine.pressButton();
        System.out.println("Current State: " + vendingMachine.getCurrentState().getClass().getSimpleName());
        System.out.println("Stock: " + vendingMachine.getStock());

        System.out.println("\n5. Buying another item:");
        vendingMachine.insertCoin();
        vendingMachine.pressButton();
        System.out.println("Stock: " + vendingMachine.getStock());
    }
}
