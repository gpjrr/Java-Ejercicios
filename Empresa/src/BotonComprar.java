import java.awt.Font;
import javax.swing.JButton;

public class BotonComprar extends JButton{
	public BotonComprar() {
		setVisible( true );
		setText("Realizar Compra");
		setEnabled(true);// interaccion boton
		setMnemonic('b');//alt+letra
		setFont( new Font("Serif",Font.BOLD ,15) );
		setBounds(840, 510, 150, 50);
	}
}
