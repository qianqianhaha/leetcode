package synctool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //必须追定队列容量
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //第一组方法 抛异常的方法
        // add() 队列满了之后，插入元素会出现IllegalStateException 异常
        //与其同组的api add() remove() element()
        /*System.out.println(blockingQueue.add("a"));//输出true
        System.out.println(blockingQueue.add("b"));//输出true
        System.out.println(blockingQueue.add("c"));//输出true
        //System.out.println(blockingQueue.add("f"));//IllegalStateExceptio full异常
        System.out.println(blockingQueue.element());//输出队首元素*/

        //第二组方法 不抛异常的方法
        // offer() poll() peek()
        /*System.out.println(blockingQueue.offer("a"));//输出true
        System.out.println(blockingQueue.offer("b"));//输出true
        System.out.println(blockingQueue.offer("c"));//输出true
        System.out.println(blockingQueue.offer("f"));//输出false

        System.out.println(blockingQueue.peek()); //输出队首元素

        System.out.println(blockingQueue.poll());//输出a
        System.out.println(blockingQueue.poll());//输出b
        System.out.println(blockingQueue.poll());//输出c
        System.out.println(blockingQueue.poll());//输出null*/

        //第三组方法 阻塞的方法
        // put() take()
        /*blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();//由于此时队列为空，无法获取元素 获取线程会被一直阻塞*/

        //第四组方法 超时控制
        //offer(e,time,unit)  poll(time,unit)
        System.out.println(blockingQueue.offer("a",2000, TimeUnit.MILLISECONDS));//输出 true
        System.out.println(blockingQueue.offer("b",2000, TimeUnit.MILLISECONDS));//输出 true
        System.out.println(blockingQueue.offer("c",2000, TimeUnit.MILLISECONDS));//输出 true
        System.out.println(blockingQueue.offer("d",2000, TimeUnit.MILLISECONDS));//等待2s钟，输出false

    }

}
