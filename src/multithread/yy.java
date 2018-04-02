package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class yy {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newScheduledThreadPool(4);
        Ticket t1 = new Ticket();
        Thread t11 = new Thread(t1);
        Ticket t2 = new Ticket();
        Thread t22 = new Thread(t2);
        Ticket t3 = new Ticket();
        Thread t33 = new Thread(t3);
        pool.execute(t11);
        pool.execute(t22);
        pool.execute(t33);
        pool.execute(t11);
        pool.execute(t11);
    }
}
