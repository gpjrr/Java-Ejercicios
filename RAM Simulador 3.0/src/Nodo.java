
public class Nodo {
	int inicio, fin,tarea;
	Nodo sig,ant;
	public Nodo(int inicio,int fin,int tarea){
		this.inicio=inicio;
		this.fin=fin;		
		this.tarea=tarea;
		sig=this;
	}
	public String toString(){
		return "["+inicio+"|T"+tarea+"|"+fin+"]-->";
	}
	
}