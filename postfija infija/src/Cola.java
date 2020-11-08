
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
	public String toString() {
		String cad="";
		Nodo<T> tem=ini;
		while( tem!=null ) {
			cad+=tem.dato;
			//cad+=tem.tipo+"__"+tem.dato;
			//cad+="\n";
			tem=tem.nxt;
		}
		return cad;
	}
	
	public void Insertar(T tipejo,String cosa) {
		Nodo<T> nov=new Nodo<>(tipejo,cosa);
		//System.out.println(tipejo+"..."+cosa+"\n");
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
	public String  Eliminar() {
		tot--;
		String temp=ini.dato;
		ini=ini.nxt;
		return temp;
	}
}
