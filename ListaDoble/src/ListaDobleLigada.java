
public class ListaDobleLigada<T> {
	Nodo ini;
	Nodo fin;
	public ListaDobleLigada() {
		ini=null;
		fin=null;
	}
	public void Insertar(T cosa) {
		Nodo<T> nov=new Nodo<>(cosa);
		if( ini==null ) {
			ini=nov;
			fin=nov;
		}
		else {
			fin.nxt=nov;
			nov.prv=fin;
			fin=nov;
		}
	}
	public int contar(){
		int cont=0;
		Nodo tem=ini;
		while( tem!=null ) {
			cont++;
			tem=tem.nxt;
		}
		return cont;
	}
	public String toString() {
		String cad="";
		Nodo tem=ini;
		while( tem!=null ) {
			cad+=tem.dato;
			cad+=" ";
			tem=tem.nxt;
		}
		return cad;
	}
	public String  Resort() {
		Nodo tem;
		int tot=contar();
		if( tot>(int)fin.dato )
			return "no es posible, hay pocos elementos";
		if( (int)fin.dato==1 ) {
			fin.prv.nxt=null;			
			tem=fin;
			fin=fin.prv;
			
			ini.prv=tem;
			tem.nxt=ini;
			ini=tem;
			
		}
		else {
			int pos=1;
			tem=ini;
			while( pos+1<(int)fin.dato  ) {
				pos++;
				tem=tem.nxt;
			}
			Nodo tem2=fin;
			fin.prv.nxt=null;
			fin=fin.prv;
			tem2.prv=tem;
			tem.nxt=tem2;
			
			tem2.nxt=tem.nxt;
			tem.nxt.prv=tem2;
		
			
		}		
		return "es posible, ya fue reordenado";
	
	}

}
