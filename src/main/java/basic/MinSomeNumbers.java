package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinSomeNumbers {
    public static void main(String[] args) {
        Integer[] o = {-1, 2, 0, 4, 5};
        int count = 2;

        Arrays.asList(o).sort(Comparator.naturalOrder());
        Integer[] out = Arrays.copyOf(o, count);

        for(Object i : out) {
            System.out.println(i);
        }
    }
}
