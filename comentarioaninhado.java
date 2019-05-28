import java.io.IOException;
import java.io.PushbackReader;

import sable.lexer.IPushbackReader;
import sable.lexer.Lexer;
import sable.lexer.LexerException;

public class Comentarioaninhado extends Lexer{
	
	public Comentarioaninhado(PushbackReader pushbackReader) {
		// TODO Auto-generated constructor stub
	}

	protected void filter() throws LexerException, IOException
    {
		if(check.equals("TAbrec")) {
			int pos = t.getPos();
			int linha = t.getLine();
			int contComent = 1;
			int contAnin = 0 ;
			t = lexer.next() ;
			check = t.getClass().getSimpleName().toString() ;
			while(contComent != 0) {
				if(check.equals("TAbrec")) {
					contComent += 1;
					contAnin = 1;
				}else if(check.equals("TFechac")) {
					contComent -= 1;
				}
				t = lexer.next() ;
				check = t.getClass().getSimpleName().toString() ;
				if (check.equals("EOF")) {
					System.out.print("Erro de comentario na posicao: " + linha +","+ pos);
					System.exit(0);
				}
			}if(contAnin == 1) {
					System.out.print("TComentarioaninhado");
				}else {
					System.out.print("TComentariobloco");
				}
			
		} if(check.equals("TBlank")) {
			System.out.println("") ;
		} else if(check.equals("TSpc")){
			System.out.print(" ");
		}else if(check.equals("TTab")){
			System.out.print("	");
		}else {
			System.out.print((t.getClass().getSimpleName())) ;
		}
    }

}
