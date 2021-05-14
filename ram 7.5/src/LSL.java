public class LSL {
	private Nodo raiz;
	public LSL(){
		raiz=null;
	}
	
	public boolean estaVacia(){
		return raiz==null;
	}
	
public void insertar(int i,int f, int t){ //inicio,fin,idtarea
		Nodo nuevo=new Nodo(i,f,t);
		if(raiz==null)
			raiz=nuevo;
		else{
			nuevo.sig=raiz.sig;
			raiz.sig=nuevo;
		}
	}

	public void eliminar(int idTarea){
		Nodo anterior=null, actual=raiz;
		do{
			if(actual.sig.tarea==idTarea){
				anterior=actual;
				actual=actual.sig;
				if(actual==anterior)
					raiz=null;
				else{
					if(actual==raiz)
						raiz=anterior;
					anterior.sig=actual.sig;
				}
				actual=raiz;
			}
			else
				actual=actual.sig;
		}while(actual!=raiz);
		if(anterior==null)
			System.out.println("Dato no encontrado.");
	}

	public void buscar(int i,int f,int nt,int id){
		//inicio,fin,nuevatarea, idtarea
		
		Nodo anterior=null, actual=raiz;
		do{
			if(actual.sig.tarea==id ){
				anterior=actual;
				actual=actual.sig;
				
				actual.inicio=i;
				actual.fin=f;
				actual.tarea=nt;
					
				
				actual=raiz;
			}
			else
				actual=actual.sig;
		}while(actual!=raiz);
		
		if(anterior==null)
			System.out.println("Dato no encontrado.");
		
	}
	
	
	public String toString(){
		Nodo actual=raiz;
		String cad="";
		do{
			cad=actual.sig+cad;
			actual=actual.sig;
		}while(actual!=raiz);
		return cad;
	}

	///MEtodo de LSL : ME devuelve un apuntador de un nodo en específico
		public Nodo apuntarElemento(int id) {
			Nodo n=raiz, elemento=null;
			do {
				if(n.tarea==id)
					elemento= n;
				n=n.sig;
			}while(n.sig!=raiz);
			
			return elemento;
		}
}