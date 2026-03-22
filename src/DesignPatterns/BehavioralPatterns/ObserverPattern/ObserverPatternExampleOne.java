package DesignPatterns.BehavioralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * OBSERVER PATTERN
 * <p>
 * Intent:
 * Observer is a behavioral design pattern that lets you define a subscription mechanism
 * to notify multiple objects about any events that happen to the object they're observing.
 * <p>
 * Problem it solves:
 * You have an object (Subject/Publisher) whose state changes, and other objects (Observers/Subscribers)
 * need to be notified of these changes. If the Subject directly references the Observers, they become
 * tightly coupled, making it hard to add or remove Observers dynamically.
 * <p>
 * How it works:
 * - Subject (Publisher): Maintains a list of observers and provides methods to attach, detach, and notify them. (e.g., WeatherStation)
 * - Observer (Subscriber): Declares an update interface for objects that should be notified of changes in a subject. (e.g., Observer interface)
 * - Concrete Observers: Implement the Observer interface to keep their state consistent with the subject's state. (e.g., DisplayDevice, MobileDevice)
 * <p>
 * Benefits:
 * - Loose Coupling: The Subject doesn't need to know the concrete classes of its observers.
 * - Open/Closed Principle: You can introduce new subscriber classes without having to change the publisher's code (and vice versa if there's a publisher interface).
 * - Dynamic Relationships: You can establish relations between objects at runtime.
 */
interface Observer {
    void update(float temp);
}

interface Subject {
    void attach(Observer obs);

    void detach(Observer obs);

    void notifyObservers();
}

class WeatherStation implements Subject {
    private float temperature;
    private List<Observer> observerList;

    public WeatherStation() {
        this.observerList = new ArrayList<>();
    }

    public void setTemperature(float temp) {
        this.temperature = temp;
        notifyObservers();
    }

    @Override
    public void attach(Observer obs) {
        observerList.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        System.out.println("detaching " + obs);
        observerList.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observerList) {
            obs.update(temperature); // run time polymorphism
        }
    }
}

class DisplayDevice implements Observer {
    @Override
    public void update(float temp) {
        System.out.println(" temp in display device " + temp);
    }

}

class MobileDevice implements Observer {

    @Override
    public void update(float temp) {
        System.out.println(" temp in mobile device " + temp);
    }
}

public class ObserverPatternExampleOne {

    public static void main(String[] args) {
        // creating publisher
        WeatherStation weatherStation = new WeatherStation();

        // creating subscribers
        DisplayDevice displayDevice = new DisplayDevice();
        MobileDevice mobileDevice = new MobileDevice();

        weatherStation.attach(displayDevice);
        weatherStation.attach(mobileDevice);

//        setting temp
        weatherStation.setTemperature(23);

//        detaching device
        weatherStation.detach(displayDevice);
    }
}
