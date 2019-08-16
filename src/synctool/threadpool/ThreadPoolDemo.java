package synctool.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());



//        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
//        new Thread(futureTask).start();
//
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}

//class MyThread implements Callable<Integer>{
//
//
//    @Override
//    public Integer call() throws Exception {
//        return 0;
//    }
//}