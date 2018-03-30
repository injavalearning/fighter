package multithread;
/*
本例是synchronized同步方法
格式：把同步（synchronized）加在方法上，这时的锁对象是this
注：同步是一种高开销的操作，因此应该尽量减少同步的内容
    通常没有必要同步整个方法，使用synchronized代码块同步关键代码即可
 */
public class Ticket2 implements Runnable{
    private int ticketCount = 100;
    public void run(){
        while(true){      //while语句不需要被同步，只有包含共享数据的代码需要同步
            sellTicket();
        }
    }
    //同步方法，这时的锁对象是this，也就是Ticket2
    private synchronized void sellTicket(){
        if(ticketCount > 0){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "...sale..." + ticketCount--);
        }else
            Thread.currentThread().interrupt();
    }

    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        t1.setName("窗口1");
        t2.setName("窗口2");

        t1.start();
        t2.start();
    }
}
