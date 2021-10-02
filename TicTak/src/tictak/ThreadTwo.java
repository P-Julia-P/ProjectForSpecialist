package tictak;
/**
 *
 * @author JuliaParpulova
 */
public class ThreadTwo implements Runnable {
    private Thread thread;
    private Object monitor;
    
    public Thread getThread () {
        return thread;
    }

    public ThreadTwo(Object m) {
        thread = new Thread (this);
        monitor = m;
    }
    
    public void run() {
        try {
            Thread.sleep(1);
            for (int i = 0; i < TicTak.num; i++) {
                System.out.print(2 + " - ");

                synchronized(monitor){ 
                    monitor.notifyAll();
                    if(i<TicTak.num-1)
                        monitor.wait();
                }
            }
        }catch (InterruptedException e) { e.printStackTrace(); }
    }
}
