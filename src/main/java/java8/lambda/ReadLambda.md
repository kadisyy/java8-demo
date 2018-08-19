# lambda表达式

## 特点
函数式编程
参数类型自动推断
代码量少,简洁
方便并行
## 函数式接口
定义: 只有一个方法的接口就是函数式接口
不包括接口默认方法和静态方法  Object重名方法 都不是

Supplier:代表一个输出
Consumer:代表一个输入
BiConsumer: 2输入
Function: 一个输入 一个输出

上面则是几个重要的接口:
在Java8中已经定义了好多的函数式接口,比如:
java.lang.Runnable
java.util.Comparator
java.util.function.Predicate
java.util.function.Consumer