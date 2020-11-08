package pila;
import java.util.Scanner;
import java.io.*;
public class EjecutaPila {
	public static void main(String[] args) {
		Pila platos= new Pila();
		int opc=0;
		String tem;
		while( opc!=4 ) {
			Scanner sc=new Scanner( System.in );
			
		//insertar quitar mostrar salir
			System.out.println("1) insertar elemento \n ");
			System.out.println("2) eliminar \n ");
			System.out.println("3) mostrar pila \n ");
			System.out.println("4) salir \n ");
			opc=sc.nextInt();
			if( opc==1 ) 	{
				sc.nextLine();
				platos.Insertar( sc.nextLine() );
			}
			if( opc==2 )
				System.out.println("elemento borrado:" + platos.Eliminar() );
			if( opc==3 )
				System.out.println( platos );
		}
	}
}
