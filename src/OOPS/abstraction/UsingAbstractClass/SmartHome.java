package OOPS.abstraction.UsingAbstractClass;

public class SmartHome {
    static abstract class SmartHomeDevices{
        String id;
        String name;
        boolean isOn;

        SmartHomeDevices(String id, String name){
            this.id = id;
            this.name = name;
            this.isOn = false;
        }
        void togglePower(){
            isOn = !isOn;
            System.out.println(name +" is now "+ (isOn ?  "ON":"OFF"));
        }
        abstract void performAction();
        void displayStatus(){
            System.out.println("[ "+id+"] "+name+" | "+ (isOn ? "Online" : "Offline"));
        }
    }
    static class SmartLight extends SmartHomeDevices{
        int brightnesslevel;
        SmartLight(String id, String name,int brightnesslevel){
            super(id,name);
            this.brightnesslevel = brightnesslevel;
        }
        @Override
        void performAction() {
            if(isOn){
                System.out.println("Changing light bulb intensity "+brightnesslevel +" nits");
            }else{
                System.out.println("Cannot change brightness. "+name+" is Off.");
            }
        }
    }
    static class Fan extends SmartHomeDevices{
        int speedLevel;
        Fan(String id,String name,int speedLevel){
            super(id,name);
            this.speedLevel = speedLevel;
        }
        @Override
        void performAction() {
            if(isOn){
                System.out.println("Fan Speed is "+speedLevel);
            }else{
                System.out.println("Cannot change fan speed.");
            }
        }
    }

    public static void main(String[] args){
        SmartHomeDevices[] myDevices = {
                new SmartHome.Fan("fan-1","Fan",5),
                new SmartLight("light-1","light",3000)
        };
        System.out.println("entering the house.");

        for(SmartHomeDevices device : myDevices){
            device.displayStatus();
            device.togglePower();
            device.performAction();
            System.out.println("--------------");
        }
    }
}
