package Exception_Handling.one_hirarcy_of_exception_and_types.Exception_Theory;

import DesignPatterns.CreationalDesignPatterns.FactoryPattern.One_transportSeervice;

public class Throw {
    public static void main(String[] args) {
     Throw fun =  new Throw();
     fun.divide();

    }
    void divide()
    {
        try{
            int a=100,b=0,c;
            c=a/b;
            System.out.println(c);
        }catch(ArithmeticException e){
            System.out.println("Arithmetic Exception"+e);
        }
    }
}
