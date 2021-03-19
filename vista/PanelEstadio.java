package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import utils.Tabla;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class PanelEstadio extends JPanel{

	private static final long serialVersionUID = 1504059663660500283L;
	
	public Tabla tablaEstadios;
	public JButton btBuscar;
	public JButton btCrear;

	public JPanel panelBuscar;
	private JLabel lblNombre;
	public JTextField tfNombre;
	
	public PanelEstadio() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		btBuscar = new JButton("Buscar");
		btBuscar.setIcon(new ImageIcon(PanelEstadio.class.getResource("/resources/job.png")));
		toolBar.add(btBuscar);
		
		btCrear = new JButton("Crear");
		btCrear.setIcon(new ImageIcon(PanelEstadio.class.getResource("/resources/boxing-gloves2.png")));
		toolBar.add(btCrear);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		Object[] cabecera = {"Id","Nombre","Dirección"};
		Class<?>[] tipos = {Integer.class,String.class,String.class};
		Integer[] medidas = {30,200,200};
		
		tablaEstadios = new Tabla(cabecera, tipos, medidas, null, null, null);
		tablaEstadios.hideColumn(0);
		scrollPane.setViewportView(tablaEstadios.tabla);
		
		panelBuscar = new JPanel();
		panelBuscar.setVisible(false);
		panelBuscar.setPreferredSize(new Dimension(100000, 30));
		add(panelBuscar, BorderLayout.SOUTH);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		panelBuscar.add(lblNombre);
		
		tfNombre = new JTextField();
		panelBuscar.add(tfNombre);
		tfNombre.setColumns(10);
		
		repaint();
		revalidate();
		
	}

}
