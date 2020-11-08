package llaves;

import java.util.ArrayList;
import java.util.Iterator;

public class Pila<T> {
	T[] arr;
	int tam=10,ini=-1;
	public Pila(int ttt){
		tam=ttt;
		ini=-1;
		arr=(T[]) new Object[ttt];
	}
	
	public boolean Vacio() {
		return ini==0;
	}
	public boolean llena(){
		return ini==tam;
	}
	public void Insertar( T cosa ) {
		if( !llena() ) {
			arr[ ++ini ]=cosa;
			///System.out.println( arr[ini] );
		}
		else
			throw new RuntimeException("no caben mas");
	}
	public String toString() {
		String Cadena="";
		for(int i=ini;i>=0;i--) {
			Cadena+=arr[i];
			Cadena+="/n";
		}
		return Cadena;
	}
	public T Eliminar() {	
		return arr[ini--];
	}
	

	
}
