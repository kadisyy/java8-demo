package java8.datedemo;


import java.io.Closeable;
import java.time.LocalDate;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DateDemo
{
    public static void main(String[] args) {
        /**
         *  类可变
         */
        Date date = new Date();

        /**
         *  finally修饰  不会变. 时间不应该  类的不可变
         */
        LocalDate localDate = LocalDate.now();



    }
}
