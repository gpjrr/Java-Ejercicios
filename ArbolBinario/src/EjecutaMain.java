
import java.util.Scanner;
public class EjecutaMain {

	    public static void main(String [] args){
	        Scanner sc = new Scanner(System.in);
	        Arbol ar = new Arbol();
	       int d = 0,opc = 0;
	       do{
	           System.out.println("1) Insertar vertice");
	           System.out.println("2) Eliminar vertice");
	           System.out.println("3) Buscar vertice");
	           System.out.println("4) Recorrido Preorden");
	           System.out.println("5) Recorrido Inorden");
	           System.out.println("6) Recorrido Postorden");
	           System.out.println("7) Recorrido Preorden Converso");
	           System.out.println("8) Recorrido Inorden Converso");
	           System.out.println("9) Recorrido Postorden Converso");
	           System.out.println("10) Salir");
	           opc = sc.nextInt();
	           switch(opc){
	               case 1:
	                   System.out.println("dar el valor a insertar: ");
	                   d = sc.nextInt();
	                   ar.Insertar(d);
	               break;
	               
	               case 2:
	                   System.out.println("dar el valor a eliminar: ");
	                   d = sc.nextInt();
	                   ar.Eliminar(d);
	               break;
	               
	               case 3:
	                   System.out.println("Digite dato a buscar: ");
	                   d = sc.nextInt();
	                   Nodo ban=ar.Busqueda(d, ar.raiz );
	                   if( ban!=null )
	                	   System.out.println(d+" exite");
	                   else
	                	   System.out.println(d+" NO exite");
	               break;
	               
	               case 4:
	                   System.out.println("Recorrido Pre-orden: ");
	                   ar.Preorden(ar.raiz);
	               break;
	               
	               case 5:
	                   System.out.println("Recorrido In-orden: ");
	                   ar.Inorden(ar.raiz);
	               break;
	               
	               case 6:
	                   System.out.println("Recorrido Post-orden: ");
	                   ar.Postorden(ar.raiz);
	               break;
	               
	               case 7:
	                   System.out.println("Recorrido Pre-orden Converso: ");
	                   ar.PreordenC(ar.raiz);
	               break;
	               
	               case 8:
	                   System.out.println("Recorrido In-orden Converso: ");
	                   ar.InordenC(ar.raiz);
	               break;
	               
	               case 9:
	                   System.out.println("Recorrido Post-orden Converso: ");
	                   ar.PostordenC(ar.raiz);
	               break;
	               
	               default:
	                   System.out.println("Opcion no valida");
	                break;
	           }
	       }while(opc != 0);
	    }
	

	
}
