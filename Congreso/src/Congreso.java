import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class Congreso {

	protected ArrayList <Persona> personas;
	protected HashMap <String, ArrayList<Persona>> tipoPersona;
	
	public Congreso(ArrayList<Persona> personas, HashMap <String, ArrayList<Persona>> tipoPersona) {
		super();
		this.personas = new ArrayList<Persona> (personas) ;
		this.tipoPersona = new HashMap <String, ArrayList<Persona>> (tipoPersona);
	}
	
	public Congreso() {
		super();
		this.personas = new ArrayList<Persona>();
		this.tipoPersona = new HashMap<String, ArrayList<Persona>>();
		this.tipoPersona.put("Politico", new ArrayList<Persona>());
		this.tipoPersona.put("Camara", new ArrayList<Persona>());
	}
	
	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public HashMap<String, ArrayList<Persona>> getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(HashMap<String, ArrayList<Persona>> tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	
	public String toString() {
		return "Congreso [personas=" + personas + ", tipoPersona=" + tipoPersona + "]";
	}

	public void cargarDatos() {
		try {
			
			
			Scanner scannerPoliticos = new Scanner(new File("politicos.csv"));
			Scanner scannerCamara = new Scanner(new File("camara.csv"));
			
			while (scannerPoliticos.hasNextLine()) {
			   String linea = scannerPoliticos.nextLine();
			   String[] array = linea.split(",");
			   
			   	Politico politico = new Politico();
				politico.setTipo(array[0]);
				politico.setIdPersona(Integer.parseInt(array[1]));
				politico.setNombre(array[2]);
				politico.setApellido(array[3]);
				politico.setEdad(Integer.parseInt(array[4]));
				politico.setSueldo(Double.parseDouble(array[5]));
				politico.setPartido(array[6]);
				politico.setPuesto(array[7]);
				
				anyadirPolitico(politico);
				
			}
	
			while (scannerCamara.hasNextLine()) {
				   String linea = scannerCamara.nextLine();
				   String[] array = linea.split(",");
				   
				    Camara camara = new Camara();
					camara.setTipo(array[0]);
					camara.setIdPersona(Integer.parseInt(array[1]));
					camara.setNombre(array[2]);
					camara.setApellido(array[3]);
					camara.setEdad(Integer.parseInt(array[4]));
					camara.setSueldo(Double.parseDouble(array[5]));
					camara.setLongevidad(Integer.parseInt(array[6]));
					camara.setNumeroActos(Integer.parseInt(array[7]));
					
					anyadirCamara(camara);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void guardarDatos() {
		PrintWriter pw = null;
		PrintWriter pw2 = null;
		try {
			pw = new PrintWriter("politicos.csv");
			pw2 = new PrintWriter("camara.csv");
			
			for (Persona politicos : tipoPersona.get("Politico")) {
				Politico politico = (Politico) politicos;
				pw.println(politico.getTipo() + "," + politico.getIdPersona() + "," + politico.getNombre() + "," + politico.getApellido() + "," + politico.getEdad() + "," + politico.getSueldo() + "," + politico.getPartido() + "," + politico.getPuesto());
			}
			
			for (Persona camaras : tipoPersona.get("Camara")) {
				Camara camara = (Camara) camaras;
				pw2.println(camara.getTipo() + "," + camara.getIdPersona() + "," + camara.getNombre() + "," + camara.getApellido() + "," + camara.getEdad() + "," + camara.getSueldo() + "," + camara.getLongevidad() + "," + camara.getNumeroActos());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
			pw2.close();
		}
	}
	
	public void eliminarPolitico(Politico persona) {
		personas.remove(persona);
		ArrayList<Persona> politicos = tipoPersona.get("Politico");
		politicos.remove(persona);
		tipoPersona.put("Politico", politicos);
		
	}
	
	public void eliminarCamara(Camara persona) {
		personas.remove(persona);
		ArrayList<Persona> camara = tipoPersona.get("Camara");
		camara.remove(persona);
		tipoPersona.put("Camara", camara);
		
	}

	public void anyadirPolitico(Politico persona) {
		personas.add(persona);
		ArrayList<Persona> politico = tipoPersona.get("Politico");
		politico.add(persona);
		tipoPersona.put("Politico", politico);
		
	}

	public void anyadirCamara(Camara persona) {
		personas.add(persona);
		ArrayList<Persona> camara = tipoPersona.get("Camara");
		camara.add(persona);
		tipoPersona.put("Camara", camara);
	}

	
	
}
