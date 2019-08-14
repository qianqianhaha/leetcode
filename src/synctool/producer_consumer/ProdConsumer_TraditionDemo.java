package synctool.producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：有四个线程，有一个资源类，这些线程交替的对资源类的某个变量执行 +1 -1（生产 消费）的行为
 * 该变量的值将交替的在0，1之间变化
 *
 * 1. 线程 操作 资源类
 * 2. 判断 干活 通知
 * 3. 防止虚假唤醒:
 */
public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        int n=3;
        new Thread(()->{
            for(int i=0;i<n;i++){
                shareData.decrement();
            }
        },"BBB").start();

        new Thread(()->{
            for(int i=0;i<n;i++){
                shareData.increment();
            }
        },"AAA").start();

        new Thread(()->{
            for(int i=0;i<n;i++){
                shareData.increment();
            }
        },"CCC").start();

        new Thread(()->{
            for(int i=0;i<n;i++){
                shareData.decrement();
            }
        },"DDD").start();

    }
}

class ShareData{
    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //生产操作 +1
    public void increment(){
        try{
            //获取操作资源类的互斥锁
            lock.lock();

            while(number!=0){
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName()+"\t生产线程："+number);
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    //消费操作 -1
    public void decrement(){
        try{
            //获取操作资源类的互斥锁
            lock.lock();

            while(number==0){
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName()+"\t消费线程："+number);
            condition.signalAll();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}