package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Boxeador;
import modelo.Equipo;
import utils.Fecha;
import vista.FormularioBoxeador;
import vista.PanelBoxeadores;

public class ControladorBoxeador {
	
	public Boxeador boxeador;
	public FormularioBoxeador fb;
	public PanelBoxeadores panel;
	
	public ControladorBoxeador(PanelBoxeadores pb) {
		
		this.panel=pb;
		this.boxeador=null;
		this.fb=new FormularioBoxeador();
		
		this.fb.btEliminar.setEnabled(false);
		
		cargarEquipos();
		
		fb.btGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(boxeador==null) {
					
					try {
						crear();
						JOptionPane.showMessageDialog(null, "Se ha creado con éxito", "Creación", JOptionPane.INFORMATION_MESSAGE);
						
						cargarTabla(panel);
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Error: "+e.getLocalizedMessage()+" - "+e.getLocalizedMessage());
					}
					
				}else {
					try {
						modificar();
						JOptionPane.showMessageDialog(null, "Se ha modificado con éxito", "Modificación", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Error: "+e.getLocalizedMessage()+" - "+e.getLocalizedMessage());
					}
				}

			}
		});
		
		fb.btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				clear();

			}
		});
		
		fb.btEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int o = JOptionPane.showConfirmDialog(null, "Estás seguro que deseas elminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
				
				if(o==0) {delete(); cargarTabla(pb);}
				

			}
		});
		
	}
	
	public ControladorBoxeador(Integer id, PanelBoxeadores pb) {
		
		this(pb);
		cargar(id);
		
	}
	
	private void cargar(int id) {
		
		Boxeador b = Boxeador.load(id);
		
		fb.tfId.setText(b.idboxeador+"");
		fb.tfNombre.setText(b.nombre);
		fb.tfApellidos.setText(b.apellidos);
		fb.fecha_nac.jspinner.setValue(b.f_nac.getFechaMysql());
		fb.tfDni.setText(b.dni);
		fb.cbEquipos.getModel().setSelectedItem(Equipo.load(b.idequipo));
		
		this.boxeador=Boxeador.load(id);
		
		this.fb.btEliminar.setEnabled(true);
		
	}
	
	private void cargarEquipos() {
		
		for(Equipo e : Equipo.find(null)) {
			
			fb.cbEquipos.addItem(e);
			
		}
		
	}
	
	private void modificar() {
		
		Equipo e = (Equipo) fb.cbEquipos.getSelectedItem();
		
		Fecha f = fb.fecha_nac.obtenerValor();
		
		this.boxeador.nombre=fb.tfNombre.getText();
		this.boxeador.apellidos=fb.tfApellidos.getText();
		this.boxeador.f_nac=f;
		this.boxeador.dni=fb.tfDni.getText();
		this.boxeador.idequipo= e.idequipo;
		
		this.boxeador.update();
		
	}
	
	private void clear() {
		
		fb.tfId.setText("");
		fb.tfNombre.setText("");
		fb.tfApellidos.setText("");
		fb.tfDni.setText("");
		
		this.boxeador=null;
		
	}
	
	private void delete() {
		
		this.boxeador.eliminar();
		
		clear();
		
		this.boxeador=null;
		
		fb.dispose();
		
	}
	
	private void crear() {
		
		Equipo e = (Equipo) fb.cbEquipos.getSelectedItem();
		
		Fecha f = fb.fecha_nac.obtenerValor();
		
		this.boxeador = Boxeador.crearBoxeador(fb.tfNombre.getText(), fb.tfApellidos.getText(),f, fb.tfDni.getText(), e.idequipo);
		
		this.fb.btEliminar.setEnabled(true);
		
		cargar(this.boxeador.idboxeador);
		
	}
	
	private void cargarTabla(PanelBoxeadores pb) {
		
		pb.tablaBox.vaciar();
		
		for(Boxeador b:Boxeador.find(null, pb.tfNombre.getText().isEmpty()? null:pb.tfNombre.getText(), pb.tfApellidos.getText().isEmpty()? null:pb.tfApellidos.getText(), pb.tfDni.getText().isEmpty()? null:pb.tfDni.getText())) {
			
			Object[] fila= {b.idboxeador,b.nombre,b.apellidos,b.dni,false};
			
			pb.tablaBox.modelo.addRow(fila);
			
		}
		
	}

}





































