import java.util.*;
import java.io.*;


public class Hilo extends Thread {

    private final MapaGrafico lamina;
 
    public Hilo(MapaGrafico lamina) {
        this.lamina = lamina;
    }

    @Override
    public void run() {
        while (true) {
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           lamina.repaint();
          
        }
    }
}
