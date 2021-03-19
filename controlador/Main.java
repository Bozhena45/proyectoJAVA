package controlador;

import javax.swing.UIManager;

import utils.Conexion;

public class Main {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		new ControladorMain();

		Conexion.close();
		
	}

}