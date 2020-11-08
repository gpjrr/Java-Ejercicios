
public class Producto {
	String Nombre;
	int Precio,Piezas,Ventas=0;
	public Producto(String nombre,int precio,int piezas){
		Nombre=nombre;
		Precio=precio;
		Piezas=piezas;
		Ventas=0;
	}
	public String toString() {
		String Imprimir="";
		Imprimir+=Nombre+" ";
		Imprimir+=Precio+" ";
		Imprimir+=Piezas+" ";
		return Imprimir;
	}
}
