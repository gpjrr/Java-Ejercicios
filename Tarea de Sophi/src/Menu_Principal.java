import java.util.Scanner;

public class Menu_Principal {
	
	public static void main(String[] args) {
		int n=0;
		int Contador;
		Productos[] Arr= new Productos[1010];
		int Opc=-1;
		Scanner sc=new Scanner( System.in );
		for(int i=0;i<100;i++)
			Arr[i]=new Productos("","",0);
		while( Opc!=3 ){
			System.out.println("1) Nuevo Producto \n");
			System.out.println("2) Ver Productos \n");
			System.out.println("3) Salir\n");
			/////System.out.println("3) \n");
			Opc=sc.nextInt();
			String Tem,temo;
			if( Opc==1 ) {
				System.out.println("Dar el nombre ");
				sc.nextLine();
				Tem=sc.nextLine();
				///System.out.println("Tem="+Tem);
				Arr[n].Nombre=Tem;
				
				System.out.println("Dar las Caracteristicas \n");
				
				temo=sc.nextLine();
				//System.out.println("Tem="+temo);
				Arr[n].setDescripcion( temo );
				
				System.out.println("Dar el precio \n");
				
				Arr[n].setPrecio( sc.nextInt() );
		
				Arr[n].Id=n++;
			}
			if( Opc==2 ){
			
				for(int i=0;i<n;i++)
					System.out.println (Arr[i].toString() );	
				
			}
			if( Opc==3 ){
				break;
			}
			
			
			
		}
		
	
	
	}
	
	
}
