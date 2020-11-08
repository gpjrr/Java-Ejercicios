public class Pila<T>{
	int tot;
	Nodo raiz;
	
	public Pila() {
		raiz=null;
		//raiz.nxt=null;
		tot=0;
	}
	public void Insertar(T tipejo,String  cosa) {
		Nodo<T> nov=new Nodo<>(tipejo,cosa);
		tot++;
		if( raiz==null ) {
			raiz=nov;
		}
		else {
			nov.nxt=raiz;
			raiz=nov;
		}
	}
	public String Eliminar() {
		tot--;
		String temp=raiz.dato;
		raiz=raiz.nxt;
		return temp;
	}
}
