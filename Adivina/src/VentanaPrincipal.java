
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame{
	int hancho,alto;
	Mundo Tierra; 
	JPanel MenuPanel;
	BotonGrupo[] Arr_bot=new BotonGrupo[100];
	
	public VentanaPrincipal( Mundo Planeta ) {
		hancho=600; 
		alto=350;
		Tierra=Planeta;
		setTitle("Menu Principal");
		setBounds(50,50,hancho,alto);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		ConfigurarPanel();
		ConfigurarOpciones();
		ConfigurarBotonEmpezar();
		ConfigurarBotonSalir();
		ConfigurarEncabezado();
		
		setVisible(true);          
		MenuPanel.setVisible(true);
	}
	public void ConfigurarPanel() {
		MenuPanel=new JPanel();
		// configuramos el panel
		MenuPanel.setLayout(null);
		MenuPanel.setBackground( Color.gray );
		MenuPanel.setBounds(50,50,hancho,alto);
		this.getContentPane().add(MenuPanel);
	}	
	public void ConfigurarBotonSalir() {
		Boton Salir=new Boton("Salir",10,210);
		ActionListener oyenteSalir=new ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
				System.exit(0);
			}
		};
		Salir.addActionListener( oyenteSalir );
		MenuPanel.add( Salir );
	}
	public void ConfigurarBotonEmpezar() {
		Boton Empezar=new Boton("Empezar",200,210);
		ActionListener oyenteEmpezar=new ActionListener() {
			public void actionPerformed( ActionEvent ae ) {
			for(int i=1;i<=5;i++)
				if( Arr_bot[i].isSelected() )
				if( Tierra.arr[i].Lista.Tnod>=1 ){
					Tierra.arr[i].Select=true;
					setVisible(false);
					dispose();
VentanaPais Ventap=new VentanaPais( Tierra,Tierra.arr[i] );
					break;
					}
					
			
			}
		};
		Empezar.addActionListener( oyenteEmpezar );
		MenuPanel.add( Empezar );
	}	
	public void ConfigurarOpciones() {
		ButtonGroup banda=new ButtonGroup();		
		for(int i=1;i<=5;i++) {
			Arr_bot[i]=new BotonGrupo(i, Tierra.arr[i].Nombre );
			MenuPanel.add( Arr_bot[i] );
			banda.add( Arr_bot[i] );							
		}
		Arr_bot[1].setSelected(true);
		
	}
	public void ConfigurarEncabezado() {
		String texto="elije un continente";
		String describe="deberas adivinar las capitales de los paises";
		describe+=", escribe en minusculas";
		Letrero titulo=new Letrero(texto,10,20,200,50);
		MenuPanel.add( titulo );
		Letrero exp=new Letrero(describe,10,80,550,50);
		MenuPanel.add( exp );
		
	}
}
	
