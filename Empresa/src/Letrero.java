import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Letrero extends JLabel{
	public  Letrero( String Cadena,int x1,int y1,int largo,int ancho) {
		setText(Cadena);
		
		setOpaque(true);
		setHorizontalAlignment( SwingConstants.CENTER );
		setVerticalAlignment( SwingConstants.CENTER );
		setLayout( null );
		//setLocation(x1,y1);

		setForeground( Color.black );
		setFont( new Font("Serif",Font.BOLD ,15) );
		setBounds(x1,y1,largo,ancho);
	}
	
}
