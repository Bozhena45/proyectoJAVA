package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import utils.Conexion;
import utils.Fecha;

public class Boxeador {
	
	public Integer idboxeador;
	public String nombre;
	public String apellidos;
	public Fecha f_nac;
	public String dni;
	public Integer idequipo;
	
	private Boxeador(Integer id, String n, String a, Fecha f, String d, Integer ideq){
		
		this.idboxeador=id;
		this.nombre=n;
		this.apellidos=a;
		this.f_nac=f;
		this.dni=d;
		this.idequipo=ideq;
		
	}
	
	public static Boxeador crearBoxeador(String n, String a, Fecha f, String d, Integer ideq) {
		
		Conexion.open();
		
		PreparedStatement insert;
		ResultSet resultado;
		
		String strInsert="Insert into boxeadores (nombre, apellidos, f_nacimiento, dni, idequipo) values (?,?,?,?,?);";
		
		try {
			
			insert=Conexion.con.prepareStatement(strInsert,Statement.RETURN_GENERATED_KEYS);
			insert.setString(1, n);
			insert.setString(2, a);
			insert.setDate(3, f.getFechaMysql());
			insert.setString(4, d);
			insert.setInt(5, ideq);
			
			insert.executeUpdate();
			resultado=insert.getGeneratedKeys();
			
			if(resultado.next()) {
				Boxeador b = new Boxeador(resultado.getInt(1),n,a,f,d,ideq);
				insert.close();
				return b;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static Boxeador load(Integer id) {
		
		Conexion.open();
		
		PreparedStatement load;
		ResultSet resultado;
		
		String strLoad = "Select * from boxeadores where idboxeador=?;";
		
		try {
			
			load=Conexion.con.prepareStatement(strLoad);
			load.setInt(1, id);
			
			resultado=load.executeQuery();
			
			if(resultado.next()) {
				
				Boxeador b = new Boxeador(resultado.getInt(1),resultado.getString(2),resultado.getString(3),new Fecha(resultado.getDate(4)),resultado.getString(5),resultado.getInt(6));
				load.close();
				return b;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void eliminar(Integer id) {
		
		Conexion.open();
		
		PreparedStatement delete;
		
		String strDelete = "Delete from boxeadores where idboxeador=?;";
		
		try {
			
			delete=Conexion.con.prepareStatement(strDelete);
			delete.setInt(1, id);
			
			delete.executeUpdate();
			
			delete.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void eliminar() {
		eliminar(this.idboxeador);
	}
	
	public void update() {
		
		Conexion.open();
		
		PreparedStatement update;
		
		String strUpdate = "Update boxeadores set nombre=?, apellidos=?, f_nacimiento=?, dni=?, idequipo=? where idboxeador=?";
		
		try {
			
			update=Conexion.con.prepareStatement(strUpdate);
			update.setString(1, this.nombre);
			update.setString(2, this.apellidos);
			update.setDate(3, this.f_nac.getFechaMysql());
			update.setString(4, this.dni);
			update.setInt(5, this.idequipo);
			update.setInt(6, this.idboxeador);
			
			update.executeUpdate();
			
			update.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static LinkedList<Boxeador> find(Integer id, String nombre, String apellidos, String dni) {
		
		Conexion.open();
		
		LinkedList<Boxeador> lista = new LinkedList<>();
		
		PreparedStatement find;
		ResultSet resultado;
		int x = 1;
		
		String strFind="Select * from boxeadores where ";
		if(id!=null) strFind+=" idboxeador=? and ";
		if(nombre!=null) strFind+=" nombre like ? and ";
		if(apellidos!=null) strFind+=" apellidos like ? and ";
		if(dni!=null) strFind+=" dni like ? and";
		strFind+=" 1=1 ";
		
		try {
			
			find=Conexion.con.prepareStatement(strFind);
			if(id!=null) {find.setInt(x, id); x++;}
			if(nombre!=null) {find.setString(x, nombre+"%"); x++;}
			if(apellidos!=null) {find.setString(x, apellidos+"%"); x++;}
			if(dni!=null) {find.setString(x, dni+"%"); x++;}
			
			resultado=find.executeQuery();
			
			while(resultado.next()) {
				
				Boxeador b = new Boxeador(resultado.getInt(1),resultado.getString(2),resultado.getString(3),new Fecha(resultado.getDate(4)),resultado.getString(5),resultado.getInt(6));
				lista.add(b);
				
			}
			
			find.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public String toString() {
		return this.nombre+" "+this.apellidos;
	}

}




























