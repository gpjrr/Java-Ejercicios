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
		Empresa Walmart=new Empresa(); //contruimos el objeto de nuestra empresa
		//usamos un try catch por si no encuentra el archivo
		try{
			String archivo="Lista_De_Productos.txt";// metemos el nombre del archivo en el string
			Walmart.inventarioInicial(archivo);// recopilamos la informacion llamando la funcion inventario inicial
		}
		catch(FileNotFoundException e){
			System.out.println( "no es posiblee ");// mandamos un mensaje por si no encuentra el archivo
			JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
			System.exit(0);
		}
		//construimos la ventana principal del programa
		// le mandamos el objeto Empresa donde Tiene el inventario
		VentanaPrincipal Ventana=new VentanaPrincipal(Walmart);
	}
}