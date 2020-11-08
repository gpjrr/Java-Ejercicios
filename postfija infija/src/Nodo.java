
public class Nodo<T> {
	T tipo;
	String dato;
	
	Nodo<T> nxt;
	/// tipo 1 = valor 
	/// tipo 2 = operador
	public Nodo(T tipejo,String  valor) {
		dato=valor;
		tipo=tipejo;
		//System.out.print( dato.getClass().getName() +" ");
		nxt=null;
	}
}
