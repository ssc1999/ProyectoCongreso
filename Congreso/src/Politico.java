import java.util.Arrays;

public class Politico extends Persona{

	
	public static int contadorPolitico = 0;
	protected int idPolitico;
	protected String partido;
	protected String puesto;
	
	
	public Politico(String tipo, String nombre, String apellido, int edad, double sueldo,
			String partido, String puesto) {
		super(nombre, apellido, edad, sueldo, tipo);
		contadorPolitico++;
		this.idPolitico = contadorPolitico;
		this.partido = partido;
		this.puesto = puesto;
	}

	public Politico() {
		super();
		contadorPolitico++;
		this.idPolitico = contadorPolitico;
		this.partido = "";
		this.puesto = "";
	}
	
	public Politico(Politico p) {
		super(p.nombre, p.apellido, p.edad, p.sueldo, p.tipo);
		this.idPolitico = p.idPolitico;
		this.partido = p.partido;
		this.puesto = p.puesto;
	}
	
	public int getIdPolitico() {
		return idPolitico;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	public String toString() {
		return tipo + ": " + nombre + " " + apellido + " del partido político: " + partido + ", con puesto de " + puesto + ", con  " + edad + " años y con un sueldo de " + sueldo + "€ anales.";
	}

	public String nombrePartido() {
		return(this.nombre + " " + this.apellido + ": " + this.partido);
	}
	
}
