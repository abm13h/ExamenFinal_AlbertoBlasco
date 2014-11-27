package es.banco.modelo;

public class TarjetaParaPago {
	private String numero;
	private int cupoMaximo;
	private int cupoDisponible;
	private String numeroComprobacion;
	private String tipo;
	private String contrasenha;
	private int id;

	//constructores
	
	public TarjetaParaPago(String numero, 
			                 int cupoMaximo, 
			                 int cupoDisponible,
			              String numeroComprobacion, 
			              String tipo, 
			              String contrasenha) {
		super();
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
		this.contrasenha = contrasenha;
		
	}
	
	public TarjetaParaPago(){
		super();
	}
	
	// gettes y setter
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getCupoMaximo() {
		return cupoMaximo;
	}
	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}
	public int getCupoDisponible() {
		return cupoDisponible;
	}
	public void setCupoDisponible(int cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumeroComprobacion() {
		return numeroComprobacion;
	}
	public void setNumeroComprobacion(String numeroComprobacion) {
		this.numeroComprobacion = numeroComprobacion;
	}
    public String getContrasenha() {
	return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
