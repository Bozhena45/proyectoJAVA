package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import modelo.Boxeador;
import modelo.Campeonato;
import modelo.Categoria;
import modelo.Combate;
import modelo.Equipo;
import modelo.Estadio;
import utils.Fecha;
import vista.FormularioCombate;
import vista.FormularioNuevoCombate;
import vista.PanelCampeonato;

public class ControladorCombate {
	
	public FormularioCombate fc;
	public Boxeador esquinaAzul;
	public Boxeador esquinaRoja;
	public Combate combate;
	public PanelCampeonato panel;
	
	public ControladorCombate(PanelCampeonato pc) {
		
		fc=new FormularioCombate();
		this.esquinaAzul=null;
		this.esquinaRoja=null;
		this.panel=pc;
		
		rellenarEstadios();
		rellenarCategorias();
		rellenarCampeonatos();
		
		fc.btElegirBoxeador.setVisible(true);
		fc.btEliminar.setEnabled(false);
		
		fc.btElegirBoxeador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FormularioNuevoCombate fnc = new FormularioNuevoCombate();
				
				fnc.panel.tablaBox.tabla.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int r = fnc.panel.tablaBox.getRealSelectedRow();
						Boolean x =(Boolean) fnc.panel.tablaBox.getValueAt(r, 4);
						if(!x) {
							fnc.panel.tablaBox.tabla.setValueAt(true, r, 4);
						}else {
							fnc.panel.tablaBox.tabla.setValueAt(false, r, 4);
						}
					}
				});
				
				//Elegir los boxeadores del combate
				fnc.panel.btElegir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						int numBox = 0;
						LinkedList<Boxeador> lista = new LinkedList<Boxeador>();
						
						for (int i = 0; i < fnc.panel.tablaBox.tabla.getRowCount(); i++) {
							
							Boolean b = (Boolean) fnc.panel.tablaBox.tabla.getValueAt(i, 4);
							
							if(b) {
								numBox++;
							}
							
						}
						
						if(numBox==2) {
							
							for (int x = 0; x < fnc.panel.tablaBox.tabla.getRowCount(); x++) {
								
								Boolean b = (Boolean) fnc.panel.tablaBox.tabla.getValueAt(x, 4);
								
								if(b) {
									Integer idBoxeador = (Integer) fnc.panel.tablaBox.tabla.getValueAt(x, 0);
									lista.add(Boxeador.load(idBoxeador));
								}
								
							}
							
							esquinaAzul=lista.get(0);
							esquinaRoja=lista.get(1);
							rellenarDatosBoxeadores(esquinaAzul, esquinaRoja);
							fc.cbGanador.addItem(esquinaAzul);
							fc.cbGanador.addItem(esquinaRoja);
							fnc.dispose();
							
						}else {
							JOptionPane.showMessageDialog(null, "No has elegido 2 Boxeadores", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				});
				
			}
		});
		
		fc.btGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
				cargarTabla();
			}
		});
		
	}
	
	public ControladorCombate(Boxeador esAz, Boxeador esRo, Combate com, PanelCampeonato pc) {
		
		fc=new FormularioCombate();
		this.esquinaAzul=esAz;
		this.esquinaRoja=esRo;
		this.combate=com;
		this.panel=pc;
		
		rellenarEstadios();
		rellenarDatosBoxeadores(esAz, esRo);
		rellenarInformacionCombate(com.idcombate);
		rellenarCategorias();
		rellenarCampeonatos();
		
		Ganador();
		
		fc.btGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar();
				cargarTabla();
			}
		});
		
		fc.btEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int o = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
				
				if(o==0) {
					combate.delete();
					JOptionPane.showMessageDialog(null, "Eliminado con éxito", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
					cargarTabla();
					fc.dispose();
				}
				
			}
		});
		
	}
	
	private void rellenarDatosBoxeadores(Boxeador esAz, Boxeador esRo) {
		
		fc.tfNombreAzul.setText(esAz.nombre);
		fc.tfApellidoAzul.setText(esAz.apellidos);
		fc.tfEquipoAzul.setText(Equipo.load(esAz.idequipo).nombre);
		
		fc.tfNombreRojo.setText(esRo.nombre);
		fc.tfApellidoRojo.setText(esRo.apellidos);
		fc.tfEquipoRojo.setText(Equipo.load(esRo.idequipo).nombre);
		
	}
	
	private void rellenarInformacionCombate(Integer idcombate) {
		
		Combate c = Combate.load(idcombate);
		Estadio  e = Estadio.load(c.idestadio);
		Categoria cat = Categoria.load(c.idcategoria);
		
		fc.cbCategoria.getModel().setSelectedItem(cat);
		Fecha f=c.hora;
		fc.spinnerFecha.setValue(f.getFechaMysql());
		fc.cbEstadios.getModel().setSelectedItem(e);
		
	}
	
	private void Ganador() {
		
		fc.cbGanador.addItem(this.esquinaAzul);
		fc.cbGanador.addItem(this.esquinaRoja);
		
		if(this.combate.ganador!=0) {
			
			Boxeador b = Boxeador.load(this.combate.ganador);
			
			fc.cbGanador.getModel().setSelectedItem(b);
			
		}
		
	}
	
	private void actualizar() {
		
		Boxeador b = (Boxeador) fc.cbGanador.getModel().getSelectedItem();
		
		this.combate.ganador=b.idboxeador;
		
		this.combate.update();
		
		JOptionPane.showMessageDialog(null, "Actualizdo con éxito", "Actualización", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	private void rellenarEstadios() {
		
		for(Estadio e:Estadio.find(null)) {
			
			this.fc.cbEstadios.addItem(e);
			
		}
		
	}
	
	private void rellenarCategorias() {
		
		for(Categoria c:Categoria.find(null)) {
			this.fc.cbCategoria.addItem(c);
		}
		
	}
	
	private void rellenarCampeonatos() {
		
		for(Campeonato c:Campeonato.find(null)) {
			this.fc.cbCampeonato.addItem(c);
		}
		
	}
	
	private void guardar() {
		
		try {
			
			Estadio e = (Estadio) fc.cbEstadios.getModel().getSelectedItem();
			Categoria c = (Categoria) fc.cbCategoria.getModel().getSelectedItem();
			Campeonato ca = (Campeonato) fc.cbCampeonato.getModel().getSelectedItem();
			Fecha f = new Fecha();
			f.setTime((Date) fc.spinnerFecha.getValue());
			
			Combate.crearCombate(this.esquinaAzul.idboxeador, this.esquinaRoja.idboxeador, e.idestadio, c.idcategoria, ca.idcampeonato, f);
			
			JOptionPane.showMessageDialog(null, "Guardado con éxito", "Guardar", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Faltan datos por rellenar", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	private void cargarTabla() {
		
		panel.tablaCombates.vaciar();
		
		Campeonato c = (Campeonato) panel.cbCameponatos.getModel().getSelectedItem();
		
		for(Combate com:Combate.find(null, null, c.idcampeonato)) {
			
			Object[] fila = {com.idcombate, com.esquina_azul, Boxeador.load(com.esquina_azul).nombre, com.esquina_roja, Boxeador.load(com.esquina_roja).nombre, Categoria.load(com.idcategoria).categoria, com.ganador==0? "No hay resultado":Boxeador.load(com.ganador).nombre};
			panel.tablaCombates.modelo.addRow(fila);
			
		}
		
	}

}




















