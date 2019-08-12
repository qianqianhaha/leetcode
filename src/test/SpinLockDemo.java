package test;


import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    private void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+" come in");

        while(!atomicReference.compareAndSet(null,thread)){

        }

    }

    private void unlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+" come out");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.lock();
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            spinLockDemo.unlock();

        },"AA").start();

        //sleep保证AA线程先获得锁
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        new Thread(()->{
            spinLockDemo.lock();
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            spinLockDemo.unlock();

        },"BB").start();

    }
}
