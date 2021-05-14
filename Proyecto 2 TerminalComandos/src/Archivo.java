import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {
	String Name;
	boolean Live;
	int Maker;
	int Size;
	
	public Archivo(String nambre,int size,int maker) {
		Name=nambre;
		Live=true;
		Size=size;
		Maker=maker;
	}
	
}



