package Conexion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		final String HOST = "192.168.20.42";
		final int puerto = 5000;
		DataInputStream in;
		DataOutputStream out;
		String opcion = " ";
		String cuenta = " ";
		String valor = " ";
		String mensaje = " ";
		
		try {
			
			Socket sc = new Socket(HOST, puerto);
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			System.out.println("Ingrese una opcion:\n 1. Consultar \n 2. Retirar \n 3. Consignar  \n 4. Salir ");
			
			opcion = teclado.next();
            
			if ("4".equals(opcion)) {
				
				valor = "00000000000"; // consultar
			    cuenta = "00000000000"; // consultar
				
			} else {
				System.out.println("Ingrese la cuenta ");
				cuenta = teclado.next();
				if ( "2".equals(opcion) ||  "3".equals(opcion)) {
					System.out.println("Ingrese el valor ");
					valor = teclado.next();

					
				} else
					valor = "00000000000"; // consultar

				
			}
			
		    mensaje = opcion + "," + cuenta + "," + valor;
			out.writeUTF(mensaje);
			mensaje = in.readUTF();
            
            System.out.println(mensaje);
            
			sc.close();
			
			
		} catch (IOException e) {
			System.out.println("Mensaje de error cliente" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
}
