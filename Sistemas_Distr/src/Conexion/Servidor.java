
package Conexion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;


public class Servidor {
	
  
	

	public static void main(String[] args) throws SQLException {
    
    ServerSocket servidor = null;
    Socket sc = null;
    DataInputStream in;
    DataOutputStream out;
	short opcion = 0;
	int cuenta = 0;
	int valor = 0;
	String mensaje = " ";
    
    final int PUERTO = 5000;
    
    try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor Iniciado");
            
            while(true) {
            	System.out.println("Esperando conexion ");
                sc = servidor.accept();
            	System.out.println("Conexion cliente ");
                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                mensaje = in.readUTF();
                
                
        		String[] vectorDatos = mensaje.split(",");
        		for (int i = 0; i < vectorDatos.length; i++) {
        			switch (i) {
        			case 0:
        				opcion = (short) Integer.parseInt(vectorDatos[i]);
        				break;
        			case 1:
        				cuenta = (int) Long.parseLong(vectorDatos[i]);
        				break;
        			default:
        				valor = (int) Double.parseDouble(vectorDatos[i]);
        			}
        		}
        		
        		
        		
                Conexion cn = new Conexion();
                
    			switch (opcion) {
    			case 1: {
    				
                    ResultSet rs = cn.SeleccionarCuenta(cuenta);
                    
                    while (rs.next()) {
                    	String Valorcliente = rs.getString("VALOR");
                    	System.out.println("Su saldo es de: " + Valorcliente);
                    }
        				break;
                    }
                    
    			case 2:{
                    cn.retirar(cuenta,valor);
                    System.out.println("case 2: " + cuenta + " campo valor: " + valor);

    				break;
    			}
    			default:{
    				System.out.println("Error default");
    			}
    			}
                    
                

                
                
                
                sc.close();
                System.out.println("Cliente desocnectado");
            }
            
            
       } catch (IOException ex) {
           //Logger.getLogger(Servidor.class.getName().log(Level.SEVERE, null, ex);
           
       }
    
}

	private static Connection getConexion() {
		// TODO Auto-generated method stub
		return null;
	}
    
}