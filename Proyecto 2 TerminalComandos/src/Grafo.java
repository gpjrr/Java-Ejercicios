import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class Grafo {
	int n;
	Nodo[] arr=new Nodo[300];
	
	int MemUsed,MemTot,BlockSize;
	
	/// variables practicas 
	int pos;
	int tp;
	String[] path=new String[300];	
	
	public Grafo() {
		
		MemUsed=0;
		MemTot=30*4;
		BlockSize=4;
		tp=0;
		n=0;
		arr[0]=new Nodo("hueco",-1);
		this.Insert( new Nodo("root",0) );
		///si es root sino nel aguas;
		copiarnombre("root");
		pos=1;
	}
	public void Insert( Nodo nuevo ) {
		int Spacio=MemTot-MemUsed;
		if( 4<=Spacio ) {
			arr[++n]=nuevo;
			int old=arr[n].dad; 
			arr[ old ].adj[ ++arr[old].m ]=n;
			MemUsed+=4;
			arr[old].DirLive++;
			System.out.println("Directorio creado con exito");
		}
		else
			System.out.println("Error, no hay espacio");
	}
	
	public void ShowDir(int posi) {
		String Cad="";
		System.out.println("total de directorios "+arr[posi].DirLive);
		for(int i=1;i<= arr[posi].m ;i++ ) {
			int t1=arr[posi].adj[i];
			if( arr[t1].Live==true ){
				Cad+=arr[t1].Name+"\t"+arr[t1].Permisos;				
				Cad+="\n";
			}
		}
		//Cad+=".. Salir\n";
		System.out.println(Cad);
	}	
	
	public void move(String nomo) {
		//System.out.println("pos="+pos);
		//System.out.println("busco a "+nomo);
		if( nomo.equals("..") ) {
			back();
			return;
		}
		for(int i=1;i<=n;i++)
if( arr[i].Live==true &&  arr[i].Name.equals(nomo)==true ) {
	copiarnombre( arr[i].Name );
	pos=i;
	//System.out.println("pos="+pos);
	return ;
}	
	}	
	
	public void copiarnombre(String nom) {
		path[ ++tp ]=nom;
	}
	
	public void back() {	
		if( pos==1 ) 
			System.out.println("ya estas en la raiz");	
		else {
			pos=arr[pos].dad;
			tp--;
		}
	
	}
	
	public void  showpath( String user ) {
		String Cad="C:"+user+"/";
		
		for(int i=1;i<=tp;i++ )
			Cad+=path[i]+"/";
		//Cad+="\n";
		System.out.print(Cad);	
	}	
	
	public int findDir(String txt) {
		for(int i=1;i<=n;i++ )
if( arr[i].Live==true && arr[i].Name.equals( txt )==true )
				return i;
		return -1;
	}	
	public boolean DeleteDir( String txt ) {
		int pos = findDir(txt);
		if( pos==-1 ) {
			System.out.println("No existe el Directorio");
			return false;
		}
		
		   Queue<Integer> Cola= new LinkedList<>();
		   Cola.add( pos );
		   while( Cola.isEmpty()==false ) {
			   pos=Cola.peek();
			   Cola.remove();
			   arr[pos].DirLive--;
			   arr[pos].Live=false;
			   MemUsed-=4;
			   for(int i=1;i<=arr[pos].m;i++)
				  Cola.add( arr[pos].adj[i] );
			   
			   for(int i=1;i<=arr[pos].TF;i++) {
				   MemUsed-=arr[pos].Files[i].Size;
				   arr[pos].Files[i].Live=false;
			   }
		   }
		
		
		///recursion :)
		
		System.out.println("Directorio borrado con exito");
		return true;
		
	}
	
	public void DeleteFile( String txt ) {
		int val=arr[pos].DeleteFile(txt);
		if( val>0 ) {
			System.out.println("Archivo borrado con exito");
			MemUsed-=val;
		}
		else
			System.out.println("No existe el archivo");
	}

	public void InsertFile(String nambre,int size,int maker ) {
		int Spacio=MemTot-MemUsed;
		if( size<=Spacio ) {
			arr[ pos ].InsertFile(nambre, size,maker);
			MemUsed+=size;
			System.out.println("Archivo creado con exito");
		}
		else
		System.out.println("Error, no hay espacio");	
	}
	
	public void Read()throws IOException {
		String titulo="Tree.txt";
		File f=new File( titulo );
		FileReader rf=new FileReader(f);
		BufferedReader br=new BufferedReader( rf );
		
			
			int tem=Integer.parseInt( br.readLine() );
			if( tem==-1 ) {
				MemUsed=0;
				MemTot=30*4;
				BlockSize=4;
				Save();
				return ;
			}
			else
				n=tem;
		
			MemUsed=Integer.parseInt( br.readLine() );
			MemTot=Integer.parseInt( br.readLine() );
			BlockSize=Integer.parseInt( br.readLine() );
			///read nodos
			for(int i=0;i<=n;i++) {
				arr[i]=new Nodo("",0);
				arr[i].Permisos=br.readLine();
				arr[i].DirLive=Integer.parseInt( br.readLine() );
				arr[i].FilesLive=Integer.parseInt( br.readLine() );
				arr[i].Name=br.readLine();
				arr[i].dad=Integer.parseInt( br.readLine() );
				
				/// checar el valor inicial de m 
				arr[i].m=Integer.parseInt( br.readLine() );
				for(int j=1;j<=arr[i].m;j++) 
					arr[i].adj[j]=Integer.parseInt( br.readLine() );	
				
				
				arr[i].TF=Integer.parseInt( br.readLine() );
				arr[i].Live=Boolean.parseBoolean( br.readLine() );


				for(int j=1;j<= arr[i].TF;j++ ) {


					arr[i].Files[j]=new Archivo("asd",0,0);
					arr[i].Files[j].Name=br.readLine();
					arr[i].Files[j].Live=Boolean.parseBoolean( br.readLine() );
					arr[i].Files[j].Maker=Integer.parseInt( br.readLine() );
					arr[i].Files[j].Size=Integer.parseInt( br.readLine() );
				}
			}
			///read string path
		}
	
	public void Save()throws IOException {
		File myFoo = new File("Tree.txt");
		FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
		                                                     // false to overwrite.
		


		fooWriter.write("");
		fooWriter.close();
		fooWriter = new FileWriter(myFoo, false);

		fooWriter.write(n+"\n");
		fooWriter.write(MemUsed+"\n");
		fooWriter.write(MemTot+"\n");
		fooWriter.write(BlockSize+"\n");
		for(int i=0;i<=n;i++) {
			fooWriter.write(arr[i].Permisos+"\n");
			fooWriter.write(arr[i].DirLive+"\n");
			fooWriter.write(arr[i].FilesLive+"\n");
			fooWriter.write(arr[i].Name+"\n");
			fooWriter.write(arr[i].dad+"\n");
			
			fooWriter.write(arr[i].m+"\n");
			for(int j=1;j<=arr[i].m;j++)
				fooWriter.write(arr[i].adj[j]+"\n");
			
			fooWriter.write(arr[i].TF+"\n");
			fooWriter.write(arr[i].Live+"\n");
			for(int j=1;j<= arr[i].TF;j++ ) {
				fooWriter.write(arr[i].Files[j].Name+"\n");
				fooWriter.write(arr[i].Files[j].Live+"\n");
				fooWriter.write(arr[i].Files[j].Maker+"\n");
				fooWriter.write(arr[i].Files[j].Size+"\n");
			}
			
		}
			
		fooWriter.close();
	}

	
	public void MemoryStatus() {
		int res=MemUsed/4;
		if( MemUsed%4>0 )
			res++;
		//res=MemTot-res;
		
		System.out.println("Memoria Total="+MemTot+" bytes");
		System.out.println("Memoria en uso="+MemUsed);
		System.out.println("Tamano del bloque=4");
		System.out.println("Total de bloques="+MemTot/4);
		System.out.println("bloques usados="+res);
	}
		
}
