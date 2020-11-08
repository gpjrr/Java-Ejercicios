import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPago extends JFrame{
	int hancho,alto; //las dimensiones de la ventana
	JPanel PagoPanel; // el panel de la ventana
	Empresa Tienda;// recibimos la informacion de la empresa
	CajaTexto Caja; // necesitamos una caja de texto para saber con cuanto pagara el cliente
	
	public VentanaPago ( Empresa tiendita ) {
		Tienda=tiendita;  // almacenamos la informacion de la empresa
		hancho=550;// determinamos las dimensiones
		alto=200;
		setVisible(true);          ///hacemos visible la ventana
		//System.out.println(ArrMapas[1].n+" "+ArrMapas[1].m);
		setTitle("paga por tus productos"); /// el titulo de la ventana
		setBounds(200,200,hancho,alto); // determinamos la ubicacion y dimension de la ventana 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE); // se cerrara la ventana al parar el codigo
		///  usamos funciones internas para administrar mejor el codigo
		ConfigurarPanel();
		ConfigurarTexto();
		ConfigurarCajaDeTexto();
		ConfigurarBotonPago();
		/// hacemos visible el panel
		PagoPanel.setVisible(true);
	}
	
	public void ConfigurarPanel() {
		PagoPanel=new JPanel();// construimos el panel
		// configuramos el panel
		PagoPanel.setLayout(null);
		PagoPanel.setBackground( Color.gray );/// le damos color
		PagoPanel.setBounds(50,50,hancho,alto);// definimos las dimensiones y ubicacion
		this.getContentPane().add( PagoPanel );// metemos el panel a la ventana
	}
	
	public void ConfigurarTexto() {
		String txt=""; /// guardamos el texto que vamos a mostrar
		txt="inserta un monto mayor o igual con el que vas a pagar, monto=";
		int suma=0;
		
		for(int i=1;i<=Tienda.TotProd;i++) /// vemos cuanto va a pagar en total el cliente
			suma+=Tienda.ListaP[i].Ventas*Tienda.ListaP[i].Precio;
		txt+=suma;// metemos al string el valor de la suma para mostrarlo
		
		Tienda.VentaCliente=suma; /// guardamos el total para usarlo en el ticket

		Letrero oracion=new Letrero( txt ,10,10,500,50); /// construimos la etiqueta con el texto de arriba
		PagoPanel.add( oracion ); ///agregamos la etiqueta al panel
		
	}

	public void ConfigurarCajaDeTexto() { 
		Caja=new CajaTexto( 10,110 );// contruimos la caja de texto
		PagoPanel.add( Caja );/// metemos la caja al panel
	}
	
	public void ConfigurarBotonPago() {
		BotonPago Pagar=new BotonPago(350,100); /// construimos el boton de pago 
		// creamos al oyente para programar las acciones a realizar tras presionar el boton
		ActionListener oyentePago=new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Caja.CheckNumero(); /// convertimos el texto que se ingreso a un valor 
				Tienda.PagoCliente=Caja.Valor; // guardamos el numero
				//checamos que no hayan errores y que el valor sea mayor a lo que se va apagar
				if( Caja.numero==true && Caja.Valor>=Tienda.VentaCliente ) {
					VentanaTicket ticket= new VentanaTicket(Tienda); //construimos la ventana del ticket
					setVisible(false);// dejamos de mostrar la ventana actual
				}
			}
		};
		Pagar.addActionListener( oyentePago );// agregamos la configuracion del boton al boton
		PagoPanel.add( Pagar ); // agregamos el boton al panel 
	}
}

