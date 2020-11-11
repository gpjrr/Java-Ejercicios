import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VentanaPrincipal extends JFrame{
	int hancho,alto; // las dimensiones de la ventana
	Empresa Tienda;  // aqui guardamos la informacion de la tienda
	JPanel MenuPanel;// en el panel vamos a insertar etiquetas y botones para el diseno del programa
	Letrero[] Encabezados= new Letrero[100]; // guardaramos los encabezados principales que estaran arriba
	Letrero[] ProdName= new Letrero[100]; // guardaremos las etiquetas de los productos
	Letrero[] ProdPzas= new Letrero[100]; // guardaremos las etiquetas del total de piezas de los productos
	Letrero[] ProdPrice= new Letrero[100];	// guardaremos los precios
	CajaTexto[] Cajita=new CajaTexto[100]; /// estas seran las cajas donde el usuario inserta la cantidad de cosas que quiere comprar
	//cada producto tiene su propia caja de texto
	
	// este es el constructor de nuestra ventana
	public VentanaPrincipal(Empresa walmart) {
		hancho=1000;  // le damos el valor a las dimenesiones
		alto=600;
		Tienda=walmart;// almacenamos la informacion de la empresa
		
		setTitle("Lista De Productos"); // ponemos el titulo a la ventana
		setBounds(50,50,hancho,alto); // definimos la posicion y el tamano de la ventana
		setLocationRelativeTo(null); // desactivamos esta propiedad para que nosotros mismo la ubiquemos donde queremos
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);  // cuando el codigo acabe la ventana va a cerrar
		
		/// aqui llamamos funciones propias para darle orden a la configuracion
		ConfigurarPanel(); // en el panel colocamos todo lo que desamos
		ConfigurarProductos();
		ConfigurarBotonComprar();
		ConfigurarEncabezado();
		
		setVisible(true);          // hacemos visible la ventana
		MenuPanel.setVisible(true); // hacemos visible el panel 
	}
	
	/// construimos  el panel y lo configuramos
	public void ConfigurarPanel() {
		MenuPanel=new JPanel(); // lo construimos
		// configuramos el panel
		MenuPanel.setLayout(null); //desactivamos la configuracion para poder editar nuestro propio panel
		MenuPanel.setBackground( Color.blue ); /// le damos color al fondo
		MenuPanel.setBounds(50,50,hancho,alto);// damos dimensiones y ubicacion iguales a la ventana 
		this.getContentPane().add(MenuPanel); /// metemos el panel a la ventana
	}
	

	public void ConfigurarBotonComprar() {
		BotonComprar Comprar=new BotonComprar(); // construimos el panel
		// utilizaremos eventos y programamos la accion cuando presionen el boton
		ActionListener oyenteCompra=new ActionListener() { 
			// en esta funcion programos todo lo que se hara al presionar el boton
			public void actionPerformed( ActionEvent ae ) { 
				boolean Validar=true; /// se usara para validar los posibles errores en las cajas de texto
				boolean Inventario=true; // se usa para validar que no se quiera comprar mas de lo existente
				int carrito=0; // contamos el total de cosas que se van a comprrar
				for(int i=1;i<=Tienda.TotProd;i++) { //iteramos sobre los productos
					Cajita[i].CheckNumero(); //convertimos el texto de la caja a numero 
					if( Cajita[i].numero==false ) // checamos si es correcto el numero
						Validar=false; // si no apagamos la bandera
					if( Cajita[i].Valor>Tienda.ListaP[i].Piezas )  // vemos que no se quiera comprar mas de lo que existe en el almacen
						Inventario=false; 
					carrito+=Cajita[i].Valor; //acumulamos las piezas que se van a comprar 
					
					Tienda.ListaP[i].Ventas=Cajita[i].Valor; // guardamos por cada producto cuantas cosas se van a comprar
					// para usarlo en el ticket 
				}	
				Tienda.ProductosCliente=carrito; /// recordamos el total de productos del cliente para usarlo en el ticket
				
				int tipoerror=0; // verificamos que tipo de error puede existir en las cajas de texto
				if( Validar==false )/// aqui es por si hay un numero mal escrito
					tipoerror=1;
				else
				if( carrito>5 )/// aqui si quieren comprar mas de 5 elementos
					tipoerror=2;
				else
				if( Inventario==false ) //aquie es cuando no hay en el inventario
					tipoerror=3;
				
				VentanaPago pagar; // la ventana para pagar
				VentanaError error; // la ventana de error
				
				if( tipoerror==0 ) { // si no hay errores construimos la ventana para pagar 
					pagar=new VentanaPago( Tienda ); // construimos la ventana
					setVisible(false); //desactivamos esta ventana 
				}
				else //construimos la ventana que muestre el error 
					error=new VentanaError(tipoerror);
	
			}
		};
		Comprar.addActionListener( oyenteCompra ); // agregamos la accion al boton
		MenuPanel.add( Comprar ); // agregamos el boton al panel
	}
	
	
	public void ConfigurarEncabezado() {
		// simplemente construimos y buicamos cada etiqueta superior
		/// mandamos al constructor el texto, la posicion en X Y, el tamano de la etiqueta
		Encabezados[1]=new Letrero("producto",10,20,100,50); 
		Encabezados[2]=new Letrero("piezas",300,20,100,50);
		Encabezados[3]=new Letrero("precio",450,20,100,50);
		Encabezados[4]=new Letrero("compra",600,20,100,50);
		for(int i=1;i<=4;i++) /// agregamos las etiquetas al panel con un for
			MenuPanel.add( Encabezados[i] );
		
	}

	public void ConfigurarProductos() {
		/// iteramos sobre los productos
		for(int i=1;i<=Tienda.TotProd;i++) {
			String NombreP=Tienda.ListaP[i].Nombre; // el nombre del producto
			ProdName[i]=new Letrero( NombreP,10,50+i*40,250,30 ); // construimos la etiqueta similarmente a los encabezados
			MenuPanel.add( ProdName[i] ); // lo agregamos al panel
			
			String piezas=String.valueOf( Tienda.ListaP[i].Piezas ); //convertimos el numero de piezas en un string
			ProdPzas[i]=new Letrero(piezas,300,50+i*40,30,30 ); //// construimos la etiqueta similarmente a los encabezados
			MenuPanel.add( ProdPzas[i] );// agregamos la etiqueta al panel
			
			String price=String.valueOf( Tienda.ListaP[i].Precio );//convertimos el precio en un string
			ProdPrice[i]=new Letrero(price,450,50+i*40,30,30 );// construimos la etiqueta similarmente a los encabezados
			MenuPanel.add( ProdPrice[i] );// agregamos la etiqueta al panel 
			 
			Cajita[i]=new CajaTexto( 600,50+i*40 );// construimos las cajas de texto
			MenuPanel.add( Cajita[i] ); // las agregamos al panel
			
		}
	}
}
