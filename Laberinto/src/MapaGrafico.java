import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
public class MapaGrafico extends JPanel{
	MapaNumeros MapB;
	Persona Sujeto;
	public MapaGrafico(MapaNumeros Mapi)  {
		Sujeto=new Persona( Mapi );
		MapB=Mapi;
		/// CAMINO CORTOOOOO
		MapB.CaminoCorto(Sujeto.pi,Sujeto.pj,0);
		setLayout(null);
		setBackground( Color.GRAY );	
	}
	@Override
	public void paintComponent( Graphics g ) {
		
		super.paintComponent(g);
		Graphics2D g2=( Graphics2D )g;
		Graphics2D[][] MatBlo= new Graphics2D[110][110];
		
		//dibjujar
		for(int i=0;i< MapB.n ;i++) 
			for(int j=0;j< MapB.m ;j++){
				MatBlo[i][j]=( Graphics2D )g;
				if( MapB.a[i][j]==1 )
				MatBlo[i][j].setColor( Color.BLACK );
				if( MapB.a[i][j]%2==0 )
				MatBlo[i][j].setColor( Color.WHITE );
				if( i==Sujeto.pi && j==Sujeto.pj)
					MatBlo[i][j].setColor( Color.RED );
	
				if( MapB.a[i][j]==5 )
					MatBlo[i][j].setColor( Color.BLUE );
MatBlo[i][j].fill( new Rectangle2D.Double( 18*j,18*i,18,18 ) );
	    }
		// movimiento de personaje
		Sujeto.mover();
		if( Sujeto.pi==Sujeto.si && Sujeto.pj==Sujeto.sj) {

			String Tx="Hiciste "+Sujeto.Pasos+" pasos, el camino mas corto es de  "+MapB.ShortPath +" pasos";
			
			Letrero EndGame=new Letrero(Tx);
			EndGame.setForeground( Color.ORANGE );
			EndGame.setBounds(0,00,1300,100  );
			EndGame.setFont( new Font("Serif",Font.BOLD ,20) );
			add(EndGame);
			//System.out.println("Hiciste "+Sujeto.Pasos+" pasos, el camino mas corto es de "+MapB.ShortPath +" pasos");
			
			return;
		}
	}
	
}
