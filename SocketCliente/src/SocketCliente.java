
package socketcliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketCliente {
static Socket cliente;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        int contacto=1;
        try {
             cliente = new Socket("Localhost",9999);
            while(contacto==1){
            int opc=0;
            DataOutputStream mensaje = new DataOutputStream(cliente.getOutputStream());
            	System.out.println("Menú:");
                System.out.println("1. Concatenar cadenas");
                System.out.println("2. Obtener potencia");
                System.out.println("3. Distancia entre puntos");
                System.out.println("4. Salir");
                System.out.println("   OPCION: ");
                opc= sc.nextInt();
                String opc1=String.valueOf(opc);
                mensaje.writeUTF(opc1);
                if(opc==4){
                    contacto=0;
                }else{
                
                opciones(opc);
                }

            }
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
public static void opciones(int opc){
    
    switch(opc){
        case 1:{
        try {
            String cadena1;
            String cadena2;
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream salidas = new DataOutputStream(cliente.getOutputStream());
            String mensaje2 = (String) entrada.readUTF();
            System.out.println("Server = "+mensaje2);
            
            System.out.println("Proporcione cadena 1:");
            cadena1 = sc.next();           
            System.out.println("Proporcione cadena 2");
            cadena2 = sc.next();
            salidas.writeUTF(cadena1);
            salidas.writeUTF(cadena2);
            
            String respuesta = (String) entrada.readUTF();
            System.out.println(respuesta);

        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            break;
        }
        case 2:{
            
        try {
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream salidas = new DataOutputStream(cliente.getOutputStream());
            
            System.out.println("Escribe el numero: ");
            int n1 = sc.nextInt();
            System.out.println("Escribe la potencia: ");
            int n2 = sc.nextInt();
            String numero1 = String.valueOf(n1);
            String numero2 = String.valueOf(n2);
            salidas.writeUTF(numero1);
            salidas.writeUTF(numero2);
            
            String respuesta = (String) entrada.readUTF();
            System.out.println("Respuesta = "+respuesta);
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
            break;
        }
        case 3:{
            
        try {
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream salidas = new DataOutputStream(cliente.getOutputStream());
            
            System.out.println("Escriba X del punto 1");
            int x1 = sc.nextInt();
            System.out.println("Escriba Y del punto 1");
            int y1 = sc.nextInt();
            System.out.println("Escriba X del punto 2");
            int x2 = sc.nextInt();
            System.out.println("Escriba Y del punto 2");
            int y2 = sc.nextInt();
            
            String X1 = String.valueOf(x1);
            String Y1 = String.valueOf(y1);
            String X2 = String.valueOf(x2);
            String Y2 = String.valueOf(y2);
            
            salidas.writeUTF(X1);
            salidas.writeUTF(Y1);
            salidas.writeUTF(X2);
            salidas.writeUTF(Y2);
            
            String resultado = entrada.readUTF();
            
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            break;
        }
    }
}
    
}
