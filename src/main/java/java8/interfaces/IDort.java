package java8.interfaces;

/**
 * Created by ck on 2018/10/29.
 */
public interface IDort {
    default String testDefault(String name){
     return "hello " + name;
    }
}
