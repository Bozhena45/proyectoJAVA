package vista;

import utils.Fecha;
import utils.MiJframe;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import modelo.Boxeador;
import modelo.Campeonato;
import modelo.Categoria;
import modelo.Estadio;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.Calendar;

import javax.swing.JSpinner;

public class FormularioCombate extends MiJframe{

	private static final long serialVersionUID = 6951126750086826253L;
	
	public JTextField tfNombreAzul;
	public JTextField tfApellidoAzul;
	public JTextField tfEquipoAzul;
	public JTextField tfEquipoRojo;
	public JTextField tfNombreRojo;
	public JTextField tfApellidoRojo;

	public JComboBox<Boxeador> cbGanador;

	public JButton btGuardar;

	public JButton btEliminar;

	public JButton btCancelar;

	public JButton btElegirBoxeador;

	public JComboBox<Estadio> cbEstadios;

	public JComboBox<Categoria> cbCategoria;

	public JComboBox<Campeonato> cbCampeonato;

	public JSpinner spinnerFecha;
	
	public FormularioCombate() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioCombate.class.getResource("/resources/boxing-gloves.png")));
		
		setBounds(100,100,533,382);
		setTitle("Combate");
		getContentPane().setLayout(null);
		
		JLabel lblEsquinaAzul = new JLabel("Esquina Azul:");
		lblEsquinaAzul.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblEsquinaAzul.setBounds(10, 15, 100, 14);
		getContentPane().add(lblEsquinaAzul);
		
		tfNombreAzul = new JTextField();
		tfNombreAzul.setEditable(false);
		tfNombreAzul.setBounds(10, 55, 100, 20);
		getContentPane().add(tfNombreAzul);
		tfNombreAzul.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 40, 60, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblApellidos.setBounds(130, 40, 60, 14);
		getContentPane().add(lblApellidos);
		
		tfApellidoAzul = new JTextField();
		tfApellidoAzul.setEditable(false);
		tfApellidoAzul.setColumns(10);
		tfApellidoAzul.setBounds(130, 55, 100, 20);
		getContentPane().add(tfApellidoAzul);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblEquipo.setBounds(10, 85, 60, 14);
		getContentPane().add(lblEquipo);
		
		tfEquipoAzul = new JTextField();
		tfEquipoAzul.setEditable(false);
		tfEquipoAzul.setBounds(10, 100, 220, 20);
		getContentPane().add(tfEquipoAzul);
		tfEquipoAzul.setColumns(10);
		
		JLabel label = new JLabel("Equipo:");
		label.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		label.setBounds(276, 85, 60, 14);
		getContentPane().add(label);
		
		tfEquipoRojo = new JTextField();
		tfEquipoRojo.setEditable(false);
		tfEquipoRojo.setColumns(10);
		tfEquipoRojo.setBounds(276, 100, 220, 20);
		getContentPane().add(tfEquipoRojo);
		
		tfNombreRojo = new JTextField();
		tfNombreRojo.setEditable(false);
		tfNombreRojo.setColumns(10);
		tfNombreRojo.setBounds(276, 55, 100, 20);
		getContentPane().add(tfNombreRojo);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		label_1.setBounds(276, 40, 60, 14);
		getContentPane().add(label_1);
		
		JLabel lblEsquinaRoja = new JLabel("Esquina Roja:");
		lblEsquinaRoja.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblEsquinaRoja.setBounds(276, 15, 100, 14);
		getContentPane().add(lblEsquinaRoja);
		
		JLabel label_3 = new JLabel("Apellidos:");
		label_3.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		label_3.setBounds(396, 40, 60, 14);
		getContentPane().add(label_3);
		
		tfApellidoRojo = new JTextField();
		tfApellidoRojo.setEditable(false);
		tfApellidoRojo.setColumns(10);
		tfApellidoRojo.setBounds(396, 55, 100, 20);
		getContentPane().add(tfApellidoRojo);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(254, 15, 2, 130);
		getContentPane().add(separator);
		
		JLabel lblInformacin = new JLabel("Informaci\u00F3n:");
		lblInformacin.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblInformacin.setBounds(10, 150, 100, 14);
		getContentPane().add(lblInformacin);
		
		JLabel lblEstadio = new JLabel("Estadio:");
		lblEstadio.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblEstadio.setBounds(10, 175, 60, 14);
		getContentPane().add(lblEstadio);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblCategoria.setBounds(254, 174, 60, 14);
		getContentPane().add(lblCategoria);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblFecha.setBounds(386, 175, 60, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblGanador = new JLabel("Ganador:");
		lblGanador.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblGanador.setBounds(10, 220, 60, 14);
		getContentPane().add(lblGanador);
		
		cbGanador = new JComboBox<Boxeador>();
		cbGanador.setBounds(10, 235, 220, 20);
		getContentPane().add(cbGanador);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 275, 485, 2);
		getContentPane().add(separator_1);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setBounds(10, 294, 89, 23);
		getContentPane().add(btGuardar);
		
		btEliminar = new JButton("Eliminar");
		btEliminar.setBounds(109, 294, 89, 23);
		getContentPane().add(btEliminar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(208, 294, 89, 23);
		getContentPane().add(btCancelar);
		btCancelar.setVisible(false);
		
		btElegirBoxeador = new JButton("Elegir Boxeadores");
		btElegirBoxeador.setVisible(false);
		btElegirBoxeador.setBounds(366, 294, 130, 23);
		getContentPane().add(btElegirBoxeador);
		
		cbEstadios = new JComboBox<Estadio>();
		cbEstadios.setBounds(10, 190, 220, 20);
		getContentPane().add(cbEstadios);
		
		cbCategoria = new JComboBox<Categoria>();
		cbCategoria.setBounds(254, 190, 110, 20);
		getContentPane().add(cbCategoria);
		
		JLabel lblCampeonato = new JLabel("Campeonato:");
		lblCampeonato.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblCampeonato.setBounds(254, 219, 100, 14);
		getContentPane().add(lblCampeonato);
		
		cbCampeonato = new JComboBox<Campeonato>();
		cbCampeonato.setBounds(254, 235, 242, 20);
		getContentPane().add(cbCampeonato);
		
		spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(386, 190, 110, 20);
		getContentPane().add(spinnerFecha);
		Fecha f = new Fecha();
		spinnerFecha.setModel(new SpinnerDateModel(f.getTime(),null,null,Calendar.DAY_OF_YEAR));
		spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha,"dd/MM/yyyy"));
		
		setVisible(true);
		centrar();
		repaint();
		revalidate();
		
	}
}
