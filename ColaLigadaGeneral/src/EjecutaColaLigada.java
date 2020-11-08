import java.util.Scanner;
import java.io.*;

public class EjecutaColaLigada {
	public static void main(String[] args) {
		Cola<Integer> fila=new Cola<>();
		int opc=0;
		String tem;
		while( opc!=4 ) {
			Scanner sc=new Scanner( System.in );
		
			//insertar quitar mostrar salir
				System.out.println("1) enfila elemento \n ");
				System.out.println("2) eliminar \n ");
				System.out.println("3) mostrar cola \n ");
				System.out.println("4) salir \n ");
				opc=sc.nextInt();
				if( opc==1 ) 	{
					sc.nextLine();
					Nodo tt=new  Nodo<>( sc.nextInt() );
					fila.Insertar( tt );
				}
				if( opc==2 )
					fila.Eliminar();
				if( opc==3 )
					System.out.println( fila );
			}
		}
}
