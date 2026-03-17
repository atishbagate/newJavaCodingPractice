package DesignPatterns.SOLID_Pattern.Five_Dependency_injection_Principle;

public class EmailService implements NotificationChannal {
    @Override
    public void Send(String msg) {
        System.out.println("sending Email." + msg);
    }
}
