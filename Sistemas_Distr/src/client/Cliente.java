package client;


public class Cliente {
	
	private int id;
	private int cuenta;
	private String name;
	private int valor;
	
	public Cliente(int id, int cuenta, String name, int valor) {
		super();
		this.id = id;
		this.cuenta = cuenta;
		this.name = name;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCuenta() {
		return cuenta;
	}

	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	

}
