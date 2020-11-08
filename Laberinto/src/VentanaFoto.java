import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaFoto extends JFrame{
	public VentanaFoto(String Nombre) {
		setVisible(true); 
		setTitle("Fotografia del equipo");
		JLabel Nosotros=new JLabel( new ImageIcon(Nombre) );

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		add( Nosotros );
		//setBounds(0,0, (Mapita.m)*10 , (Mapita.n)*10 );
		setLocationRelativeTo(null);
	}
	
}
