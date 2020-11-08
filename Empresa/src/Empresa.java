import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Empresa {
	int TotProd;
	Producto[] ListaP=new Producto[100];
	int VentaCliente;
	int PagoCliente;
	int ProductosCliente;
	public Empresa() {
		TotProd=0;
		VentaCliente=0;
		PagoCliente=0;
		ProductosCliente=0;
	}
	
	public void inventarioInicial(String Archivo) throws IOException {
		File f=new File( Archivo );
		FileReader rf=new FileReader(f);
		BufferedReader br=new BufferedReader( rf );
		
		TotProd=Integer.parseInt( br.readLine() );
		
		String NombreTemp;
		int PrecioTemp,PiezasTemp;
		for(int i=1;i<=TotProd;i++) {
			NombreTemp=br.readLine();
			PrecioTemp=Integer.parseInt( br.readLine() );
			PiezasTemp=Integer.parseInt( br.readLine() );
			ListaP[i]=new Producto(NombreTemp,PrecioTemp,PiezasTemp);
		}
		
	}
	
	public void Actualizar() {
		for(int i=1;i<=this.TotProd;i++) {
			this.ListaP[i].Piezas-=ListaP[i].Ventas;
			this.ListaP[i].Ventas=0;
		}
		
		VentaCliente=0;
		PagoCliente=0;
		ProductosCliente=0;
	}
}
