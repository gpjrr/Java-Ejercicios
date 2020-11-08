import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Letrero extends JLabel{
	public  Letrero( String Cadena) {
		setText(Cadena);
		setOpaque(true);
		setHorizontalAlignment( SwingConstants.CENTER );
		setVerticalAlignment( SwingConstants.CENTER );
		setLayout( null );
		setForeground( Color.RED );
		setFont( new Font("Serif",Font.BOLD ,50) );
		setBounds(0,00,1000,100  );
	}
}
