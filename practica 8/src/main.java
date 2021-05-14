import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int op,op1,n,b;
		Grafo tree=new Grafo();
		String txtito;
		do {
			menuPrinc();	
			tree.showpath();
			op=sc.nextInt();
		
			switch(op){
			
				case 1: /// crear directorio
					System.out.println("  Dar el nombre del directorio");
					sc.nextLine();
					txtito=sc.nextLine();
					if( tree.findDir( txtito )==-1 ) {
					tree.Insert( new Nodo( txtito, tree.pos ) );
					}
					else
				System.out.println("error, ya existe el nombre de ese directorio");
					break;
				case 2: ///  crear archivo
					System.out.println("  Dar el nombre del archivo");
					txtito=sc.nextLine();
					txtito=sc.nextLine();
					if( tree.find(txtito)==-1 )
					tree.arr[ tree.pos ].InsertFile( txtito );
					else
			System.out.println("error, ya existe el nombre de ese directorio");
					break;
				case 3: /// eliminar archivo
					tree.arr[ tree.pos ].ShowFiles();
					System.out.println("  Dar el nombre del archivo");
					sc.nextLine();
					if( tree.arr[ tree.pos ].DeleteFile( sc.nextLine() )==true )
						System.out.println("Tarea eliminda\n");
					else
						System.out.println("error burro\n");
					break;
				case 4: /// avanzar a
					tree.ShowDir( tree.pos );
					System.out.println("dar el nombre del directorio a avanzar\n");
					sc.nextLine();
					tree.move( sc.nextLine() );
					break;
				case 5: /// salir del directorio
					tree.back();
					break;
				case 6: /// ver directorios
					tree.ShowDir( tree.pos );
					break;
				case 7: /// archivos del directorio 
					tree.arr[ tree.pos ].ShowFiles();
					break;
				case 8:
					tree.ShowDir( tree.pos );
					System.out.println("  dar el nombre del directorio a borrar ");
					txtito=sc.nextLine();
					txtito=sc.nextLine();
					if( tree.findDir(txtito)==-1 )
					System.out.println("no existe el directorio");
					else
					{
						tree.arr[ tree.findDir(txtito) ].Live=false;
						System.out.println("borrado con exito");
					}
					break;
				default:
					System.out.println("  opcion incorrecta ");
					break;
			}
		}while(op!=9);
		
	
		
		
		
	}
	
	static void menuPrinc() {
		System.out.println("  1) Crear directorio");
		System.out.println("  2) crear archivo");
		System.out.println("  3) eliminar archivo");
		System.out.println("  4) avanzar a ...");
		System.out.println("  5) Salir del directorio");
		System.out.println("  6) ver directorios");	
		System.out.println("  7) Ver archivos del directorio");
		System.out.println("  8) eliminar directorio");
		System.out.println("  9) Salir");
		
		
	}




}
