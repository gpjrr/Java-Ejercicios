public class Arbol {
     Nodo raiz=null;
        
    public Nodo Busqueda(int d,Nodo aux){
        while(aux != null){
           if(d < aux.val){
               aux = aux.izq;
           }
           else
           if(d > aux.val)
             aux = aux.der;          
           else
        	 return aux;
        }
       return null;
    }
    
    public void Insertar(int dato){
      Nodo nuevo = new Nodo(dato);
      Nodo aux2 = raiz;
      Nodo aux3 = null;
      while(aux2 != null){
          aux3 = aux2;
          if( dato < aux2.val )
              aux2 = aux2.izq;
          else
              aux2 = aux2.der;
      }
 
      if(aux3 == null)
          raiz = nuevo;
      else{
          if( dato < aux3.val )
              aux3.izq = nuevo;
          else
              aux3.der = nuevo;
      }
      
    }
    
    public void Eliminar(int dato){
        Nodo aux1 = raiz;
        Nodo aux2 = null;
        Nodo temp;
        int B = 0;
        while(B != 1){
        	if( aux1==null )
        		return;
        	if(aux1.val == dato){
                B = 1;
            }
            else{
                aux2 = aux1;
                if(dato < aux1.val )
                    aux1 = aux1.izq;
                else
                    aux1 = aux1.der;
            }
        }
        
        temp = aux1;
        
        int conta=0;
        if(temp.der!=null )
        	conta++;
        if(temp.izq!=null )
        	conta++;
        
        //Nodo hoja
        if( conta==0 ) {
        	if(aux2.der == temp)
                aux2.der = null;
            
            if(aux2.izq == temp)
                aux2.izq = null;
        }
        else 
        if( conta==1 ){
             //Nodo con un hijo
	        Nodo sub=null;
	        if( temp.der!=null )
	        	sub=temp.der;
	        else
	        	sub=temp.izq;
	        if( aux2.izq==temp )
	        	aux2.izq=sub;
	        else
	        	aux2.der=sub;        
        }
        else 
        if( conta==2 ){
            temp = aux1.izq;
            //Nodo con dos hijos
            while(temp.der != null){
                temp = temp.der;
            }
            aux1.val = temp.val;
            if(aux1.der == temp)
                aux1.der = null;
            else
                aux1.izq = null;
        }
        
        temp = null;
    
    }
           
    public void Preorden(Nodo raiz){
        if(raiz != null){
            System.out.println(raiz.val);
            Preorden(raiz.izq);
            Preorden(raiz.der);
        }   
    }
    
    public void PreordenC(Nodo raiz){
        if(raiz != null){
            System.out.println(raiz.val);
            PreordenC(raiz.der);
            PreordenC(raiz.izq);
        }
    }
    
    public void Inorden(Nodo raiz){
        if(raiz != null){
            Inorden(raiz.izq);
            System.out.println(raiz.val);
            Inorden(raiz.der);
        }
    }
   
    public void InordenC(Nodo raiz) {
            if(raiz != null){
            InordenC(raiz.der);
            System.out.println(raiz.val);
            InordenC(raiz.izq);
        }
    }
    
    public void Postorden(Nodo raiz) {
        if(raiz != null){
            Postorden(raiz.izq);
            Postorden(raiz.der);
            System.out.println(raiz.val);
        }
    }
    
    public void PostordenC(Nodo raiz) {
        if(raiz != null){
            PostordenC(raiz.der);
            Postorden(raiz.izq);
            System.out.println(raiz.val);
        }
    }
    
}
