
public class Nodo<T> {
	T dato;
	Nodo<T> nxt,prv;
	public Nodo( T  cosa) {
		dato=cosa;
		//System.out.print( dato.getClass().getName() +" ");
		prv=nxt=null;
		
	}
	public String toString() {
		String cad="";
		cad+=dato;
		return cad;
	}
}
