package thread.waitNotify;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WaitNotifyAll {
    final static Object o = new Object();

    public static void main(String[] args) {
        new Thread(new Write()).start();
        new Thread(new Read()).start();

    }

    public static class  Write implements Runnable{

        @Override
        public void run() {
            synchronized (o){
                System.out.println("before write thread");
                try {
                    o.wait();
                    System.out.println("after write thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Read implements Runnable{

        @Override
        public void run() {
            synchronized (o){
                System.out.println("read thread");
                o.notify();
            }
        }
    }
}