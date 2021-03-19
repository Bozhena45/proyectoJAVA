package utils;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha extends GregorianCalendar {
	
	
	private static final long serialVersionUID = 1L;
	
	
	public Fecha (java.sql.Date f) {
		super();
		this.setTime(f);
	}
	public Fecha (java.sql.Timestamp f) {
		super();
		this.setTime(f);
	}
	
	public Fecha(String s) {
		super();
		this.set(Calendar.HOUR,0);
		this.set(Calendar.MINUTE,0);
		this.set(Calendar.SECOND,0);
		this.set(Calendar.MILLISECOND,0);
		try {
			String[] partes=s.split(" ");
			String[] f=partes[0].split("/");
			
			int dia,mes,ano, hora, minutos, segundos;
		
			dia=Integer.parseInt(f[2]);
			mes=Integer.parseInt(f[1]);
			ano=Integer.parseInt(f[0]);
			this.set(Calendar.DAY_OF_MONTH,dia);
			this.set(Calendar.MONTH,mes-1);
			this.set(Calendar.YEAR,ano);
			 if (partes.length>1) {
				 f=partes[1].split(":");
				 hora=Integer.parseInt(f[0]);
				 minutos=Integer.parseInt(f[1]);
				 this.set(Calendar.HOUR,hora);
				 this.set(Calendar.MINUTE,minutos);
				 if (f.length>2) {
					 segundos=Integer.parseInt(f[2]);
					 this.set(Calendar.SECOND,segundos);
				 } 				 
			 } 
		} catch (Exception e) {
			throw new FechaMalFormada("No se reconoce la fecha: "+s);
		}
		
	}

	public Fecha() {
		super();
	}
	
	public java.sql.Date getFechaMysql(){
		return new java.sql.Date(this.getTimeInMillis());
	}
	
	public Fecha(int d, int m, int y) {
		super(y, m-1, d);
	}
	
	public Fecha(int d, int m, int y, int h, int mi) {
		super(y, m-1, d, h, mi);
	}
	
	public Fecha(int d, int m, int y, int h, int mi, int s) {
		super(y, m-1, d, h, mi, s);
	}
	
	public String getFecha() {
		return String.format("%02d",this.get(Calendar.DAY_OF_MONTH))+"/"+String.format("%02d",(this.get(Calendar.MONTH)+1))+"/"+this.get(Calendar.YEAR);
	}
	
	public String getFechaHora() {
		return this.getFecha()+" "+String.format("%02d",this.get(Calendar.HOUR_OF_DAY))+":"+String.format("%02d",this.get(Calendar.MINUTE));
	}
	
	public String getFechaHoraSegundos() {
		return this.getFechaHora()+":"+String.format("%02d",this.get(Calendar.SECOND));
	}
}

class FechaMalFormada extends RuntimeException {

	private static final long serialVersionUID = -8015042356472343989L;

	public FechaMalFormada(String m) {
		super(m);
		
	}

}

