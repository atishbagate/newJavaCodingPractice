package DesignPatterns.BehavioralPatterns.StatePattern;

/**
 * STATE PATTERN - Simple Example
 * <p>
 * Here is a very simple example of a Mobile Phone's Alert System.
 * The behavior of the alert() method changes completely depending on
 * whether the phone is in Ringing, Vibration, or Silent state.
 */

// 1. State Interface
interface MobileAlertState {
    void alert(AlertStateContext ctx);
}

// 2. Concrete States
class Ringing implements MobileAlertState {
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("Phone is Ringing... Ring! Ring!");
    }
}

class Vibration implements MobileAlertState {
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("Phone is Vibrating... Bzzzt! Bzzzt!");
    }
}

class Silent implements MobileAlertState {
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("Phone is Silent... (Screen lights up only)");
    }
}

// 3. Context
class AlertStateContext {
    private MobileAlertState currentState;

    public AlertStateContext() {
        // Default state
        currentState = new Ringing();
    }

    public void setState(MobileAlertState state) {
        this.currentState = state;
    }

    public void alert() {
        currentState.alert(this);
    }
}

public class StatePatternExampleTwo {
    public static void main(String[] args) {
        System.out.println("--- Mobile Phone Alert System ---");

        AlertStateContext phone = new AlertStateContext();

        // Initial State (Ringing)
        phone.alert();

        // Change state to Vibration
        phone.setState(new Vibration());
        phone.alert();

        // Change state to Silent
        phone.setState(new Silent());
        phone.alert();
    }
}
