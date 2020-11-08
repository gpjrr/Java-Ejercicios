
public class Nodo<T> {
	T dato;
	Nodo<T> nxt,prv;
	public Nodo( T  cosa) {
		dato=cosa;
		nxt=null;
		//System.out.print( dato.getClass().getName() +" ");
	}
	public String toString() {
		String cad="";
		cad+=dato;
		return cad;
	}
}
