
public abstract class Persona implements Registrar{

	public static int contadorPersona = 0;
	protected int idPersona;
	protected String nombre;
	protected String apellido;
	protected int edad;
	protected double sueldo;
	protected String tipo;
	
	public Persona(String nombre, String apellido, int edad, double sueldo, String tipo) {
		super();
		contadorPersona++;
		this.idPersona = contadorPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sueldo = sueldo;
		this.tipo = tipo;
	}
	
	public Persona() {
		super();
		contadorPersona++;
		this.idPersona = contadorPersona;
		this.nombre = "";
		this.apellido = "";
		this.edad = 0;
		this.sueldo = 0;
		this.tipo = "";
	}
	
	public Persona(Persona p) {
		super();
		this.idPersona = p.idPersona;
		this.nombre = p.nombre;
		this.apellido = p.apellido;
		this.edad = p.edad;
		this.sueldo = p.sueldo;
		this.tipo = p.tipo;
	}

	public int getIdPersona() {
		return idPersona;
	}
	
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "Carnet del congreso: " + idPersona + ", " +nombre + " " + apellido + " con edad de " + edad + " años y sueldo de: " + sueldo + "€ anuales y de tipo: " + tipo;
	}


	public String getStringSueldo() {
		return(this.nombre + " " + this.apellido + ": " + this.sueldo + " € anuales.");
	}
	
	public Persona registrar() {
		return null;
	}

	
	
}
