package Java.design_pattern;
/*
本例是线程安全的懒汉式，能够在多线程中很好的工作，但是，效率很低（加锁影响效率）
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
