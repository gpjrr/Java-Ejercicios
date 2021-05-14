
public class Pila {

	int size;
	int[] arr;
 
	int n;

	public Pila(int tam) {
		size=tam;
		arr=new int[tam+20];
		n=0;
	}

	public void Insertar(int dato) {
		arr[++n]=dato;
	}
 
	public boolean Vacio() {
		return n==0;
	}

	public int Borrar( ) {
		return arr[n--];
	}
	public boolean lleno() {
		return n==size;
	}
}
