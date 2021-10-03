package mycounter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

public class MyCounter {

    public static void main(String[] args) throws IOException  {
        SimpleParser sp=new SimpleParser();  
        sp.Parse(args);
        
        WordCount wc=new WordCount(sp.getInFile(), null);
        wc.countWords();
        
        Iterator keys = wc.getWords().keySet().iterator();
        while(keys.hasNext()){
           String w=keys.next().toString(); 
           int n= (int)wc.getWords().get(w);
           System.out.println(w+"   "+n);
        }  
    }
}
