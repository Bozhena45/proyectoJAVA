package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.About;
import vista.PanelMain;
import vista.VistaPrincipal;

public class ControladorMain {

	public VistaPrincipal vp;
	
	public ControladorMain() {
		
		vp=new VistaPrincipal();
		
		vp.panel = new PanelMain();
		vp.getContentPane().add(vp.panel, BorderLayout.CENTER);
		vp.repaint();
		vp.revalidate();
		
		vp.menuBoxeadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				vp.getContentPane().removeAll();
				vp.panel = new ControladorPanelBoxeadores().pb;
				vp.getContentPane().add(vp.panel, BorderLayout.CENTER);
				vp.repaint();
				vp.revalidate();
				
			}
		});
		
		vp.menuCampeonatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vp.getContentPane().removeAll();
				vp.panel = new ControladorPanelCamp().pc;
				vp.getContentPane().add(vp.panel, BorderLayout.CENTER);
				vp.repaint();
				vp.revalidate();
				 
			}
		});
		
		vp.mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new About();
				
			}
		});
		
		vp.mntmEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				vp.getContentPane().removeAll();
				vp.panel = new ControladorPanelEquipo().pe;
				vp.getContentPane().add(vp.panel, BorderLayout.CENTER);
				vp.repaint();
				vp.revalidate();
				
			}
		});
		
		vp.mntmEstadios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				vp.getContentPane().removeAll();
				vp.panel = new ControladorPanelEstadio().pe;
				vp.getContentPane().add(vp.panel, BorderLayout.CENTER);
				vp.repaint();
				vp.revalidate();
				
			}
		});
		
	}
	
}



















