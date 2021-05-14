
public class ram {
	int size;
	int taskn;
	
	int[] arr = new int[1000];
	int[] tareas = new int[1000];
	int[] iniT = new int[1000];
	int[] finT = new int[1000];
	int map[][]=new int[1000][8];
	
     ram(int n) {
    	size=n;
    	for(int i=0;i<=900;i++) {
    		arr[i]=0;
    		tareas[i]=0;
    		iniT[i]=0;
    		finT[i]=0;
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
    	  iniT[taskn]=j;
		  finT[taskn]=j+ta-1;
		  
    	  for( int k=1;k<=ta;k++ ) 
    		  arr[j++]=taskn;
    					  
    		
    	
    	  return true;
    	  
      }

      
      public void VerTareas() {
    	  System.out.println("Las tareas actuales son\n");
			for(int i=1;i<=taskn; i++ )
				if( tareas[i]!=0 ) 
System.out.println("Tarea "+i+" tamaño="+tareas[i]+" inicio="+iniT[i]+" final="+finT[i]+"\n");
    	  
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
     
      public void resort() {
    	int tip=0;
    	int pos=1;
    	int tam;
    	
    	int[] copia = new int[1000];
    	for(int i=1;i<=900;i++) 
    		copia[i]=0;
    	
    	for(int i=1;i<=size;i++) {
    		if( arr[i]!=0 ) {
    			tip=arr[i];
  
    			tam=finT[ tip ]-iniT[ tip ]+1;  
    			
    			for(int j=1;j<=size;j++)
    				if( arr[j]==tip )
    					arr[j]=0;
    			
    			for(int j=1;j<=tam;j++)
    				copia[pos++]=tip;
    			
    			///this.VerRam();
    		}
    	}
    	
    	for(int i=1;i<=size;i++)
    		arr[i]=copia[i];
      }

      public void verMapa() {
    	  //Inicializamos la matriz en ceros para reordenarla con la actualización
    	  for(int i=0;i<1000;i++)
      		for(int j=0;j<8;j++)
      			map[i][j]=0;
    	  //Actualización del mapa con arr[]    	  
    	  int espacioOcupado=0;
    	  for(int i=0;i<arr.length;i++)
    		  if(arr[i]!=0)
    			  espacioOcupado++;
    	 
    	  for(int i=0;i<(int)Math.ceil(espacioOcupado/8);i++) //Llena con unos las filas que se llenan completas
    		  for(int j=0;j<8;j++)
    			  map[i][j]=1;

    	  //Rellena los espacios faltantes de la fila adicional
    	  for(int j=0;j<espacioOcupado%8;j++)
    		  map[(int)Math.ceil(espacioOcupado/8)][j]=1;
    	  
    	  //Escirtura de mapa
    	  System.out.print("\n---MAPA DE BITS---\n");
    	  for(int i=0;i<(int)Math.ceil(size/8)+1;i++) {
    		  for(int j=0;j<8;j++) {
    			  System.out.print(map[i][j]+" ");
    		  }
    		  System.out.print("\n");
    	  }
    	  System.out.print("\n\n");
      }

     
}
