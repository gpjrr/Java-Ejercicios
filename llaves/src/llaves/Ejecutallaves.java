package llaves;

import java.util.Scanner;

public class Ejecutallaves {
	public static void main(String[] args) {
		String cad;
		char ltr;
		int ban=0;
		Scanner sc=new Scanner( System.in );
		
		System.out.println("dar las operaciones");
		cad=sc.nextLine();
		
		Pila<Integer> kys=new Pila<>(1000);
		kys.Insertar(-1);
		for(int i=0;i<cad.length();i++) {
			ltr=cad.charAt(i);
			if( ltr=='(' )
				kys.Insertar( 1 );
			if( ltr=='[' )
				kys.Insertar( 2 );
			if( ltr=='{' )
				kys.Insertar( 3 );
			int tem=0;
			if( ltr==')' )
				tem=1;
			if( ltr==']' )
				tem=2;
			if( ltr=='}' )
				tem=3;
			if( tem>=1 && tem!=kys.Eliminar() ) {
				ban=1;
				break;
			}
		}
		if( kys.Vacio() && ban==0 )
			System.out.println("esta balanceado");
		else
			System.out.println("NO esta balanceado");
	}
}
