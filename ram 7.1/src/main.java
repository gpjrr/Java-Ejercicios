import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class main {    
    	public static void main(String[] args) {
    		int n;
    		int Taskcon=0;
    		Random stupid= new Random(); 
    		Scanner sc = new Scanner(System.in);
    		int t1,t2,t3; /// variables temporales 
    		System.out.println("Especifique tamaño de RAM: ");
    		ram memo=new ram( sc.nextInt() );
    		ram hdd=new ram( memo.size );
    		Taskcon=0;
    		int opc=-1;
    		while( opc!=11 ) {
    			System.out.println("  1) Crear Tarea");
    			System.out.println("  2) Ver distribuciones de almacenamiento");
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
	    			case 1: System.out.println("---------------- CREAR TAREA ----------------");
	    					System.out.println("Tamaño de la tarea: "); //Creación de tarea
	    					Taskcon++;
	    					if(memo.espaciosDisp==0) { //Si RAM está al 100% 
			    				if ( hdd.Insert( sc.nextInt(),Taskcon )==true ) { //Inserción directa en SWAP
			    					System.out.println("Tarea creada\n");
			    					hdd.ActLista();
			    					memo.setTask(memo.getTask()+1);
		    					}
			    				else {
				    					System.out.println("Error: Espacio insuficiente \n");
				    					Taskcon--;
				    			}
			    			}
	    					else
	    					if(memo.espaciosDisp<=(int)(memo.size*0.30)) { //Si solo queda el 30% o menos
			    				/*empiezo a condicionar aleatorio*/
			    				
		    					int rando=( stupid.nextInt()%2 ) ;
		    					memo.resort();
		    					if( rando%2==0 ) {
		    						if (  memo.Insert( sc.nextInt(), Taskcon )==true ) {
				    					System.out.println("Tarea creada\n");
				    					memo.ActLista();
			    					}
				    				else {
				    					System.out.println("Error: Espacio insuficiente \n");
				    					Taskcon--;
				    				}
				    			}
		    					else {
		    						hdd.setTask(memo.getTask());
		    						if ( hdd.Insert( sc.nextInt(),Taskcon )==true ) {
				    					System.out.println("Tarea creada\n");
				    					hdd.ActLista();
				    					memo.setTask(memo.getTask()+1);
			    					}
		    						else {
				    					System.out.println("Error: Espacio insuficiente \n");
				    					Taskcon--;
				    				}
		    					}
			    			}
			    			else{ //Si no insertar directo en RAM
			    				if (  memo.Insert( sc.nextInt(),Taskcon )==true ) {
			    					System.out.println("Tarea creada\n");
			    					memo.ActLista();
		    					}
			    				else {
			    					System.out.println("Error: Espacio insuficiente \n");
			    					Taskcon--;
			    				}
			    			}
			    			System.out.println("RAM:  ");
	    					memo.VerRam();
	    					System.out.println("SWAP: ");
	    					hdd.VerRam();
	    				break;
	    			case 2:System.out.println("---------------- VER DISTRIBUCIONES ----------------"); 
		    				System.out.println("RAM:  ");
	    					memo.VerRam();
	    					System.out.println("SWAP: ");
	    					hdd.VerRam();
	    				break;
	    			case 3:System.out.println("---------------- VER LISTA DE TAREAS ----------------"); 
	    					memo.VerListaLigadaTask(); //Ver lista de tareas
	    				break;
	    			case 4: System.out.println("---------------- DESPACHAR PRIMER TAREA ----------------");
	    					int pos=1; //Eliminar primer tarea
		            		while( memo.arr[pos]==0 && pos<=memo.size ) pos++;
		            		int tip=memo.arr[pos];
			            		if(  tip!=0 ) {
			            			memo.EliminarID( tip );
			            			memo.ActLista();
			            		}
		            			else
		            			System.out.println("Error: No existen tareas \n");
		            		
			            		System.out.println("RAM:  ");
		    					memo.VerRam();
	    				break;
	    			case 5: System.out.println("---------------- ELIMINAR TAREA POR ID ----------------");
	    					memo.VerRam(); //Eliminar cualquier tarea
	    					memo.VerTareas();
		                	System.out.println("Proporcione ID de tarea a eliminar: ");		
		                	memo.EliminarID( sc.nextInt() );   
		                	memo.ActLista();
		                	
		                	System.out.println("RAM:  ");
	    					memo.VerRam();
	    					System.out.println("SWAP: ");
	    					hdd.VerRam();
	    				break;
	    			case 6: System.out.println("---------------- MAPA DE BITS ----------------");
	    				System.out.println("RAM\n");
	    				memo.verMapa();
    					System.out.println("SWAP\n");
    					hdd.verMapa();;
	    					
	    				break;
	    			case 7:System.out.println("---------------- MOVER TAREA A SWAP ----------------");
	    				System.out.println("Cual es la tarea que deseas mover? ");
	    				memo.VerRam(); 
	    				memo.VerTareas();
	    				int id=sc.nextInt();
	    				if(hdd.espaciosDisp>=memo.finT[id]-memo.iniT[id]+1) {
		    				hdd.Insert( memo.finT[id]-memo.iniT[id]+1, id );
		    				memo.EliminarID(id);
		    				//hdd.modificarID(hdd.taskn, id);
		    				
		    				System.out.println("RAM:  ");
	    					memo.VerRam();
	    					System.out.println("SWAP: ");
	    					hdd.VerRam();
	    					
	    					
	    				}
	    				else
	    					System.out.println("Espacio insuficiente. No se realizaron cambios.");
	    				hdd.ActLista();
    					memo.ActLista();
	    				break;
	    			case 8:System.out.println("---------------- MOVER TAREA A RAM ----------------");
	    				System.out.println("Cual es la tarea que deseas mover? ");
	    				hdd.VerRam();
	    				hdd.VerTareas();
	    				id=sc.nextInt();
	    				if(memo.espaciosDisp>=hdd.finT[id]-hdd.iniT[id]+1) {
		    				memo.Insert( hdd.finT[id]-hdd.iniT[id]+1,id );
		    				hdd.EliminarID(id);
		    				//memo.modificarID(memo.taskn, id);
		    				
		    				System.out.println("RAM:  ");
	    					memo.VerRam();
	    					System.out.println("SWAP: ");
	    					hdd.VerRam();
	    					
	    				
	    				}
	    				else
	    					System.out.println("Espacio insuficiente. No se realizaron cambios.");
	    				
	    				hdd.ActLista();
    					memo.ActLista();
	    				break;
	    			case 9: System.out.println("---------------- INTERCAMBIO RAM<->SWAP ----------------");
	    				ram temp=new ram( memo.size );
	    				temp=hdd;
	    				hdd=memo;
	    				memo=temp;
	    				
	    				System.out.println("RAM:  ");
    					memo.VerRam();
    					System.out.println("SWAP: ");
    					hdd.VerRam();
	    				break;
	    			case 10: System.out.println("---------------- PAGINACIÓN ----------------");
		    				System.out.println("1) Configurar por tamaño de página");
		    				System.out.println("2) Configurar por total de páginas");
		    				System.out.println("OPCION: ");
		    				opc=sc.nextInt();
		    				//Determinamos el tamaño de nuestras páginas
		    				if(opc==1) {
		    					System.out.println("Proporcione tamaño de página: ");
		    					t1=sc.nextInt(); //tam pag
		    					t3=(int)memo.size/t1; //num pags
		    				}
		    				else {
		    					System.out.println("Proporcione total de páginas: ");
		    					t3=sc.nextInt(); //num pags
		    					t1=(int)memo.size/t3; //tam pag
		    				}
		    				int []pag=new int[t1]; 
		    				int casillaArr=1;
		    				t2=1; //Numero de paginas
		    				boolean termina=false; //Verificará si ya se revisó todos los espacios de almacenamiento
	    					do {
	    						System.out.print("\nPág. #"+t2+ " -> ");
		    					for(int j=0;j<t1;j++) {
		    						pag[j]=memo.arr[casillaArr];
		    						if(j==0)//Si es el primer elemento de pag
		    							System.out.print(pag[j]+", ");
		    						else {//Si son los sigueintes
		    							if(pag[j]!=pag[j-1]) //Comparo si ya se escribió anteriormente
			    							System.out.print(pag[j]+", ");
		    						}
		    						casillaArr++;
		    					}
		    					t2++;
	    					}while(t2<=t3);

		    				System.out.println("\n");
	    				break;
	    				
	    			default: break;
    				
    			}//Fin del switch
    		}//Fin while  del menú
    	}//Fin del main static
}
