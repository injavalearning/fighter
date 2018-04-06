package multithread;
/**
 * 本例是线程池的使用，包括线程池的创建、线程执行和关闭
 */

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        //创建一个定长线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Ticket1 ticket = new Ticket1();

        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        //将线程放入线程池中执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);

        //关闭线程池
        pool.shutdown();
    }
}
