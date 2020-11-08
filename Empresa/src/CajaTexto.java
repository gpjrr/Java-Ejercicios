import javax.swing.JTextField;

public class CajaTexto extends JTextField{
	String Palabra;
	boolean numero;
	int Valor;
	public CajaTexto(int x1,int y1) {
		setText("0");
		setBounds(x1,y1,60,30);
	}
	public void CheckNumero(){
		numero=true;
		Palabra=this.getText();
		for(int i=0;i<Palabra.length();i++)
			if( Palabra.charAt(i)<'0'  || Palabra.charAt(i)>'9' )
				numero=false;
		if( numero==true )
			Valor=Integer.parseInt( Palabra );
		else
			Valor=0;
	}
}
