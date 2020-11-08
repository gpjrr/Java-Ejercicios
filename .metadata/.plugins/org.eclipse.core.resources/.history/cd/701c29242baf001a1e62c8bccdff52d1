import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPais extends JFrame{
	int hancho,alto;
	Mundo Tierra; 
	JPanel PanelPais;
	Continente Conti;
	CajaTexto Cajita;
	public VentanaPais( Mundo Planeta ,Continente continen) {
		hancho=567; 
		alto=700;
		Tierra=Planeta;
		Conti=continen;
		for(int i=1;i<=5;i++) 
			if( Tierra.arr[i].Nombre.equals( Conti.Nombre ) ){
				Tierra.arr[i]=Conti;
				break;
			}
		
		for(int i=1;i<=5;i++)
			if( Tierra.arr[i].Select==true )	
				Tierra.arr[i].Select=false;
			
		String tituloVentana="paises de "+Conti.Nombre;
		setTitle(tituloVentana);
		
		
		setBounds(50,50,hancho,alto);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		ConfigurarPanel();
		ConfigurarContenido();
		ConfigurarCajaTexto();
		ConfigurarFoto();
		
		ConfigurarBotonEvaluar();
		ConfigurarBotonIzquierda();
		ConfigurarBotonDerecha();
		ConfigurarBotonSalir();
		setVisible(true);          
		PanelPais.setVisible(true);
	}
	
	public void ConfigurarPanel() {
		PanelPais=new JPanel();
		// configuramos el panel
		PanelPais.setLayout(null);
		PanelPais.setBackground( Color.gray );
		PanelPais.setBounds(0,500,hancho,300);
		this.getContentPane().add(PanelPais);
	}
	public void ConfigurarContenido() {
		String txt="Pais: ";
		if( Conti.Hide==false ) 
			txt+=Conti.yo.Pais;
		else
			txt+="..........";
			
		Letrero NombrePais=new Letrero( txt,0,0,300,30 );
		NombrePais.setFont( new Font("Serif",Font.BOLD ,30) );
		PanelPais.add( NombrePais );
					    
	    Letrero NombreCapital=new Letrero("Capital: ",00,30,115,30 );
		NombreCapital.setFont( new Font("Serif",Font.BOLD ,30) );
		PanelPais.add( NombreCapital );
		
	}
	public void ConfigurarCajaTexto() {
		if( Conti.Hide==true) {
			//Cajita
		}
		Cajita=new CajaTexto(115,30, Conti.yo.Respuesta );
		PanelPais.add(Cajita);
	}
	public void ConfigurarFoto() {
		JLabel Bandera=new JLabel( new ImageIcon( Conti.yo.Bandera ) );
		Bandera.setBounds(0, 0, 550, 367);
		this.add( Bandera );
	}
	public void ConfigurarBotonIzquierda() {
		Boton Left=new Boton("Izquierda",0,110);
		ActionListener oyenteIzquierda=new ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				Conti.yo.Respuesta=Cajita.Check();
				Conti.yo=Conti.yo.prv;
				dispose();
				VentanaPais hola=new VentanaPais(Tierra,Conti);
			}
		};
		Left.addActionListener( oyenteIzquierda);
		PanelPais.add( Left );
	}
	public void ConfigurarBotonDerecha() {
		Boton Right=new Boton("Derecha",407,110);
		ActionListener oyenteDerecha=new ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				Conti.yo.Respuesta=Cajita.Check();
				Conti.yo=Conti.yo.nxt;
				dispose();
				VentanaPais Nuevo=new VentanaPais(Tierra,Conti);
			}
		};
		Right.addActionListener( oyenteDerecha );
		PanelPais.add( Right );
		
	}
	
	public void ConfigurarBotonSalir() {
		Boton Salir=new Boton("Salir",407,10);
		ActionListener oyenteSalir=new ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				
				Conti.yo.Respuesta=Cajita.Check();
				Conti.Evaluar();
				for(int i=1;i<=5;i++) 
					if( Tierra.arr[i].Nombre.equals( Conti.Nombre ) ){
						Tierra.arr[i]=Conti;
						break;
					}
			
				dispose();
			VentanaPrincipal Nuevo=new VentanaPrincipal(Tierra);
			}
		};
		Salir.addActionListener( oyenteSalir );
		PanelPais.add( Salir );
	}
	
	public void ConfigurarBotonEvaluar() {
		Boton Salir=new Boton("Evaluar",208,110);
		ActionListener oyenteSalir=new ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				
				Conti.yo.Respuesta=Cajita.Check();
				Conti.Evaluar();
				
				System.out.println( Conti.Lista.Imprime() );
				
				
				dispose();
	VentanaResultado Nuevo=new VentanaResultado(Tierra,Conti);
			}
		};
		Salir.addActionListener( oyenteSalir );
		PanelPais.add( Salir );
	}
	

	
}