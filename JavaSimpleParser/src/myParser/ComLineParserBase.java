
package myParser;

public class ComLineParserBase {
    private String [] keys;
    private String [] delimeters;
    //варианты завершения разбора командной строки:
    protected enum switchStatus {NoError,Error,ShowUsage};

    public ComLineParserBase(String [] keys, String [] delimeters) {
        this.keys = keys;
        this.delimeters = delimeters;
    }

    public ComLineParserBase(String [] keys) {
   this(keys, new String [] {"/","-"});
   }

    //выводит подсказку об ошибочном ключе и о вариантах командной строки
    
    protected void onUsage (String errorKey){
    }
    
    //обрабатывает команду для  каждого найденного ключа
    protected switchStatus onSwitch(String key, String keyValue){ 
    return switchStatus.NoError;
    }
    
    //содержит бизнес логику по разбору командной строки
    public boolean parse (String [] args){
    switchStatus ss = switchStatus.NoError;
    int argNum;
    for (argNum = 0; (ss==switchStatus.NoError)&&(argNum<args.length);argNum++){
        //проверка наличия правильного разделителя
        boolean isDelimeter = false;
        for(int n=0; !isDelimeter && (n<delimeters.length); n++){
            isDelimeter = args[argNum].regionMatches(0, delimeters[n], 0, 1);
        }
        if(isDelimeter){
            //проверка наличия правильного ключа
        boolean isKey = false;
        int i;
            for(i=0; !isKey && (i<keys.length); i++){
            isKey = args[argNum].regionMatches(1,keys[i],0,keys[i].length()); 
            if(isKey==true) break;
            }
           
            if(isKey==false) {
            ss=switchStatus.Error; break;
            }
            else onSwitch(keys[i], args[argNum]); 
        }
        else{
        ss=switchStatus.Error;
        break;
        }
    }
    //завершение разбора командной строки
    if(ss==switchStatus.ShowUsage) onUsage(null);
    if(ss==switchStatus.Error) onUsage((argNum==args.length)? null : args[argNum]);
    return ss==switchStatus.NoError;
    }

   
    
}
