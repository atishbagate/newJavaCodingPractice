package DesignPatterns.SOLID_Pattern.Three_Liskov_Substitution_Principle;

public class WritableUser extends UserProfile implements WritableInterface {

    @Override
    public void UpdateUserName(String userName) {
        this.UserName = userName;
    }

    @Override
    public void save() {
        System.out.println("saving user name to database");
    }
}
