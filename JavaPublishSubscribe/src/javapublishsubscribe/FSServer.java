package javapublishsubscribe;
//издатель
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;

public class FSServer {
    
    private String dir; 
    private ArrayList<FSMonitor> clients; 
    private volatile boolean canWork; 

    public FSServer(String dir) {
        this.dir = dir;
        clients = new ArrayList<>();
        canWork = true;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    
    public boolean addClient(FSMonitor client){
        clients.add(client);         
        return true;
    }
    public boolean removeClient(FSMonitor client){
        clients.remove(client);
        return true;
    }
    
    public void start(){
    //............
    }
    
    public void stop(){
        canWork = false;
    }
    
    public void run(){
        try{
            
            WatchService watch=  FileSystems.getDefault().newWatchService(); 
            Paths.get(dir).register(watch, 
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE);
            
            while(canWork){
                WatchKey key = watch.take(); 
                
                for (WatchEvent pollEvent : key.pollEvents()) {
                    String fName = pollEvent.context().toString();
                    int kind = 0;
                    if(pollEvent.kind() == StandardWatchEventKinds.ENTRY_CREATE)
                        kind = FSMonitor.CREATED;
                    else if(pollEvent.kind() == StandardWatchEventKinds.ENTRY_DELETE)
                        kind = FSMonitor.DELETED;
                 for (FSMonitor client : clients) {
                    client.fileEvent(fName, kind);
                }
                }
                
               
                
                key.reset(); 
            }
            
            watch.close(); 
            
        } catch (IOException | InterruptedException ex){
        
        }
        
    }
    
}
