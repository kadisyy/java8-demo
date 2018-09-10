# 复习
## Long Integer 等

== 和 equals 都是比较数值
ps: Integer有一个缓存池的概念(-128-127), 在其中比较== 数值,超过则非比较数值
比如：

```
        Integer i =1000;
        Integer j = 1000;

        System.out.println(i == j);  //False

        Integer i1 =100;
        Integer j1 = 100;

        System.out.println(i1 == j1);  //True
```


## Synchronize锁优化手段有哪些


- 锁为啥费时间

锁竞争是kernal mode下的，会经过user mode(用户态)到kernal mode(内核态) 的切换，是比较花时间的。


- 适应自旋锁

https://www.zhihu.com/question/38857029/answer/78480263

- 锁消除

```
  public void vectorTest(){
        Vector<String> vector = new Vector<String>();
        for(int i = 0 ; i < 10 ; i++){
            vector.add(i + "");
        }

        System.out.println(vector);
    }
```
Vector是默认加锁的，但JVM如果发现vector变量仅仅在vectorTest()方法中使用，
那该vector是线程安全的。JVM会把vector内部加的锁去除，这个优化就叫做：锁消除。

- 锁粗化


- 轻量级锁

轻量级锁能提升程序同步性能的依据是“对于绝大部分的锁，在整个同步周期内都是不存在竞争的”，这是一个经验数据。

如果没有竞争，轻量级锁使用CAS操作避免了使用互斥量的开销
但如果存在锁竞争，除了互斥量的开销外，还额外发生了CAS操作，因此在有竞争的情况下，轻量级锁会比传统的重量级锁更慢。
简单来说：如果发现同步周期内都是不存在竞争，JVM会使用CAS操作来替代操作系统互斥量。这个优化就被叫做轻量级锁


- 偏向锁

偏向锁就是在无竞争的情况下把整个同步都消除掉，连CAS操作都不做了！

## NIO回顾

