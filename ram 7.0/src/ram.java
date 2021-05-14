
public class ram {
	int size;
	int taskn;
	int espaciosDisp;
	int[] arr = new int[1000];
	int[] tareas = new int[1000];
	int[] iniT = new int[1000];
	int[] finT = new int[1000];
	int map[][]=new int[1000][8];
	LSL lista=new LSL(); //Creo la lista ligada simple (circular)
	
     public ram(int n) {
    	size=n;
    	for(int i=0;i<=900;i++) {
    		arr[i]=0;
    		tareas[i]=0;
    		iniT[i]=0;
    		finT[i]=0;
    	}
    	espaciosDisp=n;
      }
      
    
     
      public void ActLista() {
    	 int[] vis=new int[400];
    	 for(int i=0;i<=300;i++)
    		 vis[i]=0;
    	int tip,tam,pos;
    	 lista=new LSL();
    	pos=1;
    	while( pos<=size ) {
    		tip=arr[pos];
    		int ini=pos;
    		while( arr[pos]==tip && pos<=size ) pos++;
    		lista.insertar(ini,pos-1, tip);
    	}
     }
     
      public boolean Insert(int ta) {
    	  int mx=-1;
    	  int ceros=0;
    	  int con=0;
    	  
    	  if(taskn==1) 
    		  lista.eliminar(0);
    	  for(int i=1;i<=size;i++) {
    		  if( arr[i]==0 ) {
    			  con++;
    			  ceros++;
    		  }
    		  else
    			  con=0;
    		 
    		  if(  con>mx  )
    			  mx=con;
    	  }
    	  
    	  if (  mx<ta ) 
    		  resort();
    	  if( ceros<ta )
    		  return false;
    	  
    	  for(int i=1;i<=size;i++) 
    	  	if( arr[i]==0 ){
    	  		int k=i;
    	  		while( arr[k+1]==0 && k+1<=size ) k++;
    	  		if( k-i+1>=ta ) {
    	  			int j=i;    	  		
    	  			taskn++;
    	  			
    	  			tareas[taskn]=ta;
    	  			iniT[taskn]=j;
    	  			finT[taskn]=j+ta-1;
    	  		  
    	  			//lista.insertar( iniT[taskn],finT[taskn],taskn );
    	  		  
    	  			for( int t1=1;t1<=ta;t1++ ) 
    	      		  arr[j++]=taskn;    	      	 		
    	  		
    	  			break;
    	  		}
    	  	}
    	  	espaciosDisp-=ta;
			return true;
      	  
      }
    
      public void verMapa() {
    	  //Inicializamos la matriz en ceros para reordenarla con la actualización
    	  for(int i=0;i<1000;i++)
      		for(int j=0;j<8;j++)
      			map[i][j]=0;
    	  //Actualización del mapa con arr[]    	  
    	  int espacioOcupado=0;
    	  for(int i=0;i<arr.length;i++)
    		  if(arr[i]!=0) {
    			  int tem=i-1;
    			  int mod=tem/8;
    			  map[mod][tem%8]=1;
    		  }
    			  
    	  System.out.print("\n---MAPA DE BITS---\n");
    	  for(int i=0;i<(int)Math.ceil(size/8)+1;i++) {
    		  for(int j=0;j<8;j++) {
    			  System.out.print(map[i][j]+" ");
    		  }
    		  System.out.print("\n");
    	  }
    	  System.out.print("\n\n");
      }
      
      public void VerListaLigadaTask() {
    	  if(taskn==0)
    		  lista.insertar(1, size, 0);
    	 
    	  System.out.println("Las tareas actuales son:  [inicio|ID|fin]\n");
    	  System.out.println(lista+"\n\n");
      }
      
      public void VerTareas() {
    	  System.out.println("Las tareas actuales son:\n");
			for(int i=1;i<=taskn; i++ )
				if( tareas[i]!=0 ) { 
					System.out.println("\tTarea "+i+" tamaño="+tareas[i]+" inicio="+iniT[i]+" final="+finT[i]);
				}
      }
      
      public void EliminarID(int yo) {
    	  if( tareas[yo]==0 )
    		  return;
    	  tareas[yo]=0;
    	  for( int i=1;i<=size;i++ )
    		  if( arr[i]==yo ) {
    			  arr[i]=0;
    			  espaciosDisp+=tareas[i];  
    		  }
    	  
    	  lista.buscar( iniT[yo],finT[yo],0,yo   );
    	  
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
    	lista=new LSL();
    	for(int i=1;i<=size;i++) {
    		if( arr[i]!=0 ) {
    			tip=arr[i];
  
    			tam=finT[ tip ]-iniT[ tip ]+1;  
    			
    			for(int j=1;j<=size;j++)
    				if( arr[j]==tip )
    					arr[j]=0;
    			
    			iniT[tip]=pos;
    			
    			for(int j=1;j<=tam;j++)
    				copia[pos++]=tip;
    			
    			finT[tip]=pos-1;
    	lista.insertar(iniT[tip], finT[tip], tip  );
    			///this.VerRam();
    		}
    	}
    	
    	for(int i=1;i<=size;i++)
    		arr[i]=copia[i];
      }
      
      public void setTask(int t) {
      	taskn=t;
      }
      public int getTask() {
      	return taskn;
      }
      
      
      
      
}
