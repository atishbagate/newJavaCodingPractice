package DesignPatterns.SOLID_Pattern.Five_Dependency_injection_Principle;

public class NotificationService {
    private NotificationChannal notificationChannal;

    public NotificationService(NotificationChannal channal) {
        this.notificationChannal = channal;
    }

    public void sendNotification(String msg) {
        notificationChannal.Send(msg);
    }
}
