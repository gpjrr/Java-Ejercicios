import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Letrero extends JLabel{
	// el constructor recibe el texto la ubicacion XY y las dimensiones
	public  Letrero( String Cadena,int x1,int y1,int largo,int ancho) {
		setText(Cadena);// colocamos el texto
		
		setOpaque(true); //le damos un fondo opaco
		setHorizontalAlignment( SwingConstants.CENTER );// centramos texto creooo 
		setVerticalAlignment( SwingConstants.CENTER );
		setLayout( null );
		//setLocation(x1,y1);

		setForeground( Color.black );/// le damos color
		setFont( new Font("Serif",Font.BOLD ,15) ); // editamos la fuente
		setBounds(x1,y1,largo,ancho); /// editamos las dimensiones y su posicion
	}
	
}
