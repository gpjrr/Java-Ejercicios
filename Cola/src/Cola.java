
public class Cola {
	int ini,fin;
	String[] arr=new String[100];
	public Cola() {
		ini=fin=-1;
	}
	public void Insertar( String cosa ) {
		arr[++fin]=cosa;
	}
	public String Eliminar() {
		return arr[++ini];
	}
	public String toString() {
		String ans=new String();
		for(int i=ini+1;i<=fin;i++) {
			ans+=arr[i];
			ans+="\n";
		}
		return ans;
	}
}
