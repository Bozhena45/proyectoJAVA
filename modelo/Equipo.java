package modelo;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import utils.Conexion;

public class Equipo {
	
	public int idequipo;
	public String nombre;
	public String direccion;
	public InputStream image;
	
	private Equipo(int id, String n, String d, InputStream i) {
		this.idequipo=id;
		this.nombre=n;
		this.direccion=d;
		this.image=i;
	}
	
	public static Equipo crearEquipo(String n, String d, InputStream i) {
		
		Conexion.open();
		
		PreparedStatement insert;
		ResultSet resultado;
		
		String strInsert = "Insert into equipos (nombre, direccion, img) values (?,?,?);";
		
		try {
			
			insert=Conexion.con.prepareStatement(strInsert,Statement.RETURN_GENERATED_KEYS);
			insert.setString(1, n);
			insert.setString(2, d);
			if(i!=null)insert.setBinaryStream(3, i,(int) i.available());
			else insert.setNull(3, java.sql.Types.BLOB);
			
			insert.executeUpdate();
			
			resultado=insert.getGeneratedKeys();
			
			if(resultado.next()) {
				
				Equipo e = new Equipo(resultado.getInt(1),n,d,i);
				insert.close();
				return e;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static Equipo load(int id) {
		
		Conexion.open();
		
		PreparedStatement load;
		ResultSet resultado;
		
		String strLoad = "Select * from equipos where idequipo=?";
		
		try {
			
			load=Conexion.con.prepareStatement(strLoad);
			load.setInt(1, id);
			
			resultado=load.executeQuery();
			
			if(resultado.next()) {
				
				Equipo e = new Equipo(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getBinaryStream(4));
				load.close();
				return e;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void update() {
		
		Conexion.open();
		
		PreparedStatement update;
		
		String strUpdate="Update equipos set nombre=?, direccion=?, img=? where idequipo=?";
		
		try {
			
			update=Conexion.con.prepareStatement(strUpdate);
			update.setString(1, this.nombre);
			update.setString(2, this.direccion);
			update.setBinaryStream(3, this.image,(int) this.image.available());
			update.setInt(4, this.idequipo);
			
			update.executeUpdate();
			
			update.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void delete(Integer id) {
		
		Conexion.open();
		
		PreparedStatement delete;
		
		String strDelete = "Delete from equipos where idequipo=?";
		
		try {
			
			delete=Conexion.con.prepareStatement(strDelete);
			delete.setInt(1, id);
			
			delete.executeUpdate();
			
			delete.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static LinkedList<Equipo> find(String nom){
		
		Conexion.open();
		
		LinkedList<Equipo> lista = new LinkedList<Equipo>();
		
		PreparedStatement find;
		ResultSet resultado;
		int x = 1;
		
		String strFind = "Select * from equipos where ";
		if(nom!=null) strFind+=" nombre like ? and ";
		strFind+=" 1=1 ";
		
		try {
			
			find=Conexion.con.prepareStatement(strFind);
			if(nom!=null) {find.setString(x, nom+"%"); x++;}
			
			resultado=find.executeQuery();
			
			while(resultado.next()) {
				
				Equipo e = new Equipo(resultado.getInt(1), resultado.getString(2), resultado.getString(3),resultado.getBinaryStream(4));
				lista.add(e);
				
			}
			
			find.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public String toString() {
		return this.nombre;
	}

}






























