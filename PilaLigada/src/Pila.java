
public class Pila<T>{
	int tot;
	Nodo raiz;
	
	public Pila() {
		raiz=null;
		//raiz.nxt=null;
		tot=0;
	}
	
	public void Insertar(T cosa) {
		Nodo<T> nov=new Nodo<>(cosa);
		tot++;
		if( raiz==null ) {
			raiz=nov;
		}
		else {
			nov.nxt=raiz;
			raiz=nov;
		}
	}
	
	public String toString() {
		String cad="";
		Nodo<T> tem=raiz;
		while( tem!=null ) {
			cad+=tem.dato;
			cad+="\n";
			tem=tem.nxt;
		}
		return cad;
	}
	
	public void Eliminar() {
		tot--;
		System.out.print( raiz.dato+" " );
		raiz=raiz.nxt;
	}
}
