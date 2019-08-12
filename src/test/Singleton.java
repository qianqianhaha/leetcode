package test;

public class Singleton {
    //单例模式实现
    //需注意 单例模式的单例实例对象是静态的
    //1 懒汉式 只适用于单线程  存在线程安全问题 使得不能持有同一份实例
    /*
    private static Singleton instance;

    private Singleton(){
    }

    public static Singleton getInstance(){
        if(instance!=null){
            instance = new Singleton();
        }
        return instance;
    }*/


    //2 线程安全的懒汉式
    /*private volatile static Singleton instance; //禁止指令重排，需声明为volatile

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance!=null){
            synchronized (Singleton.class){
                if(instance!=null){
                    instance = new Singleton();
                }
            }
        }

        return instance;

    }*/

    //3 饿汉式
    //其问题是 非懒加载，第一次类加载就会初始化，无法依赖参数和配置文件生成实例
    /*private static Singleton instance = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }*/


    //4 静态内部类  推荐方法
    private Singleton(){

    }
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }


}
