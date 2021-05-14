public class Nodo {
    String Palabra;//la palabra del nodo
    int contador;// el total de veces que se repite la palabra
    Nodo der;// el nodo hijo de la derecha
    Nodo izq;// el nodo hijo de la izquierda
    
    
    public Nodo( String palabra ){//el constructor del nodo
    	Palabra=palabra;// asignas las palabra
    	contador=1;// contador vale 1 porque ya creaste un nodo
        der = null;//las nodos hijo no hay ent es nulo
        izq = null;
        
    }
}