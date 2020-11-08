import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPago extends JFrame{
	int hancho,alto;
	JPanel PagoPanel;
	Empresa Tienda;
	CajaTexto Caja;
	
	public VentanaPago ( Empresa tiendita ) {
		Tienda=tiendita; 
		hancho=550;
		alto=200;
		setVisible(true);          
		//System.out.println(ArrMapas[1].n+" "+ArrMapas[1].m);
		setTitle("paga por tus productos");
		setBounds(200,200,hancho,alto);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		ConfigurarPanel();
		ConfigurarTexto();
		ConfigurarCajaDeTexto();
		ConfigurarBotonPago();
		PagoPanel.setVisible(true);
	}
	public void ConfigurarPanel() {
		PagoPanel=new JPanel();
		// configuramos el panel
		PagoPanel.setLayout(null);
		PagoPanel.setBackground( Color.gray );
		PagoPanel.setBounds(50,50,hancho,alto);
		this.getContentPane().add( PagoPanel );
	}
	
	public void ConfigurarTexto() {
		String txt="";
		txt="inserta un monto mayor o igual con el que vas a pagar, monto=";
		int suma=0;
		
		for(int i=1;i<=Tienda.TotProd;i++)
			suma+=Tienda.ListaP[i].Ventas*Tienda.ListaP[i].Precio;
		txt+=suma;
		Tienda.VentaCliente=suma;

		Letrero oracion=new Letrero( txt ,10,10,500,50);
		PagoPanel.add( oracion );
		
	}

	public void ConfigurarCajaDeTexto() {
		Caja=new CajaTexto( 10,110 );
		PagoPanel.add( Caja );
	}
	
	public void ConfigurarBotonPago() {
		BotonPago Pagar=new BotonPago(350,100);
		ActionListener oyentePago=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caja.CheckNumero();
				Tienda.PagoCliente=Caja.Valor;
				if( Caja.numero==true && Caja.Valor>=Tienda.VentaCliente ) {
					VentanaTicket ticket= new VentanaTicket(Tienda);
					setVisible(false);
				}
			}
		};
		
		Pagar.addActionListener( oyentePago );
		PagoPanel.add( Pagar );
	}
}

