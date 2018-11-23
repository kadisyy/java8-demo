package java8.interfaces;

import basic.Student;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by ck on 2018/10/29.
 */
public class Dort implements IDort {

    private static Dort dort = null;
    private Dort(){};

    synchronized static Dort getInstance(){
        if(dort == null){
            return dort = new Dort();
        }
        return dort;
    }

    String getDefautt(){
       return  this.testDefault("Li");
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getDefautt());

        Consumer consumer = ( (arg) ->{
            System.out.println(arg);
        });
        consumer.accept(123);

        Supplier supplier = ()-> "12345";
        System.out.println(supplier.get());

        Student student = new Student();
        student.setAge(11);
        student.setName("name");

        System.out.println(student.toString());

    }
}
