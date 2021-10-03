package javapublishsubscribe;
//интерфейс клиента
//средство связи
public interface FSMonitor {
    
   static int CREATED = 1; 
   static int DELETED = -1; 
    
  public void fileEvent(String fName, int kind); 
    
}
