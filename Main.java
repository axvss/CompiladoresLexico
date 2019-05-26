// Main 1.0
import sable.lexer.* ;
import sable.node.*;

import java.io.* ;
 
public class Main {
   public static void main(String[] args) throws LexerException, IOException {
      if (args.length > 0) {
    	  Lexer lexer = null;
         try {
            lexer = new Lexer (new PushbackReader(     // chama o lexer pra trabalhar
            		new FileReader(args[0]), 1024));
         }
         catch (Exception e) {
            System.out.println (e) ;
         }
         String parada = "class sable.node.EOF"; // string pra usar como condição de parada no while
         Token t = lexer.getToken();
         String check = t.getClass().toString(); // nome do nosso token
         
         while (!check.equals(parada)) { // quando chega no final, para
         System.out.println(check); // enquanto nao chega vai imprimindo
         lexer.next(); // e passando pro próximo
         t = lexer.getToken(); 
         check = t.getClass().toString(); 
         }
         
         
      }
      
      else {
         System.err.println("nada na entrada =(");
         System.exit(1);
      }
   }
}