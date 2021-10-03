package tictak;

public class ThreadTwo implements Runnable {
    private Thread thread;
    private Mon monitor;

    
    public Thread getThread () {
        return thread;
    }

    public ThreadTwo(Mon m) {
        thread = new Thread (this);
        monitor = m;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < TicTak.num; i++) {
                synchronized(monitor){     
                    
                    if (monitor.c ==0 || monitor.c ==2) 
                        monitor.wait();
                    if (monitor.c==1) {
                        System.out.print(2 + " - ");
                        monitor.c = 2; 
                        monitor.notifyAll();
                        if(i<TicTak.num-1)
                            monitor.wait();
                    }
                }
            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
