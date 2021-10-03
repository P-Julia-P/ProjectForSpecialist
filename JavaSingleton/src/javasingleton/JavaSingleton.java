package javasingleton;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class JavaSingleton {

   
    public static void main(String[] args) {
   
        Singleton obj = Singleton.getInstance(); 
        
        Calendar sys = Calendar.getInstance();
        System.out.println(sys.get(Calendar.DATE));
        
        Date d = sys.getTime();
        DateFormat dF = DateFormat.getDateInstance(DateFormat.LONG, new Locale("en", "UK"));
        String date = dF.format(d);
        System.out.println(date);
        
    }
    
}
