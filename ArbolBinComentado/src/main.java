import java.util.Scanner;
import java.util.*;
public class main {
	    public static void main(String [] args){
	        Scanner sc = new Scanner(System.in);// construimos el scanner
	        Arbol Tree = new Arbol();// construimos el arbol
	   
	       System.out.println("escribe la oracion");
	       String Oracion=sc.nextLine();//guardamos la oracion
	       StringTokenizer st = new StringTokenizer( Oracion );//metemos la oracion en el token usando el tip del profe
	       
	       while( st.hasMoreTokens() ) {// mientras hay palabras va a trabajar
	    	   String Palabra=st.nextToken() ;// tomamos la palabra
	    	  //la funcion regresa el nodo de la palabra o null sino existe ninguna
	    	   Nodo temp= Tree.Busqueda( Palabra , Tree.raiz );//vemos si existe en el arbol
	    	   if( temp==null )
	    	   Tree.Insertar( Palabra );//si no existe la creamos y la guardamos
	    	   else 
	    		   temp.contador++;// en el caso contrario solo aumentamo el nodo donde se encontro
  
	       }
	       //se muestra el inorden del arbol
	       Tree.Inorden( Tree.raiz );
	    }
}
// ejemplos
/*
 Usted sabe que puede contar conmigo no hASTa dos o hasta diez sino contar cONMIgo
 
  nueve UNO dOs TREs uno CUATro SIete tres NUEve tres
 */
 