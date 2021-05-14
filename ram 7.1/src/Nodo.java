
public class Nodo {
	int inicio, fin,tarea;
	Nodo sig;
	public Nodo(int inicio,int fin,int tarea){
		this.inicio=inicio;
		this.fin=fin;		
		this.tarea=tarea;
		sig=this;
	}
	public String toString(){
		if(tarea!=0)
			return "["+inicio+"|T"+tarea+"|"+fin+"]-->";
		else
			return "["+inicio+"|H|"+fin+"]-->";
	}
	
}