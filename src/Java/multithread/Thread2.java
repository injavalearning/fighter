package Java.multithread;

/**
 * 本例是实现多线程的方式二：实现Runnable接口
 * 1、实现Runnable接口
 * 存放线程执行代码的类去实现(implements) Runnable接口
 * 2、重写所实现接口的run方法，并将线程执行代码存放在run方法中
 * 3、通过Thread类创建线程对象，并将Runnable接口的子类对象作为Thread类的构造函数的参数进行传递
 * 为什么？因为线程的执行代码都封装在Runnable接口子类对象的run方法中，所以要在线程对象创建时就必须明确要执行的代码
 * 4、Thread线程对象调用start方法，启动线程
 */
public class Thread2 implements Runnable{
    private String name;
    Thread2(String name){
        this.name = name;
    }
    public void run(){
        for(int i=0;i<20;i++){
            System.out.println(name + "......" + i);
        }
    }

    public static void main(String[] args) {
        Thread2 t1 = new Thread2("A");
        Thread2 t2 = new Thread2("B");

        /**
         * 在启动多线程的时候，需要先通过Thread类的构造方法Thread(Runnable target) 构造出对象，
         * 然后调用Thread对象的start()方法来运行多线程代码。
         */
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
