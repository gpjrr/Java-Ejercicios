
import java.util.ArrayList;
import java.util.Iterator;

public class Cola<T>{
	T[] arr;
	int tam=10,ini=-2,fin=-2;
	public Cola(int ttt){
		tam=ttt;
		ini=-1;
		fin=-1;
		arr=(T[]) new Object[ttt];
	}
	
	public boolean Vacio() {
		return ini==0;
	}
	public boolean llena(){
		return fin==tam;
	}
	public void Insertar( T cosa ) {
		if( !llena() ) {
			arr[ ++fin ]=cosa;
			///System.out.println( arr[ini] );
		}
		else
			throw new RuntimeException("no caben mas");
	}
	public String toString() {
		String Cadena="";
		for(int i=ini+1;i<=fin;i++) {
			Cadena+=arr[i];
			Cadena+=' ';
		}
		return Cadena;
	}
	public T Eliminar() {	
		return arr[++ini];
	}
}
