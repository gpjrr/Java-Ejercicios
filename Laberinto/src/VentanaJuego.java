import javax.swing.JFrame;

public class VentanaJuego extends JFrame{
	MapaGrafico plana;
	Hilo hilo;
	public VentanaJuego(int PosNiv,MapaNumeros Mapita) {
		setVisible(true); 
		setTitle("Laberinto "+PosNiv);
		plana= new MapaGrafico(Mapita);
		//setBounds(0,0, (Mapita.m)*10 , (Mapita.n)*10 );
		setLocationRelativeTo(null);
		add( plana );
		addKeyListener( new EventoTeclado() );
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		/// aqui va lo del hilo para ejecutar
		// TODO Auto-generated constructor stub
		hilo=new Hilo( plana );
		hilo.start(); //Hilo esta mas
	}
	
}
