import javax.swing.JTextField;

public class CajaTexto extends JTextField{
	String Palabra; /// aqui almacenanmos la palabra que inserta el usuario
	boolean numero; /// es una bandera para ver si es un numero
	int Valor; // el valor del posbile numero
	public CajaTexto(int x1,int y1) {
		setText("0"); /// configura el contenido inicial de la caja
		setBounds(x1,y1,60,30); // configura las dimensiones y el tamano
	}
	public void CheckNumero(){
		numero=true; // afirmamos que va a ser un numero 
		Palabra=this.getText(); // obtenemos el texto de la caja 
		for(int i=0;i<Palabra.length();i++) // vemos sobre cada letra que hay unicamente caracteres de digito
			if( Palabra.charAt(i)<'0'  || Palabra.charAt(i)>'9' )
				numero=false; // si alguno no es un digito desactivamos la bandera
		if( numero==true ) // si la bandera dice que es un numero entonces obtenemos el valor
			Valor=Integer.parseInt( Palabra );
		else
			Valor=0; // en caso de que no lo hacemos 0 
	}
}
