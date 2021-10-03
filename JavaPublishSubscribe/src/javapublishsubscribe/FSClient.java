package javapublishsubscribe;
//подписчик
public class FSClient implements FSMonitor{

    @Override
    public void fileEvent(String fName, int kind) {
    switch (kind) {
        case FSMonitor.CREATED:
            System.out.println("File created: " + fName);
            break;
        case FSMonitor.DELETED:
            System.out.println("File deleted: " + fName);
            break;
        default:System.out.println("Unknown event");
    }
    
    }
    
}
