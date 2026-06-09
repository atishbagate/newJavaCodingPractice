package DesignPatterns.CreationalDesignPatterns.FactoryPattern;



public class One_transportSeervice {

    public interface Notification{
        void sendNotification();
    }

    public static class EmailNotification implements Notification{
        @Override
        public void sendNotification() {
            System.out.println("Email notification sent.");
        }
    }
    public static class SMSNotification implements Notification{
        @Override
        public void sendNotification() {
            System.out.println("SMS notification sent.");
        }
    }

    public static class NotificationFactory {
        public Notification createNotification(String type) {
            if (type == null || type.isEmpty()) {
                return null;
            }
            if (type.equalsIgnoreCase("EMAIL")) {
                return new EmailNotification();
            } else if (type.equalsIgnoreCase("SMS")) {
                return new SMSNotification();
            }
            return null;
        }
    }


        public static void main(String[] args) {
            NotificationFactory factory = new NotificationFactory();
            Notification emailNotification = factory.createNotification("EMAIL");
            Notification smsNotification = factory.createNotification("SMS");
        }

}
