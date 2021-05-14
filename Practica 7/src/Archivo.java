
public class Archivo {
	String nombre;
	int tamArchivo, bytes_bloque;
	//int permiso; //0=read, 1=write, 2=execute
	
	public Archivo() {
		nombre="-";
		tamArchivo=0;
		bytes_bloque=0;
	}
	public Archivo(String nombre, int tam) {
		this.nombre=nombre;
		this.tamArchivo=tam;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getBytesBloque() {
		return bytes_bloque;
	}
	public void setTam(int p) {
		tamArchivo=p;
	}
}



