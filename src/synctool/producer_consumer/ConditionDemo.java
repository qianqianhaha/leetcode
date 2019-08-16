package synctool.producer_consumer;
/**
 * 实现a b c三个线程 a->b->c->a 按照此顺序交替打印 使用lock
 *
 *
 * lock                 vs                  synchronized
 * 1. synchronized属于jvm层面，属于java关键字，底层使用monitorenter 以及 monitorexit；lock属于api层面，是jdk1.5以后出现的一个类
 *
 * 2. synchronized无需手动释放锁，lock需要unlock()手动释放锁，否则会发生死锁
 *
 * 3. synchronized不可中断，lock可以中断
 *
 * 4. synchronized是非公平锁，lock通过传入布尔参数决定是否是公平锁
 *
 * 5. synchronized只能通过notify/notifyAll 随机唤醒或者全部唤醒所有线程
 *      lock 能够绑定多个condition，实现部分唤醒或者精确唤醒。
 *
 *
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    public static void main(String[] args) {
        MyPrint myPrint = new MyPrint();

        new Thread(()->{
            for(int i=0;i<10;i++){
                myPrint.print1();
            }

        },"aaa").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                myPrint.print2();
            }

        },"bbb").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                myPrint.print3();
            }

        },"ccc").start();
    }
}

class MyPrint{

    ReentrantLock lock = new ReentrantLock();
    volatile boolean b1 = true;
    volatile boolean b2 = false;
    volatile boolean b3 = false;
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print1(){
        try{
            lock.lock();

            while(!b1)
                condition1.await();
            b1 = false;
            for(int i=0;i<1;i++){
                System.out.println("print 1 "+(i+1));
            }
            //设置标志位的操作需要在唤醒操作之前
            b2 = true;
            //指定唤醒condition2
            condition2.signal();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void print2(){
        try{
            lock.lock();

            while(!b2)
                condition2.await();
            b2 = false;
            for(int i=0;i<2;i++){
                System.out.println("==print 2 "+(i+1));
            }
            b3 = true;
            condition3.signal();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void print3(){
        try{
            lock.lock();

            while(!b3)
                condition3.await();
            b3 = false;
            for(int i=0;i<3;i++){
                System.out.println("++print 3 "+(i+1));
            }
            b1 = true;
            condition1.signal();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


}
