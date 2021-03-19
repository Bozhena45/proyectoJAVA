package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Estadio;
import utils.OpenUrl;
import vista.FormularioEstadio;
import vista.PanelEstadio;

public class ControladorEstadio {
	
	public FormularioEstadio fe;
	public Estadio estadio;
	public PanelEstadio panel;
	
	public ControladorEstadio(PanelEstadio pe) {
		
		this.fe=new FormularioEstadio();
		this.estadio=null;
		this.panel=pe;
		
		fe.btGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(estadio==null) {guardar(); cargarTabla();}
				
			}
		});
		
		fe.btEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int o = JOptionPane.showConfirmDialog(null, "Estás seguro que deseas eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
				
				if(o==0) {
					Estadio.delete(estadio.idestadio);
					cargarTabla();
					fe.dispose();
				}
				
			}
		});
		
		fe.btnPruebaUrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String estadio = fe.tfDireccion.getText();
				String[] e = estadio.split(" ");
				String fin="";
				for(String x:e) {
					fin+=x+"+";
				}
				@SuppressWarnings("unused")
				OpenUrl ou = new OpenUrl("https://www.google.com/maps/place/"+fin);
			}
		});
		
	}
	
	public ControladorEstadio(Integer id, PanelEstadio pe) {
		
		this(pe);
		this.estadio=Estadio.load(id);
		this.fe.btEliminar.setEnabled(true);
		this.fe.btGuardar.setEnabled(false);
		cargarDatos(estadio);
		
	}
	
	private void guardar() {
		
		String nombre = this.fe.tfNombre.getText();
		String direccion = this.fe.tfDireccion.getText();
		
		try {
			Estadio e = Estadio.crearEstadio(nombre, direccion);
			this.estadio=e;
			this.fe.btEliminar.setEnabled(true);
			this.fe.btGuardar.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Creado con éxito", "Success", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	private void cargarDatos(Estadio e) {
		
		this.fe.tfNombre.setText(e.nombre);
		this.fe.tfDireccion.setText(e.direccion);
		
	}
	
	private void cargarTabla() {
		
		panel.tablaEstadios.vaciar();
		
		for(Estadio e:Estadio.find(null)) {
			
			Object[] fila = {e.idestadio,e.nombre,e.direccion};
			panel.tablaEstadios.modelo.addRow(fila);
			
		}
		
	}

}









