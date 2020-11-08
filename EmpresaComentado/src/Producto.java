
public class Producto {
	String Nombre; // nombre del producto
	int Precio,Piezas,Ventas=0; /// es el precio las piezas y cuantos se van a vender 
	public Producto(String nombre,int precio,int piezas){ //el constructor recibe el nombre el precio y el total de piezas 
		/// guardamos los valores 
		Nombre=nombre; 
		Precio=precio;
		Piezas=piezas;
		Ventas=0;
	}
	
	
	/// la funcion toString se uso para imprimir la infromacion pero fue durante el desarrollo
	/// no tiene ningun uso durante el codigo
	public String toString() {
		String Imprimir="";
		Imprimir+=Nombre+" ";
		Imprimir+=Precio+" ";
		Imprimir+=Piezas+" ";
		return Imprimir;
	}
}
