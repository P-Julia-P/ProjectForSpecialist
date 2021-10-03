
package myParser;

public class SimpleParser extends ComLineParserBase{

    private String inFile, outFile;
    
    public SimpleParser() {
        super(new String [] {"?","r","w"});
    }

    public String getInFile() {
        return inFile;
    }

    public String getOutFile() {
        return outFile;
    }

    @Override
    protected void onUsage (String errorKey){
        if (errorKey!=null) System.out.println("ErrorKey: "+ errorKey);
        else{
            System.out.println("формат ком.строки: имя программы [-r<input-fileName>][-w<output-fileName>]");
            System.out.println("-? показать Help файл");
            System.out.println("-r задать имя входного файла");
            System.out.println("-w выполнить вывод в указанный файл");  
        }
    } 
    
    @Override
    protected switchStatus onSwitch(String key, String keyValue){ 
        switchStatus status = switchStatus.NoError;
        switch (key){
            case "?" :   status = switchStatus.ShowUsage; break;
            case "r" : if(keyValue!=null) inFile=keyValue; 
                        else status = switchStatus.Error; break;
            case "w" : if(keyValue!=null) outFile=keyValue; 
                        else status = switchStatus.Error; break;
            default: break;
        }
    return status;
    }   
    


    @Override
    public String toString() {
        return "inFile= " + inFile + ", outFile= " + outFile;
    }
    

}
