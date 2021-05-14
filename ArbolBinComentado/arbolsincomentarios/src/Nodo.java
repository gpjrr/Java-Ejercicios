public class Nodo {
    String Palabra;
    int contador;
    Nodo der;
    Nodo izq;
    
    public Nodo( String palabra ){
    	Palabra=palabra;
    	contador=1;
        der = null;
        izq = null;
    }
}