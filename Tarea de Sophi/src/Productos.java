
public class Productos {
	int Id;
	double Precio;
	String Nombre;
	String Caracteristicas;
	double PrecioIva() {
		return Precio*1.16;
	}
	public Productos(String Name,String Car,int pri) {
		
		Nombre=Name;
		Caracteristicas=Car;
		Precio=pri;
		
	}
    public int  getCodigo() {
        return Id;
    }

    public void setCodigo(int codigo) {
        this.Id = codigo;
    }

    public String getDescripcion() {
        return Caracteristicas;
    }

    public void setDescripcion(String descripcion) {
        this.Caracteristicas=descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(float price) {
        this.Precio = price;
    }

    public void setNombre(String Name ) {
    	this.Nombre=Name;
    }
	
    public String getNombre() {
    	return Nombre;
    }
    public String toString() {
    	String cad="Nombre:"+Nombre+" PrecioConIva:"+this.PrecioIva();
    	cad+=" PrecioSinIva:"+Precio+" Caracteristicas:"+Caracteristicas;
    	cad+=" ID="+Id;
    	return cad;
    }
    
}
