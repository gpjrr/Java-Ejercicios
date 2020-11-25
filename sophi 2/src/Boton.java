import java.awt.Font;
import javax.swing.JButton;

public class Boton extends JButton{
	public Boton (String palabra,int x1,int y1) {
		setVisible( true );
		setText( palabra );
		setEnabled(true);// interaccion boton
		setFont( new Font("Serif",Font.BOLD ,30) );
		setBounds(x1, y1, 70, 70);
	}
}