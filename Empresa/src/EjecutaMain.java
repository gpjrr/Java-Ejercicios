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
		Empresa Walmart=new Empresa();
	
		try{
			String archivo="Lista_De_Productos.txt";
			Walmart.inventarioInicial(archivo);
		}
		catch(FileNotFoundException e){
			System.out.println( "no es posiblee ");
			JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
			System.exit(0);
		}
		
		VentanaPrincipal Ventana=new VentanaPrincipal(Walmart);
	}
}