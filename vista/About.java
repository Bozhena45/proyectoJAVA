package vista;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class About extends JDialog{

	private static final long serialVersionUID = -4660754389327191558L;
	
	public About() {
		
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/resources/boxing-gloves.png")));
		
		setSize(420,185);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JTextPane txt = new JTextPane();
		txt.setEditable(false);
		txt.setText("Campeonatos de Boxeo\r\n\r\nVersion 1.0\r\nBuild id: 20180917-1800\r\n\r\n(c) Copyright Carlos S.A contributors and others 2019. All rights reserved. The Carlos S.A logo cannot be altered without Carlos S.A permission");
		txt.setBounds(79, 11, 325, 133);
		txt.setBackground(new Color(240, 240, 240));
		getContentPane().add(txt);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(About.class.getResource("/resources/boxing-gloves.png")));
		label.setBounds(20, 39, 46, 66);
		getContentPane().add(label);
		
		setVisible(true);
		repaint();
		revalidate();
		
	}
	
}
