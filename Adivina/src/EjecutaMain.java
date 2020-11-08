import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;

public class EjecutaMain {
	public static void main(String[] args) throws IOException {
		Mundo Planeta;
		try{
			String archivo="Paises.txt";
			Planeta=new Mundo(archivo);
			VentanaPrincipal Ventana=new VentanaPrincipal( Planeta );
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
			System.exit(0);
		}
	
		
	}
}