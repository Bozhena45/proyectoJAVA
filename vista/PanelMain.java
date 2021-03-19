package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class PanelMain extends JPanel{

	private static final long serialVersionUID = -8581493709576267765L;
	
	public BufferedImage img;
	
	public PanelMain() {
		setLayout(new BorderLayout(0, 0));
		
		this.img = null;
		
		try {
			img = ImageIO.read(PanelMain.class.getResource("/resources/fire-and-water.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,0,0, getWidth(), getHeight(), this);    
	}

}
