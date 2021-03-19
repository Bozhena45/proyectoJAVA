package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import utils.Conexion;

public class Estadio {
	
	public int idestadio;
	public String nombre;
	public String direccion;
	
	private Estadio(int id, String n, String d) {
		this.idestadio=id;
		this.nombre=n;
		this.direccion=d;
	}
	
	public static Estadio crearEstadio(String n, String d) {
		
		Conexion.open();
		
		PreparedStatement insert;
		ResultSet resultado;
		
		String strInsert = "Insert into estadios (nombre, direccion) values (?,?);";
		
		try {
			
			insert=Conexion.con.prepareStatement(strInsert,Statement.RETURN_GENERATED_KEYS);
			insert.setString(1, n);
			insert.setString(2, d);
			
			insert.executeUpdate();
			
			resultado=insert.getGeneratedKeys();
			
			if(resultado.next()) {
				
				Estadio e = new Estadio(resultado.getInt(1),n,d);
				insert.close();
				return e;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static Estadio load(Integer id) {
		
		Conexion.open();
		
		PreparedStatement load;
		ResultSet resultado;
		
		String strLoad = "Select * from estadios where idestadio=? ";
		
		try {
			
			load=Conexion.con.prepareStatement(strLoad);
			load.setInt(1, id);
			
			resultado=load.executeQuery();
			
			if(resultado.next()) {
				return new Estadio(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
			}
			
			load.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void delete(Integer id) {
		
		Conexion.open();
		
		PreparedStatement delete;
		
		String strDelete="Delete from estadios where idestadio=?";
		
		try {
			
			delete=Conexion.con.prepareStatement(strDelete);
			delete.setInt(1, id);
			
			delete.executeUpdate();
			
			delete.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static LinkedList<Estadio> find(String nom){
		
		LinkedList<Estadio> lista = new LinkedList<>();
		
		Conexion.open();
		
		PreparedStatement find;
		ResultSet resultado;
		int x = 1;
		
		String strFind = "Select * from estadios where ";
		if(nom!=null) strFind+=" nombre like ? and ";
		strFind+=" 1=1 ";
		
		try {
			
			find=Conexion.con.prepareStatement(strFind);
			if(nom!=null) { find.setString(x, nom+"%"); x++;}
			
			resultado=find.executeQuery();
			
			while(resultado.next()) {
				
				Estadio e = new Estadio(resultado.getInt(1), resultado.getString(2), resultado.getString(3));
				lista.add(e);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public String toString() {
		return this.nombre;
	}

}





















