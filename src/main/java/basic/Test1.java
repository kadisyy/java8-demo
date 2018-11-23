package basic;


import java.util.*;

/**
 * Created by ck on 2018/11/22.
 */
public class Test1 {
    public static void main(String[] args) {
        List list1 = Arrays.asList(1, 2, 3);
        list1.set(1, 10);

        list1.forEach(o -> System.out.println(o));

        //default length is 16
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = sb.append("1111111111111111111");
        System.out.println(sb == sb1);

        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = sb2.append("11112228888888888822222");
        System.out.println(sb2 == sb3);

        String c = new String("abcd");
        String d = c.intern();
        String a = "abcd";
        String b = "abcd";


        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);

        String e = a.toString();
        System.out.println(a == e);

        System.out.println(reduce());
    }

    // 相邻去重
    public static int reduce() {
        List steps = new ArrayList<>();
        int[] a = {1, 1, 1, 2, 2, 3, 3, 2, 2, 5, 5, 3, 3};
        int last = -1;
        for(int i = 0; i < a.length; i++) {
            if(last != a[i]){
                last = a[i];
                steps.add(a[i]);
            }
        }
        return steps.size();
    }
}
