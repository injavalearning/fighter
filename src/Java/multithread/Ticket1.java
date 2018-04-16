package Java.multithread;

/**
 * 本例是synchronized同步代码块
 * 格式：synchronized(对象) {
 *     需要被同步的代码;
 * }
 * 这里的锁对象可以是任意对象
 */
public class Ticket1 implements Runnable{
    private int ticketCount = 100;
    //创建锁对象（类型可以理解为锁的牌子），这个也是共享的资源，多个线程使用的是同一锁对象
    private Object obj = new Object();
    public void run(){
        while(true) synchronized (obj) {
            if (ticketCount > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...sale..." + ticketCount--);
            } else
                Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Ticket1 ticket = new Ticket1();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        t1.setName("窗口1");
        t2.setName("窗口2");

        t1.start();
        t2.start();
    }
}
