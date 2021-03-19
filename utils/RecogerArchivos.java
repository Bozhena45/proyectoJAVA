package utils;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RecogerArchivos {
	
	public JFileChooser selectorArchivos;
	public File archivo;
	public FileNameExtensionFilter filtro;
	public String nombreArchivo;
	
	public RecogerArchivos() {
		
		this.archivo=null;
		this.selectorArchivos=new JFileChooser();
		this.filtro=null;
		this.nombreArchivo=null;
		
		int seleccion = this.selectorArchivos.showOpenDialog(null);
		
		if(seleccion==JFileChooser.APPROVE_OPTION) {
			
			this.archivo=this.selectorArchivos.getSelectedFile();
			this.nombreArchivo=this.archivo.getName();
			
		}
		
	}
	
	public RecogerArchivos(String descripcion, String filtro) {
		
		this.archivo=null;
		this.selectorArchivos=new JFileChooser();
		this.filtro=new FileNameExtensionFilter(descripcion,filtro);
		this.nombreArchivo=null;
		
		int seleccion = this.selectorArchivos.showOpenDialog(null);
		
		if(seleccion==JFileChooser.APPROVE_OPTION) {
			
			this.archivo=this.selectorArchivos.getSelectedFile();
			this.nombreArchivo=this.archivo.getName();
			
		}
		
		
	}
	
	public static String seleccionarDirectorio() {
		
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int respuesta = jfc.showSaveDialog(null);
		
		if(respuesta==JFileChooser.APPROVE_OPTION) {
			File f = jfc.getSelectedFile();
			String ruta = f.getAbsolutePath();
			return ruta;
		}
		
		return null;
		
	}

}



















