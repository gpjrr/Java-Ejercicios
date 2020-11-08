
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;
public class EjecutaMain {
	public static void main(String[] args) throws IOException {
		MapaNumeros[] ArrMapas=new MapaNumeros[10];
		for(int i=1;i<=5;i++) {
			String Nombre;
                        try{
                            Nombre="map";	Nombre+=i; Nombre+=".txt";
                            ArrMapas[i]=new MapaNumeros();
                            ArrMapas[i].construir(Nombre);
                        }
                        catch(FileNotFoundException e){
                            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo map"+i+".txt");
                            System.exit(0);
                        }
		}
		Ventana marco = new Ventana( ArrMapas );
		///System.out.println("se pudoo");
		
	}
}
