package design_pattern;
/*
饿汉式：在程序启动或单例模式类被加载的时候，单例模式实例就已经被创建
优点：没有加锁，执行效率会提高
缺点：类加载时就初始化，浪费内存（空间换时间）
 */
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();
    private Singleton3(){}

    public static Singleton3 getInstance(){
        return instance;
    }
}
