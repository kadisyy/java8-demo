//package thread.threadpool;
//
//import thread.waitNotify.WaitNotifyAll;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadFactory;
//
//public class Demo1 {
//
//    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(1, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread( () -> {
//                    System.out.println("define");
//                });
//            }
//        });
//
//        service.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        }, )
//    }
//}
