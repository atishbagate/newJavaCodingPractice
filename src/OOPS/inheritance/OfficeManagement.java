package OOPS.inheritance;

public class OfficeManagement {
    static class Emp{
        protected String name;
        protected double baseSalary;

        Emp(String name, double baseSalary){
            this.name = name;
            this.baseSalary = baseSalary;
    }
    void displaySalary(){
        System.out.println("Emp : "+name+" | Base Salary : "+baseSalary);
        }
    }
    // 2. The Child Class (Subclass) - Reusing Parent code
    static class Manager extends Emp {
        private double bonus;

        Manager(String name, double baseSalary, double bonus) {
            super(name, baseSalary);
            this.bonus = bonus;
        }

        // Inheritance + Polymorphism (Overriding)
        @Override
        void displaySalary(){
            super.displaySalary();
            System.out.println("role : manager | total compansation : "+(baseSalary+bonus));
        }
    }
    static class Clerk extends Emp{
        private String language;
        Clerk(String name, double baseSalary, String language){
            super(name,baseSalary);
            this.language = language;
        }
        @Override
        void displaySalary(){
            super.displaySalary();
        }
        void lang(){
            System.out.println(name+" language name "+language);
        }
    }

    public static void main(String[] args) {

        Manager m = new Manager("manager 1",100,200);

        Clerk c = new Clerk("bob",50,"hindi");

        m.displaySalary();
        c.displaySalary();
        c.lang();
    }
}
