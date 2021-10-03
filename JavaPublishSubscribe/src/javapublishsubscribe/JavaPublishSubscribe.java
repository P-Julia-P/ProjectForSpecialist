package javapublishsubscribe;

public class JavaPublishSubscribe {
 
    public static void main(String[] args) {
        
        FSServer server = new FSServer(".");
        server.addClient(new FSClient());
        server.run();
    
    
    }
    
}
