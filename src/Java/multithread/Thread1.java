package Java.multithread;

/**
 * 本例是实现多线程的方式一：继承Thread类
 * 1、继承Thread类
 * 2、重写Thread类的run方法，并且将线程要执行的代码存放到run方法中
 * 3、创建继承Thread类的子类的对象，也就是创建线程
 * 4、线程对象调用start方法，开启线程，线程会自动执行run方法
 * run()方法与start()方法：run()方法里面存放着Thread线程对象需要执行的代码，线程对象调用start()方法，让所创建的线程处于
 * 就绪状态，start()方法会自动调用run()方法。
 */
public class Thread1 extends Thread{
    private String name;
    Thread1(String name){
        this.name = name;
    }
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(name + "......" + i);
        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1("A");
        Thread1 t2 = new Thread1("B");
        t1.start();
        t2.start();
    }
}
