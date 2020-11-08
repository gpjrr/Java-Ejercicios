import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class EventoTeclado extends KeyAdapter{
	static boolean Up,Down,left,Right;
	@Override
	public void keyPressed( KeyEvent e ) {
		int id= e.getKeyCode();
		if( id == KeyEvent.VK_W )
			Up=true;
		if( id == KeyEvent.VK_S )
			Down=true;
		if( id == KeyEvent.VK_A )
			left=true;
		if( id == KeyEvent.VK_D )
			Right=true;
	}
	@Override
public void keyReleased( KeyEvent e ) {
	int id= e.getKeyCode();
	if( id == KeyEvent.VK_W )
		Up=false;
	if( id == KeyEvent.VK_S )
		Down=false;
	if( id == KeyEvent.VK_A )
		left=false;
	if( id == KeyEvent.VK_D )
		Right=false;
	}
	
	
}
