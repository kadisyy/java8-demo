package basic;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ck on 2018/11/23.
 */
public class WordReverse {
    public static void main(String[] args) {
        String in = "I am a student.";
        String[] ss = in.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = ss.length -1; i>=0; i--) {
            sb.append(ss[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
