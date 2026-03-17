package DesignPatterns.SOLID_Pattern.Four_Interface_segrigation_Pattern;

public class Patient implements login, PayBilling {
    @Override
    public void login() {
        System.out.println("Patient logged in successfully.");
    }

    @Override
    public void payBilling() {
        System.out.println("Patient billing processed.");
    }

}
