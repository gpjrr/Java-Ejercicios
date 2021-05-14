import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class main {    
    	public static void main(String[] args) {
    		int n;
    		int[] vis = new int[1000];
    		for(int i=0;i<900;i++)  vis[i]=0;
    		Random stupid= new Random(); 
    		Scanner sc = new Scanner(System.in);
    		int t1,t2,t3; /// variables temporales 
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
    			System.out.println("  9) Intercambiar RAM<-->SWAP");
    			System.out.println("  10) Paginación");
    			System.out.println("  11) Salir");
    			System.out.println("OPCION: ");
    			opc=sc.nextInt() ;
    			
    			switch(opc){
	    			case 1: System.out.println("Tamaño de la tarea: "); //Creación de tarea
			    			if(memo.espaciosDisp<=(int)(memo.size*0.30)) { //Si solo queda el 30% o menos
			    				/*empiezo a condicionar aleatorio*/
		    					int rando=( stupid.nextInt()%2 ) ;
		    					memo.resort();
		    					if( rando%2==0 ) {
		    						if (  memo.Insert( sc.nextInt() )==true ) {
				    					System.out.println("Tarea creada\n");
				    					memo.ActLista();
			    					}
				    				else
				    					System.out.println("Error: Espacio insuficiente \n");
		    					}
		    					else {
		    						hdd.setTask(memo.getTask());
		    						if ( hdd.Insert( sc.nextInt())==true ) {
				    					System.out.println("Tarea creada\n");
				    					hdd.ActLista();
				    					memo.setTask(memo.getTask()+1);
			    					}
				    				else
				    					System.out.println("Error: Espacio insuficiente \n");
		    					}
			    			}
			    			else if(memo.espaciosDisp==0) { //Si RAM está al 100% 
			    				if ( hdd.Insert( sc.nextInt())==true ) { //Inserción en SWAP
			    					System.out.println("Tarea creada\n");
			    					hdd.ActLista();
			    					memo.setTask(memo.getTask()+1);
		    					}
			    				else
			    					System.out.println("Error: Espacio insuficiente \n");
			    			}
			    			else { //Si no insertar directo en RAM
			    				if (  memo.Insert( sc.nextInt() )==true ) {
			    					System.out.println("Tarea creada\n");
			    					memo.ActLista();
		    					}
			    				else
			    					System.out.println("Error: Espacio insuficiente \n");
			    			}
			    			System.out.println("ESPDIPS: "+memo.espaciosDisp);
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
	    			case 7://Mover a SWAP
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
	    			case 8:// Mover a RAM
	    				System.out.println("Cual es la tarea que deseas mover? ");
	    				hdd.VerTareas();
	    				id=sc.nextInt();
	    				memo.Insert( hdd.finT[id]-hdd.iniT[id]+1 );
	    				hdd.EliminarID(id);
	    				
	    				System.out.println("RAM\n");
	    				memo.VerRam();
    					System.out.println("SWAP\n");
    					hdd.VerRam();
	    				break;
	    			case 9: //Ver RAM y SWAP
	    				ram temp=new ram( memo.size );
	    				temp=hdd;
	    				hdd=memo;
	    				memo=temp;
	    				System.out.println("RAM\n");
    					memo.VerRam();
    					System.out.println("SWAP\n");
    					hdd.VerRam();
	    				break;
	    			case 10: //Paginación
	    				System.out.println("1) configurar por tamaño ");
	    				System.out.println("2) configurar por total de paginas ");
	    				opc=sc.nextInt();
	    				if( opc==1 ) {
	    					System.out.println("dar el tamaño deseado");
	    					t1=sc.nextInt();
	    				}
	    				else {
	    					System.out.println("dar el total de paginas");
	    					t3=sc.nextInt();
	    					t1=memo.size/t3;
	    				}
	    					
	    					pos=1;
	    					
	    					t2=1;
	    					for(int i=1;i<=memo.size;i++) {
	    						if( i%t1==0 ) {
	    							if( t2!=1 ) {
	    								for(int j=1;j<=pos;j++)
	    									System.out.println(vis[j]+" ");
	    								pos=1;
	    							}
	    								
	    							System.out.println("pagina #"+t2);
	    							t2++;
	    						}
	    						if( memo.arr[i]!=0 && memo.arr[i]!=vis[pos-1])
	    							vis[pos++]=memo.arr[i];

	    							
	    					}
	    				
	    				break;
	    				
	    			default: break;
    				
    			}
    		}//Fin while  del menú
    	}
}
