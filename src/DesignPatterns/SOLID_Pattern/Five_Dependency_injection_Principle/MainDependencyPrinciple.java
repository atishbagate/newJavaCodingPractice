package DesignPatterns.SOLID_Pattern.Five_Dependency_injection_Principle;

//This is the most powerful principle for building scalable systems, especially as you move into Microservices and Spring Boot.
//        In short: Depend on abstractions (interfaces), not on concretions (classes).

//1. The Core Concept
//DIP consists of two main rules:
//High-level modules should not depend on low-level modules. Both should depend on abstractions.
//Abstractions should not depend on details. Details (implementations) should depend on abstractions.


public class MainDependencyPrinciple {
    public static void main(String[] args) {

        NotificationService notification = new NotificationService(new EmailService());
        notification.sendNotification("hello from Email. ");

        NotificationService notification2 = new NotificationService(new SMS_Service());
        notification2.sendNotification("hello from SMS. ");
    }
}
