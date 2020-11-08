import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Mundo {
	Continente[] arr=new Continente[10];
	public Mundo(String archivo) throws IOException {
		File f=new File( archivo );
		FileReader rf=new FileReader(f);
		BufferedReader br=new BufferedReader( rf );
		
		for(int i=1;i<=5;i++) {
			String name=br.readLine();
			int tot=Integer.parseInt( br.readLine() );
			arr[i]=new Continente( name,tot );
			for(int j=1;j<=tot;j++) {
				String pais=br.readLine();
				String capital=br.readLine();
				arr[i].NuevoPais(pais, capital);
			}	
		}
		/*
		for(int i=1;i<=5;i++) {
			System.out.println(arr[i].Nombre);
			System.out.println(arr[i].Lista.Imprime());
		}
		*/
		
	}

}


