import java.util.Scanner;
import java.io.*;

public class Ejecuta {
	public static void main(String[] args) {
		ListaLigada<Integer> lista=new ListaLigada<>();
		int opc=0;
		String tem;
		while( opc!=7 ) {
			Scanner sc=new Scanner( System.in );
		
			//insertar quitar mostrar salir
				System.out.println("1) insertar elemento \n ");
				System.out.println("2) eliminar \n ");
				System.out.println("3) mostrar pila \n ");
				System.out.println("4) buscar \n ");
				System.out.println("5) eliminar pares \n ");
				System.out.println("6) contat elementos e insertar\n ");
				System.out.println("7) salir \n ");
				opc=sc.nextInt();
				if( opc==1 ) 	{
					sc.nextLine();
					lista.Insertar( sc.nextInt()   );
				}
				if( opc==2 ) {
					sc.nextLine();
					lista.Eliminar( lista.Buscar( sc.nextInt() ) );
				}
				
				if( opc==3 )
					System.out.println( lista.toString() );
				if( opc==4 ) {
					sc.nextLine();
					if( lista.Buscar( sc.nextInt() )!=null )
						System.out.println("se encuentra en la lista");
					else
						System.out.println("no esta en la lista");
				}
				if( opc==5 )
					lista.EliminarPares();
				if( opc==6 ) {
					int cuenta=lista.Contar();
					System.out.println(cuenta);
					boolean bandera;///=lista.Buscar(cuenta);
					if( bandera )
						System.out.println("se encuentra en la lista");
					else {
						System.out.println("no esta en la lista");
						lista.Insertar( cuenta );
					}
						
				}
					
			}
	
	}
}
