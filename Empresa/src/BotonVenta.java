
import java.awt.Font;
import javax.swing.JButton;
public class BotonVenta extends JButton{
	public BotonVenta(int x1,int y1) {
		setVisible( true );
		setText("Nuevo \n Cliente");
		setEnabled(true);// interaccion boton
		setFont( new Font("Serif",Font.BOLD ,15) );
		setBounds(x1, y1, 150, 50);
	}
}

