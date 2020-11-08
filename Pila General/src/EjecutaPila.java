import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class EjecutaPila {
	public static void main(String[] args) {
		Pila<Integer> platos=new Pila<>(100);
		
		//platos.crear(  tem );
		platos.Insertar(10);
		platos.Insertar(45);
		platos.Insertar(12);
		System.out.println( platos.toString() );
		platos.Eliminar();
	}
}


