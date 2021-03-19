package vista;

import utils.MiJframe;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FormularioEstadio extends MiJframe{

	private static final long serialVersionUID = -17719710950736604L;
	
	public JTextField tfNombre;
	public JTextField tfDireccion;

	public JButton btGuardar;

	public JButton btEliminar;

	public JButton btnPruebaUrl;
	
	public FormularioEstadio() {
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioEstadio.class.getResource("/resources/boxing-gloves.png")));
		
		setBounds(100,100,275,214);
		setTitle("Estadio");
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		label.setBounds(10, 11, 62, 14);
		getContentPane().add(label);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(10, 26, 180, 20);
		getContentPane().add(tfNombre);
		
		JLabel label_1 = new JLabel("Direcci\u00F3n:");
		label_1.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		label_1.setBounds(10, 56, 62, 14);
		getContentPane().add(label_1);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(10, 71, 180, 20);
		getContentPane().add(tfDireccion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 135, 230, 8);
		getContentPane().add(separator);
		
		btGuardar = new JButton("Guardar");
		btGuardar.setBounds(10, 151, 89, 23);
		getContentPane().add(btGuardar);
		
		btEliminar = new JButton("Eliminar");
		btEliminar.setEnabled(false);
		btEliminar.setBounds(151, 151, 89, 23);
		getContentPane().add(btEliminar);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FormularioEstadio.class.getResource("/resources/ring2.png")));
		label_2.setBounds(205, 15, 46, 41);
		getContentPane().add(label_2);
		
		JLabel lbFotoDirecc = new JLabel("");
		lbFotoDirecc.setIcon(new ImageIcon(FormularioEstadio.class.getResource("/resources/map.png")));
		lbFotoDirecc.setBounds(205, 62, 46, 31);
		getContentPane().add(lbFotoDirecc);
		
		btnPruebaUrl = new JButton("Buscar Mapa");
		btnPruebaUrl.setBounds(10, 101, 102, 23);
		getContentPane().add(btnPruebaUrl);
		
		setVisible(true);
		centrar();
		repaint();
		revalidate();
		
	}
}
