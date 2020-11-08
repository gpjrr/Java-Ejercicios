
public class Nodo<T> {
	T dato;
	Nodo<T> nxt;
	public Nodo( T  cosa) {
		dato=cosa;
		//System.out.print( dato.getClass().getName() +" ");
		nxt=null;
	}
	public String toString() {
		String cad="";
		cad+=dato;
		return cad;
	}
}
