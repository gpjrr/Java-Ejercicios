import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaTicket extends JFrame{
	Empresa Tienda; // guardamos la informacion de la tienda
	JPanel TicketPanel; // el panel de la ventana
	int hancho,alto; // las dimensiones de la ventana
	
	/// todas estas varibles seran etiquetas para mostrar la informacion
	Letrero[] Encabezados= new Letrero[10]; // guardamos las etiquetas de los encabezados
	Letrero[] ProdName= new Letrero[100]; // de los productos  
	Letrero[] ProdPzas= new Letrero[100]; // las piezas que vendiero por cada producto
	Letrero[] ProdPrice= new Letrero[100]; // el precio por producto
	Letrero Total,DineroTotal;// el total y el valor
	Letrero Pago,DineroPago; /// con cuanto pago el cliente
	Letrero Cambio,DineroCambio; /// cuanto le debemos dar de cambio
	Letrero Piezas,TotalPiezas; /// cuantas piezas compro el cliente
	
	public VentanaTicket(Empresa tienda) {
		Tienda=tienda;// guardamos la informacion de la tienda 
		hancho=600; // damos las dimensiones
		// la altura depende del total de productos que compro
		alto=100+40*( 5+Tienda.ProductosCliente );
		setTitle("Ticket De Compra"); // configuramos el titulo de la ventana
		setBounds(50,50,hancho,alto); /// configuramos las dimensiones y la posicion de la ventana
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(this.EXIT_ON_CLOSE); // se cierra la ventana cuando se detiene el codigo
		// las configuraciones que se llaman  en funciones de la misma clase para fines de orden
		ConfigurarPanel(); 
		ConfigurarEncabezado();
		ConfigurarProductos();
		ConfigurarTextoFinal();
		ConfigurarBotonSalir();
		ConfigurarBotonVenta();
		setVisible( true ); /// mostramos la ventana
		TicketPanel.setVisible(true); /// mostramos el panel
	}
	
	public void ConfigurarPanel() {
		TicketPanel=new JPanel(); /// construimos el panel 
		TicketPanel.setLayout(null); 
		TicketPanel.setBackground( Color.white );//le damos color 
		TicketPanel.setBounds(50,50,hancho,alto); /// configuramos sus dimensiones
		this.getContentPane().add(TicketPanel); // agregamos el panel a la ventana
	}
	public void ConfigurarEncabezado() {
		// construimos todas las etiquetas que son encabezados
		Encabezados[1]=new Letrero("producto",10,20,100,50);
		Encabezados[2]=new Letrero("piezas",300,20,100,50);
		Encabezados[3]=new Letrero("Costo",450,20,100,50);
		// agregamos todas ellas al panel 
		for(int i=1;i<=3;i++)
			TicketPanel.add( Encabezados[i] );
	}
	
	
	public void ConfigurarProductos() {
		/// iteramos sobre todos los productos
		for(int i=1,con=1;i<=Tienda.TotProd;i++)
			if( Tienda.ListaP[i].Ventas!=0 ) {/// verificamos si el cliente adquirio ese tipo producto
				
				String NombreP=Tienda.ListaP[i].Nombre;/// guardamos en un string el nombre del producto
				ProdName[i]=new Letrero( NombreP,10,50+con*40,250,30 ); // construimos la etiqueta con el nombre 
				TicketPanel.add( ProdName[i] ); /// agregamos la etiqueta al panel 
				
				String piezas=String.valueOf( Tienda.ListaP[i].Ventas ); // guardamos el total de piezas que va a comprar
				ProdPzas[i]=new Letrero(piezas,300,50+con*40,50,30 ); // construimos la etiqueta con el valor 
				TicketPanel.add( ProdPzas[i] ); // agregamos la etiqueta al panel
				
				int res=Tienda.ListaP[i].Ventas*Tienda.ListaP[i].Precio; /// obtenemos el valor de cuanto va aa pagar por ese tipo de producto
				/// es precio*total de piezas
				String price=String.valueOf( res ); // convertimos el valor a un string
				ProdPrice[i]=new Letrero(price,450,50+con*40,50,30 ); /// construimos la etiqueta con el valor
				TicketPanel.add( ProdPrice[i] ); // agregamos la etiqueta al panel
				con++; // el contador nos ayuda a colocar la informacion de cada producto sobre una fila
				// es un equivalente a desplazar la fila para el siguiente producto
			}
	}
	// configura los ultimas linas del ticket 
	public void ConfigurarTextoFinal() {
		String Tem;  // un string temporal 
		
		
		int pos=40*Tienda.ProductosCliente+50; /// pos nos ayuda a ubicarnos en las filas para conservar una buena distancia		
		pos+=40; // bajamos de fila
		Tem="Total"; // guardamos el texto
		Total=new Letrero(Tem,300,pos,100,30);// construimos la etiqueta
		TicketPanel.add( Total ); //agregamos la etiqueta al panel
		Tem=String.valueOf( Tienda.VentaCliente ); // guardamos el valor del total a un string 
		DineroTotal=new Letrero(Tem,450,pos,50,30);// construimos la etiqueta
		TicketPanel.add( DineroTotal );//agregamos la etiqueta al panel
		
		pos+=40;// bajamos de fila
		Tem="Pago";// guardamos el texto
		Pago=new Letrero(Tem,300,pos,100,30); // construimos la etiqueta
		TicketPanel.add( Pago ); //agregamos la etiqueta al panel
		Tem=String.valueOf( Tienda.PagoCliente ); //guardamos el valor del pago del cliente 
		DineroPago=new Letrero(Tem,450,pos,50,30); // construimos la etiqueta
		TicketPanel.add( DineroPago ); // agregamos la etiqueta al panel 
		
		pos+=40; //bajamos de fila 
		Tem="Cambio"; // guardamos el texto
		Cambio=new Letrero(Tem,300,pos,100,30);// construimos la etiqueta
		TicketPanel.add( Cambio ); // agregamos la etiqueta al panel 
		int Resta=Tienda.VentaCliente-Tienda.PagoCliente; /// obtenemos el cambio restando el total con el pago 
		Tem=String.valueOf( -Resta ); // convertimos el resultado a un string
		DineroCambio=new Letrero(Tem,450,pos,50,30); /// construimos la etiqueta
		TicketPanel.add( DineroCambio ); // agregamos la etiqueta al panel
	
		pos+=40; // bajamos de fila 
		Tem="Piezas"; //guardamos el texto 
		Piezas=new Letrero(Tem,300,pos,100,30);// consturimos la etiqueta
		TicketPanel.add( Piezas ); //agregamos la etiqueta
		Tem=String.valueOf( Tienda.ProductosCliente ); // convertimos el total de productos 
		TotalPiezas=new Letrero(Tem,450,pos,50,30);// construimos la etiqueta
		TicketPanel.add( TotalPiezas ); // agregamos la etiqueta al panel 
	}
	public void ConfigurarBotonSalir() {
		int y=Tienda.ProductosCliente*40+90; // la coordenada en Y
		BotonSalir Salir=new BotonSalir(10,y); //construiomos el boton 
		ActionListener oyenteSalir=new ActionListener() { // construimos la funcion por realizar al presionar el boton
			public void actionPerformed(ActionEvent ae) {
				setVisible(false); //borramos la ventana
				System.exit(0); // detenemos el codigo
				///exit(0);
			}
		};
		Salir.addActionListener( oyenteSalir );// agregamos la funcion al boton
		TicketPanel.add( Salir ); // agregamos el boton al panel
	}
	public void ConfigurarBotonVenta() { 
		int y=Tienda.ProductosCliente*40+90+80; // configuramos la coordenada de y 
		BotonVenta VentaB=new BotonVenta(10,y); // construimos el boton
		
		ActionListener oyeVenta=new ActionListener() { // construimos la funcion por realizar al presionar el boton
			public void actionPerformed(ActionEvent ae) {
				
				Tienda.Actualizar(); //actualizamos la informacion de los productos 
				// actualizar el inventario
				setVisible(false); // desaparecer el ticket
				// volvemos a construir la ventana principal mandando la nueva informacion
				VentanaPrincipal Ventana=new VentanaPrincipal(Tienda);
				
			}
		};
		VentaB.addActionListener( oyeVenta );// agregamos la funcion al boton
		TicketPanel.add( VentaB ); //agregamos el boton al panel
	}

}
