import java.util.Scanner;
import java.io.*;

public class main {
	public static void main(String[] args) {	
		/// en opc guardamos la opcion que toma el usuario
		int opc=0;
		// sc es el scaner para los valores
		Scanner sc=new Scanner(System.in);
		// contruimos la cola
		System.out.println(" dar el tamano de la cola");
		Cola fila=new Cola( sc.nextInt() );
		//el while no se rompe hasta que decida salir
		while( opc!=4 ) {
			// mostramos el menu			
			System.out.println("  1) Insertar Elemnto a la Cola");
			System.out.println("  2) Borrar Elemento a la Cola");
			System.out.println("  3) Mostrar Elementos de la Cola");
			System.out.println("  4) Salir");
						// leemos la opcion
			opc=sc.nextInt();
			switch(opc) {
				//leemos el valor y lo metemos en la pila
				case 1:
					
					if( fila.lleno()!=true) {
						System.out.println("Dar el valor a insertar");
						fila.Insertar( sc.nextInt() );
					}
					else
						System.out.println("la cola esta llena ");
					
				break;
				// case 2 es para borrar 
				// hay una condicion por si la cola esta vacia
				case 2:
					if(  fila.Vacio()==true  )
						System.out.println("no hay elementos en la pila");
						else
					System.out.println("El valor "+fila.Borrar()+" fue eliminado");
				break;
				// muestras los elementos
				case 3:
					System.out.println("los Elementos son:");
					System.out.println( fila.Mostrar() );
					
				break;
				// por si el usuario se equivoca
				default:
					System.out.println( "opcion invalida" );
				break;
			}
			
		}
		
		
		
		
	}
}
