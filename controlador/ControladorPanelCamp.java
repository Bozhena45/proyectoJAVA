package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import modelo.Boxeador;
import modelo.Campeonato;
import modelo.Categoria;
import modelo.Combate;
import utils.RecogerArchivos;
import vista.PanelCampeonato;

public class ControladorPanelCamp {
	
	public PanelCampeonato pc;
	public Campeonato campeonato;
	
	public ControladorPanelCamp() {
		
		pc = new PanelCampeonato();
		this.campeonato=null;
		
		rellenarCampeonatos();
		
		pc.cbCameponatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pc.tablaCombates.vaciar();
				
				Campeonato c = (Campeonato) pc.cbCameponatos.getModel().getSelectedItem();
				
				for(Combate com:Combate.find(null, null, c.idcampeonato)) {
					
					Object[] fila = {com.idcombate, com.esquina_azul, Boxeador.load(com.esquina_azul).nombre, com.esquina_roja, Boxeador.load(com.esquina_roja).nombre, Categoria.load(com.idcategoria).categoria, com.ganador==0? "No hay resultado":Boxeador.load(com.ganador).nombre};
					pc.tablaCombates.modelo.addRow(fila);
					
				}
				
				campeonato=c;
				
			}
		});
		
		pc.tablaCombates.tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2 && e.getButton()==1) {
					Integer idCombate=(int) pc.tablaCombates.getValueSelected(0);
					Integer idAzul=(int) pc.tablaCombates.getValueSelected(1);
					Integer idRojo=(int) pc.tablaCombates.getValueSelected(3);
					new ControladorCombate(Boxeador.load(idAzul), Boxeador.load(idRojo), Combate.load(idCombate),pc);
				}
			}
		});
		
		pc.btnAadirCombate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ControladorCombate(pc);
				
			}
		});
		
		pc.btPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(campeonato!=null) {
					String ruta = RecogerArchivos.seleccionarDirectorio();
					
					if(ruta!=null) {
						String s = ruta.substring(0, 3);
						s+="\\";
						s+=ruta.substring(3,ruta.length());
						s+="\\";
						generarPdf(s,campeonato.nombre+".pdf");
					}
					
				}
				else JOptionPane.showMessageDialog(null, "Debes seleccionar un campeonato", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		
	}
	
	private void rellenarCampeonatos() {
		
		for(Campeonato c:Campeonato.find(null)) {
			pc.cbCameponatos.addItem(c);
		}
		
	}
	
	private void generarPdf(String dest, String nompdf) {
		
		PdfWriter writer;
		try {
			
			writer = new PdfWriter(dest+nompdf);
			PdfDocument pdf = new PdfDocument(writer);
			Document documento = new Document(pdf);
			
			String img = "E:\\workspace\\campeonatos_boxeo\\src\\resources\\logo.png";
					
			Image i = null;
			
			try {
				i = new Image(ImageDataFactory.create(img));
				documento.add(i);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
			Paragraph titulo = new Paragraph();
			titulo.add("Resumen "+this.campeonato.nombre);
			titulo.setFontSize(23);
			titulo.setBold();
			documento.add(titulo);
			
			documento.add(new Paragraph("Combates:").setFontSize(20));
			
			for (int y = 0; y < Categoria.find(null).size(); y++) {
				
				Table tablaCombate=null;
				
				if(Combate.find(null, y+1, this.campeonato.idcampeonato).size()!=0) {
					
					documento.add(new Paragraph(Categoria.load(y+1).categoria).setFontSize(18));
					
					tablaCombate = new Table(new float[] {10,10,10,10});
					
					for (int x = 0; x < 4; x++) {
						Cell celda = new Cell();
						celda.setWidth(250);
						if(x==0) celda.add(new Paragraph("Esquina Azul").setBold());
						if(x==1) celda.add(new Paragraph("Esquina Roja").setBold());
						if(x==2) celda.add(new Paragraph("Categoria").setBold());
						if(x==3) celda.add(new Paragraph("Ganador").setBold());
						tablaCombate.addCell(celda);
					}
					
					for(Combate c:Combate.find(null, y+1, this.campeonato.idcampeonato)) {
						
						Cell celda = new Cell();
						Cell celda2 = new Cell();
						Cell celda3 = new Cell();
						Cell celda4 = new Cell();
						celda.add(new Paragraph(Boxeador.load(c.esquina_azul).nombre));
						celda2.add(new Paragraph(Boxeador.load(c.esquina_roja).nombre));
						celda3.add(new Paragraph(Categoria.load(c.idcategoria).categoria));
						celda4.add(new Paragraph(c.ganador==0? "No hay resultado":Boxeador.load(c.ganador).nombre));
						tablaCombate.addCell(celda);
						tablaCombate.addCell(celda2);
						tablaCombate.addCell(celda3);
						tablaCombate.addCell(celda4);
						
					}
					
					documento.add(tablaCombate);
					documento.add(new Paragraph("\n"));
					
				}
				
			}
			
			
			
			documento.close();
			
			JOptionPane.showMessageDialog(null, "Exportado con éxito", "Success", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}



















