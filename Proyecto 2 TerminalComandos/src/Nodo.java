
public class Nodo {
	String Permisos;
	int DirLive;
	int FilesLive;
	String Name;
	int dad;
	int m;
	int[] adj=new int[300];
	int TF;
	Archivo[] Files=new Archivo[300];
	Boolean Live;
	
	
	public Nodo(String nambre,int padr) {
		Name=nambre;
		dad=padr;
		m=0;
		FilesLive=0;
		adj=new int[300];
		TF=0;
		Files=new Archivo[300];
		Live=true;
		Permisos="rwx";
	}
	
public void InsertFile(String name,int size,int maker) {
		Files[ ++TF ]=new Archivo(name,size,maker);
		FilesLive++;
	}
	
	public int DeleteFile(String name) {
		for(int i=1;i<= TF;i++ )
			if( Files[i].Live==true &&
			   Files[i].Name.equals( name )==true ){
				
				Files[i].Live=false;
				FilesLive--;
				return Files[i].Size;
			}
		return -1;
	}
	
	public void ShowFiles() {
		String Cad="";
		System.out.println("total de Archivos "+ FilesLive	);
		for(int i=1;i<= TF;i++ )
			if( Files[i].Live==true ){
				Cad+=Files[i].Name;
				Cad+="\n";
			}
		System.out.println(Cad);	
	}
	
	

}

