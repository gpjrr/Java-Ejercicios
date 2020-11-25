import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VentanaPrincipal extends JFrame{

	int hancho,alto; // las dimensiones de la ventana	
    Sintonizador Estacion=new Sintonizador(0); 
	JPanel MenuPanel;
	Letrero Numero;
		
		public VentanaPrincipal( Sintonizador num ) {
			hancho=300; alto=300; 
			
			 Estacion= num;
			setTitle("Radio Fm");
			setBounds(50,50,hancho,alto);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			ConfigurarPanel();
			ConfigurarBotonDerecha();
			ConfigurarBotonIzquierda();
			ConfigurarTexto();
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
		
		public void ConfigurarBotonDerecha() {
			Boton Derecha=new Boton("+",200,100); 

			ActionListener oyente=new ActionListener() { 

				public void actionPerformed( ActionEvent ae ) { 
					Estacion.frecuenciaSubir();
					dispose();
		VentanaPrincipal Nuevo=new VentanaPrincipal( Estacion );
				}
		 
			};
			Derecha.addActionListener( oyente ); 	
			MenuPanel.add( Derecha );
		}
		
		public void ConfigurarBotonIzquierda() {
			Boton Izquierda=new Boton("-",20,100); 

			ActionListener oyente=new ActionListener() { 

				public void actionPerformed( ActionEvent ae ) { 
					Estacion.frecuenciaBajar();
					dispose();
		VentanaPrincipal Nuevo=new VentanaPrincipal( Estacion );
				}
		 
			};
			Izquierda.addActionListener( oyente ); 	
			MenuPanel.add( Izquierda );
		}

		void ConfigurarTexto(){
			String cad="";
			cad+=Estacion.frecuencia;
			
			Numero= new Letrero(cad ,120,100,50,50);
			MenuPanel.add( Numero );
		}
		
}

