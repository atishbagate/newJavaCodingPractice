package DesignPatterns.SOLID_Pattern.Three_Liskov_Substitution_Principle;


//base class
public class UserProfile {
    protected String UserName;


    public String getUserName() {
        System.out.println("user name " + this.UserName);
        return UserName;
    }

}
