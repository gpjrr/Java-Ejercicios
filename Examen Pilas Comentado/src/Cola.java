
public class Cola{
	Pila p1,p2;
	
	public Cola(int tam) {
		// creamos las 2 pilas para manejar la cola
		p1=new Pila(tam);
		p2=new Pila(tam);
	}
	public void Insertar( int dato ) {
		// el dato se guarda en la primer pila
		p1.Insertar(dato);
		
	}
	public int Borrar() {
		// dato va a tener el elemento borrado para mostrarlo
		int dato=0;
		// pasamos los elementos de la primer pila a la segunda
		while( p1.Vacio()!=true ) 
			p2.Insertar( p1.Borrar() );
			
		// tomamos el ultimo elemento de la segunda pila
		dato=p2.Borrar();
		// los regresamos a la primer pila
		while( p2.Vacio()!=true ) 
			p1.Insertar( p2.Borrar() );
		// regresamor el valor
		return dato;
	}
	// regresa un string para mostrar la cola en orden
	public String Mostrar() {
		String  cad="";
		// los volvemos a mover
		// los pasamos a la segunda pila
		while( p1.Vacio()!=true ) 
			p2.Insertar( p1.Borrar() );
				// y conforme los vamos regresando son guardados en cad 
		while( p2.Vacio()!=true ) { 
			int t1=p2.Borrar();
			cad+=t1+" ";
			// aqui se insertan a la primer pila
			p1.Insertar( t1 );
		}
		
		return cad;
	}
	// para ver si no hay en la cola elementos checamos si hay elementos en la primer pila
	public boolean Vacio() {
		return p1.Vacio();
	}
	public boolean lleno() {
		return p1.lleno();
	}
}
