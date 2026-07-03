package JAVA_8_Features.One_Functional_Interface;

@FunctionalInterface
interface fly {
    void fly(String name);
}

//    1. class implementation
class Bird implements fly {
    @Override
    public void fly(String name) {
        System.out.println(name + " is flying from Bird Class. ");
    }
}

public class Two_Ways_To_Use_Functional_Interface {

    // 3 ways to implement functional interface :-

//    1. By Implementing functional interface to class
//    2. By anonymous Inner class
//    3. By lambada function
//    4.  Method referencing :  it is advanced version of lambada function.


    public static void main(String[] args) {

//        1. by class implementation.
//       Bird b1 = new Bird();
//       b1.fly("sparrow");


//       2.  anonymous Inner class
//       fly b2 =  new fly(){
//            @Override
//            public void fly(String name) {
//                System.out.println(name+ " is flying from Bird in anonymous class. ");
//            }
//        };
//       b2.fly("crow");

//       3. lambada function
        fly fly = (name) -> System.out.println(name);
        fly.fly("anonymous bird ");

//        4. method referencing : it is advanced version of lambada function.
        fly flyReferencing = System.out::println;
        flyReferencing.fly("referecing bird ");


    }
}
