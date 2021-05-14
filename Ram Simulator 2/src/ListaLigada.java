
public class ListaLigada<T>{	
	Nodo cola;
	public ListaLigada() {
		cola=null;
		//raiz.nxt=null;	
	}
	
	public void Insertar(T cosa) {
		Nodo<T> nov=new Nodo<>(cosa);
		if( cola==null ) 
			cola=nov;
		else {
			cola.nxt=nov;
			nov.prv=cola;
			cola=nov;
		}
	}
	
	public String toString() {
		String cad=" ";
		Nodo<T> pos=cola;
		while( pos.prv!=null )	
			pos=pos.prv;
		while( pos.nxt!=null ) {
			cad+=pos.dato+" ";
			pos=pos.nxt;
		}
			return cad;
	} 
	public Nodo<T> Buscar(T cosa) {
		Nodo<T> pos=cola;
		while( pos.dato!=cosa && pos!=null)
			pos=pos.prv;
		return pos;
	}
	
	public void Eliminar(Nodo<T> pos) {
		if( pos==null )
			return;
		pos.prv.nxt=pos.nxt;
		pos.nxt.prv=pos.prv;
	}
	public int Contar(){
		int tem=0;
		Nodo<T> pos=cola;
		while( pos!=null ) {
			tem++;
			pos=pos.prv;
		}
		return tem;
	}
	public void EliminarPares() {
		int tot=this.Contar();
	
		//for(int i=2;)
	}
}