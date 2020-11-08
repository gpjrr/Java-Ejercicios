import java.util.Arrays; 
import java.util.Random;
import java.util.Scanner; 		
import java.io.*;

public class Grafo {
	int n,m;
	private Vertice Raiz;
	String Word="";

	public void Construir( String titulo ) throws IOException{		
		File f=new File( titulo );
		FileReader rf=new FileReader(f);
		BufferedReader br=new BufferedReader( rf );
		
		
		n=Integer.parseInt( br.readLine() );
		m=Integer.parseInt( br.readLine() );
		
		for(int i=1;i<=n;i++) {
			// leer vertices nombres
			InsertarVertice( br.readLine() );
		}
			
		for(int i=1;i<=m;i++) {
			/// leeer aristas 
			String wrd=br.readLine();
			String n1="",n2="";
			
			for(int j=0;  wrd.charAt(j)!=' ';j++) 
				n1+=wrd.charAt(j);
			
			
			for(int j=wrd.length()-1 ;wrd.charAt(j)!=' ' ;j--)
				n2+=wrd.charAt(j);
			
			///System.out.println( n1+" "+n2+"\n" );
			InsertarArista( n1,n2 );
		}
		
	}
	
	public Vertice BuscarVertice(String nombre) {
		for(Vertice i=Raiz; i!=null ; i=i.sig  )
			if( i.Name.equals( nombre ) )
				return i;
		return null;
	}
	
	public void InsertarVertice( String nombre ) {
		Vertice nuevo=BuscarVertice( nombre );
		if( nuevo==null ) {
	
			if( Raiz!=null ) {
				Vertice i=Raiz;
				for(  ; i.sig!=null; i=i.sig );
				i.sig= new Vertice( nombre );
			}
			else 
				Raiz=new Vertice( nombre ); 
		}
	}
	
	public void InsertarArista( String origen, String destino ) {
		Vertice b1=BuscarVertice( origen );
		Vertice b2=BuscarVertice( destino );
		if( b1!=null && b2!=null ) {
			VerticeAdyacente n1=new VerticeAdyacente( origen );
			VerticeAdyacente n2=new VerticeAdyacente( destino );
			
			if( b1.raiz!=null ) {
				VerticeAdyacente i=b1.raiz;
				for(;i.sig!=null;i=i.sig);
				i.sig=n2;		
			}
			else
				b1.raiz=n2;
			
			if( b2.raiz!=null ) {
				VerticeAdyacente i=b2.raiz;
				for(;i.sig!=null;i=i.sig);
				i.sig=n1;		
			}
			else
				b2.raiz=n1;
			
		}
	
	}
	
	public String toString() {
		String cad="";
		for(Vertice i=Raiz; i!=null ; i=i.sig  ) {
			cad+=i.Name;
			cad+=" :";
			cad+=i.imprime();
			cad+="\n";
		}
		return cad;
	}

	public void EliminarArista( String sujeto1, String sujeto2 ) {
		Vertice nod1=BuscarVertice( sujeto1 );
		Vertice nod2=BuscarVertice( sujeto2 );
		if( nod1==null || nod2==null )
			return;
		nod1.EliminarAdyacente( sujeto2 );
		nod2.EliminarAdyacente( sujeto1 );
	}
	
	public void EliminarVertice( String sujeto ) {
		Vertice yo=BuscarVertice( sujeto );
		if( yo==null )
			return;
		
		VerticeAdyacente i=yo.raiz;
		for( ; i!=null;i=i.sig ) 
			BuscarVertice( i.Name ).EliminarAdyacente( yo.Name );
			
		
		System.out.println( toString() );
		
		Vertice pas=null;
		Vertice act=Raiz;
		while( act.Name.equals( sujeto )!=true ) {
			pas=act;
			act=act.sig;
		}
	
		if( act==Raiz ) 
			Raiz=Raiz.sig;
		if( pas!=null )
			pas.sig=act.sig;
		act.sig=null;
	}
	
	public void dfs( Vertice pos ) {
		pos.vis=true;
		Word+=pos.Name+" ";
		VerticeAdyacente son=pos.raiz;
		for( ;son!=null;son=son.sig )
			if( BuscarVertice( son.Name ).vis==false )
				dfs( BuscarVertice(son.Name) );
	}
	
	public String BusquedaProfundidad( String sujeto ) {
		Word="";
		for(Vertice i=Raiz;i!=null;i=i.sig)
			i.vis=false;
		
		Vertice pos=BuscarVertice( sujeto );
		if( pos==null )
			return Word;
		dfs( pos );
		return Word;
	}
	
	public String BusquedaAmplitud( String sujeto ) {
		Word="";
		for(Vertice i=Raiz;i!=null;i=i.sig)
			i.vis=false;
	
		Vertice pos=BuscarVertice( sujeto );
		if( pos==null )
			return Word;
	
		Vertice[] cola=new Vertice[1010];
		int ini=1;
		int fin=1;
		
		cola[1]=BuscarVertice( sujeto );
		
		while( ini<=fin ) {
			Vertice yo=cola[ini++];
			if( yo.vis==true )
				continue;
			yo.vis=true;
			Word+=yo.Name+" ";
			
			VerticeAdyacente son=yo.raiz;
			for( ;son!=null;son=son.sig )
				if( BuscarVertice( son.Name ).vis==false )
					cola[ ++fin ]=BuscarVertice( son.Name );
		}
		return Word;
	}
}
