package synctool;

import javax.swing.*;
import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue ：只存放单个元素的阻塞队列
 * 一个put操作
 * 一个take操作
 * 相互衔接
 */
public class SynchronousQueueDemo {

    private static SynchronousQueue<String> queue = new SynchronousQueue<>();
    public static void main(String[] args) {
        SynchronousQueueDemo syncDemo = new SynchronousQueueDemo();
        new Thread(new MyThread1(queue),"aaa").start();
        new Thread(new MyThread2(queue),"bbb").start();

    }
}

//生产者线程
class MyThread1 implements Runnable{

    private SynchronousQueue<String> queue;
    public MyThread1(SynchronousQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        try {

            System.out.println(Thread.currentThread().getName()+"\t put a");
            queue.put("a");
            //生产者线程生产出第一个对象之后，由于对象在SynchronousQueue中，没有消费者取走，
            //此时生产者线程处于阻塞状态，以下代码不能执行

            //当消费者取走了第一个对象之后，阻塞结束，继续往下执行
            System.out.println(Thread.currentThread().getName()+"\t put b");
            queue.put("b");

            System.out.println(Thread.currentThread().getName()+"\t put c");
            queue.put("c");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//消费者线程
class MyThread2 implements Runnable{
    private SynchronousQueue<String> queue;
    public MyThread2(SynchronousQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            //消费者每隔3s中取走一个对象
            try{Thread.sleep(3000); }catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t get "+queue.take());

            try{Thread.sleep(3000); }catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t get "+queue.take());

            try{Thread.sleep(3000); }catch (InterruptedException e) {e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t get "+queue.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


