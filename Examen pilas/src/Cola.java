
public class Cola{
	Pila p1,p2;
	
	public Cola(int tam) {
		p1=new Pila(tam);
		p2=new Pila(tam);
	}
	public void Insertar( int dato ) {
		p1.Insertar(dato);
		
	}
	public int Borrar() {
		int dato=0;
		while( p1.Vacio()!=true ) 
			p2.Insertar( p1.Borrar() );
			
	
		dato=p2.Borrar();
	
		while( p2.Vacio()!=true ) 
			p1.Insertar( p2.Borrar() );
	
		return dato;
	}

	public String Mostrar() {
		String  cad="";

		while( p1.Vacio()!=true ) 
			p2.Insertar( p1.Borrar() );
 
		while( p2.Vacio()!=true ) { 
			int t1=p2.Borrar();
			cad+=t1+" ";

			p1.Insertar( t1 );
		}
		
		return cad;
	}

	public boolean Vacio() {
		return p1.Vacio();
	}
	public boolean lleno() {
		return p1.lleno();
	}
}
