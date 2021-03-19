package vista;

import utils.MiJframe;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class FormularioEquipo extends MiJframe{

	private static final long serialVersionUID = -6702436943925723766L;
	public JTextField tfNombre;
	public JTextField tfDireccion;
	public JButton btFoto;
	public JButton btGuardar;
	public JButton btEliminar;
	public JLabel lbNombreFoto;
	public JLabel lbFoto;
	
	public FormularioEquipo() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioEquipo.class.getResource("/resources/boxing-gloves.png")));
		
		setBounds(100,100,300,300);
		getContentPane().setLayout(null);
		
		lbFoto = new JLabel("No hay im\u00E1gen");
		lbFoto.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		lbFoto.setBounds(25, 11, 89, 62);
		getContentPane().add(lbFoto);
		
		btFoto = new JButton("A\u00F1adir foto");
		btFoto.setBounds(150, 29, 105, 23);
		getContentPane().add(btFoto);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblNombre.setBounds(25, 85, 62, 14);
		getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(25, 100, 200, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		lblDireccin.setBounds(25, 130, 62, 14);
		getContentPane().add(lblDireccin);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(25, 145, 200, 20);
		getContentPane().add(tfDireccion);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FormularioEquipo.class.getResource("/resources/punch.png")));
		label_1.setBounds(235, 90, 34, 41);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FormularioEquipo.class.getResource("/resources/punching-bag.png")));
		label_2.setBounds(235, 135, 45, 41);
		getContentPane().add(label_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 190, 230, 8);
		getContentPane().add(separator);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setBounds(25, 210, 89, 23);
		getContentPane().add(btGuardar);
		
		btEliminar = new JButton("Eliminar");
		btEliminar.setEnabled(false);
		btEliminar.setBounds(166, 210, 89, 23);
		getContentPane().add(btEliminar);
		
		lbNombreFoto = new JLabel("");
		lbNombreFoto.setFont(new Font("Calibri Light", Font.ITALIC, 11));
		lbNombreFoto.setBounds(150, 52, 105, 14);
		getContentPane().add(lbNombreFoto);
		
		setVisible(true);
		centrar();
		repaint();
		revalidate();
		
	}
}
