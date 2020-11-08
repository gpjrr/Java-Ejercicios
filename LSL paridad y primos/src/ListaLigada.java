
public class ListaLigada<T> {
	Nodo ini;
	Nodo fin;
	
	public ListaLigada() {
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
			if( (int)cosa%2==0 ) {
				nov.nxt=ini;
				ini=nov;
				//System.out.println("___"+ini.nxt.dato);
			}
			else {
				fin.nxt=nov;
				fin=nov;
				
			}
		}
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

	public void EliminarPrimos() {
		Nodo tem=ini;
		Nodo pst=null;
		
		while( tem!=null ) {
			if( tem.SoyPrimo() ) {
				System.out.println(tem.dato+" ES primo");
				if( tem==ini ) {
					ini=tem.nxt;
					tem=ini;
					pst=null;
				}
				else
				if( tem==fin ) {
					if( fin==ini )
						ini=fin=null;
					else {
						pst.nxt=null;
						fin=pst;	
					
					}
					break;
				}
				else {
					pst.nxt=tem.nxt;
					tem=tem.nxt;
				}
				/*
				if( pst!=null )
					System.out.println(".p."+pst.dato);
				if( tem!=null )
					System.out.println(".n."+tem.dato);
				*/
			}
			else {
				System.out.println(tem.dato+" no es primo");
				pst=tem;
				tem=tem.nxt;
				/*
				if( pst!=null )
					System.out.println("_p_"+pst.dato);
				if( tem!=null )
					System.out.println("_n_"+tem.dato);
				*/
			}
			
		}
	}

}
