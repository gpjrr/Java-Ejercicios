import java.awt.Font;

import javax.swing.JButton;

public class BotonFoto extends JButton{
	public BotonFoto() {
		setVisible( true );
		setText("Team Dinamita");
		setEnabled(true);// interaccion boton
		setMnemonic('b');//alt+letra
		setFont( new Font("Serif",Font.BOLD ,20) );
		setBounds(0,360 , 200, 100);
		
	}
}
