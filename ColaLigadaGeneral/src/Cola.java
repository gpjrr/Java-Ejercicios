
public class Cola<T>{
	int tot;
	Nodo ini;
	Nodo fin;
	
	public Cola() {
		ini=null;
		fin=null;
		//raiz.nxt=null;
		tot=0;
	}
	
	public void Insertar(Nodo nov) {
		//Nodo<T> nov=new Nodo<>(cosa);
		tot++;
		if( ini==null ) {
			ini=nov;
			fin=nov;
			//System.out.println("funciona\n ");
		}
		else {
			fin.nxt=nov;
			fin=nov;
		}
	}
	
	public String toString() {
		String cad="";
		Nodo<T> tem=ini;
		while( tem!=null ) {
			cad+=tem.dato;
			cad+=" ";
			tem=tem.nxt;
		}
		return cad;
	}
	
	public void Eliminar() {
		tot--;
		System.out.print( ini.dato+" " );
		ini=ini.nxt;
	}
}
