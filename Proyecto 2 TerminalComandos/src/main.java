
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int op,op1,n,b;
		String txtito;
		User Usuario= new User("Users.txt");
		int NumUser=0;
		
		while(1>0) {
		
			String User="";
			do {
				System.out.println("Dar el Nombre de Usuario");
				User=sc.nextLine();
				if( Usuario.Search( User )==-1 ) 
					System.out.println("Usuario incorrecto");
				else {
					NumUser=Usuario.Search( User );
					System.out.println("Dar la contraseña");
					while(1==1) {
						if( Usuario.Paswor(NumUser,sc.nextLine())==true ){
					System.out.println("Inicio de sesion");
					break;
						}
				else
					System.out.println("contrasena incorrecta");
					}
					
				}
			}while( Usuario.Search( User )==-1 );
			
			Usuario.CommandSimulator( NumUser );
			System.out.println("sesion cerrada");
		}
			
	
		
	}
}
