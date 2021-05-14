 import java.text.*;
import java.util.*;
import java.io.*;
  

public class Arbol {
     Nodo raiz=null;//la raiz del arbol
        // a busqueda le mandamos la palabra que buscamos y el nodo con el que nos moveremos dentro del arbol
    public Nodo Busqueda(String word,Nodo aux){
    
    	Collator comparador = Collator.getInstance();// construimos un comparador de palabras 
    	comparador.setStrength(Collator.PRIMARY);// se configura para que no importen las mayusculas ni minusculas 
    	while(aux != null){//mientras estemos en algun nodo el ciclo funciona
    		int res=comparador.compare(word, aux.Palabra);//se guarda el resultado de comparar la palabra que buscamos con la del nodo ren 


           if(  res < 0 ){ //la palabra es menor a la del nodo
               aux = aux.izq;// te mueves a la izquierda
           }
           else
           if(res > 0)//la palabra es mayor a la del nodo
             aux = aux.der;// te mueves a la derecha          
           else/// encontraste la palabra y regresas el nodo
        	 return aux;
        }
    	//te perdiste en el infinito
       return null;
    }
    
    public void Insertar(String word ){// insertamos una nueva palabra en el arbol
      Nodo nuevo = new Nodo(word);// creamos el nodo
      Nodo aux2 = raiz;//este nodo es el que se va a mover en el arbol
      Nodo aux3 = null;// va a ir detras de aux2 como respaldo por si se pierde en el infinito
      Collator comparador = Collator.getInstance();// creamos comparador
      comparador.setStrength(Collator.PRIMARY);// lo configuramos
      while(aux2 != null){// vamos bajando hasta llegar a una hojaa
          aux3 = aux2;//como aux2 va a avanzar, aux3 toma su lugar
          int res=comparador.compare(word, aux2.Palabra);// resultado de comparar la palabra y el nodo
          
          //System.out.println( word+" "+ aux2.Palabra);
          if( res < 0 )// muy similar a lo de arriba
              aux2 = aux2.izq;// la palabra es menor te mueves a la izquierda
          else
              aux2 = aux2.der;// si fue mayor a la derecha 
      }
      if(aux3 == null)// si de un inicio aux2 fue null ent es la primer palabra en el arbol
          raiz = nuevo;// raiz apunta a la nueva palabra
      else{
    	  //aux3 se quedo en la hoja del arbol solo queda ver de que lado va  
    	  int res2=comparador.compare(word, aux3.Palabra);// se guarda el resultado de comparar 

          if( res2 < 0  )// si es menor va a la izquierda 
              aux3.izq = nuevo;
          else/// si es mayor va a la derecha
              aux3.der = nuevo;
      }
      
    }
    
         /// aqui son los tipos de orden realizados con recursion unicamente, es la forma en que se va visitando el arbol nada especial
    public void Preorden(Nodo raiz){
        if(raiz != null){
        	System.out.println(raiz.Palabra+"\t frecuencia "+raiz.contador);
            Preorden(raiz.izq);
            Preorden(raiz.der);
        }   
    }
       
    //inorden es el importante
    public void Inorden(Nodo raiz){
        if(raiz != null){
        	//primero bajaa todo a la izquierda
            Inorden(raiz.izq);
            //imprime su posicion
            System.out.println(raiz.Palabra+"\t frecuencia "+raiz.contador);
            // y se mueve a la derecha 
            Inorden(raiz.der);
        }
    }
    
    public void Postorden(Nodo raiz) {
        if(raiz != null){
            Postorden(raiz.izq);
            Postorden(raiz.der);
            System.out.println(raiz.Palabra+"\t frecuencia "+raiz.contador);
        }
    }
    
    
}