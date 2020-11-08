import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaError extends JFrame{
	int hancho,alto;
	JPanel ErrorPanel;
	int NumeroError;
	public VentanaError (int numerror) {
		NumeroError=numerror;
		hancho=600;
		alto=110;
		setVisible(true);          
		//System.out.println(ArrMapas[1].n+" "+ArrMapas[1].m);
		setTitle("Error de compra");
		setBounds(200,200,hancho,alto);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		ConfigurarPanel();
		ConfigurarTexto();
		ErrorPanel.setVisible(true);
	}
	public void ConfigurarPanel() {
		ErrorPanel=new JPanel();
		// configuramos el panel
		ErrorPanel.setLayout(null);
		ErrorPanel.setBackground( Color.gray );
		ErrorPanel.setBounds(50,50,hancho,alto);
		this.getContentPane().add(ErrorPanel);
	}
	public void ConfigurarTexto() {
		String txt="";
		if( NumeroError==1 )
		txt="Las cajas de texto deben tener unicamente caracteres de digitos";	
		else
		if( NumeroError==2 )
		txt="No puedes Comprar mas de 5 productos.";
		else
		if( NumeroError==3 )
		txt="No puedes comprar mas productos de los que existen";
		
		
		
		Letrero punto1=new Letrero( txt ,10,10,500,50);
		ErrorPanel.add(punto1);
		
	}
}
