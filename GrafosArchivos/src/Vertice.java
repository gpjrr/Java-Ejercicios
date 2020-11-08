
public class Vertice {
	String Name;
	Vertice sig;
	VerticeAdyacente raiz;
	Boolean vis=false;
	public Vertice( String titu ) {
		Name=titu;
		sig=null;
		raiz=null;
		
	}
	
	public void EliminarAdyacente( String tit ) {
		VerticeAdyacente pas=null;
		VerticeAdyacente act=raiz;
		if( act==null )
			return;
		
		while( act.Name.equals( tit )!=true ) {
			pas=act;
			act=act.sig;
		}
	
		if( act==raiz ) 
			raiz=raiz.sig;
	if( pas!=null )
		pas.sig=act.sig;
	act.sig=null;
		
		
	}
	
	public String imprime() {
		String Cad="";
		for( VerticeAdyacente i=raiz; i!=null; i=i.sig ) {
			Cad+=i.Name;
			Cad+=" ";
		}
		return Cad;
	}
}
