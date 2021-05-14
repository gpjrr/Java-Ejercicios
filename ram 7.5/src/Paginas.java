import java.util.Random;

public class Paginas {
	int idPagina,contError;
	int tareas[];
	int n;
	boolean live;
	public Paginas(int id,int t[]) {
		idPagina=id;
		contError=0;
		tareas=t;
		n=1;
		live=true;

	}
	public void insert( int pos,int val ) {
		this.tareas[pos]=val;
	}
	
	public boolean tieneError() {
		return contError==5;
	}
	
	public void ejecutarCiclo() { 
//Método que "ejecuta ciclo" y genera 50% probabilidad de erora la página
		Random rn = new Random();
		int getError = (rn.nextInt(100))%2 ;
		 if(getError%2==0)
			 contError++;
	}

	
}
