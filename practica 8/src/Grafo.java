public class Grafo {
	
	
	int n;
	Nodo[] arr=new Nodo[300];
	
	int pos;
	int tp;
	String[] path=new String[300];
	
	
	public Grafo() {
		
		arr[0]=new Nodo("hueco",-1);
		tp=0;
		n=0;
		this.Insert( new Nodo("root",0) );
		copiarnombre("root");
		pos=1;
	}
	
	public void Insert( Nodo nuevo ) {
		arr[++n]=nuevo;
		int old=arr[n].dad; 
		///System.out.println("old="+old);
		arr[ old ].adj[ ++arr[old].m ]=n;
	}


	public void ShowDir(int posi) {
		String Cad="";
		System.out.println("total de directorios "+arr[posi].m);
		for(int i=1;i<= arr[posi].m ;i++ ) {
			int t1=arr[posi].adj[i];
			if( arr[t1].Live==true ){
				Cad+=arr[t1].Name;
				Cad+="\n";
			}
		}
		System.out.println(Cad);
	}
	
	public void move(String nomo) {
		System.out.println("busco a "+nomo);
		for(int i=1;i<=n;i++)
if( arr[i].Live==true &&  arr[i].Name.equals(nomo)==true ) {
	copiarnombre( arr[i].Name );
	pos=i;
	return ;
}	
	}
	
	public void copiarnombre(String nom) {
		path[ ++tp ]=nom;
	}
	
	public void back() {
		
		
		if( pos==1 ) 
			System.out.println("ya estas en la raiz ");	
		else {
			pos=arr[pos].dad;
			tp--;
		}
	
	}
	
	public void showpath() {
		String Cad="";
		for(int i=1;i<= tp;i++ )
			Cad+=path[i]+"/";
		Cad+="\n";
		System.out.println(Cad);	
	}
	
	public int find(String txt) {
		//int res=-1;
		System.out.println("txt="+txt);
		for(int i=1;i<=arr[pos].TF;i++ ) {
			//System.out.println("t="+  );
			if( arr[pos].Files[i].Live==true )
			if( arr[pos].Files[i].Name.equals( txt )==true )
				return i;
		}
		return -1;
	}
	
	public int findDir(String txt) {
		/// 	int res=-1;
		
		for(int i=1;i<=n;i++ )
if( arr[i].Live==true && arr[i].Name.equals( txt )==true )
				return i;
		return -1;
	}
	
	
	/*
	public void showfiles() {
		String Cad="";
		for(int i=1;i<=arr[pos].TF;i++ )
			Cad+= arr[pos].Files[i].Name +"\n";
		
		System.out.println(Cad);
		
	}
	*/
	
	/*
	public void showdir() {
		String Cad="directorios \n";
		for(int i=1;i<=arr[pos].m;i++ ) {
			int t1=arr[pos].adj[i];
			if( arr[t1].Live==true )
				Cad+=arr[t1].Name+"\n";
		}
		System.out.println(Cad);
		
	}*/
	
	
	
	
}
