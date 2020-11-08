
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
			fin=fin.nxt;
			fin.nxt=null;
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
			///System.out.print(tem.dato+"__");

			cad+=tem.dato;
			cad+=" ";
			tem=tem.nxt;
		}
		return cad;
	}
	
	public String  Resort() {
		Nodo tem,tem2;
		int tot=contar();
		System.out.print(tot+" " + (int)fin.dato+"\n");
		if( tot<(int)fin.dato )
			return "no es posible, hay pocos elementos";
		if( (int)fin.dato==1 ) {
			fin.prv.nxt=null;			
			tem=fin;
			fin=fin.prv;
			
			ini.prv=tem;
			tem.nxt=ini;
			ini=tem;
		}
		else
		if( (int)fin.dato!=tot ) {	
			int pos=1;
			tem2=fin;
			tem=ini;
			while( pos+1<=(int)fin.dato  ) {
				pos++;
				tem=tem.nxt;
			}
			if( tem.nxt==fin ) {
				tem2.prv=tem.prv;
				tem.prv.nxt=tem2;
				tem2.nxt=tem;
				tem.prv=tem2;
				tem.nxt=null;
				fin=tem;
			}
			else {
				//tem es el nodo de enmedio
				fin=tem2.prv;
			
				tem2.prv=tem.prv;
				tem.prv.nxt=tem2;
				
				tem2.nxt=tem.nxt;
				tem.nxt.prv=tem2;
				
				fin.nxt=tem;
				tem.prv=fin;
				
				tem.nxt=null;
				fin=fin.nxt;
			}
		}		
		System.out.print( toString()  );
		return "es posible, ya fue reordenado";
	
	}

}
