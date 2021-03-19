package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Estadio;
import vista.PanelEstadio;

public class ControladorPanelEstadio {
	
	public PanelEstadio pe;
	
	public ControladorPanelEstadio() {
		
		pe = new PanelEstadio();
		
		rellenarEstadios();
		
		pe.btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(pe.panelBuscar.isVisible()) {
					
					if(!pe.tfNombre.getText().isEmpty()) {
						
						pe.tablaEstadios.vaciar();
						
						for(Estadio e:Estadio.find(pe.tfNombre.getText())) {
							
							Object[] fila = {e.idestadio,e.nombre,e.direccion};
							pe.tablaEstadios.modelo.addRow(fila);
							
						}
						
					}else {
						rellenarEstadios();
					}
					
					pe.panelBuscar.setVisible(false);
					
				}else {
					pe.panelBuscar.setVisible(true);
				}
				
			}
		});
		
		pe.btCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ControladorEstadio(pe);
			}
		});
		
		pe.tablaEstadios.tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2 && e.getButton()==1) {
					Integer id=(int) pe.tablaEstadios.getValueSelected(0);
					new ControladorEstadio(id,pe);
				}
			}
		});
		
	}
	
	private void rellenarEstadios() {
		
		pe.tablaEstadios.vaciar();
		
		for(Estadio e:Estadio.find(null)) {
			
			Object[] fila = {e.idestadio,e.nombre,e.direccion};
			pe.tablaEstadios.modelo.addRow(fila);
			
		}
		
	}

}
