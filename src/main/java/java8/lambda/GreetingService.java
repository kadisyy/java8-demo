package java8.lambda;

/**
 * 函数式接口   只能有一个方法接口. 比图Runnable 和Callalbe Comparator
 */
@FunctionalInterface
public interface GreetingService  {

    void sayMessage(String spp); //是函数式接口

    default int get(){return 1;}; //不是

    static void insert1(){}  //不是

    public int  hashCode(); // Object方法不是


}
