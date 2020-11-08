import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaTicket extends JFrame{
	Empresa Tienda;
	JPanel TicketPanel;
	int hancho,alto;
	Letrero[] Encabezados= new Letrero[10];
	Letrero[] ProdName= new Letrero[100];
	Letrero[] ProdPzas= new Letrero[100];
	Letrero[] ProdPrice= new Letrero[100];
	Letrero Total,DineroTotal;
	Letrero Pago,DineroPago;
	Letrero Cambio,DineroCambio;
	Letrero Piezas,TotalPiezas;
	
	public VentanaTicket(Empresa tienda) {
		Tienda=tienda;
		hancho=600;
		
		alto=100+40*( 5+Tienda.ProductosCliente );
		setTitle("Ticket De Compra");
		setBounds(50,50,hancho,alto);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		ConfigurarPanel();
		ConfigurarEncabezado();
		ConfigurarProductos();
		ConfigurarTextoFinal();
		ConfigurarBotonSalir();
		ConfigurarBotonVenta();
		setVisible( true );
		TicketPanel.setVisible(true);
	}
	public void ConfigurarPanel() {
		TicketPanel=new JPanel();
		TicketPanel.setLayout(null);
		TicketPanel.setBackground( Color.white );
		TicketPanel.setBounds(50,50,hancho,alto);
		this.getContentPane().add(TicketPanel);
	}
	public void ConfigurarEncabezado() {
		Encabezados[1]=new Letrero("producto",10,20,100,50);
		Encabezados[2]=new Letrero("piezas",300,20,100,50);
		Encabezados[3]=new Letrero("Costo",450,20,100,50);
		for(int i=1;i<=3;i++)
			TicketPanel.add( Encabezados[i] );
	}
	public void ConfigurarProductos() {
		for(int i=1,con=1;i<=Tienda.TotProd;i++)
			if( Tienda.ListaP[i].Ventas!=0 ) {
				String NombreP=Tienda.ListaP[i].Nombre;
				ProdName[i]=new Letrero( NombreP,10,50+con*40,250,30 );
				TicketPanel.add( ProdName[i] );
				
				String piezas=String.valueOf( Tienda.ListaP[i].Ventas );
				ProdPzas[i]=new Letrero(piezas,300,50+con*40,50,30 );
				TicketPanel.add( ProdPzas[i] );
				
				int res=Tienda.ListaP[i].Ventas*Tienda.ListaP[i].Precio;
				String price=String.valueOf( res );
				ProdPrice[i]=new Letrero(price,450,50+con*40,50,30 );
				TicketPanel.add( ProdPrice[i] );
				con++;
			}
	}
	public void ConfigurarTextoFinal() {
		String Tem; 
		int pos=40*Tienda.ProductosCliente+50;		
		pos+=40;
		Tem="Total";
		Total=new Letrero(Tem,300,pos,100,30);
		TicketPanel.add( Total );
		Tem=String.valueOf( Tienda.VentaCliente );
		DineroTotal=new Letrero(Tem,450,pos,50,30);
		TicketPanel.add( DineroTotal );
		
		pos+=40;
		Tem="Pago";
		Pago=new Letrero(Tem,300,pos,100,30);
		TicketPanel.add( Pago );
		Tem=String.valueOf( Tienda.PagoCliente );
		DineroPago=new Letrero(Tem,450,pos,50,30);
		TicketPanel.add( DineroPago );
		
		pos+=40;
		Tem="Cambio";
		Cambio=new Letrero(Tem,300,pos,100,30);
		TicketPanel.add( Cambio );
		int Resta=Tienda.VentaCliente-Tienda.PagoCliente;
		Tem=String.valueOf( -Resta );
		DineroCambio=new Letrero(Tem,450,pos,50,30);
		TicketPanel.add( DineroCambio );
	
		pos+=40;
		Tem="Piezas";
		Piezas=new Letrero(Tem,300,pos,100,30);
		TicketPanel.add( Piezas );
		Tem=String.valueOf( Tienda.ProductosCliente );
		TotalPiezas=new Letrero(Tem,450,pos,50,30);
		TicketPanel.add( TotalPiezas );
	}
	public void ConfigurarBotonSalir() {
		int y=Tienda.ProductosCliente*40+90;
		BotonSalir Salir=new BotonSalir(10,y);
		ActionListener oyenteSalir=new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				System.exit(0);
				///exit(0);
			}
		};
		Salir.addActionListener( oyenteSalir );
		TicketPanel.add( Salir );
	}
	public void ConfigurarBotonVenta() {
		int y=Tienda.ProductosCliente*40+90+80;
		
		BotonVenta VentaB=new BotonVenta(10,y);
		
		ActionListener oyeVenta=new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Tienda.Actualizar();
				setVisible(false);
				VentanaPrincipal Ventana=new VentanaPrincipal(Tienda);
			}
		};
		VentaB.addActionListener( oyeVenta );
		TicketPanel.add( VentaB );
	}

}
