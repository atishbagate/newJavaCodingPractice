package OOPS.One_inheritance;

public class NotificationManager {

    public static void main(String[] args) {

        NotificationManager.SMSnotification sms = new SMSnotification("Sumit", "sms detailsss...");
        sms.getNotification("message sent");
    }

    public static class Notification {
        private String reciever;

        Notification(String reciever) {
            this.reciever = reciever;
        }

        protected void getNotification(String message) {
            System.out.println("details " + this.reciever + " and message is " + message);
        }
    }

    public static class SMSnotification extends Notification {
        private String SMS;

        SMSnotification(String reciever, String SMS) {
            super(reciever);
            this.SMS = SMS;
        }

        @Override
        protected void getNotification(String message) {
            super.getNotification(message);
            System.out.println("inside SMS notification " + this.SMS);
        }
    }
}
