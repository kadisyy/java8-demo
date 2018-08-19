package java8.lambda;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Dmeo1 {
    public static void main(final String[] args) {
       List<String> list = Arrays.asList("abc","a","1234","45678");

        Collections.sort(list,(x,y)->x.length() - y.length());  //类型自动推断

        System.out.println(list);

        // 函数式接口, 仅存在接口:  public abstract void run();
        Runnable runnable = () -> {
            System.out.println("hell0");
        };

        runnable.run();

        Consumer<String> consumer = (a) ->{
            //写一个具体的实现,其他地方都可以调用
            System.out.println(a);
        };
        consumer.accept("asdf");

        Supplier<String> supplier = () ->{
            return "hello world";
        };

        System.out.println(supplier.get());

        Function<Integer,String> function = (str) -> {
            return str + "a";
        };
        System.out.println(function.apply(1));
    }
}
