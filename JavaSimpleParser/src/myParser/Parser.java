/*В свойствах проекта, в категории «Выполнить», в графе «Аргументы», 
задайте командную строку:   -wOutfileName -rInfileName*/
package myParser;

public class Parser {

   
    public static void main(String[] args) {
     SimpleParser p = new SimpleParser();
     p.parse(args);
     System.out.println(p.toString());
    }
    
}
