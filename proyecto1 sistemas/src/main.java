import java.io.*;
import java.util.Scanner;
import java.util.Random;


public class main {
	public static void main (String [] args ) {
		int opc=0,miniopc;
		Scanner sc=new Scanner(System.in);
		Memoria Ram,HDD;
		int t1,t2,t3;
		String temp;
		
		System.out.println("  Dar el tamano de la memoria");
		t1=sc.nextInt();
		Ram=new Memoria( t1 );
		HDD=new Memoria( t1 );
		while( opc!=10 ) {
			System.out.println("  1) Crear Tarea");
			System.out.println("  2) Despachar Tarea ");
			System.out.println("  3) Cambiar estado de las Tareas");
			System.out.println("  4) Cambiar el tamaño de alguna tarea");
			System.out.println("  5  Ver el arreglo de Ram");
			System.out.println("  6) Ver el Mapa de bits de Ram");
			System.out.println("  7) Ver lista ligada de Ram");
			System.out.println("  8) Ver el arreglo de HDD");
			System.out.println("  9) Lista de procesos");
			System.out.println("  10) Salir");
			
			opc=sc.nextInt();
			
			switch(opc) {
				case 1:
					/////// Crear Tarea
					System.out.println("Dar el tamano de la tarea ");
					t1=sc.nextInt();
					System.out.println("Dar el nombre de la Tarea ");
					temp=sc.nextLine();
					temp=sc.nextLine();
					
					if( Ram.Insert( new Task(t1,temp,-1)  )!=true   ) {
						
						if( Ram.empty+HDD.empty<t1 )
							System.out.println("ERROR No hay espacio en ningun dispositivo");
						for(int i=1;i<=Ram.pos;i++)
							if( Ram.arr[i].live==true && Ram.arr[i].state<=2 && Ram.arr[i].Size<=HDD.empty ) {
								HDD.Insert( Ram.arr[i].clone() );
								System.out.println("La tarea "+Ram.arr[i].Name+" fue movida");
								Ram.Delete( i );																				
							}
								
						if( Ram.empty<t1  )
							System.out.println("ERROR todas las tareas estan en ejecucion");
						else 
							Ram.Insert( new Task(t1,temp,-1)  );
								
						
					}
					System.out.println( Ram.Arreglo() );
					System.out.println( Ram.ViewTask() );
					break;
				case 2:
					////////////////////  Despachar Tarea
					if( Ram.pos==0 ) {
						System.out.println("no hay tareas");
						break;
					}
					System.out.println("1) Primer tarea de la pila");
					System.out.println("2) Dar el nombre de la Tarea");
					miniopc=sc.nextInt();
					if( miniopc==1 )
						Ram.Delete( Ram.pos );
					else {
						System.out.println("Selecciona la Tarea a borrar:\n");
						System.out.println( Ram.ViewTask() );
						String letra=sc.nextLine();
						letra=sc.nextLine();
						for(int i=1;i<=Ram.pos;i++) 
						if( Ram.arr[i].Name.equals(letra)==true ){
							Ram.Delete( i);
							break;
						}
						
					}
					System.out.println( Ram.Arreglo() );
					break;
				case 3:
					////////////Cambiar estado de las Tareas
					System.out.println("1) RAM");
					System.out.println("2) HDD");
					miniopc=sc.nextInt();
					if( miniopc==1 ) {
					
						System.out.println("1) Cambiarlo a todas las tareas");
						System.out.println("2) Seleccionar una tarea");
						miniopc=sc.nextInt();
						if( miniopc==1 )
							Ram.shuffle( 1, Ram.size );
						else {
							System.out.println("Selecciona la Tarea:\n");
							System.out.println( Ram.ViewTask() );
							
							String letra=sc.nextLine();
							letra=sc.nextLine();
							
							System.out.println("Selecciona el estado:");
							System.out.println("0) aleatorio");
							System.out.println("1) espera");						
							System.out.println("2) listo");
							System.out.println("3) ejecucion");						
							miniopc=sc.nextInt();
							for(int i=1;i<=Ram.pos;i++) 
							if( Ram.arr[i].Name.equals(letra)==true ){
								if(miniopc==0)
								Ram.shuffle(i, i);
								else
								Ram.arr[i].state=miniopc;
								break;
							}
							
						}
					}
					else {
						System.out.println("1) Cambiarlo a todas las tareas");
						System.out.println("2) Seleccionar una tarea");
						miniopc=sc.nextInt();
						if( miniopc==1 )
							HDD.shuffle( 1, HDD.size );
						else {
							System.out.println("Selecciona la Tarea:\n");
							System.out.println( HDD.ViewTask() );
							
							String letra=sc.nextLine();
							letra=sc.nextLine();
							
							System.out.println("Selecciona el estado:");
							System.out.println("0) aleatorio");
							System.out.println("1) espera");						
							System.out.println("2) listo");
							System.out.println("3) ejecucion");						
							miniopc=sc.nextInt();
							for(int i=1;i<=HDD.pos;i++) 
							if( HDD.arr[i].Name.equals(letra)==true ){
								if(miniopc==0)
								HDD.shuffle(i, i);
								else
								HDD.arr[i].state=miniopc;
								break;
							}
							
						}
					}
					System.out.println("update:\n"+HDD.ViewTask());
					break;
				case 4:
					///// Cambiar el tamaño de alguna tarea
					System.out.println("Selecciona la Tarea\n"+Ram.ViewTask()); 
					
					String letra=sc.nextLine();
					letra=sc.nextLine();
					for(int i=1;i<=Ram.pos;i++) 
					if( Ram.arr[i].Name.equals(letra)==true ){
						t1=i;
						break;
					}
					t2=(Ram.arr[t1].Size+Ram.empty); 
					while( true ) {
						System.out.println("Dar el tamano nuevo 0<x<"+t2);
						t3=sc.nextInt();
						if( 1<=t3 && t3<=t2 )  
							break;
						else
							System.out.println("ERROR, dar un valor correcto");
					}
			
					Ram.Delete( t1 );
					Ram.Insert( new Task(t3, Ram.arr[t1].Name, Ram.arr[t1].state) );
					System.out.println( Ram.Arreglo() );
					break;
				case 5:
					////// Ver el arreglo de Ram
					System.out.println("El arreglo es\n"+Ram.Arreglo());
					
					break;
				case 6:
					 ///  Ver el Mapa de bits de Ram
					System.out.println("El Mapa es\n"+Ram.Mapa());
					break;
				case 7:
					////  Ver lista ligada de Ram
					System.out.println("La lista ligada es\n"+Ram.ListaLigada());
					break;
				case 8:
					//// Ver el arreglo de HDD
					System.out.println("El arreglo es\n"+HDD.Arreglo());
					break;
				case 9:
					//// Lista de procesos
					System.out.println("Los procesos Ram son:\n"+Ram.ViewTask());
					System.out.println("Los procesos HDD son:\n"+HDD.ViewTask());
					break;
				case 10:
					System.out.println("adios popo");
					break;
				default:
					System.out.println("opcion incorrecta");
					break;
					
			
			
			}
			
		}
		
		

	
	}
}
