package Exception_Handling.one_hirarcy_of_exception_and_types.Exception_Theory;

import java.io.FileInputStream;

public class TryCatch {
    public static void main(String[] args) {
        try {
            int a = 100, b = 0, c;
            c = a / b;
            System.out.println(c);
        } catch (Exception e) {
            System.out.println("Exception occured");

//            e.printStackTrace();  // print exception class and desc and stack trace.
            System.out.println(e.toString()); // print only exception class name and description
            System.out.println(e.getMessage());  // print only  description
        }
    }
}
