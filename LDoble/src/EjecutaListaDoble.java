import java.util.Scanner;
import java.io.*;

public class EjecutaListaDoble {
	public static void main(String[] args) {
		int opc=0;
		ListaDobleLigada<Integer> Lista=new ListaDobleLigada();
		while( opc!=4 ) {
			Scanner sc=new Scanner( System.in );
				System.out.println("1) insertar elemento \n ");
				System.out.println("2) reordenar ultimo\n ");
				System.out.println("3) mostrar lista ligada \n ");
				System.out.println("4) salir \n ");
				opc=sc.nextInt();
				if( opc==1 )
					Lista.Insertar( sc.nextInt() );
				if( opc==2 )
					System.out.println( Lista.Resort() );
				if( opc==3 )
					System.out.println(Lista.toString() );
			}
		}
}
