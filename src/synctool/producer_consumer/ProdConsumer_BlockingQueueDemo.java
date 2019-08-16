package synctool.producer_consumer;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用BlockingQueue实现生产者-消费者
 * 此外 还使用了 volatile atomicInteger
 * 不需要加锁，不需要进行wait() notify() 控制线程
 */
public class ProdConsumer_BlockingQueueDemo {

    public static void main(String[] args) {
        MyResource resource = new MyResource(new ArrayBlockingQueue<>(4));
        new Thread(()->{
            System.out.println("生产者线程启动");
            System.out.println();
            try {
                resource.MyProduce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Producer").start();

        new Thread(()->{
            System.out.println("消费者线程启动");
            System.out.println();
            try {
                resource.MyConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resource.stop();

    }
}

class MyResource{
    private volatile boolean flag = true;
    private AtomicInteger atomic = new AtomicInteger();

    private BlockingQueue<String> queue = null;

    public MyResource(BlockingQueue<String> queue){
        this.queue = queue;
        System.out.println(queue.getClass().getName());
    }

    public void MyProduce() throws Exception {
        String data = "";
        boolean b;
        while(flag){
            //标志位为true 说明生产线程需要生产
            data = atomic.getAndIncrement()+"";

            b = queue.offer(data,2000, TimeUnit.MILLISECONDS);
            if(b){
                System.out.println("生产者线程生产 "+data+" 成功");
            }else{
                System.out.println("生产者线程生产 "+data+" 失败");
            }

            TimeUnit.SECONDS.sleep(2);

        }
        System.out.println("主线程要求生产结束，生产者不再生产");

    }

    public void MyConsumer() throws Exception{

        String data ;
        while(flag){
            data = queue.poll(3000,TimeUnit.MILLISECONDS);
            if(data==null || data.equals("")){
                flag = false;
                System.out.println("主线程要求停止生产，消费线程不再消费");
                return;

            }
            System.out.println("*****消费者取到 "+data);

        }

    }

    public void stop(){
        flag = false;
    }


}
