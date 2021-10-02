package tictak;
/**
 *
 * @author JuliaParpulova
 */
public class ThreadThree  implements Runnable{
    private Object monitor;
    private Thread thread;

    public Thread getThread() {
        return thread;
    }
    
    public ThreadThree(Object m) {
        thread = new Thread(this);
        monitor = m;
    }
    
    public void run() {
        try {
            Thread.sleep(2);
            for (int i = 0; i < TicTak.num; i++) {
                System.out.println(3);

                synchronized(monitor){  
                    monitor.notifyAll();
                    if(i<TicTak.num-1)
                        monitor.wait();
                }
            }
        }catch (InterruptedException e) { e.printStackTrace(); }
    }
}
