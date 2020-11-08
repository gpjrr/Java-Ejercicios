package pila;

public class Pila {
	int ini;
	String[] arr=new String[100];
	public Pila() {
		ini=-1;
	}
	public void Insertar( String cosa ) {
		arr[++ini]=cosa;
	}
	public String toString() {
		String ans=new String();
		for(int i=0;i<=ini;i++) {
			ans+=arr[i];
			ans+="\n";
		}
		return ans;
	}
	public String Eliminar() {
		return arr[ini--];
	}
}
