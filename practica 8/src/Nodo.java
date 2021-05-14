
public class Nodo {
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
		TF=0;
		Live=true;
		
	}
	public void InsertFile(String name) {
		Files[ ++TF ]=new Archivo(name);
	}
	
	public boolean DeleteFile(String name) {
		for(int i=1;i<= TF;i++ )
			if( Files[i].Live==true &&
			   Files[i].Name.equals( name )==true ){
				
				Files[i].Live=false;
				return true;
			}
		return false;
	}
	
	public void ShowFiles() {
		String Cad="";
		for(int i=1;i<= TF;i++ )
			if( Files[i].Live==true ){
				Cad+=Files[i].Name;
				Cad+="\n";
			}
		System.out.println(Cad);	
	}
	
	

}

