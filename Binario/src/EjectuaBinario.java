import java.util.Scanner;

public class EjectuaBinario {
	public static void main(String[] args) {
		Scanner sc=new Scanner( System.in );
		System.out.println("dar un numero en decimal");
		int num=sc.nextInt();
		Pila<Integer> dig=new Pila<>(100);
		
		while( num>0 ){
			dig.Insertar( num%2 );
			num/=2;
		}
		System.out.println( dig.toString() );
	}
}
