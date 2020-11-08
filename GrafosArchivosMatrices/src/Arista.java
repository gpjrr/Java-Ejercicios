
public class Arista implements Comparable<Arista>{
	int Nod1,Nod2,Dis;
	
	public Arista(int n1,int n2,int ds) {
		Nod1=n1;
		Nod2=n2;
		Dis=ds;
	}
	void Crear(int n1,int n2,int ds) {
		Nod1=n1;
		Nod2=n2;
		Dis=ds;
	}
	
	public int compareTo(Arista arg0) {
		if( this.Dis < arg0.Dis )
		return -1;
		else
		return 1;
	}
	
}
