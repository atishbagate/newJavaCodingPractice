package DesignPatterns.BehavioralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(float temp);
}
interface Subject{
    void attach(Observer obs);
    void detach(Observer obs);
    void notifyObservers();
}

class  WeatherStation implements Subject{
    private float temperature;
    private List<Observer> observerList;

    public WeatherStation(){
        this.observerList = new ArrayList<>();
    }
    public void setTemperature(float temp){
        this.temperature = temp;
        notifyObservers();
    }

    @Override
    public void attach(Observer obs) {
        observerList.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        System.out.println("detaching "+obs);
    observerList.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observerList){
            obs.update(temperature); // run time polymorphism
        }
    }
}

class DisplayDevice implements Observer{
    @Override
    public void update(float temp) {
        System.out.println(" temp in display device "+temp);
    }

}

class MobileDevice implements Observer{

    @Override
    public void update(float temp) {
        System.out.println(" temp in mobile device "+temp);
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
