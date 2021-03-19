package vista;

import javax.swing.JPanel;

import utils.Tabla;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JToolBar;

import modelo.Boxeador;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class PanelBoxeadores extends JPanel{

	private static final long serialVersionUID = -5673723129508415238L;
	
	public Tabla tablaBox;
	public JButton btCrear;

	public JButton btElegir;
	public JTextField tfNombre;
	public JTextField tfApellidos;
	public JTextField tfDni;

	public JButton btBuscar;

	public JPanel panelBuscar;
	public JButton btSerach;
	
	public PanelBoxeadores() {
		
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		btBuscar = new JButton("Buscar");
		btBuscar.setIcon(new ImageIcon(PanelBoxeadores.class.getResource("/resources/job.png")));
		toolBar.add(btBuscar);
		
		btCrear = new JButton("Crear");
		btCrear.setIcon(new ImageIcon(PanelBoxeadores.class.getResource("/resources/boxing-gloves2.png")));
		toolBar.add(btCrear);
		
		btElegir = new JButton("Elegir");
		btElegir.setIcon(new ImageIcon(PanelBoxeadores.class.getResource("/resources/athlete.png")));
		btElegir.setVisible(false);
		toolBar.add(btElegir);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		Object[] cabecera = {"id","Nombre","Apellidos","Dni","Elegir"};
		Class<?>[] tipos = {Integer.class,String.class,String.class,String.class,Boolean.class};
		Integer[] medidas = {40,100,200,100,30};
		
		tablaBox = new Tabla(cabecera, tipos, medidas, null, null, null);
		scrollPane.setViewportView(tablaBox.tabla);
		
		panelBuscar = new JPanel();
		add(panelBuscar, BorderLayout.WEST);
		panelBuscar.setPreferredSize(new Dimension(100, 300));
		panelBuscar.setLayout(new BoxLayout(panelBuscar, BoxLayout.Y_AXIS));
		panelBuscar.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		panelBuscar.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setMaximumSize(new Dimension(2147483647, 20));
		panelBuscar.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		panelBuscar.add(lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setMaximumSize(new Dimension(2147483647, 20));
		tfApellidos.setColumns(10);
		panelBuscar.add(tfApellidos);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Calibri Light", Font.ITALIC, 12));
		panelBuscar.add(lblDni);
		
		tfDni = new JTextField();
		tfDni.setMaximumSize(new Dimension(2147483647, 20));
		tfDni.setColumns(10);
		panelBuscar.add(tfDni);
		
		btSerach = new JButton("Buscar");
		btSerach.setMaximumSize(new Dimension(93, 23));
		panelBuscar.add(btSerach);
		
		//tablaBox.hideColumn(0);
		tablaBox.esconderColumna(0);
		tablaBox.esconderColumna(4);
		tablaBox.boldHeader("Calibri Light",true,12);
		rellenarTabla();
		
		repaint();
		revalidate();
		
	}
	
	private void rellenarTabla() {
		
		tablaBox.vaciar();
		
		LinkedList<Boxeador> boxeadores = Boxeador.find(null, null, null, null);
		
		for(Boxeador b:boxeadores) {
			
			Object[] fila= {b.idboxeador,b.nombre,b.apellidos,b.dni,false};
			
			tablaBox.modelo.addRow(fila);
			
		}
		
	}
}
























