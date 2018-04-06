package multithread;
/**
 * 本例是Lock锁实现同步
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket3 implements Runnable{
    private int ticketCount = 100;
    private Lock lock = new ReentrantLock();
    public void run(){
        while(true) {
            try {
                //加锁
                lock.lock();
                if (ticketCount > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "...sale..." + ticketCount--);
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Ticket3 ticket = new Ticket3();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        t1.setName("窗口1");
        t2.setName("窗口2");

        t1.start();
        t2.start();
    }
}
