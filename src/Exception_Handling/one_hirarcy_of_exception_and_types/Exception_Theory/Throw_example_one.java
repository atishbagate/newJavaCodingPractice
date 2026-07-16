package Exception_Handling.one_hirarcy_of_exception_and_types.Exception_Theory;

class YoungerAgeException extends RuntimeException {
    YoungerAgeException(String msg){
        super(msg);
    }
}

public class Throw_example_one {
    public static void main(String[] args) {
        int age = 12;
        try {
            if (age < 18) {
                throw new YoungerAgeException("Your age is older than 18");
            }else {
                System.out.println("Your age is older than 18");
            }
        } catch (YoungerAgeException e) {
            e.printStackTrace();
        }
        System.out.println("program handled exception properly.");
    }
}
