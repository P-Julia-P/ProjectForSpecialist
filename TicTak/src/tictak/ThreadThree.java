package tictak;

public class ThreadThree  implements Runnable{
    private Mon monitor;
    private Thread thread;
   

    public Thread getThread() {
        return thread;
    }
    
    public ThreadThree(Mon m) {
        thread = new Thread(this);
        monitor = m;
    }


    @Override
    public void run() {
         try {
            for (int i = 0; i < TicTak.num; i++) {
                synchronized(monitor){
                    
                    if(monitor.c == 1 || monitor.c == 0) 
                        monitor.wait();
                    if(monitor.c==2){
                        System.out.println(3);
                        monitor.c = 0;
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
