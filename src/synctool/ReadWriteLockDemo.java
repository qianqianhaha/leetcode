package synctool;
/**
 * juc 读写锁
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        //5个线程同时写入
        for(int i=0;i<5;i++){
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },"write: "+i+"").start();

        }

        //5个线程同时读取
        for(int i=0;i<5;i++){
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },"read: "+i+"").start();

        }
    }
}



class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key,Object value){

        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" 正在写入");
            Thread.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" 写入完成");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }

    }

    public void get(String key){

        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" 正在读取");
            Thread.sleep(300);
            Object res = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 读取完成 "+res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }

    }

}