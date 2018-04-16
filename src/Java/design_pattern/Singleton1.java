package Java.design_pattern;

/**
 * 懒汉式：当程序第一次访问单例模式实例时才进行创建（时间换空间）
 * 本例是线程不安全的懒汉式，多线程下不能正常工作
 * http://www.runoob.com/design-pattern/singleton-pattern.html
 */
public class Singleton1 {
    private static Singleton1 instance;
    private Singleton1(){}

    /**
     * 在其他类的main函数中通过Singleton1 object = Singleton1.getInstance();获取唯一可用的对象。
     * 不能通过Singleton1 object = new Singleton1();因为构造函数Singleton1()是不可见的（private)。
     * 因为在main函数中获取了唯一可用的对象object，所以如果Singleton1类还有其它的方法，可以直接通过
     * object.xxx()调用。
     */
    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}
