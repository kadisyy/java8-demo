package java8.lambda;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dmeo1 {
    public static void main(final String[] args) {
       List<String> list = Arrays.asList("abc","a","1234","45678");

        Collections.sort(list,(x,y)->x.length() - y.length());  //类型自动推断

        System.out.println(list);

    }
}
