package vista;

import utils.Fecha;
import utils.JSpinnerFecha;
import utils.MiJframe;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import modelo.Equipo;

import javax.swing.JComboBox;

public class FormularioBoxeador extends MiJframe {

	private static final long serialVersionUID = 8780947658444270349L;
	public JTextField tfId;
	public JTextField tfNombre;
	public JTextField tfApellidos;
	public JTextField tfDni;
	public JComboBox<Equipo> cbEquipos;
	public JButton btGuardar;
	public JButton btCancelar;
	public JButton btEliminar;
	public JSpinnerFecha fecha_nac;

	public FormularioBoxeador() {
		setResizable(false);
		getContentPane().setFont(new Font("Calibri Light", Font.PLAIN, 12));
		
		setTitle("Formulario Boxeador");
		setBounds(100, 100, 360, 365);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblId.setBounds(10, 10, 46, 14);
		getContentPane().add(lblId);
		
		tfId = new JTextField();
		tfId.setHorizontalAlignment(SwingConstants.CENTER);
		tfId.setFont(new Font("Calibri Light", Font.BOLD, 12));
		tfId.setEditable(false);
		tfId.setBounds(10, 25, 40, 30);
		getContentPane().add(tfId);
		tfId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 80, 46, 14);
		getContentPane().add(lblNewLabel);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(10, 95, 150, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblApellidos.setBounds(184, 80, 71, 14);
		getContentPane().add(lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(183, 95, 150, 20);
		getContentPane().add(tfApellidos);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblFechaNacimiento.setBounds(10, 125, 99, 14);
		getContentPane().add(lblFechaNacimiento);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblDni.setBounds(184, 124, 99, 14);
		getContentPane().add(lblDni);
		
		tfDni = new JTextField();
		tfDni.setColumns(10);
		tfDni.setBounds(183, 140, 150, 20);
		getContentPane().add(tfDni);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 180, 323, 2);
		getContentPane().add(separator);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblEquipo.setBounds(10, 200, 99, 14);
		getContentPane().add(lblEquipo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 255, 323, 2);
		getContentPane().add(separator_1);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setBounds(10, 280, 89, 23);
		getContentPane().add(btGuardar);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(244, 280, 89, 23);
		getContentPane().add(btCancelar);
		
		btEliminar = new JButton("Eliminar");
		btEliminar.setBounds(127, 280, 89, 23);
		getContentPane().add(btEliminar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FormularioBoxeador.class.getResource("/resources/martial-arts-couple-fight.png")));
		label.setBounds(170, 204, 32, 40);
		getContentPane().add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FormularioBoxeador.class.getResource("/resources/avatar.png")));
		label_2.setBounds(269, 10, 64, 63);
		getContentPane().add(label_2);
		
		cbEquipos = new JComboBox<Equipo>();
		cbEquipos.setBounds(10, 215, 150, 20);
		getContentPane().add(cbEquipos);
		
		fecha_nac = new JSpinnerFecha(new Fecha());
		fecha_nac.jspinner.setBounds(10, 140, 150, 20);
		getContentPane().add(fecha_nac.jspinner);
		
		setVisible(true);
		centrar();
		repaint();
		revalidate();
		
	}
}
