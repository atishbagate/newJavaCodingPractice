package DesignPatterns.BehavioralPatterns.CommandPattern;

interface DevicesCommand {
    void execute();

    void undo();
}

class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class Fan {
    public void turnOn() {
        System.out.println("Fan is ON");
    }

    public void turnOff() {
        System.out.println("Fan is OFF");
    }
}

//Concrete command for fan turning on/off
class LightCommand implements DevicesCommand {
    private Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();

    }
}

//concrete command for Light on and off
class FanCommand implements DevicesCommand {
    private Fan fan;

    public FanCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOn();
    }

    @Override
    public void undo() {
        fan.turnOff();
    }
}

// 4. The Invoker (The Remote Control)
class RemoteController {
    private DevicesCommand slot;

    public void setCommand(DevicesCommand devicesCommand) {
        this.slot = devicesCommand;
    }

    public void pressButton() {
        slot.execute();
    }

    public void pressDownButton() {
        slot.undo();
    }
}

public class CommandPatternExampleTwo {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();

        //command
        LightCommand lightCommand = new LightCommand(light);
        FanCommand fanCommand = new FanCommand(fan);

        // The Invoker
        RemoteController remote = new RemoteController();

        remote.setCommand(lightCommand);
        remote.pressButton();
        remote.pressDownButton();

        remote.setCommand(fanCommand);
        remote.pressButton();
        remote.pressDownButton();
    }
}
