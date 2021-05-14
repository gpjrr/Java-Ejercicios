import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class main {    
    	public static void main(String[] args) {
    		int n;
    		Random stupid= new Random(); 
    		Scanner sc = new Scanner(System.in);
    		
    		System.out.println("Especifique tamaño de RAM: ");
    		ram memo=new ram( sc.nextInt() );
    		ram hdd=new ram( memo.size );
    		
    		int opc=-1;
    		while( opc!=9 ) {
    			System.out.println("  1) Crear Tarea");
    			System.out.println("  2) Ver distribucion de Ram");
    			System.out.println("  3) Ver lista de tareas");
    			System.out.println("  4) Despachar Primer Tarea");
    			System.out.println("  5) Eliminar Tarea por ID");
    			System.out.println("  6) Mapa de bits");
    			System.out.println("  7) Mover Tarea a SWAP");
    			System.out.println("  8) Mover Tarea a RAM");
    			System.out.println("  8) Intercambiar RAM<-->SWAP");
    			System.out.println("  9) Salir");
    			
    			System.out.println("OPCION: ");
    			opc=sc.nextInt() ;
    			
    			switch(opc){
	    			case 1: System.out.println("Tamaño de la tarea: "); //Creación de tarea
	    					
	    					int rando=( stupid.nextInt()%2 ) ;
	    					//memo.resort();
	    					if( rando%2==0 ) {
	    					
	    						if (  memo.Insert( sc.nextInt() )==true ) {
			    					System.out.println("Tarea creada\n");
			    					memo.ActLista();
		    					}
			    				else
			    					System.out.println("Error: Espacio insuficiente \n");
	    						
	    					}
	    					else {
	    						
	    						if (  hdd.Insert( sc.nextInt() )==true ) {
			    					System.out.println("Tarea creada\n");
			    					hdd.ActLista();
		    					}
			    				else
			    					System.out.println("Error: Espacio insuficiente \n");
	    						
	    					}
	    					System.out.println("RAM\n");
	    					memo.VerRam();
	    					System.out.println("SWAP\n");
	    					hdd.VerRam();
	    				break;
	    			case 2://Ver distribución de RAM 
	    				System.out.println("RAM\n");
    					memo.VerRam();
    					System.out.println("SWAP\n");
    					hdd.VerRam();
	    				break;
	    			case 3: memo.VerListaLigadaTask(); //Ver lista de tareas
	    				break;
	    			case 4: int pos=1; //Eliminar primer tarea
		            		while( memo.arr[pos]==0 && pos<=memo.size ) pos++;
		            		int tip=memo.arr[pos];
			            		if(  tip!=0 ) {
			            			memo.EliminarID( tip );
			            			memo.ActLista();
			            		}
		            			else
		            			System.out.println("Error: No existen tareas \n");
		            		
		            		System.out.println("RAM\n");
	    					memo.VerRam();
	    				break;
	    			case 5: memo.VerRam(); //Eliminar cualquier tarea
	    					memo.VerTareas();
		                	System.out.println("Proporcione ID de tarea a eliminar: ");		
		                	memo.EliminarID( sc.nextInt() );   
		                	memo.ActLista();
		                	
		                	System.out.println("RAM\n");
	    					memo.VerRam();
	    					System.out.println("SWAP\n");
	    					hdd.VerRam();
	    				break;
	    			case 6: //Mapa de bits
	    				System.out.println("RAM\n");
	    				memo.verMapa();
    					System.out.println("SWAP\n");
    					hdd.verMapa();;
	    					
	    				break;
	    			case 7:
	    				System.out.println("Cual es la tarea que deseas mover? ");
	    				memo.VerTareas();
	    				int id=sc.nextInt();
	    				hdd.Insert( memo.finT[id]-memo.iniT[id]+1 );
	    				memo.EliminarID(id);
	    				
	    				System.out.println("RAM\n");
    					memo.VerRam();
    					System.out.println("SWAP\n");
    					hdd.VerRam();
	    				break;
	    			case 8:
	    				ram temp=new ram( memo.size );
	    				temp=hdd;
	    				hdd=memo;
	    				memo=temp;
	    				System.out.println("RAM\n");
    					memo.VerRam();
    					System.out.println("SWAP\n");
    					hdd.VerRam();
	    				break;
	    			default: break;
    				
    			}
    		}//Fin while  del menú
    	}
}
