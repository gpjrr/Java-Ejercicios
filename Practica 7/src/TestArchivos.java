import java.util.InputMismatchException;
import java.util.Scanner;

public class TestArchivos {

	
	public static void main(String[]args) {
		Scanner s=new Scanner(System.in);
		int op,op1,n,b;
		
		Almacenaje memo=setAlmacen();
		do {
			menuPrinc();
			
			op=s.nextInt();
			
			switch(op){
				case 1: CaseCrear(memo);
					break;
				case 2: CaseEliminar(memo);
					break;
				case 3: CaseDesfragmentar(memo);
					break;
				case 4: verAlmacen(memo);
					break;
				case 5: CambiarTam(memo);
					break;
				default: break;
			}
		}while(op!=6);
		
	}
	
	public static void CambiarTam(Almacenaje memo) {
		Scanner s=new Scanner(System.in);
		String cad;
		
		System.out.println("  >>> Cambiar tamaño <<<");
		System.out.println("Nombre archivo:");
		cad=s.next();
		memo.cambiarTam(cad);
	}

	public static void verAlmacen(Almacenaje memo) {
		System.out.println("  >>> Almacenamiento <<<");
		memo.mostrarArreglo();
	}

	public static void CaseDesfragmentar(Almacenaje memo) {
		System.out.println("  >>> Desfragmentar <<<");
		memo.desfragmentar();
	}

	public static void CaseCrear(Almacenaje memo) {
		Scanner s=new Scanner(System.in);
		String cad;
		int op1,n;
		do { 
			System.out.println("  >>> Crear Archivo <<<");
			do {
				System.out.println("Proporcione nombre: ");
				cad=s.next();
				if(memo.duplicate(cad))
					System.out.println("Ese nombre ya existe!!");
			}while(memo.duplicate(cad));
			//try {}catch(InputMismatchException e);
			System.out.println("Proporcione tamaño: ");
			n=s.nextInt();
			memo.crear(cad,n,-2);
			menuCrear();
			op1=s.nextInt();
		}while(op1!=2);
	}
	
	public static void CaseEliminar(Almacenaje memo) {
		verAlmacen(memo);
		Scanner s=new Scanner(System.in);
		String cad;
		
		System.out.println("  >>> Eliminar Archivo <<<");
		System.out.println("Nombre archivo por eliminar:");
		cad=s.next();
		memo.eliminar(cad);
	} 
	
	public static void menuPrinc() {
		System.out.println("\n---------- SISTEMA DE ARCHIVOS ----------");
		System.out.println("  1) Crear Archivo");
		System.out.println("  2) Eliminar Archivo");
		System.out.println("  3) Desfragmentar");
		System.out.println("  4) Ver almacenamiento");
		System.out.println("  5) Cambiar tamaño de tarea");
		System.out.println("  6) Salir\n OPCIÓN: ");
	}
	
	public static void menuCrear() {
		System.out.println("  1) Crear otro archivo");
		System.out.println("  2) Regresar");
	}
	
	public static boolean esMultiplo(int t, int b) {
		return t%b==0;
	}
	
	public static Almacenaje setAlmacen() {
		Almacenaje m=new Almacenaje(20,4);
		int b, n; //b=numBloques y n=tamaño de Almacen(en bytes)
		
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Proporcione tamaño de almacenamiento (bytes): ");
		n=s.nextInt();
		do {
			System.out.println("\nProporcione tamaño de bloque (bytes): ");
			b=s.nextInt();
			//Se generan los bloques
			if(esMultiplo(n,b)) {
				m=new Almacenaje(n,b);
			}
			else
				System.out.println("Error!! Debe se un número múltiplo del tamaño de almacenamiento ");
		}while(!esMultiplo(n,b));
		
		
		
		return m;
		
	}


}
