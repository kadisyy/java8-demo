package java8.lambda;


public class Demo2 {
    public static void main(String[] args) {
        GreetingService service = message -> System.out.println("hello " +message);
        service.sayMessage("LiBai");
    }
}
