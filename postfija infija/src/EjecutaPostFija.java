import java.util.Scanner;

import javax.xml.soap.Text;

import java.io.*;
public class EjecutaPostFija {
		public static void main(String[] args) {
			Scanner sc=new Scanner( System.in );
			PostFija Texto=new PostFija(  );	
			Texto.leer( sc.nextLine() );
			Texto.Convertir();
			///System.out.println( Texto.col.toString() );
			System.out.println( Texto.Expresion() );
			System.out.println( Texto.Resultado() );
		}
}
/// y=5+8/(2^3)+1-7