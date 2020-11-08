import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Continente {
	String Nombre;
	int TotalPaises;
	Boolean Select;
	Boolean Hide;
	ListaDobleLigada Lista=new ListaDobleLigada();
	Nodo yo;
	int Puntos;
	public Continente( String name, int tot ) {
		Nombre=name;
		Select=false;
		TotalPaises=tot;
		Hide=false;
	}
	public void NuevoPais(String Pais, String Capital) {
		Nodo nuevo=new Nodo( Pais,Capital );
		Lista.Insertar(nuevo);
		yo=Lista.ini;
	}
	public void Evaluar() {
		Puntos=Lista.Aciertos();
		Lista.Limpiar();
		yo=Lista.ini;
		
			
	}
}
