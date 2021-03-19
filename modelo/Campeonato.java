package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import utils.Conexion;

public class Campeonato {

	public int idcampeonato;
	public String nombre;
	
	private Campeonato(int id, String n) {
		this.idcampeonato=id;
		this.nombre=n;
	}
	
	public static Campeonato crearCampeonato(String n) {
		
		Conexion.open();
		
		PreparedStatement insert;
		ResultSet resultado;
		
		String strInsert = "Insert into campeonatos (nombre) values (?);";
		
		try {
			
			insert=Conexion.con.prepareStatement(strInsert,Statement.RETURN_GENERATED_KEYS);
			insert.setString(1, n);
			
			insert.executeUpdate();
			
			resultado=insert.getGeneratedKeys();
			
			if(resultado.next()) {
				
				Campeonato c = new Campeonato(resultado.getInt(1),n);
				insert.close();
				return c;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static LinkedList<Campeonato> find(String nom){
		
		LinkedList<Campeonato> lista = new LinkedList<Campeonato>();
		
		Conexion.open();
		
		PreparedStatement find;
		ResultSet resultado;
		int x = 1;
		
		String strFind = "Select * from campeonatos where ";
		if(nom!=null) strFind+=" nombre like ? and ";
		strFind+=" 1=1 ";
		
		try {
			
			find=Conexion.con.prepareStatement(strFind);
			if(nom!=null) {find.setString(x, nom+"%"); x++;}
			
			resultado=find.executeQuery();
			
			while(resultado.next()) {
				
				Campeonato c = new Campeonato(resultado.getInt(1), resultado.getString(2));
				lista.add(c);
				
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























