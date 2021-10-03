
package mycounter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCount {
    
    private String inFile;
    private String outFile;
    static String testString = "Hello test"; 
    Map <String,Integer> words = new HashMap() ;

    public Map getWords() {
       return words;
    }
    
    public WordCount(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }
    
    public void countWords () throws FileNotFoundException, IOException {
        Reader reader;
        
       if (inFile==null) reader = new StringReader(testString);
       else reader = new FileReader(inFile);
        
        BufferedReader br=new BufferedReader(reader); 
        for(String line = br.readLine();line !=null; line = br.readLine()){
            StringTokenizer st;
            st = new StringTokenizer(line," .,:;/\\'\n\r*\"\t!?-<>{}[]()=$&|");
            while (st.hasMoreTokens()){
                String token = st.nextToken();
                  if(!words.containsKey(token)) words.put(token, 1);
                  else {Object val = words.get(token);
                        int n=(int) val;
                        n++;
                        words.put(token, n);
                  }
            }
            
        }
        reader.close();
    }
    
}
