
public class Nodo {
	String Pais;
	String Bandera,Capital;
	Boolean punto;
	String Respuesta;
	Nodo nxt,prv;
	
	public Nodo(String pais,String capital) {
		Pais=pais;
		Bandera=pais+".png";
		Capital=capital;
		nxt=null;
		prv=null;
	
		punto=false;
		Respuesta="";
	}
	public String toString() {
		String Cad=Pais+" "+Capital+" "+Bandera;
		return Cad;
	}
}
