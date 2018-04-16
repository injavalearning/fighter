package Java.multithread;

/**
 * 本例是线程安全问题的介绍，引用的是最常见的多窗口售票问题
 * 这里使用Runnable接口来实现线程，这样做是为了共享代售票这个资源（因为只new了一个子类的对象，把这个对象作为参数传给了
 * 两个Thread类的构造函数里），如果我们使用继承Thread来操作，需要将代售票ticketCount设置为全局的公共变量才能实现共享的
 * 效果。意思就是，实现Runnable的方法多个线程会共享这100张票（因为执行的是一个run方法），继承Thread的方法每个线程都有
 * 100张票，如果有两个线程就有200张票（因为每个线程执行了各自的run方法）。
 * 打印结果：会发现两个窗口都在卖同一张票，这就是由于多线程导致的线程安全问题
 */
public class Ticket implements Runnable{
    private int ticketCount = 100;
    public void run(){
        while(true){
            if(ticketCount > 0){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...sale..." + ticketCount--);
            }else {
                Thread.currentThread().interrupt();
                break;  // 因为用的是while(true)，加break等程序运行结束自动退出
            }
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        t1.setName("窗口1");
        t2.setName("窗口2");

        t1.start();
        t2.start();
    }
}
