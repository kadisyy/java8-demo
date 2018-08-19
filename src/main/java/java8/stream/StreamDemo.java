package java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class StreamDemo {

    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("E:\\myGit\\java8-demo\\src\\main\\java\\java8\\stream\\stream.md")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.asList(1, 2, 3, 4, 5).stream().filter(x ->x %2 ==0).forEach( System.out::println);
    }
}
