package vista;

import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.JScrollPane;

import modelo.Boxeador;
import utils.MiJframe;

import java.awt.BorderLayout;

public class FormularioNuevoCombate extends MiJframe {

	private static final long serialVersionUID = 7340998237047499115L;
	
	public PanelBoxeadores panel;
	public LinkedList<Boxeador> boxeadores;
	
	public FormularioNuevoCombate() {
		
		this.boxeadores=new LinkedList<Boxeador>();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(FormularioNuevoCombate.class.getResource("/resources/boxing-gloves.png")));
		
		
		setSize(630,475);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		panel = new PanelBoxeadores();
		panel.tablaBox.showColumnn(4, 70);
		panel.btElegir.setVisible(true);
		panel.btBuscar.setVisible(false);
		panel.btCrear.setVisible(false);
		
		scrollPane.setViewportView(panel);
		
		setVisible(true);
		repaint();
		revalidate();
		
	}

}



















