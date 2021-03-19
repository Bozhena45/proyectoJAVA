package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MiJframe extends JFrame {

	private static final long serialVersionUID = 7024867568916092411L;

	public MiJframe() {
		super();
	}
	
	public void centrar() {
		//Centrar la pantalla
		Toolkit p = Toolkit.getDefaultToolkit();
				
		Dimension tam=p.getScreenSize();
		int h=tam.height;
		int w=tam.width;
				
		this.setLocation((w/2)-(this.getSize().width/2), (h/2)-(this.getSize().height/2));
	}
	
}
