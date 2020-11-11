import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaError extends JFrame{
	int hancho,alto; // las dimensiones de la ventana
	JPanel ErrorPanel; // el panel para cargar el error
	int NumeroError; // reconoceremos que tipo de error es
	public VentanaError (int numerror) { // recibimos el tipo de error
		NumeroError=numerror; // guardamos el error
		hancho=600; // definimos las dimensiones
		alto=110;
		setVisible(true);          // hacemos visible la ventana
		//System.out.println(ArrMapas[1].n+" "+ArrMapas[1].m);
		setTitle("Error de compra"); // el texto superior
		setBounds(200,200,hancho,alto); /// definimos la posicion y dimension de la ventana
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE); // se cierra al detener el codigo
		// funciones internas para un mejor orden del codigo
		ConfigurarPanel(); 
		ConfigurarTexto();
		ErrorPanel.setVisible(true); //hacemos visible el panel
	}
	public void ConfigurarPanel() {
		ErrorPanel=new JPanel(); // construimos el panel
		// configuramos el panel
		ErrorPanel.setLayout(null); // desactivamos configuraciones por defaul
		ErrorPanel.setBackground( Color.gray ); /// le damos color de fondo
		ErrorPanel.setBounds(50,50,hancho,alto); /// determinamos su ubicacion y las dimensiones
		this.getContentPane().add(ErrorPanel); /// agregamos el panel a la ventana
	}
	public void ConfigurarTexto() {
		String txt="";// en texto guardamos el tipo de error que corresponde a la variable NumeroError
		if( NumeroError==1 )
		txt="Las cajas de texto deben tener unicamente caracteres de digitos";	
		else
		if( NumeroError==2 )
		txt="No puedes Comprar mas de 5 productos.";
		else
		if( NumeroError==3 )
		txt="No puedes comprar mas productos de los que existen";
		
		Letrero punto1=new Letrero( txt ,10,10,500,50); ///construimos la etiqueta
		ErrorPanel.add(punto1);/// agregamos la etiqueta al panel 
		
	}
}
