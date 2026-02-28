package Collections.HashMapExamples;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasicHashmapExample {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Atish");
        map.put(2, "sumit");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> i : entries) {
            System.out.println("key " + i.getKey() + " - " + i.getValue());
        }

        System.out.println(map.get(1));
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("Atish"));

        map.remove(1);
        System.out.println(map);
        map.clear();
        System.out.println(map);
    }
}

