import java.io.*;
import java.util.Scanner;


public class main {    
    	public static void main(String[] args) {
    		int n;
    		
    		Scanner sc = new Scanner(System.in);
    		
    		System.out.println("Especifique tamaño de RAM: ");
    		
    		ram memo=new ram( sc.nextInt() );
    		
    		int opc=-1;
    		while( opc!=7 ) {
    			System.out.println("  1) Crear Tarea");
    			System.out.println("  2) Ver distribucion de Ram");
    			System.out.println("  3) Ver lista de tareas");
    			System.out.println("  4) Despachar Primer Tarea");
    			System.out.println("  5) Eliminar Tarea por ID");
    			System.out.println("  6) Mapa de bits");
    			System.out.println("  7) Salir");
    			System.out.println("OPCION: ");
    			opc=sc.nextInt() ;
    			
    			switch(opc){
	    			case 1: System.out.println("Tamaño de la tarea: "); //Creación de tarea
		    				//memo.resort();
	    					if (  memo.Insert( sc.nextInt() )==true ) 
		    					System.out.println("Tarea creada\n");
		    				else
		    					System.out.println("Error: Espacio insuficiente \n");
		    				memo.VerRam();
	    				break;
	    			case 2: memo.VerRam(); //Ver distribución de RAM
	    				break;
	    			case 3: memo.VerListaLigadaTask(); //Ver lista de tareas
	    				break;
	    			case 4: int pos=1; //Eliminar primer tarea
		            		while( memo.arr[pos]==0 && pos<=memo.size ) pos++;
		            		int tip=memo.arr[pos];
		            		if(  tip!=0 )
		            			memo.EliminarID( tip );
		            		else
		            			System.out.println("Error: No existen tareas \n");
		            		
		            		memo.VerRam();
	    				break;
	    			case 5: memo.VerRam(); //Eliminar cualquier tarea
		                	
	    					memo.VerTareas();
		                	System.out.println("Proporcione ID de tarea a eliminar: ");		
		                	memo.EliminarID( sc.nextInt() );   
		                	
		                	memo.VerRam();
	    				break;
	    			case 6: //Mapa de bits
	    					memo.verMapa();
	    				break;
	    			default: break;
    				
    			}
    		}//Fin while  del menú
    	}
}
