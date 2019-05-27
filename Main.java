
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;



import sable.lexer.Lexer;
import sable.lexer.LexerException;
import sable.node.Token;


public class Main {
	 public static void main(String[] args) throws LexerException, IOException { 
		Lexer lexer = null;
		try {
			lexer = new Lexer (new PushbackReader( 
			        new FileReader(args[0]), 1024));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
		String parada = "EOF" ;
		Token t = lexer.next() ;
		String check = t.getClass().getSimpleName() ;
		while (!check.equals(parada)){
			if(check.equals("TBlank")) {
				System.out.println("") ;
			} else if(check.equals("TSpc")){
				System.out.print(" ");
			}else {
				System.out.print((t.getClass().getSimpleName())) ;
			}
			t = lexer.next() ;
			check = t.getClass().getSimpleName();
		}
	 }
}
