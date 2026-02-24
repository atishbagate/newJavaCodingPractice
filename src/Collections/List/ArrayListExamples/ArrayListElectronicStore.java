package Collections.List.ArrayListExamples;

import java.util.ArrayList;

public class ArrayListElectronicStore {

    public static void main(String[] args) {

        ArrayList<String> shopList = new ArrayList<>();
        shopList.add("Smartphone");
        shopList.add("tablet");
        shopList.add("laptop");

//        insert at specific index
        shopList.add(3, "camera");

//        remove index
        shopList.remove(2);
        shopList.remove("tablet");

//        checking exist
        shopList.contains("laptop");

//        finding the position
        int position = shopList.indexOf("Smartphone");

        System.out.println("final list " + shopList);
        shopList.clear();

    }

}
