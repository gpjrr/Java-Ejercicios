import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
public class Task implements Cloneable{
	int Size;
	int ini,fin;
	String Name;
	int state;
	boolean live;

	/// 1=wait 2=ready 3=running  
	
	Task(int tam,String nombre ,int stado){
		live=true;
		Size=tam;
		ini=0;
		fin=tam-1;
		Name=nombre;
		if( stado==-1 ) {
		/// llenar state
			int sts=ThreadLocalRandom.current().nextInt(1, 10 + 1);
			
			if( sts>5 ) 
				state=3;
			else {
				if( sts<=2 )
				state=2;
					else 
				state=1;
			}			
		}
		else
			state=stado;
	///	System.out.println(nombre+")"+stado+"_"+state);
	}

	public void SetPos(int p){
		ini=p;
		fin=p+Size-1;
	}
	
	public void RandomState() {
		Random stupid=new Random();
		state=stupid.nextInt( 1000 );
		state%=3;
		if( state==0 )
			state++;
	}
	
	public String toString() {
		String cad="";
			cad+=ini+"_"+fin+" "+Name+" "+state+"\n";
		return cad;
	}

	public Task clone() {
		Task cosa=null;
		try{
            cosa=(Task) super.clone();
     
		}catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
		return cosa;
	}
}
