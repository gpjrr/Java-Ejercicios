 import java.text.*;
import java.util.*;
import java.io.*;
  

public class Arbol {
     Nodo raiz=null;
        
    public Nodo Busqueda(String word,Nodo aux){
    
    	Collator comparador = Collator.getInstance();
    	while(aux != null){
    		int res=comparador.compare(word, aux.Palabra);
    		comparador.setStrength(Collator.PRIMARY);
    		
           if(  res < 0 ){
               aux = aux.izq;
           }
           else
           if(res > 0)
             aux = aux.der;          
           else
        	 return aux;
        }
       return null;
    }
    
    public void Insertar(String word ){
      Nodo nuevo = new Nodo(word);
      Nodo aux2 = raiz;
      Nodo aux3 = null;
      Collator comparador = Collator.getInstance();
      while(aux2 != null){
          aux3 = aux2;
          int res=comparador.compare(word, aux2.Palabra);
          comparador.setStrength(Collator.PRIMARY);
          //System.out.println( word+" "+ aux2.Palabra);
          if( res < 0 )
              aux2 = aux2.izq;
          else
              aux2 = aux2.der;
      }
 
      if(aux3 == null)
          raiz = nuevo;
      else{
    	  int res2=comparador.compare(word, aux3.Palabra);
    	  comparador.setStrength(Collator.PRIMARY);
          if( res2 < 0  )
              aux3.izq = nuevo;
          else
              aux3.der = nuevo;
      }
      
    }
    
         
    public void Preorden(Nodo raiz){
        if(raiz != null){
            System.out.println(raiz.Palabra+" r="+raiz.contador);
            Preorden(raiz.izq);
            Preorden(raiz.der);
        }   
    }
       
    public void Inorden(Nodo raiz){
        if(raiz != null){
            Inorden(raiz.izq);
            System.out.println(raiz.Palabra+"\t frecuencia "+raiz.contador);
            Inorden(raiz.der);
        }
    }
    
    public void Postorden(Nodo raiz) {
        if(raiz != null){
            Postorden(raiz.izq);
            Postorden(raiz.der);
            System.out.println(raiz.Palabra+" r="+raiz.contador);
        }
    }
    
    
}