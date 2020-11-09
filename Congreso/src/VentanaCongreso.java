import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaCongreso extends JFrame{
	
	private Congreso congreso;
	private JTextField textNombre;
	private JTextField textApellido;
	private JSpinner spinnerEdad;
	private JSpinner spinnerSueldo;
	private JRadioButton radioPolitico;
	private JRadioButton radioCamara;
	private JComboBox comboPartido;
	private JComboBox comboPuesto;
	private JSpinner spinnerLongevidad;
	private JSpinner spinnerActos;
	private JLabel textCPa;
	private JLabel textCPu;
	private JLabel textSL;
	private JLabel textSA;
	private JList lista;
	protected DefaultListModel datos;
	private JList lista2;
	protected DefaultListModel datos2;
	private JButton botonAnyadir;
	private JButton botonEliminar;
	private JButton botonImprimir;
	private JComboBox listarMiembro;
	private JComboBox sueldoMiembro;
	private JComboBox listarPartido;
	private JComboBox listarCamara;
	private JButton botonLimpiarLista;
	
	private JPanel contentPane;
	
	public VentanaCongreso() {
		
		congreso = new Congreso();
		setTitle("Congreso de diputados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(950, 400));
		setResizable(false);
		pack();
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		JPanel panelAdmin = new JPanel(new BorderLayout());
		JPanel panelPeriodista = new JPanel(new BorderLayout());
		contentPane.add(panelAdmin);
		contentPane.add(panelPeriodista);
		
		
		JMenuBar menu = new JMenuBar();
		JMenu menuDatos = new JMenu("Datos");
		JMenu menuModo = new JMenu("Modo");
		JMenuItem cargar = new JMenuItem("Cargar Datos");
		JMenuItem guardar = new JMenuItem("Guardar Datos");
		JMenuItem imprimir = new JMenuItem("Imprimir");
		JMenuItem admin = new JMenuItem("Administrador");
		JMenuItem periodista = new JMenuItem("Periodista");
		
		menuDatos.add(cargar);
		menuDatos.add(guardar);
		menuDatos.add(imprimir);
		menuModo.add(admin);
		menuModo.add(periodista);
		menu.add(menuDatos);
		menu.add(menuModo);
		setJMenuBar(menu);
		menu.setVisible(true);
		
		admin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelAdmin.setVisible(true);
				panelPeriodista.setVisible(false);
			}
		});
		periodista.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelAdmin.setVisible(false);
				panelPeriodista.setVisible(true);
			}
		});
		
		//Estructura panelAdmin
		
		JPanel panelAdminWest = new JPanel(new BorderLayout());
		JPanel panelAdminWestNorth = new JPanel(new GridLayout(9, 2));
		JPanel panelAdminWestSouth = new JPanel(new GridLayout(1, 2));
		JPanel panelAdminEast = new JPanel(new BorderLayout());
		panelAdminWest.add(panelAdminWestNorth, BorderLayout.NORTH);
		panelAdminWest.add(panelAdminWestSouth, BorderLayout.SOUTH);
		panelAdmin.add(panelAdminWest, BorderLayout.WEST);
		panelAdmin.add(panelAdminEast, BorderLayout.EAST);

		textNombre = new JTextField(20);
		textApellido = new JTextField(20);
		spinnerEdad = new JSpinner();
		spinnerSueldo = new JSpinner();
		comboPartido = new JComboBox();
		comboPartido.addItem("PSOE");
		comboPartido.addItem("PP");
		comboPartido.addItem("PNV");
		comboPartido.addItem("UP");
		comboPartido.addItem("CIUDADANOS");
		comboPartido.addItem("VOX");
		comboPuesto = new JComboBox();
		comboPuesto.addItem("Presidente");
		comboPuesto.addItem("Concejal");
		comboPuesto.addItem("Secretario");
		radioPolitico = new JRadioButton("Politico");
		radioCamara = new JRadioButton("Camara");
		spinnerLongevidad = new JSpinner();
		spinnerActos = new JSpinner();
		textCPa = new JLabel("Partido:");
		textCPu = new JLabel("Puesto:");
		textSL = new JLabel("Longevidad en el puesto:");
		textSA = new JLabel("Numero de actos:");
		botonAnyadir = new JButton("Anyadir");
		botonEliminar = new JButton("Eliminar");
		
		JPanel grupoCongreso = new JPanel();
		grupoCongreso.add(radioPolitico);
		grupoCongreso.add(radioCamara);
		
		ButtonGroup grupoTipo = new ButtonGroup();
		grupoTipo.add(radioPolitico);
		grupoTipo.add(radioCamara);
		
		panelAdminWestNorth.add(new JLabel("Nombre:"));
		panelAdminWestNorth.add(textNombre);
		panelAdminWestNorth.add(new JLabel("Apellido:"));
		panelAdminWestNorth.add(textApellido);
		panelAdminWestNorth.add(new JLabel("Edad:"));
		panelAdminWestNorth.add(spinnerEdad);
		panelAdminWestNorth.add(new JLabel("Sueldo anual en €:"));
		panelAdminWestNorth.add(spinnerSueldo );
		panelAdminWestNorth.add(new JLabel("Cargo"));
		panelAdminWestNorth.add(grupoCongreso);
		panelAdminWestNorth.add(textCPa);
		panelAdminWestNorth.add(comboPartido);
		panelAdminWestNorth.add(textCPu);
		panelAdminWestNorth.add(comboPuesto);
		panelAdminWestNorth.add(textSL);
		panelAdminWestNorth.add(spinnerLongevidad);
		panelAdminWestNorth.add(textSA);
		panelAdminWestNorth.add(spinnerActos);
		panelAdminWestSouth.add(botonAnyadir);
		panelAdminWestSouth.add(botonEliminar);
		
		datos = new DefaultListModel();
		lista = new JList(datos);
		JScrollPane listaVentana = new JScrollPane(lista);
		listaVentana.setPreferredSize(new Dimension(400, 300));
		panelAdminEast.add(listaVentana, BorderLayout.EAST);
		
		//botones incialmente invisibles
		textCPa.setVisible(false);
		comboPartido.setVisible(false);
		textCPu.setVisible(false);
		comboPuesto.setVisible(false);
		textSL.setVisible(false);
		spinnerLongevidad.setVisible(false);
		textSA.setVisible(false);
		spinnerActos.setVisible(false);
		
		radioPolitico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textCPa.setVisible(true);
				comboPartido.setVisible(true);
				textCPu.setVisible(true);
				comboPuesto.setVisible(true);
				textSL.setVisible(false);
				spinnerLongevidad.setVisible(false);
				textSA.setVisible(false);
				spinnerActos.setVisible(false);
				
			}
		});
		
		radioCamara.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textCPa.setVisible(false);
				comboPartido.setVisible(false);
				textCPu.setVisible(false);
				comboPuesto.setVisible(false);
				textSL.setVisible(true);
				spinnerLongevidad.setVisible(true);
				textSA.setVisible(true);
				spinnerActos.setVisible(true);
			}
		});
		
		botonEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Persona persona = (Persona) lista.getSelectedValue();
				datos.removeElement(persona);
				if (persona instanceof Politico) {
					congreso.eliminarPolitico((Politico) persona);
				} else {
					congreso.eliminarCamara((Camara) persona);
				}
			}
		});
		
		botonAnyadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = (String) textNombre.getText();
				String apellido = (String) textApellido.getText();
				int edad = (Integer) spinnerEdad.getValue();
				double sueldo = (Double) spinnerSueldo.getValue();
				String partido = (String) comboPartido.getSelectedItem();
				String puesto = (String) comboPuesto.getSelectedItem();
				int longevidad = (Integer) spinnerLongevidad.getValue();
				int actos = (Integer) spinnerActos.getValue();
				
				if (radioPolitico.isSelected()) {
					String tipo = "Politico";
					Politico politico = new Politico(tipo, nombre, apellido, edad, sueldo, partido, puesto);
					congreso.anyadirPolitico(politico);
					datos.addElement(politico);
				} else {
					String tipo = "Camara";
					Camara camara = new Camara(tipo,nombre, apellido, edad, sueldo, longevidad, actos);
					congreso.anyadirCamara(camara);
					datos.addElement(camara);
				}
			}
		});
		
		cargar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				congreso.cargarDatos();
				for(Persona persona: congreso.getPersonas()) { 
					datos.addElement(persona);
				}
			}
		});
		
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				congreso.guardarDatos();
			}
		});
		
		imprimir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread t = new Thread() {
					@Override
					public void run() {
						for (Persona persona : congreso.getPersonas()) {
							System.out.println(persona);
							try {
								Thread.sleep(2000);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				};
				
				t.start();
			}
		});
		
		//Estructura panelPeriodista
		
		JPanel panelPeriodistaWest = new JPanel(new BorderLayout());
		JPanel panelPeriodistaEast = new JPanel(new BorderLayout());
		JPanel panelPeriodistaWestNorth = new JPanel(new GridLayout(4,2));
		JPanel panelPeriodistaWestSouth = new JPanel(new BorderLayout());
		panelPeriodistaWest.add(panelPeriodistaWestNorth, BorderLayout.NORTH);
		panelPeriodistaWest.add(panelPeriodistaWestSouth, BorderLayout.SOUTH);
		panelPeriodista.add(panelPeriodistaWest, BorderLayout.WEST);
		panelPeriodista.add(panelPeriodistaEast, BorderLayout.EAST);
		
		listarMiembro = new JComboBox();
		listarMiembro.addItem("");
		listarMiembro.addItem("Congreso");
		listarMiembro.addItem("Políticos");
		listarMiembro.addItem("Cámara");
		sueldoMiembro = new JComboBox();
		sueldoMiembro.addItem("");
		sueldoMiembro.addItem("Congreso");
		sueldoMiembro.addItem("Políticos");
		sueldoMiembro.addItem("Cámara");
		listarPartido = new JComboBox();
		listarPartido.addItem("");
		listarPartido.addItem("PSOE");
		listarPartido.addItem("PP");
		listarPartido.addItem("PNV");
		listarPartido.addItem("UP");
		listarPartido.addItem("CIUDADANOS");
		listarPartido.addItem("VOX");
		listarCamara = new JComboBox();
		listarCamara.addItem("");
		listarCamara.addItem("Años de longevidad");
		listarCamara.addItem("Numero de actos");
		botonLimpiarLista = new JButton("Limpiar lista");
		
		datos2 = new DefaultListModel();
		lista2 = new JList(datos2);
		JScrollPane lista2Ventana = new JScrollPane(lista2);
		lista2Ventana.setPreferredSize(new Dimension(400, 300));
		panelPeriodistaEast.add(lista2Ventana);
	
		panelPeriodistaWestNorth.add(new JLabel("Listar participantes: "));
		panelPeriodistaWestNorth.add(listarMiembro);
		panelPeriodistaWestNorth.add(new JLabel("Mostrar sueldos de las personas tipo: "));
		panelPeriodistaWestNorth.add(sueldoMiembro);
		panelPeriodistaWestNorth.add(new JLabel("Políticos del siguiente partido: "));
		panelPeriodistaWestNorth.add(listarPartido);
		panelPeriodistaWestNorth.add(new JLabel("Miembros de la cámara con mayor: "));
		panelPeriodistaWestNorth.add(listarCamara);
		panelPeriodistaWestSouth.add(botonLimpiarLista);
		
		listarMiembro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 String lM = (String) listarMiembro.getSelectedItem();
				 datos2.removeAllElements();
			        switch (lM) {//check for a match
			            case "Congreso":			            	
			            	for(Persona persona : congreso.getPersonas()) {   			   
			            			datos2.addElement(persona);
			            	}  
			                break;
			            case "Políticos":			   
			            	for(Persona persona : congreso.getPersonas()) {   
			            		if (persona instanceof Politico) {
			            			datos2.addElement((Politico) persona);
			            		}          	
			            	}  
			                break;
			            case "Cámara":			            	
			            	for(Persona persona : congreso.getPersonas()) {   
			            	    if(persona instanceof Camara) {  
			            		datos2.addElement((Camara) persona);
			            	    }
			            	}  
			                break;
			        }
			}
		});
		
		sueldoMiembro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 String lM = (String) sueldoMiembro.getSelectedItem();
				 datos2.removeAllElements();
			        switch (lM) {//check for a match
			        case "Congreso":
			        	
		            	for(Persona persona : congreso.getPersonas()) {   
		            	      datos2.addElement(persona.getStringSueldo()); 
		            	}  
		                break;
		            case "Políticos":
		            	
		            	for(Persona persona : congreso.getPersonas()) {  
		            		if(persona instanceof Politico) {
		            		datos2.addElement(((Politico)persona).getStringSueldo());		
		            		}
		            	}  
		                break;
		            case "Cámara":
		            	
		            	for(Persona persona : congreso.getPersonas()) {   
		            		if(persona instanceof Camara) {
		            		datos2.addElement(((Camara)persona).getStringSueldo()); 
		            		}
		            	}   
		                break;
			        }
			}
		});
		
		listarPartido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 String lM = (String) listarPartido.getSelectedItem();
				 Politico politico = new Politico();
				 datos2.removeAllElements();
				 
				 for(Persona persona : congreso.getPersonas()) {   
			            if(persona instanceof Politico) {
			            	 if(((Politico) persona).getPartido().equals(lM)){
			            		 datos2.addElement((Politico)persona);
			            	 }
						} 
			      }  		     
			}
		});
		
		listarCamara.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 String lM = (String) listarCamara.getSelectedItem();
				 datos2.removeAllElements();
			        switch (lM) {//check for a match
			            case "Años de longevidad":
			            	
			            	for(Persona persona : congreso.getTipoPersona().get("Camara")) {       
								if(persona instanceof Camara) {
			            		datos2.addElement(((Camara)persona).getLong());
								}
			            	}      
			                break;
			            case "Numero de actos":
			            	
			            	for(Persona persona : congreso.getTipoPersona().get("Camara")) {  
			            		if(persona instanceof Camara) {
			            			datos2.addElement(((Camara)persona).getAct());
			            		}
			            		
			            	}  
			                break;
			        }
			}
		});
		
		botonLimpiarLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				datos2.removeAllElements();
			}
		});
		
		//
		pack();
		contentPane.setVisible(true);
		panelAdmin.setVisible(true);
		panelPeriodista.setVisible(false);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			   public void run() {
			    try {
			     VentanaCongreso frame = new VentanaCongreso();
			     frame.setVisible(true);
			    } catch (Exception e) {
			     e.printStackTrace();
			    }
			   }
			  });

	}

}
