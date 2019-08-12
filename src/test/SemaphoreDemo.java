package test;

import java.util.concurrent.Semaphore;

/**
 * 信号量  抢车位 多个对象争抢多个资源
 * 可复用
 * 多个共享变量的互斥使用
 * 并发线程数的控制
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //有四个车位
        Semaphore semaphore = new Semaphore(3);

        //有10辆车
        for(int i=0;i<8;i++){
            final int temp = i+1;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+" 占到车位");
                    Thread.sleep(temp*1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+" 离开车位");
                    semaphore.release();
                }

            }).start();
        }
    }
}
