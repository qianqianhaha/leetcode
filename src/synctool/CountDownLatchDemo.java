package synctool;
/**
 * CountDownLatch 倒计时计数
 * 秦灭六国 一统天下
 */

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i=0;i<5;i++){
            final int temp = i;
            new Thread(()->{
               System.out.println("第"+(temp+1)+"位同学离开");
               countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
            System.out.println("班长锁门");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
