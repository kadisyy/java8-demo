package java8.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * 仅仅是一种引用 不需要括号
 *
 * 静态方法引用
 实例方法引用
 对象方法引用
 构造方法引用
 */
public class Method {
    /**
     *  静态方法引用
     * @return
     */
    public static String getWorld(){
        return "hello world";
    }

    public static int count(String a, String b){
        return a.length() +b.length();
    }

    public  String getWorldInstance(){
        return "hello world";
    }

    public static void main(String[] args) {
        /**
         * 静态方法引用
         */
        Supplier<String> supplier = () -> Method.getWorld();
        Supplier<String> supplier1 =  Method :: getWorld;
        System.out.println(supplier1.get());

        // 2 inputs and 1 output
        BiFunction<String,String,Integer> size =  Method::count;
        System.out.println(size.apply("xxx","aaaaaaaaaa"));

        /**
         * 实例方法引用  也可以调用父类的
         */
        Supplier<String> supplier3 =  new Method() :: getWorldInstance;
        System.out.println(supplier3.get());

        /**
         * 对象方法引用
         */

    }
}
