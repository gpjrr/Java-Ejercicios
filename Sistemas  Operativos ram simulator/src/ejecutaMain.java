import java.io.*;
import java.util.Scanner;


public class ejecutaMain {    
    	public static void main(String[] args) {
    		int n;
    		
    		Scanner sc = new Scanner(System.in);
    		
    		System.out.println("Dar el espacio total \n");
    		
    		ram memo=new ram( sc.nextInt() );
    		
    		int opc=-1;
    		while( opc!=6 ) {
    			System.out.println("1) Crear Tarea");
    			System.out.println("2) Ver distribucion de Ram");
    			System.out.println("3) ver lista de tareas");
    			System.out.println("4) Eliminar Primer Tarea");
    			System.out.println("5) Eliminar Tarea por ID");
    			System.out.println("6) Salir");
    			opc=sc.nextInt() ;
    		
    			if( opc==1 ) {
    				System.out.println("Dar el tamaño de la tarea\n");
    				
    				if (  memo.Insert( sc.nextInt() )==true )
    					System.out.println("Fue un exito\n");
    				else
    					System.out.println("Error, no hay suficiente espacio \n");
    				memo.VerRam();
    			}
    			else    				
    			if( opc==2 ) /// ver ram
    				memo.VerRam();
       			else
        		if( opc==3 ) 
        			memo.VerTareas();
           		else
         		if( opc==4 ) {
         			//borra primer tarea
         			int pos=1;
            		while( memo.arr[pos]==0 && pos<=memo.size ) pos++;
            		int tip=memo.arr[pos];
            		if(  tip!=0 )
            			memo.EliminarID( tip ); 
            	    		
            		memo.VerRam();
               	}
               	else
                if( opc==5 ) {
                	// borrar id
                	memo.VerTareas();
                	System.out.println("dar el id ID\n");		
                	memo.EliminarID( sc.nextInt() );    
                	memo.VerRam();
                }
                 
    		}
    		    		

    	}
		
}
