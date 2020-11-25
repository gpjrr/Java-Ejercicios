

public class Sintonizador {
	
	double frecuencia;
	//Constructor por defecto
	    public Sintonizador (double frecuencia) {
	        this.frecuencia = frecuencia;
	    }

	       //Métodos 
	        public void frecuenciaSubir(){
	        	frecuencia+=0.5;
	        	if( frecuencia>108 )
	        		frecuencia=80;
	            
	        }
	    
	        public void  frecuenciaBajar(){
	        	frecuencia-=0.5;
	        	if( frecuencia<80 )
	        		frecuencia=108;
	        }   
	    
	    //Set frecuencia
	    public void setFrecuencia(double frecuencia){
	        this.frecuencia = frecuencia;
	    }
	    //Get frecuencia
	    public double getFrecuencia(){
	        return frecuencia;
	    }
	 	
}



