package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import modelo.Campeonato;
import utils.Tabla;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelCampeonato extends JPanel{

	private static final long serialVersionUID = -2586416060368908158L;
	public Tabla tablaCombates;
	public JComboBox<Campeonato> cbCameponatos;
	public JButton btnAadirCombate;
	public JButton btPdf;
	public JScrollPane scrollPane;
	
	public PanelCampeonato() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		cbCameponatos = new JComboBox<Campeonato>();
		toolBar.add(cbCameponatos);
		
		btnAadirCombate = new JButton("A\u00F1adir Combate");
		btnAadirCombate.setIcon(new ImageIcon(PanelCampeonato.class.getResource("/resources/conflict.png")));
		toolBar.add(btnAadirCombate);
		
		btPdf = new JButton("Exportar PDF");
		btPdf.setIcon(new ImageIcon(PanelCampeonato.class.getResource("/resources/pdf.png")));
		toolBar.add(btPdf);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		Object[] cabecera = {"id", "idazul","Esquina Azul", "idrojo","Esquina Roja", "Categoria", "Ganador"};
		Class<?>[] tipos = {Integer.class, Integer.class,String.class, Integer.class,String.class, String.class, String.class};
		Integer[] medidas = {30,30,100,30,100,100,100};
		
		tablaCombates = new Tabla(cabecera, tipos, medidas, null, null, null);
		scrollPane.setViewportView(tablaCombates.tabla);
		tablaCombates.hideColumn(0);
		tablaCombates.hideColumn(0);
		tablaCombates.hideColumn(1);
		
		repaint();
		revalidate();
		
	}

}
