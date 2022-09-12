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
			
			System.out.println("Ingrese una opcion:\n 1. Consultar \n 2. Retirar \n 3. Consignar  \n 4. Salir ");
			
			opcion = teclado.next();
			
			Socket sc = new Socket(HOST, puerto);
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			if ("4".equals(opcion)) {
				/*
				 * enviar mensaje de fin al server crrar el socket cliente
				 */
				System.out.println("Gracias por utilizar nuestros servicios. ");
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
		
			String message = in.readUTF();
			
			sc.close();
			
			
		} catch (IOException e) {
			System.out.println("Mensaje de error cliente" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	/*public static String transacciones (String dato) {
		System.out.println("Dato recibido en trasacciones " + dato);
		String value = dato;
		switch (dato) {
		case value: {
			
		}
			throw new IllegalArgumentException("Unexpected value: " + value);
		} 
		
		return "";
	}*/

}
