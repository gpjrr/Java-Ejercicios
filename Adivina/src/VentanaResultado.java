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

public class VentanaResultado extends JFrame{
	
	int hancho,alto;
	Mundo Tierra; 
	JPanel PanelResultado;
	Continente Conti;
	
	public VentanaResultado( Mundo Planeta ,Continente continen) {
		hancho=650; 
		alto=250;
		Tierra=Planeta;
		Conti=continen;
		
		for(int i=1;i<=5;i++) 
			if( Tierra.arr[i].Nombre.equals( Conti.Nombre ) ){
				Tierra.arr[i]=Conti;
				break;
			}	
		String tituloVentana="Resultados";
		setTitle(tituloVentana);
		
		
		setBounds(50,50,hancho,alto);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		ConfigurarPanel();
		ConfigurarContenido();
		if( Conti.Lista.Tnod>=1 )
			ConfigurarBotonAceptar();
		ConfigurarBotonMenu();
		
		setVisible(true);          
		PanelResultado.setVisible(true);
	}
	
	public void ConfigurarPanel() {
		PanelResultado=new JPanel();
		PanelResultado.setLayout(null);
		PanelResultado.setBackground( Color.gray );
		PanelResultado.setBounds(0,0,hancho,alto);
		this.getContentPane().add(PanelResultado);
	}	
	public void ConfigurarContenido() {
		String txt="Tienes ";
		txt+=Conti.Puntos;
		txt+=" aciertos.";
		
		Letrero Result=new Letrero( txt,10,10,250,30 );
		Result.setFont( new Font("Serif",Font.BOLD ,30) );
		PanelResultado.add( Result );
			
		if( Conti.Lista.Tnod>=1 ) 
		txt="quieres intentarlo de nuevo?, click en Aceptar";
		else
		txt="bravo has ganado, prueba con otros continentes";
	    
		Letrero Pregunta=new Letrero(txt ,0,50,650,30 );
		Pregunta.setFont( new Font("Serif",Font.BOLD ,30) );
		PanelResultado.add( Pregunta );
		
	}
	public void ConfigurarBotonAceptar() {
		Boton Aceptar=new Boton("Aceptar",0,110);
		ActionListener oyenteAceptar=new ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				Conti.Hide=true;
		
				for(int i=1;i<=5;i++) 
					if( Tierra.arr[i].Nombre.equals( Conti.Nombre ) ){
						Tierra.arr[i]=Conti;
						break;
					}	
				
				dispose();
				VentanaPais nuevo=new VentanaPais(Tierra,Conti);
			}
		};
		Aceptar.addActionListener( oyenteAceptar);
		PanelResultado.add( Aceptar );
	}
	public void ConfigurarBotonMenu() {
		Boton Menu=new Boton("Menu",450,110);
		ActionListener oyenteMenu=new ActionListener() {
			public void actionPerformed( ActionEvent ae ) {

				for(int i=1;i<=5;i++) 
					if( Tierra.arr[i].Nombre.equals( Conti.Nombre ) ){
						Tierra.arr[i]=Conti;
						break;
					}	
				dispose();
				VentanaPrincipal Nuevo=new VentanaPrincipal(Tierra);
			}
		};
		Menu.addActionListener( oyenteMenu );
		PanelResultado.add( Menu );
		
	}

	}