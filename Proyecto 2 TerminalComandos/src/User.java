import java.util.Arrays; 
import java.util.Random;
import java.util.Scanner; 		
import java.io.*;


public class User {
	int n;
	Boolean[] SuperUser;
	String[] Name,Password;
	Scanner sc=new Scanner(System.in);
	String txt; 
	Grafo Tree;
	boolean God;

	
	public User( String titulo ) throws IOException {
		File f=new File( titulo );
		FileReader rf=new FileReader(f);
		BufferedReader br=new BufferedReader( rf );
		
		Name=new String[400] ;
		Password=new String[400] ;
		SuperUser= new Boolean[4040];
		
		n=Integer.parseInt( br.readLine() );
		//System.out.println( n );
		for(int i=1;i<=n;i++){
			Name[i]="popo"; Password[i]="popo";
			//System.out.println(Name[i]);
			Name[i]=br.readLine();
			//System.out.println(Name[i]);
			Password[i]=br.readLine();
			//System.out.println( Password[i] );
			SuperUser[i]=Boolean.parseBoolean( br.readLine() );
			//System.out.println( SuperUser[i] );
		}

	}
	public int Search(String yo) {
		for(int i=1;i<=n;i++)
			if( Name[i].equals(yo)==true )
				return i;
		return -1;
	}
	public boolean Paswor(int pos,String contra) {
		return Password[pos].equals( contra );
	}
		
	public void CommandSimulator( int NumUser ) throws IOException{
		Tree=new Grafo();
		Tree.Read();
		
		Tree.MemoryStatus();
		String user=Name[NumUser];
		//System.out.println( "pos="+Tree.pos );
		while( true ) {
			Tree.showpath(user);
			txt=sc.nextLine();
			
			if( txt.equals("cd")==true ) {	
								
				System.out.println( "Selecciona el Directorio " );				
				Tree.ShowDir( Tree.pos );
				txt=sc.nextLine();
				
				if( SuperUser[ NumUser ]==false ) {
					int tem=Tree.findDir( txt );
					if( tem==-1 )
						System.out.println("no existe el directorio");
					else				
					if( Tree.arr[ tem ].Permisos.charAt(0)!='r' ) {
						System.out.println("no hay permisos para leer aqui");
						continue;
					}
				
				}				
				Tree.move( txt );
			}	
			else //lista de directorios y archivos
			if( txt.equals("dir")==true ) {
				Tree.ShowDir(Tree.pos);
				Tree.arr[ Tree.pos ].ShowFiles(); 
			}
			else //crear directorio
			if( txt.equals("mkdir")==true ) {
				if( SuperUser[ NumUser ]==false )
				if( Tree.arr[ Tree.pos ].Permisos.charAt(1)!='w' ) {
					System.out.println("no hay permisos para escribir aqui");
					continue;
				}
				
				System.out.println("Dar el nombre del directorio");
				//sc.nextLine();
				txt=sc.nextLine();
				
				if( Tree.findDir( txt )==-1 ) 
				Tree.Insert( new Nodo( txt, Tree.pos ) );
			
				else
					System.out.println("El Directorio ya Existe");
				
			}
			else//crear archivo
			if( txt.equals("touch")==true ) {
				if( SuperUser[ NumUser ]==false )
				if( Tree.arr[ Tree.pos ].Permisos.charAt(1)!='w' ) {
					System.out.println("no hay permisos para escribir aqui");
					continue;
				}
				///  crear archivo
				System.out.println("Dar el nombre del archivo");
				//txt=sc.nextLine();
				txt=sc.nextLine();
				System.out.println("Dar el tamano del archivo");
				int tem=sc.nextInt();
				Tree.InsertFile( txt,tem,NumUser );
			}
			else//borar carpeta o archivo
			if( txt.equals("rm")==true ){
				if(  SuperUser[ NumUser ]==false  && Tree.pos==1 ) {
					System.out.println("no hay permisos para borrar en la raiz");
					continue;
				}
				if( SuperUser[ NumUser ]==false )
				if( Tree.arr[ Tree.pos ].Permisos.charAt(1)!='w' ) {
					System.out.println("no hay permisos para escribir aqui");
					continue;
				}
				
				Tree.ShowDir(Tree.pos);
				Tree.arr[ Tree.pos ].ShowFiles();
				System.out.println("  Dar el nombre del archivo o directorio");
				txt=sc.nextLine();
				//txt=sc.nextLine();
			
				if( Tree.DeleteDir(txt)==false ) 
					Tree.DeleteFile(txt);	
				
			}
			else//cambiar permisos
			if( txt.equals("chmod")==true ) {
				
				if( SuperUser[ NumUser ]==false ) {
					System.out.println("solo el usuario root manipula los permisos");
					continue;
				}
				
				if( Tree.arr[ Tree.pos ].Permisos.charAt(1)!='w' ) {
					System.out.println("no hay permisos para escribir aqui");
					continue;
				}
				
				Tree.ShowDir(Tree.pos);
				System.out.println("Dar el nombre del directorio");
				txt=sc.nextLine();
				int pos=Tree.findDir( txt );
				if( pos==-1 ) 
					System.out.println("el directorio no existe");
				else {
					System.out.println("Dar los nuevos permisos");
					  Tree.arr[ pos ].Permisos=sc.nextLine();
				}
			
			}
			else// memu
			if( txt.equals("help")==true ) {
				ShowMenu();
			}
			else // cerrar sesion
			if( txt.equals("exit")==true ) {
				return;
			}
			else//Status de memoria
			if(  txt.equals("memory")==true ) {
				Tree.MemoryStatus();
			}
			else {
				//System.out.println("usa help para ver los compandos");
			}
			Tree.Save();
			
			
		}
	}
	
	

	public void ShowMenu() {
		System.out.println("Cd: moverse entre carpetas");
		System.out.println("dir: lista de directorios y archivos");
		System.out.println("mkdir:crear directorio");
		System.out.println("touch:crear archivo");
		System.out.println("rm:borar carpeta o archivo");
		System.out.println("chmod:cambiar permisos");
		System.out.println("help:menu de comandos");
		System.out.println("memory:Status de memoria");
		System.out.println("exit:Cerrar Sesion");
		
	}
	
}




