package DesignPatterns.SOLID_Pattern.One_SingleResponsibilityPrinciple;

public class NotificationRepository {
    public void sendMail(Invoice invoice) {
        System.out.println("sending mail for invoice: " + invoice.getId());
    }
}
