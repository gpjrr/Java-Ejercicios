import java.util.Scanner;

public class Almacenaje {
	int tam, espaciosDisp, contFiles, tamBloque;
	Archivo archivos[];
	
	public Almacenaje(int tam, int tamBloque) {
		this.tam=tam;
		this.tamBloque=tamBloque;
		espaciosDisp=(int)Math.ceil(tam/tamBloque); //Indicaran número de bloques disponibles
		archivos=new Archivo[(int)Math.ceil(tam/tamBloque)];
		inicializarArreglo(archivos);
		contFiles=0;
	}
	
	public boolean crear(String nombre, int tamArch,int pos ) {
		boolean ban=false;
		if( pos==-2 )
			ban=true;
		if(espaciosDisp*tamBloque>=tamArch ) { //Si hay bloques disponibles 
			int bytesRestantes=tamArch; //Númer de Bytes ya colocados en almacenaje
			do {
				if( ban==true )
					pos=buscar("-");
				else
					ban=true;
				if(pos!=-1) {
					archivos[pos].nombre=nombre;
					archivos[pos].tamArchivo=tamArch;
					if(bytesRestantes>tamBloque) {
						archivos[pos].bytes_bloque=tamBloque;
						bytesRestantes-=tamBloque;
						espaciosDisp--;
					}
					else {
						archivos[pos].bytes_bloque=bytesRestantes;
						espaciosDisp--;
						bytesRestantes=0;
					}
				}
			}while(bytesRestantes!=0);
			contFiles++;
			mostrarArreglo();
			return true;
		}
		else {
			System.out.println("Ups!! Espacio isuficiente...");
			return false;
		}
	}
	
	public void eliminar(String nombre) {
		int pos=buscar(nombre);
		if(pos!=-1) {
			int bytesRestantes=(int)Math.ceil(archivos[pos].tamArchivo/tamBloque); //Para saber cuántos bloques nos faltan
			do {
				int p=buscar(nombre);
				resetByte(p);
				espaciosDisp++;
			}while(buscar(nombre)!=-1);
			contFiles--;
			System.out.println("Se eliminó exitosamente!  ESPDISP="+espaciosDisp);
			mostrarArreglo();
		}
		else
			System.out.println("Error!! No se encontró el archivo...");
		

	}
	
	public void cambiarTam(String nombre) {
		Scanner s=new Scanner(System.in);
		int pos=buscar(nombre);
		int newTam;
		int oldTam;
		System.out.println("¿Cuál es el nuevo tamaño? ");
		newTam=s.nextInt();
		
		if(pos!=-1) {
			oldTam=archivos[pos].tamArchivo;
			eliminar( nombre );
			if ( crear( nombre,newTam, pos )==true )
				System.out.println("el tamano fue cambiado");
			else {
				crear( nombre, oldTam , pos );
			}
		}
		else 
			System.out.println("no existe la tarea");
		
	}
	
	public int encontrarUltimo(String nombre) {
		int pos=0;
		for(int i=0;i<archivos.length;i++)
			if(archivos[i].nombre.equals(nombre))
				pos=i;
		return pos;
	}
	
	public void desfragmentar() {
		Archivo aux[]=new Archivo[tam];
		inicializarArreglo(aux);
		
		for(int i=0;i<archivos.length;i++) //Respaldo en el auxiliar 
			copiarByte(archivos[i],aux[i]);
		
		Archivo po,pc,pa;
		for(int i=0;i<archivos.length-1;i++) {
			po=aux[i];
			pa=aux[i+1];
			for(int j=1;j<archivos.length-i;j++) {
				pc=aux[i+j];
				if(pc.nombre.equals(po.nombre)) 
					intercambiarBytes(pc,pa);
			}
		}
		for(int i=0;i<tam;i++) //Respaldo en el auxiliar 
			copiarByte(aux[i],archivos[i]);
		
		mostrarArreglo();
	}
	
	public void intercambiarBytes(Archivo original, Archivo copia) {
		Archivo aux=new Archivo();
		
		copiarByte(original,aux);
		copiarByte(copia,original);
		copiarByte(aux,copia);
	}
	
	public void copiarByte(Archivo original, Archivo copia) {
		copia.nombre=original.nombre;
		copia.tamArchivo=original.tamArchivo;
		copia.bytes_bloque=original.bytes_bloque;
	}
	
	public void resetByte(int pos) {
		archivos[pos].nombre="-";
		archivos[pos].tamArchivo=0;
		archivos[pos].bytes_bloque=0;
	}
	
	public void mostrarArreglo() { //Muestra el arreglo de almacenamiento
		System.out.print("\n | ");
		for(int i=0;i<archivos.length;i++) 
	System.out.print(archivos[i].nombre+" "+archivos[i].bytes_bloque+" | ");
		
		System.out.println("\n");
	}
	
	
	public int buscar(String nombre) { //Devuelve posición en el arreglo de archivos
		for(int i=0;i<archivos.length;i++) {
			if(archivos[i].nombre.equals(nombre)==true)
				return i;
		}
		return -1;
	}
	
	public boolean duplicate(String nombre) {
		if(buscar(nombre)!=-1)
			return true;
		else
			return false;
	}
	
	public void inicializarArreglo(Archivo arr[]) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=new Archivo();
		}
	}
}
