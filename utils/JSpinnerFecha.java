package utils;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class JSpinnerFecha {
	
	public JSpinner jspinner;
	public Fecha fecha;
	
	public JSpinnerFecha(Fecha f) {
		
		this.jspinner=new JSpinner();
		this.jspinner.setModel(new SpinnerDateModel(f.getTime(),null,null,Calendar.DAY_OF_YEAR));
		this.jspinner.setEditor(new JSpinner.DateEditor(this.jspinner,"dd/MM/yyyy"));
		
	}
	
	public Fecha obtenerValor() {
		
		Fecha f = new Fecha();
		f.setTime((Date) this.jspinner.getValue());
		return f;
		
	}

}
