import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class main {    
    	public static void main(String[] args) {
    		int n, modoPaginación=0;
    		
    		int Taskcon=0;
    		Random stupid= new Random(); 
    		Scanner sc = new Scanner(System.in);
    		int t1,t2,t3; /// variables temporales 
    		System.out.println("Especifique tamaño de RAM: ");
    		ram memo=new ram( sc.nextInt() );
    		ram hdd=new ram( memo.size );
    		
    		//Configuración para las páginas de la RAM
    		System.out.println("1) Configurar por tamaño de página");
			System.out.println("2) Configurar por total de páginas");
			System.out.println("OPCION: ");
			modoPaginación=sc.nextInt();
			if(modoPaginación==1) {
				System.out.println("Proporcione tamaño de página: ");
				t1=sc.nextInt(); //tam pag
				t3=memo.size/t1; //num pags
				if( memo.size%t1>0 )
					t3++;
			}
			else {
				System.out.println("Proporcione total de páginas: ");
				t3=sc.nextInt(); //num pags
				t1=memo.size/t3; //tam pag
				if( memo.size%t3>0 )
					t1++;
			}
			int pagsGeneradas=t3;
			//ArrPags=new Paginas[100]; //Se crea el arreglo  para las páginas
		
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
	    			case 3:System.out.println("---------------- VER LISTA DE TAREAS EN RAM ----------------"); 
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
	    				Paginas[] ArrPags=new Paginas[100];
	    				//int[] pagTask=
	    						 
	    				//for(int i=0;i<999;i++) pagTask[i]=0;
	    				
	    				for(int i=0;i<90;i++)
	    				ArrPags[i]=new Paginas(i, new int[1010] );
	    				
	    			///System.out.println("t1="+t1+ " t3="+t3);
	    			//t1 tamano de la pagina
	    			//t3 total de paginas
	    			//------------Generar llenado de páginas, actualizándose cada vez que se entra a esta opcion-----------------
			    			
		    				
			    			int casillaArr=1;//recorre arr de ram
		    				
		    				t2=1; //Numero de paginas
		    				
							for(;t2<=t3;t2++) {
								//
								//ArrPags[t2]=new Paginas(t2,pagTask);
								//System.out.println("t2==="+t2+" cas=="+casillaArr);
								for(int j=1;j<=t1;j++) 
									ArrPags[t2].insert(j,memo.arr[casillaArr++]);
									//System.out.println("\n\**+paux.tareas[j]);
									///// PROBLEMA CON LA ASIGNACION A ARREGLO DE PAGINAS :(
							
							/*
								for(int o=1;o<=t1;o++)
									System.out.print(ArrPags[t2].tareas[o]+ " ");
								System.out.print("\n");
							
								System.out.println("t1="+t1+ " t3="+t3);
								for(int i=1;i<=t2;i++) {
									System.out.print("\nPág. #"+ArrPags[i].idPagina+" errores="+ArrPags[i].contError+'\n');
									for(int j=1;j<=t1;j++) {
										System.out.print(i+"_"+j+"=");
										System.out.print(ArrPags[i].tareas[j]+"\n");
									}
								}
								*/
							}
				
							
							
					//--------Menu de paginación----------------
							do {
								System.out.println("\n\n1) Ver páginas");
		    					System.out.println("2) Ejecutar 1 ciclo");
		    					System.out.println("3) Ejecutar N ciclos");
		    					System.out.println("4) Regresar");
		    					opc=sc.nextInt();
		    					switch(opc) {
									case 1:System.out.println(">>>>>>>>> Páginas <<<<<<<<<");
										for(int k=1;k<=t3;k++) 
											if( ArrPags[k].live==true ){
											System.out.print("\nPág. #"+ArrPags[k].idPagina+" errores="+ArrPags[k].contError+'\n');
											for(int j=1;j<=t1;j++) 
												if(ArrPags[k].tareas[j]!=ArrPags[k].tareas[j-1])
													System.out.print(ArrPags[k].tareas[j]+", ");
											}
										
										break;
									case 2:System.out.println(">>>>>>>>> Ejecución ciclo <<<<<<<<<");
										int con=0;
										for(int i=1;i<=t3;i++) 
											if( ArrPags[i].live==true ){
												ArrPags[i].ejecutarCiclo();
												
												if(ArrPags[i].tieneError()) {
													ArrPags[i].live=false;
													con++;
													for(int k=1;k<=t1;k++) {
														int pipi;
														pipi=ArrPags[i].tareas[k];
												
														ArrPags[t3+con].insert(k, pipi );
														
													}
												}
											}
										t3+=con;
										for(int k=1;k<=t3;k++) 
											if( ArrPags[k].live==true ){
											System.out.print("\nPág. #"+ArrPags[k].idPagina+" errores="+ArrPags[k].contError+'\n');
											for(int j=1;j<=t1;j++) 
												if(ArrPags[k].tareas[j]!=ArrPags[k].tareas[j-1])
													System.out.print(ArrPags[k].tareas[j]+", ");
											}
										
										
										break;
									case 3: System.out.println(">>>>>>>>> Ejecución N ciclos <<<<<<<<<");
										System.out.println("¿Cuántas ejecuciones desea realizar?");
										int ejecuciones=sc.nextInt();
										int cono=0;
										for(int j=0;j<ejecuciones;j++) {
											
											for(int i=1;i<=t3;i++) 
												if( ArrPags[i].live==true ){
													ArrPags[i].ejecutarCiclo();
													
													if(ArrPags[i].tieneError()) {
														ArrPags[i].live=false;
														cono++;
														for(int k=1;k<=t1;k++) {
															int pipi;
															pipi=ArrPags[i].tareas[k];
													
															ArrPags[t3+cono].insert(k, pipi );
															
														}
													}
												}
											
										}
										
										t3+=cono;
										for(int k=1;k<=t3;k++) 
											if( ArrPags[k].live==true ){
											System.out.print("\nPág. #"+ArrPags[k].idPagina+" errores="+ArrPags[k].contError+'\n');
											for(int j=1;j<=t1;j++) 
												if(ArrPags[k].tareas[j]!=ArrPags[k].tareas[j-1])
													System.out.print(ArrPags[k].tareas[j]+", ");
											}
										
										
										break;
										
		    						default: System.out.println("opcion invalida"); break;
		    						
		    					}
							}while(opc!=4);
	 
		    				System.out.println("\n");
	    				break;
	    				
	    			default: break;
    				
    			}//Fin del switch
    		}//Fin while  del menú
    	}//Fin del main static
}
