package Exception_Handling.one_hirarcy_of_exception_and_types.Exception_Theory;

import java.io.*;

class AccessFile{
    void readFile() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("d:/abc.txt");
    }
}

public class Throws_Example {
    public static void main(String[] args) {
        System.out.println("Throws keyword example");

        AccessFile file = new AccessFile();

        try {
            file.readFile();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }

        System.out.println("end code.");
    }
}
