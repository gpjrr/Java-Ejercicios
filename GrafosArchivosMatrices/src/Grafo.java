import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Grafo {
	int n,m;
	/// sea n el total de vertices y m el total de aristas 
	int mat[][]=new int[1010][1010];
	String Vertice[]=new String[1010];
	Boolean Live[]=new Boolean[1010];
	String word;
	Boolean vis[]=new Boolean[1010];	
	int dad[]=new int[1010];
	int ran[]=new int[1010];
	
	int dis[]=new int[1010];
	
	
	public int BuscarVertice( String titulo ) {
		int i=1;
		for(;i<=n;i++) {
			if( Vertice[i].equals( titulo ) && Live[i]==true  )
				return i;
		}
		return -1;
	}
	
 	public void Construir( String titulo ) throws IOException{
		
		File f=new File( titulo );
		FileReader rf=new FileReader(f);
		BufferedReader br=new BufferedReader( rf );
		
		
		n=Integer.parseInt( br.readLine() );
		m=Integer.parseInt( br.readLine() );
		
		for(int i=1;i<=1000;i++) {
			Vertice[i]="";
			for(int j=1;j<=1000;j++)
				mat[i][j]=-1;
			Live[i]=false;
		}
		
		for(int i=1;i<=n;i++) 
			InsertarVertice( br.readLine() );
		
		
		for(int i=1;i<=m;i++) {
			String wrd=br.readLine();
			String n1="",n2="";
			int t3;
			for(int j=0;  wrd.charAt(j)!=' ';j++) 
				n1+=wrd.charAt(j);
			for(int j=wrd.length()-1 ;wrd.charAt(j)!=' ' ;j--)
				n2+=wrd.charAt(j);
			t3=Integer.parseInt( br.readLine() );
			InsertarArista( n1,n2 ,t3);
			
		}
		
	}
	
	public void InsertarVertice( String nombre ) {
		 int pos=BuscarVertice( nombre );
		 if( pos==-1 ) {
			int i=1;
			while( Live[i]==true )	i++;	
			if( i>n )
				n=i;
			pos=i;
		 }
		 Live[pos]=true;
		 Vertice[ pos ]=nombre;	 
	}
	 
	public void InsertarArista( String origen, String destino,int peso) { 
		 int p1=BuscarVertice( origen );
		 int p2=BuscarVertice( destino );
		 if( Math.min(p1, p2)!=-1 )
			 mat[p2][p1]=mat[p1][p2]=peso;
	}
	
	public void EliminarVertice( String muerto ) {
		int p1=BuscarVertice( muerto );
		if( p1==-1 )
			return;
		Vertice[p1]="";
		Live[p1]=false;
		for(int i=1;i<=n;i++)
			mat[p1][i]=mat[i][p1]=-1;
	}
	
	public void EliminarArista( String origen, String destino ) {
		int p1=BuscarVertice( origen );
		int p2=BuscarVertice( destino );
		if( Math.min(p1, p2)!=-1 )
			mat[p2][p1]=mat[p1][p2]=-1;
	}
	
	public String toString() {
		String cad="";
		for(int i=1;i<=n;i++)
			if( Vertice[i]!="" ) {
				cad+=Vertice[i]+":\n";
				for(int j=1;j<=n;j++)
					if( mat[i][j]!=-1 )
						cad+=Vertice[j]+" dis="+mat[i][j]+"\n";
				cad+='\n';
			}
		return cad;
	}
	
	public void dfs(int pos) {
		vis[pos]=true;
		word+=Vertice[pos]+" ";
		for(int i=1;i<=n;i++)
			if( mat[pos][i]!=-1 && !vis[i] )
				dfs( i );
	}
	
	public String BusquedaProfundidad(String  origen ) {
		for(int i=1;i<=n;i++) 
			vis[i]=false;
		word="";
		int pos=BuscarVertice(origen);
		if( pos!=-1 )
		dfs( pos );
		
		return word; 
	}
	
	public String BusquedaAmplitud(String origen) {
		for(int i=1;i<=n;i++) 
			vis[i]=false;
		word="";
		int pos=BuscarVertice(origen);
		if( pos==-1 )
		return word;
		/// programar profundidad
		int cola[]=new int[1010];
		int ini=1;
		int fin=1;
		cola[ini]=pos;
		
		while( ini<=fin ) {
			int act=cola[ini++];
			if( vis[ act ] )
				continue;
			
			vis[ act ]=true;
			word+=Vertice[ act ]+" ";
			for(int i=1;i<=n;i++) 
				if( mat[act][i]!=-1 && !vis[ i ] )
					cola[ ++fin ]=i;
		}
		return word;
	}
	
	public String muestra( Arista yo ) {
		String pal="";
		pal+=" "+Vertice[ yo.Nod1 ]+"  "+Vertice[ yo.Nod2 ];
		pal+="="+yo.Dis;
		return pal;
	}
	
	public String prims() {
		word="";
		for(int i=0;i<n+10;i++)
			vis[i]=false;
	
		Cola queue= new Cola(100);
		
		int pos=-1;
		for(int i=1;i<n;i++)
			if( Live[i]==true  ) {
				pos=i;
				break;
			}
		
		if( pos==-1 ) 
			return word;		
		
		Arista tm=new Arista(0,0,0);
		tm.Crear(pos,pos,0  );
		queue.Insertar( tm );
		
		while( queue.tot>=1 ) {
			Arista tem=queue.Ver();
			queue.Eliminar();
			///System.out.println("tma="+queue.tot );
			///System.out.println("S="+muestra(tem) );
			if( vis[ tem.Nod2 ]==true )
				continue;
			vis[ tem.Nod2 ]=true;
			
			pos=tem.Nod1;
			word+=Vertice[pos]+"-"+Vertice[tem.Nod2];
			word+="="+tem.Dis;
			word+="\n";
			pos=tem.Nod2;
			for(int i=1;i<=n;i++) 
				if( mat[ pos ][i]>=0 && vis[i]!=true) {
					Arista nueva=new Arista(pos,i,mat[pos][i]);
					
		///			System.out.println("e="+muestra(nueva) );
					queue.Insertar( nueva );
///System.out.println("c="+muestra( queue.Ver() ) );
				}
	///		System.out.println( queue.tostring() );
		}
		
		return word;
	
	}
	
	int find(int pos) {
		if( pos==dad[pos] )
			return dad[pos];
		return dad[pos]=find( dad[pos] );
	}
	
	void unir( int t1,int t2 ) {
		if( ran[t1]>=ran[t2] ) {
			if( ran[t1]==ran[t2] )
				ran[t1]++;
			dad[t2]=dad[t1];
		}
		else
			dad[t1]=dad[t2];
	}
	
	public String kruskal() {
		word="";
		for(int i=1;i<=1000;i++)
			dad[i]=i;
		Arista arr[]=new Arista[m];
		int con=0;
		for(int i=1;i<=n;i++)
			if( Live[i]==true )
			for(int j=i+1;j<=n;j++)
				if( mat[i][j]>=1 ) 
					arr[con++]=new Arista(i,j, mat[i][j] );
		Arrays.sort( arr );
		for(int i=0;i<con;i++) {
			int b1=find( arr[i].Nod1 );
			int b2=find( arr[i].Nod2 );
			if( b1!=b2 ) {
				word+=muestra( arr[i] )+"\n";
				unir(b1,b2);
			}
		}
			return word;
	}


	public String Dijkstra( String origen ) {
		for(int i=1;i<=1000;i++)
			dis[i]=1000000;


		int pos=BuscarVertice(origen);
		if( pos==-1 )
			return "no existe el nodo";
		
		dis[pos]=0;
		Arista tem=new Arista(pos,0,0);
		Cola queue=new Cola(1000);
		queue.Insertar( tem );
		
		while( queue.tot>=1 ) {
			tem=queue.Ver();
			queue.Eliminar();

			pos=tem.Nod1;
			if( tem.Dis>dis[pos] )
				continue;
			dis[pos]=tem.Dis;
			
			for(int i=1;i<=n;i++) 
				if( Live[i]==true && mat[pos][i]>0 ) {
					int t1=tem.Dis+mat[pos][i];
					if( dis[ i ]>t1 ) {
						Arista nue=new Arista(i,0,t1);
						queue.Insertar( nue );
					}
				}
				
		}
	
			
		word="";
		for(int i=1;i<=n;i++)
			if( Live[i]==true ){
					word+=Vertice[i]+" "+dis[i];
					word+="\n";
			}
		return word;
	}
}



