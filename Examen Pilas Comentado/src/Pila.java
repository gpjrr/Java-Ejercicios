
public class Pila {
	//la pila es un arreglo
	int size;
	int[] arr;
	// n apunta a elemento en el tope 
	int n;
	// construimos el arreglo
	public Pila(int tam) {
		size=tam;
		arr=new int[tam+20];
		n=0;
	}
	// metemos el valor al final
	public void Insertar(int dato) {
		arr[++n]=dato;
	}
	/// vemos si hay elementos en la pila con el valor de n 
	public boolean Vacio() {
		return n==0;
	}
	// quitamos el ultimpo de arr y lo regresamos para manipularlo dentro de la cola
	public int Borrar( ) {
		return arr[n--];
	}
	public boolean lleno() {
		return n==size;
	}
}
