import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics; 

public class Ventana extends JFrame{
	int PosNiv;
	Niveles[] Arr_bot=new Niveles[100];
	BotonStart bot1=new BotonStart();
	JPanel MenuPanel;
	BotonFoto botFoto;
	public Ventana( MapaNumeros[] ArrMapas ) {
		setVisible(true);          
		//System.out.println(ArrMapas[1].n+" "+ArrMapas[1].m);
		setTitle("Menu de niveles");
		setBounds(50,50,1000,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		ConfigurarPanel();
		ConfigurarTitulo();
		ConfigurarBotonesNiveles();
		ConfigurarBotonStart(ArrMapas);
		//ConfigurarBotonFoto();
	}
	public void ConfigurarBotonFoto() {
		botFoto=new BotonFoto();
	 	ActionListener oyentefoto=new ActionListener() {
	 		public void actionPerformed( ActionEvent ae) {
	 			VentanaFoto MarcoFoto=new VentanaFoto("FotografiaEquipo.jpg");
	 			setVisible(false);
	 		}	
	 	};
	 	botFoto.addActionListener( oyentefoto );
	 	MenuPanel.add( botFoto );
	}
	public void ConfigurarBotonStart(MapaNumeros[] ArrMapas) {
		//metemos el boton
	 	bot1=new BotonStart();		
	 	ActionListener oyente=new ActionListener() {
	 		public void actionPerformed( ActionEvent ae) {
	 			for(int i=1;i<=5;i++)
	 				if( Arr_bot[i].isSelected() ) {
	 					VentanaJuego Tablero;
	 					Tablero= new VentanaJuego(i,ArrMapas[i]);
	 					setVisible(false);	
	 					break;
	 				}
	 		}
	
	 	};
	 	bot1.addActionListener( oyente );	 
	 	MenuPanel.add( bot1 ); 
	}
	public void ConfigurarBotonesNiveles() {
		//metemos conjunto de niveles
		Arr_bot=new Niveles[100];
		ButtonGroup banda=new ButtonGroup();
		for(int i=1;i<=5;i++) {
			Arr_bot[i]=new Niveles(i);
			MenuPanel.add( Arr_bot[i] );
			banda.add( Arr_bot[i] );
		}
		Arr_bot[1].setSelected(true);		
	}
	public void ConfigurarTitulo() {
		// metemos el tituloo
		String Pregunta="¿Que nivel deseas seleccionar?";
		Letrero Opcion=new Letrero(Pregunta);
		MenuPanel.add( Opcion );
	}
	public void ConfigurarPanel() {
		MenuPanel=new JPanel();
		// configuramos el panel
		MenuPanel.setLayout(null);
		MenuPanel.setBackground( Color.YELLOW );
		MenuPanel.setBounds(50,50,1000,500);
		this.getContentPane().add(MenuPanel);
	}
}