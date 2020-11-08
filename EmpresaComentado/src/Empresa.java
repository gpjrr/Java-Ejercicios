import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Empresa {
	int TotProd; // el valor de N que es el total de productos
	Producto[] ListaP=new Producto[100]; /// un arreglo para guardar los productos
	int VentaCliente; // la suma de cuanto va a comprar el cliente
	int PagoCliente;// el monto con el que va a pagar 
	int ProductosCliente;// el total de productos que lleva 
	public Empresa() {
		// limpiamos las variables 
		TotProd=0;
		VentaCliente=0;
		PagoCliente=0;
		ProductosCliente=0;
	}
	
	public void inventarioInicial(String Archivo) throws IOException {
		// construimos los lectores del archivo para cargar la informacion del inventario
		File f=new File( Archivo );
		FileReader rf=new FileReader(f);
		BufferedReader br=new BufferedReader( rf );
		
		TotProd=Integer.parseInt( br.readLine() ); // guardamos el total de productos
		
		String NombreTemp; 
		int PrecioTemp,PiezasTemp;
		for(int i=1;i<=TotProd;i++) {
			NombreTemp=br.readLine(); /// leemos el nombre del producto 
			PrecioTemp=Integer.parseInt( br.readLine() ); //leemos el precio
			PiezasTemp=Integer.parseInt( br.readLine() ); // leemos el total de piezas 
			ListaP[i]=new Producto(NombreTemp,PrecioTemp,PiezasTemp); /// construimos el producto mandando todo lo leido anteriormente 
		}
		
	}
	
	public void Actualizar() { // vamos a actualizar nuestro inventario en el sistema para continuar las ventas
		for(int i=1;i<=this.TotProd;i++) { // iteramos sobre cada producto para restar los vendidos
			this.ListaP[i].Piezas-=ListaP[i].Ventas;
			this.ListaP[i].Ventas=0; // limpiamos el total de piezas vendidas
		}
		// limpiamos las variables para un nuevo uso 
		VentaCliente=0;
		PagoCliente=0;
		ProductosCliente=0;
	}
}
