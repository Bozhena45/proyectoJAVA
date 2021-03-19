package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import modelo.Equipo;
import vista.PanelEquipo;

public class ControladorPanelEquipo {
	
	public PanelEquipo pe;
	
	public ControladorPanelEquipo() {
		
		pe = new PanelEquipo();
		
		rellenarEquipos();
		
		pe.tbEquipos.tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2 && e.getButton()==1) {
					Integer id=(int) pe.tbEquipos.getValueSelected(0);
					new ControladorEquipo(id,pe);
				}
			}
		});
		
		pe.btCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ControladorEquipo(pe);
			}
		});
		
		pe.btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nom = JOptionPane.showInputDialog(null, "Nombre Equipo: ", "Buscar", JOptionPane.QUESTION_MESSAGE);
				
				if(nom!=null) {
					
					pe.tbEquipos.vaciar();
					
					for(Equipo e:Equipo.find(nom)) {
						
						Object[] fila = {e.idequipo,e.nombre,e.direccion,e.image==null? "No hay imágen":"Sí, hay imágen"};
						
						pe.tbEquipos.modelo.addRow(fila);
						
					}
					
				}
				
			}
		});
		
	}
	
	private void rellenarEquipos() {
		
		pe.tbEquipos.vaciar();
		
		for(Equipo e:Equipo.find(null)) {
			
			Object[] fila = {e.idequipo,e.nombre,e.direccion,e.image==null? "No hay imágen":"Sí, hay imágen"};
			
			pe.tbEquipos.modelo.addRow(fila);
			
		}
		
	}

}
