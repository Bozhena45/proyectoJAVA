package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelo.Boxeador;
import vista.PanelBoxeadores;

public class ControladorPanelBoxeadores {
	
	PanelBoxeadores pb;
	
	public ControladorPanelBoxeadores() {
		
		pb=new PanelBoxeadores();
		
		pb.tablaBox.tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2 && e.getButton()==1) {
					Integer id=(int) pb.tablaBox.getValueSelected(0);
					new ControladorBoxeador(id,pb);
				}
			}
		});
		
		pb.btCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ControladorBoxeador(pb);
			}
		});
		
		pb.btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pb.panelBuscar.setVisible(true);
			}
		});
		
		pb.btSerach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pb.tablaBox.vaciar();
				
				for(Boxeador b:Boxeador.find(null, pb.tfNombre.getText().isEmpty()? null:pb.tfNombre.getText(), pb.tfApellidos.getText().isEmpty()? null:pb.tfApellidos.getText(), pb.tfDni.getText().isEmpty()? null:pb.tfDni.getText())) {
					
					Object[] fila= {b.idboxeador,b.nombre,b.apellidos,b.dni,false};
					
					pb.tablaBox.modelo.addRow(fila);
					
				}
				
				pb.panelBuscar.setVisible(false);
				
			}
		});
		
	}
	
}