package java8.optional;


import java.math.BigDecimal;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        User user = new User();

        user.setName("LiF");
        Integer id = Optional.ofNullable(user.getId()).orElseGet(() -> 10);
        System.out.println(id);

    }
}
