
public class Nodo<T> {
	T dato;
	Nodo<T> nxt;
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
	public boolean SoyPrimo() {
		int div=0;
		for(int i=1;i<=(int)dato;i++) 
			if( (int)dato%i==0 )
				div++;
		return (div==2);
	}
}
