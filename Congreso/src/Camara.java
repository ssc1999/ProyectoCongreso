
public class Camara extends Persona {

	public static int contadorCamara = 0;
	protected int idCamara;
	protected int longevidad;
	protected int numeroActos;
	
	
	public Camara(String tipo, String nombre, String apellido, int edad, double sueldo, int longevidad,
			int numeroActos) {
		super(nombre, apellido, edad, sueldo, tipo);
		contadorCamara++;
		this.idCamara = contadorCamara;
		this.longevidad = longevidad;
		this.numeroActos = numeroActos;
	}

	public Camara() {
		super();
		contadorCamara++;
		this.idCamara = contadorCamara;
		this.longevidad = 0;
		this.numeroActos = 0;
	}
	
	public Camara(Camara c) {
		super(c.nombre, c.apellido, c.edad, c.sueldo, c.tipo);
		this.idCamara = c.idCamara;
		this.longevidad = c.longevidad;
		this.numeroActos = c.numeroActos;
	}

	public int getIdCamara() {
		return idCamara;
	}

	public int getLongevidad() {
		return longevidad;
	}

	public void setLongevidad(int longevidad) {
		this.longevidad = longevidad;
	}

	public int getNumeroActos() {
		return numeroActos;
	}

	public void setNumeroActos(int numeroActos) {
		this.numeroActos = numeroActos;
	}

	public String toString() {
		return tipo + ": " + nombre + " " + apellido + ", longevidad de " + longevidad + " años, en presencia de " + numeroActos
				+ " actos, "  +  " con edad de " + edad + " años y con un sueldo de " + sueldo + "€ anuales.";
	}
	
	public String getLong() {
		return(this.nombre + " " + this.apellido + ": " + this.longevidad + " años de longevidad.");
	}
	
	public String getAct() {
		return(this.nombre + " " + this.apellido + ": " + this.numeroActos + " número de actos.");
	}
	
}
