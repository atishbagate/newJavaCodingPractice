package DesignPatterns.SOLID_Pattern.One_SingleResponsibilityPrinciple;

//1. Single Responsibility Principle (SRP)
//"A class should have one, and only one, reason to change."
//
//The Theory: A class should do one thing only. If a class handles database logic,
// business logic, and email notifications all at once, it is "fat." If you change the email provider, you risk breaking the database logic.
//
//Interview Tip: Talk about "High Cohesion."
//
//Java Example: Instead of one UserService that saves users AND sends emails,
// create a UserRepository for the database and an EmailService for notifications.
//
public class mainInvoice {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(1, "invoice one");
        System.out.println(invoice.toString());

        NotificationRepository notificationService = new NotificationRepository();
        notificationService.sendMail(invoice);

        SaveToDataBase saveToDataBase = new SaveToDataBase();
        saveToDataBase.saveToDB(invoice);
    }
}
