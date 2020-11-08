
public class EjecutaVoltearCola {
	public static void main(String[] args) {
		Cola<Integer> per=new Cola<>(1000);
		Pila<Integer> vlt=new Pila<>(1000);
		per.Insertar(1);
		per.Insertar(2);
		per.Insertar(3);
		per.Insertar(4);
		per.Insertar(5);
		System.out.println( per.toString() );
		System.out.println( per.Eliminar() );

		System.out.println( per.toString() );
		per.Insertar(6);
		System.out.println( per.toString() );
		while( !per.Vacio() ) 
			vlt.Insertar( per.Eliminar()  );
		while( !vlt.Vacio() )
			per.Insertar( vlt.Eliminar() );
		System.out.println( per.toString() );
	}
}
