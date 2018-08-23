package java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Predicate;

public class StreamDemo {

    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("F:\\myGit\\java8-demo\\src\\main\\java\\java8\\stream\\stream.md")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.asList(1, 2, 3, 4, 5).stream().filter(x ->x %2 ==0).forEach( System.out::println);

        Predicate<Integer> predicate = x -> x>5;

        System.out.println(predicate.test(1));
    }
}
