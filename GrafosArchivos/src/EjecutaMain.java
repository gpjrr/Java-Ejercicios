import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;
public class EjecutaMain {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner( System.in );
		Grafo grafi=new Grafo();

		try {
			System.out.println("hay 4 grafos cual desea usar? inserta un numero entre 1-4");
			String Nombe=new String();
			Nombe="Grafo";
			Nombe+= Integer.toString( sc.nextInt() );
			Nombe+=".txt";
			//System.out.println( Nombre );
			grafi.Construir( Nombe );
		}
		catch(FileNotFoundException e){
			System.out.println( "no es posiblee ");
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
            System.exit(0);
        }
			
		
		int opc=0;
		while( opc!=8 ) {
			System.out.println("1) insertar nodo \n");
			System.out.println("2) insertar arista \n");
			System.out.println("3) mostrar grafo \n");
			System.out.println("4) eliminar nodo \n");
			System.out.println("5) eliminar arista \n");
			System.out.println("6) salir del grafo \n");
			System.out.println("6) busqueda en profundidad \n");
			System.out.println("7) busqueda en amplitud \n");
			System.out.println("8) salir del grafo \n");
			opc=sc.nextInt();
			if( opc==1 ) {
				System.out.println("dar el nombre del nuevo nodo\n");
				sc.nextLine();
				grafi.InsertarVertice( sc.nextLine() );
			}
			if( opc==2 ) {
				String t1,t2;
				System.out.println("dar el nombre del primer nodo\n");
				sc.nextLine();
				t1=sc.nextLine();
				System.out.println("dar el nombre del segundo nodo\n");
				t2=sc.nextLine();
				grafi.InsertarArista(t1, t2);
			}
			if( opc==3 ) 
				System.out.println( grafi.toString() );
			
			if( opc==4 ) {
				System.out.println("dar el nombre del nodo por eliminar\n");
				sc.nextLine();
				grafi.EliminarVertice( sc.nextLine() );
			}
			if( opc==5 ) {
				String t1,t2;
				System.out.println("dar el nombre del primer nodo\n");
				sc.nextLine();
				t1=sc.nextLine();
				System.out.println("dar el nombre del segundo nodo\n");
				t2=sc.nextLine();
				
				grafi.EliminarArista(t1, t2);
			}
			if( opc==6 ) {
				System.out.println("dar el nombre del primer nodo\n");
				sc.nextLine();
	System.out.println( grafi.BusquedaProfundidad( sc.nextLine() ) );
			}
			if( opc==7 ) {
				System.out.println("dar el nombre del primer nodo\n");
				sc.nextLine();
	System.out.println( grafi.BusquedaAmplitud( sc.nextLine() ) );
			}

			
		}
		
	}

}