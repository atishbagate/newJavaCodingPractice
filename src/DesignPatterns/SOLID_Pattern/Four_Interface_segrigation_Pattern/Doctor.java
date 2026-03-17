package DesignPatterns.SOLID_Pattern.Four_Interface_segrigation_Pattern;

public class Doctor implements login, TakeRecord {
    @Override
    public void takeRecord() {
        System.out.println("taking record");
    }

    @Override
    public void login() {
        System.out.println("login done");
    }
}
