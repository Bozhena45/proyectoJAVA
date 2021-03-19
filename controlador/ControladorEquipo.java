package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelo.Equipo;
import utils.RecogerArchivos;
import vista.FormularioEquipo;
import vista.PanelEquipo;

public class ControladorEquipo {
	
	public FormularioEquipo fe;
	public Equipo equipo;
	public File imagen;
	public PanelEquipo pe;
	
	public ControladorEquipo(PanelEquipo pe) {
		
		this.fe=new FormularioEquipo();
		this.equipo=null;
		this.imagen=null;
		this.pe=pe;
		
		fe.btFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RecogerArchivos ra = new RecogerArchivos("*.png","png");
				
				if(ra.archivo!=null) {
					imagen=ra.selectorArchivos.getSelectedFile();
					fe.lbNombreFoto.setText(ra.nombreArchivo);
				}
				
			}
		});
		
		fe.btGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(equipo==null) {
					guardar();
					cargarDatos();
					cargarTabla();
				}else {
					modificar();
				}
				
			}
		});
		
		fe.btEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int o = JOptionPane.showConfirmDialog(null, "Estás seguro que deseas eliminar", "Eliminar", JOptionPane.YES_NO_OPTION);
				
				if(o==0) {
					Equipo.delete(equipo.idequipo);
					cargarTabla();
					fe.dispose();
				}
				
			}
		});
		
	}
	
	public ControladorEquipo(Integer idequipo, PanelEquipo pe) {
		
		this(pe);
		
		this.equipo=Equipo.load(idequipo);
		
		cargarDatos();
		
		this.fe.btEliminar.setEnabled(true);
		
	}
	
	private void guardar() {
		
		String nombre = fe.tfNombre.getText();
		String direccion = fe.tfDireccion.getText();
		FileInputStream foto=null;
		
		if(this.imagen!=null) {
			try {
				foto = new FileInputStream(this.imagen);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			foto=null;
		}
		
		try {
			Equipo e = Equipo.crearEquipo(nombre, direccion, foto);
			this.equipo=e;
			fe.btEliminar.setEnabled(true);
			JOptionPane.showMessageDialog(null, "Creado con éxito","Success",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void cargarDatos() {
		
		fe.tfNombre.setText(this.equipo.nombre);
		fe.tfDireccion.setText(this.equipo.direccion);
		Image img = null;
		
		if(this.equipo.image!=null) {
			
			fe.lbFoto.setText(null);
			
			try {
				img = ImageIO.read(this.equipo.image);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			fe.lbFoto.setIcon(new ImageIcon(img));
			
		}
		
	}
	
	private void modificar() {
		
		this.equipo.nombre=this.fe.tfNombre.getText();
		this.equipo.direccion=this.fe.tfDireccion.getText();
		
		FileInputStream foto=null;
		
		try {
			
			if(this.imagen!=null) {
				
				foto = new FileInputStream(this.imagen);
				
				this.equipo.image=foto;
				
			}
			
			this.equipo.update();
			
			JOptionPane.showMessageDialog(null, "Actualizado con éxito", "Actualizado", JOptionPane.INFORMATION_MESSAGE);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void cargarTabla() {
		
		pe.tbEquipos.vaciar();
		
		for(Equipo e:Equipo.find(null)) {
			
			Object[] fila = {e.idequipo,e.nombre,e.direccion,e.image==null? "No hay imágen":"Sí, hay imágen"};
			
			pe.tbEquipos.modelo.addRow(fila);
			
		}
		
	}

}






















