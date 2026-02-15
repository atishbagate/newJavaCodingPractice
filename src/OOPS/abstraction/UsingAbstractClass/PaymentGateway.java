package OOPS.abstraction.UsingAbstractClass;

public class PaymentGateway {
   static  abstract class Payment{
         String TranscationId;

         Payment(String TransactionId) {
             this.TranscationId = TransactionId;
         }
         abstract void ProcessPayment(double amount);
         void showRecipt(double amount) {
             System.out.println("Transaction ID: " + TranscationId);
             System.out.println("Amount Paid: " + amount);
             System.out.println("Status : Success....");
         }
     }

    static class CreditCardPayment extends Payment {
         private String cardNumber;

         CreditCardPayment(String id, String cardNumber) {
             super(id);
             if (cardNumber.length() < 5) {
                 this.cardNumber = cardNumber;
             } else {
                 throw new RuntimeException("Invalid card number");
             }
         }

         @Override
         void ProcessPayment(double amount) {
             System.out.println("validating card no : " + cardNumber);
             System.out.println("charging card : $ " + amount);
         }
     }

     public static void main(String[] args) {
       Payment myPayment;
       myPayment = new CreditCardPayment("tx-1","1234");
       myPayment.ProcessPayment(100);
       myPayment.showRecipt(100);
     }
}


