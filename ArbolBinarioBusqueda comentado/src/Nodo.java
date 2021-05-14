public class Nodo {
    String Palabra;
    int contador;
    Nodo der;
    Nodo izq;
    boolean vis;
    
    public Nodo( String palabra ){
    	Palabra=palabra;
    	contador=1;
        der = null;
        izq = null;
        vis=false;
    }
}