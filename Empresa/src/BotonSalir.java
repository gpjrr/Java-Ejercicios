
import java.awt.Font;
import javax.swing.JButton;
public class BotonSalir extends JButton{
	public BotonSalir (int x1,int y1) {
		setVisible( true );
		setText("Salir");
		setEnabled(true);// interaccion boton
		setFont( new Font("Serif",Font.BOLD ,15) );
		setBounds(x1, y1, 150, 50);
	}
}

