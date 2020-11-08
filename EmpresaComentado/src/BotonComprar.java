import java.awt.Font;
import javax.swing.JButton;

public class BotonComprar extends JButton{
	public BotonComprar() { // recibimos la posicion del boton
		setVisible( true );// mostramos el boton
		setText("Realizar Compra");//configuramos el texto
		setEnabled(true);// interaccion boton
		setMnemonic('b');//alt+letra
		setFont( new Font("Serif",Font.BOLD ,15) );// configuramos la fuente
		setBounds(840, 510, 150, 50);// configuramos las dimensiones y posicion
	}
}
