import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.SwingConstants;
public class BotonStart extends JButton{
	public BotonStart() {
		setVisible(true);
		setText("Comenzar");
		setEnabled(true);// interaccion boton
		setMnemonic('a');//alt+letra
		setFont( new Font("Serif",Font.BOLD ,20) );
		setBounds(400,300 , 200, 100);
		
		//addActionListener( oyente );
	}	
	
	
}
