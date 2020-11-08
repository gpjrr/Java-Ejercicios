public class Nodo {
    int val;
    Nodo der;
    Nodo izq;
    boolean vis;
    
    public Nodo(int dato){
    	val = dato;
        der = null;
        izq = null;
        vis=false;
    }
}
