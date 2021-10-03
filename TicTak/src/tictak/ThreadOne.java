package tictak;

public class ThreadOne extends Thread {
  private Mon monitor;

    public ThreadOne(Mon m) {
    monitor = m;
    }


  @Override
    public void run () {
        try { 
            for (int i = 0; i < TicTak.num; i++) {
                synchronized (monitor){ 
                    
                  if (monitor.c ==1 || monitor.c ==2)
                      monitor.wait();
                  if(monitor.c==0) {
                        System.out.print(1+" - ");
                        monitor.c=1; 
                        monitor.notifyAll();
                        if(i<TicTak.num-1)
                            monitor.wait();
                  }
                }
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
