package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import utils.Tabla;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelEquipo extends JPanel{

	private static final long serialVersionUID = 2444788553973510800L;
	public Tabla tbEquipos;
	public JButton btCrear;
	public JButton btBuscar;
	
	public PanelEquipo() {
		
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		btBuscar = new JButton("Buscar");
		btBuscar.setIcon(new ImageIcon(PanelEquipo.class.getResource("/resources/job.png")));
		toolBar.add(btBuscar);
		
		btCrear = new JButton("Crear");
		btCrear.setIcon(new ImageIcon(PanelEquipo.class.getResource("/resources/boxing-gloves2.png")));
		toolBar.add(btCrear);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		Object[] cabecera = {"Id", "Nombre", "Dirección", "Imágen"};
		Class<?>[] tipos = {Integer.class, String.class, String.class, String.class};
		Integer[] medidas = {30,100,200,50};
		
		tbEquipos = new Tabla(cabecera, tipos, medidas, null, null, null);
		scrollPane.setViewportView(tbEquipos.tabla);
		tbEquipos.hideColumn(0);
		
		repaint();
		revalidate();
		
	}

}
