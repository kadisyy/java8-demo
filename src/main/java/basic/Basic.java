package basic;


import java.util.LinkedHashMap;

public class Basic {
    public static void main(String[] args) {
        Integer i =1000;
        Integer j = 1000;

        System.out.println(i == j);  //False

        Integer i1 =100;
        Integer j1 = 100;

        System.out.println(i1 == j1);  //True

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);

        linkedHashMap.put("1",1);
        linkedHashMap.put("12",1);
        linkedHashMap.put("2",1);
        linkedHashMap.put("21",1);
        linkedHashMap.put("3",1);
        linkedHashMap.put("123",1);


        for(Object key: linkedHashMap.keySet()){
            System.out.println("key = " + key + "; value = " + linkedHashMap.get(key));
        }

    }
}
