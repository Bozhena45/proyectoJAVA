package vista;

import utils.MiJframe;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VistaPrincipal extends MiJframe{
	
	private static final long serialVersionUID = 3889525055274706996L;
	public JMenuItem menuCampeonatos;
	public JMenuItem menuBoxeadores;
	public JPanel panel;
	public JMenuItem mntmAbout;
	public JMenuItem mntmEquipos;
	public JMenuItem mntmEstadios;

	public VistaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPrincipal.class.getResource("/resources/boxing-gloves.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Campeonatos Boxeo");
		setBounds(100,100,660,500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuInicio = new JMenu("Inicio");
		menuBar.add(menuInicio);
		
		menuCampeonatos = new JMenuItem("Campeonatos");
		menuCampeonatos.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/resources/prize.png")));
		menuInicio.add(menuCampeonatos);
		
		menuBoxeadores = new JMenuItem("Boxeadores");
		menuBoxeadores.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/resources/gloves.png")));
		menuInicio.add(menuBoxeadores);
		
		mntmEquipos = new JMenuItem("Equipos");
		mntmEquipos.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/resources/teams.png")));
		menuInicio.add(mntmEquipos);
		
		mntmEstadios = new JMenuItem("Estadios");
		mntmEstadios.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/resources/ring.png")));
		menuInicio.add(mntmEstadios);
		
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/resources/boxing.png")));
		menuHelp.add(mntmAbout);
		
		setVisible(true);
		centrar();
		repaint();
		revalidate();
		
	}

}
