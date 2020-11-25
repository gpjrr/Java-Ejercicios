import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;



public class main {
    
    	public static void main(String[] args) throws IOException {
    		//construimos la ventana principal del programa
    		// le mandamos el objeto Empresa donde Tiene el inventario
    		Sintonizador cosa=new Sintonizador(80);
    		
    		VentanaPrincipal Ventana=new VentanaPrincipal( cosa );
    	}
	
	
}
