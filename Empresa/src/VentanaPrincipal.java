import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VentanaPrincipal extends JFrame{
	int hancho,alto;
	Empresa Tienda; 
	JPanel MenuPanel;
	Letrero[] Encabezados= new Letrero[100];
	Letrero[] ProdName= new Letrero[100];
	Letrero[] ProdPzas= new Letrero[100];
	Letrero[] ProdPrice= new Letrero[100];	
	CajaTexto[] Cajita=new CajaTexto[100];
	
	public VentanaPrincipal(Empresa walmart) {
		hancho=1000; 
		alto=600;
		Tienda=walmart;
		setTitle("Lista De Productos");
		setBounds(50,50,hancho,alto);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		ConfigurarPanel();
		ConfigurarProductos();
		ConfigurarBotonComprar();
		ConfigurarEncabezado();
		
		setVisible(true);          
		MenuPanel.setVisible(true);
	}
	
	public void ConfigurarPanel() {
		MenuPanel=new JPanel();
		// configuramos el panel
		MenuPanel.setLayout(null);
		MenuPanel.setBackground( Color.blue );
		MenuPanel.setBounds(50,50,hancho,alto);
		this.getContentPane().add(MenuPanel);
	}
	
	public void ConfigurarBotonComprar() {
		BotonComprar Comprar=new BotonComprar();
		ActionListener oyenteCompra=new ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				boolean Validar=true;
				boolean Inventario=true;
				int carrito=0;
				for(int i=1;i<=Tienda.TotProd;i++) {
					Cajita[i].CheckNumero();
					if( Cajita[i].numero==false )
						Validar=false;
					if( Cajita[i].Valor>Tienda.ListaP[i].Piezas ) 
						Inventario=false;
					carrito+=Cajita[i].Valor;
					
					
					
					Tienda.ListaP[i].Ventas=Cajita[i].Valor;
				}	
				Tienda.ProductosCliente=carrito;
				
				int tipoerror=0;
				if( Validar==false )
					tipoerror=1;
				else
				if( carrito>5 )
					tipoerror=2;
				else
				if( Inventario==false )
					
					tipoerror=3;
				
				VentanaPago pagar;
				VentanaError error;
				
				if( tipoerror==0 ) {
					pagar=new VentanaPago( Tienda );
					setVisible(false);
				}
				else
					error=new VentanaError(tipoerror);
	
			}
		};
		Comprar.addActionListener( oyenteCompra );
		MenuPanel.add( Comprar );
	}
	
	public void ConfigurarEncabezado() {
		Encabezados[1]=new Letrero("producto",10,20,100,50);
		Encabezados[2]=new Letrero("piezas",300,20,100,50);
		Encabezados[3]=new Letrero("precio",450,20,100,50);
		Encabezados[4]=new Letrero("compra",600,20,100,50);
		for(int i=1;i<=4;i++)
			MenuPanel.add( Encabezados[i] );
		
	}

	public void ConfigurarProductos() {
		for(int i=1;i<=Tienda.TotProd;i++) {
			String NombreP=Tienda.ListaP[i].Nombre;
			ProdName[i]=new Letrero( NombreP,10,50+i*40,250,30 );
			MenuPanel.add( ProdName[i] );
			
			String piezas=String.valueOf( Tienda.ListaP[i].Piezas );
			ProdPzas[i]=new Letrero(piezas,300,50+i*40,30,30 );
			MenuPanel.add( ProdPzas[i] );
			
			String price=String.valueOf( Tienda.ListaP[i].Precio );
			ProdPrice[i]=new Letrero(price,450,50+i*40,30,30 );
			MenuPanel.add( ProdPrice[i] );
			
		
			Cajita[i]=new CajaTexto( 600,50+i*40 );
			MenuPanel.add( Cajita[i] );
			
		}
	}
}
