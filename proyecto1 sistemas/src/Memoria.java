
public class Memoria {
	int size;
	int empty;
	int pos;
	Task[] arr=new Task[300];
	
	
	
     public Memoria(int n) {
    	size=n;
    	pos=0;
    	empty=n;
    	for(int i=0;i<=200;i++)
    	arr[i]=new Task(1,"",-1);
      }
     
     public void Delete(int pos) {
    	 empty+=arr[pos].Size;
    	 arr[pos].live=false;
     }
     
     
     public boolean Insert( Task niu ) {
    	if( empty<niu.Size ) 
    		return false;
    	resort();
    	
    	/// maybe
    	niu.SetPos( arr[pos].fin+1 );
    	empty-=niu.Size;
    	pos++;
    	arr[pos]=niu;
    	
    	return true;
    }
   
    public void resort() {
    	Task[] copy=new Task[300];
    	for(int i=0;i<=200;i++)
    		copy[i]=new Task(1,"",-1);
    	
    	int pos2=0;
    	for(int i=1;i<=pos;i++) 
    		if( arr[i].live==true ) {
    			pos2++;
    			copy[pos2]=arr[i].clone();
    			copy[pos2].SetPos( copy[pos2-1].fin+1 );
    		}
    	
    	for(int i=1;i<=pos2;i++) {
    		//arr[i]=new Task( copy[i].Size,copy[i].Name, copy[i].state  );
    		arr[i]=copy[i].clone();
    		arr[i].SetPos( arr[i-1].fin+1 );

    	}
    	//arr=copy;
    	//pos-=(pos2-pos );
    	pos=pos2;
    }
     
     public String ViewTask() {
    	 String cad="";
    	 String word="";
    	 int con=1;
    	 for(int i=1;i<=pos;i++) 
    		 if( arr[i].live==true ) {
    			if( arr[i].state==1 )
    			 word="espera";
    			else
    			if( arr[i].state==2 )
    				word="listo";
    			else
    				word="ejecucion";
   cad+=arr[i].Name+" ["+arr[i].ini+","+arr[i].fin+"] "+word+"\n";
    			 //con++;
    		 }
    	 return cad;
     }
     
     public String ListaLigada() {
    	 String cad="";
    	 for(int i=1;i<=this.pos;i++)
    		 if( arr[i].live==true )
    		 cad+="["+arr[i].ini+" "+arr[i].Name+" "+arr[i].fin+"] ";
    		 else
    		 cad+="["+arr[i].ini+" _ "+arr[i].fin+"] ";
    			 
    	 int ss=arr[pos].fin+1;
    		if( arr[ pos ].fin<size ) 
    			 cad+="["+ss+" _ "+size+"] ";
    	 return cad;
     }
     
     public String Arreglo() {
    	 String cad="";
    	 int ubi=1;
    	 for(int i=1;i<=size;i++) { 
    		 if( i>arr[ubi].fin )ubi++;
    		 if( ubi<=this.pos ) {
    			 if( arr[ubi].live==true )
    			 	cad+=arr[ubi].Name+" ";
    			 else
    				 cad+="_ ";
    		 }
    		 else
    			 cad+="_ ";
    		 
    	 }
    	 
    	 return cad;
     }
     public String Mapa() {
    	 String cad="";
    	 int ubi=1;
    	 int tito= size+8-(size%8) ;
    	 for(int i=1;i<=tito;i++) { 
    		 if( i>arr[ubi].fin )ubi++;
    		 if( ubi<=this.pos ) {
    			 if( arr[ubi].live==true )
    			 	cad+="1"+" ";
    			 else
    				 cad+="0 ";
    		 }
    		 else
    			 cad+="0 ";
    		 if(i%8==0)
    			 cad+="\n";
    	 }
    	 return cad;
     }
     
     public void shuffle(int bg,int nd) {
    	 for(int i=bg;i<=nd;i++) 
    		 arr[i].RandomState();
    	 
     }
     
     
}
