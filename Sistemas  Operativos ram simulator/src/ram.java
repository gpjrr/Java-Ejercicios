
public class ram {
	int size;
	int taskn;
	int[] arr = new int[1000];
	int[] tareas = new int[1000];
      ram(int n) {
    	size=n;
    	for(int i=0;i<=900;i++) {
    		arr[i]=0;
    		tareas[i]=0;
    	}
      }
      
      public boolean Insert(int ta) {
    	  int mx=-1;
    	  int con=0;
    	  for(int i=size;i>=1;i--) {
    		  if(  arr[i]==0 )
    			  con++;
    		  else
    			  break;
    		  if( con>mx ) mx=con;
    	  }
    	  if( ta>mx )
    		  return false;
    	  //System.out.println("1) Crear Tarea");
    	  int cer=0,j;
    	  int pos=size;
    	  while( arr[pos]==0 && pos>=1) pos--;
    	  pos++;	  
    	    
    	  j=pos;
    	  taskn++;
    	  tareas[taskn]=ta;
    	  for( int k=1;k<=ta;k++ ) 
    		  arr[j++]=taskn;
    					  
    		
    	
    	  return true;
      }

      
      public void VerTareas() {
    	  System.out.println("Las tareas actuales son\n");
			for(int i=1;i<=taskn; i++ )
				if( tareas[i]!=0 ) 
			System.out.println("Tarea "+i+" tamaño="+tareas[i]+"\n");
    	  
      }
      
      public void EliminarID(int yo) {
    	  if( tareas[yo]==0 )
    		  return;
    	  tareas[yo]=0;
    	  for( int i=1;i<=size;i++ )
    		  if( arr[i]==yo )
    			  arr[i]=0;
      
      }
      
      public void VerRam() {
    	  String cad="";
			for(int i=1;i<=size;i++) {
				cad+=arr[i];
				cad+=" "; 
			}
			System.out.println(cad+"\n");
    	  
      }
}
