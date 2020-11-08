
public class ListaDobleLigada {
	Nodo ini;
	Nodo fin;
	int Tnod;
	
	public ListaDobleLigada() {
		ini=null;
		fin=null;
		Tnod=0;
	}
	
	public void Insertar(Nodo nov) {
		Tnod++;
		if( ini==null ) {
			ini=nov;
			fin=nov;
		}
		else {
			fin.nxt=nov;
			nov.prv=fin;
			fin=nov;
			fin.nxt=ini;
			ini.prv=fin;
		}
	}
	
	public Nodo Buscar(String PaisB) {
		Nodo pos=ini;
		if( pos.Pais.equals(PaisB) )
			return pos;
		
		pos=pos.nxt;
		while( pos!=ini ) {
			if( pos.Pais.equals(PaisB) )
				return pos;
			pos=pos.nxt;
		}
		return null;
	}
	
	public void Eliminar(String name) {
		Nodo dead=Buscar( name );
		
		if( dead==null )
			return;
		Tnod--;
		if( Tnod==0 ) {
			ini=fin=null;
			return;
		}
		if( fin==dead )
			fin=fin.prv;
		if( ini==dead )
			ini=ini.nxt;
		dead.nxt.prv=dead.prv;
		dead.prv.nxt=dead.nxt;
	}

	public String Imprime() {
		String Cad="";
		Nodo pos=ini;
		if( pos==null )
			return "se acabo";
		Cad+=pos.Pais+" "+pos.Capital+"="+pos.Respuesta+" \n";
		
		while( pos.nxt!=ini ) {
			pos=pos.nxt;
			Cad+=pos.Pais+" "+pos.Capital+"="+pos.Respuesta+" \n";
		}
		return Cad;
	}

	public int Aciertos() {
		int Sum=0;
		Nodo pos=ini;
		if( pos==null )
			return 0;
		if( pos.Capital.equals(pos.Respuesta)  ) {
			pos.punto=true;
			Sum++;
		}
		
		while( pos.nxt!=ini ) {
			pos=pos.nxt;
			if( pos.Capital.equals(pos.Respuesta) ) {
				pos.punto=true;
				Sum++;
				//System.out.println( "->"+pos.Respuesta );
			}
			
		}
		return Sum;
	}

	public void Limpiar() {
		Nodo pos=ini;
		if( ini==null )
			return;
		do {
			if( pos.punto==true ) {
				Eliminar(pos.Pais);
				Limpiar();
				return;
			}
			pos=pos.nxt;
		}while( pos!=ini );
		
	}
}
	