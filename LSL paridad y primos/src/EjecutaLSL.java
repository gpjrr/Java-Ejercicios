import java.util.Scanner;
import java.io.*;

public class EjecutaLSL {
	public static void main(String[] args) {
		int opc=0;
		ListaLigada<Integer> Lista=new ListaLigada();
		
		while( opc!=4 ) {
			Scanner sc=new Scanner( System.in );
				System.out.println("1) insertar elemento \n ");
				System.out.println("2) eliminar primos \n ");
				System.out.println("3) mostrar lista ligada \n ");
				System.out.println("4) salir \n ");
				opc=sc.nextInt();
				if( opc==1 )
					Lista.Insertar( sc.nextInt() );
				if( opc==2 )
					Lista.EliminarPrimos();
				if( opc==3 )
					System.out.println(Lista.toString() );
			}
		}
}
