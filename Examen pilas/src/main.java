import java.util.Scanner;
import java.io.*;

public class main {
	public static void main(String[] args) {	

		int opc=0;

		Scanner sc=new Scanner(System.in);
	
		System.out.println(" dar el tamano de la cola");
		Cola fila=new Cola( sc.nextInt() );
	
		while( opc!=4 ) {
				
			System.out.println("  1) Insertar Elemnto a la Cola");
			System.out.println("  2) Borrar Elemento a la Cola");
			System.out.println("  3) Mostrar Elementos de la Cola");
			System.out.println("  4) Salir");
	
			opc=sc.nextInt();
			switch(opc) {
	
				case 1:
					
					if( fila.lleno()!=true) {
						System.out.println("Dar el valor a insertar");
						fila.Insertar( sc.nextInt() );
					}
					else
						System.out.println("la cola esta llena ");
					
				break;
	
				case 2:
					if(  fila.Vacio()==true  )
						System.out.println("no hay elementos en la pila");
						else
					System.out.println("El valor "+fila.Borrar()+" fue eliminado");
				break;
	
				case 3:
					System.out.println("los Elementos son:");
					System.out.println( fila.Mostrar() );
					
				break;
				default:
					System.out.println( "opcion invalida" );
				break;
			}
			
		}
		
		
		
		
	}
}
