package java8.lambda;


import java.util.function.Consumer;
import java.util.function.Supplier;

public class Demo2 {
    public static void main(String[] args) {
        GreetingService service = message -> System.out.println("hello " +message);
        service.sayMessage("LiBai");


        Consumer<String> consumer = (arg) -> {
            System.out.println("hello " + arg);
        };

        consumer.accept("LiBai");

        Supplier<String>  supplier = () -> "fuck";
        System.out.println(supplier.get());
    }
}
