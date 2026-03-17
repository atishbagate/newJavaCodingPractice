package DesignPatterns.SOLID_Pattern.Five_Dependency_injection_Principle;

public class SMS_Service implements NotificationChannal {
    @Override
    public void Send(String msg) {
        System.out.println("sending SMS. " + msg);
    }
}
