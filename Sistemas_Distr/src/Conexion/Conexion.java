
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    String bd="sistemas_distr";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
	Connection cn;
	PreparedStatement pst;
	ResultSet rs = null;

    public Conexion() {
    }
    
    public Connection conectar() {
        try {
            Class.forName (driver);
            cx=DriverManager.getConnection(url+bd, user, password);
            //System.out.println("SE CONECTO A BD "+ bd);
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("NO SE CONECTO A BD "+ bd);
            System.out.println("Error"+ ex.getMessage() + ex.getCause());            
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex));
        }
        return cx;
    }
    
    public void desconectar (){
        try {
            cx.close();
        } catch (SQLException ex){
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex));
        }   
    }
    
	public ResultSet SeleccionarCuenta(int cliente) {
		cn = conectar();
		try {
			pst = cn.prepareStatement("SELECT VALOR FROM customers WHERE CUENTA=?");
			pst.setLong(1, cliente);
			rs = pst.executeQuery();
		} catch(Exception e) {
			
		} return rs;

	}
	
	
	public void retirar(int cliente, int valor) {
		cn = conectar();
		PreparedStatement preparar = null;
		String query = "UPDATE customers SET VALOR = VALOR - " + valor +" WHERE CUENTA = " + cliente;
		try {
			preparar=cn.prepareStatement(query);
			preparar.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
			
		}

	}
	
	
	
	public void consignar(int cliente, int valor) {
		cn = conectar();
		PreparedStatement preparar = null;
		String query = "UPDATE customers SET VALOR = VALOR + " + valor +" WHERE CUENTA = " + cliente;
		try {
			preparar=cn.prepareStatement(query);
			preparar.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
			
		}

	}
	
	
    
}
