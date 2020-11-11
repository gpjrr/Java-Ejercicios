
import java.awt.Font;
import javax.swing.JButton;
public class BotonSalir extends JButton{
	public BotonSalir (int x1,int y1) { // recibimos la posicion del boton
		setVisible( true );// mostramos el boton
		setText("Salir");//configuramos el texto
		setEnabled(true);// interaccion boton
		setFont( new Font("Serif",Font.BOLD ,15) );// configuramos la fuente
		setBounds(x1, y1, 150, 50);// configuramos las dimensiones y posicion
	}
}

