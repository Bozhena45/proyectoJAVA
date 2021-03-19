package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import utils.Conexion;

public class Categoria {
	
	public int idcategoria;
	public String categoria;
	
	private Categoria(int id, String c) {
		this.idcategoria=id;
		this.categoria=c;
	}
	
	public static Categoria crearCategoria(String c) {
		
		Conexion.open();
		
		PreparedStatement insert;
		ResultSet resultado;
		
		String strInsert = "Insert into categorias (categoria) values (?);";
		
		try {
			
			insert=Conexion.con.prepareStatement(strInsert, Statement.RETURN_GENERATED_KEYS);
			insert.setString(1, c);
			
			insert.executeUpdate();
			
			resultado=insert.getGeneratedKeys();
			
			if(resultado.next()) {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static Categoria load(Integer id) {
		
		Conexion.open();
		
		PreparedStatement load;
		ResultSet resultado;
		
		String strLoad = "Select * from categorias where idcategoria=? ";
		
		try {
			
			load=Conexion.con.prepareStatement(strLoad);
			load.setInt(1, id);
			
			resultado=load.executeQuery();
			
			if(resultado.next()) {
				
				return new Categoria(resultado.getInt(1), resultado.getString(2));
				
			}
			
			load.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static LinkedList<Categoria> find(String nom){
		
		LinkedList<Categoria> lista = new LinkedList<Categoria>();
		
		Conexion.open();
		
		PreparedStatement find;
		ResultSet resultado;
		int x = 1;
		
		String strFind="Select * from categorias where ";
		if(nom!=null) strFind+=" categoria like ? and ";
		strFind+=" 1=1 ";
		
		try {
			
			find=Conexion.con.prepareStatement(strFind);
			if(nom!=null) {find.setString(x, nom+"%"); x++;}
			
			resultado=find.executeQuery();
			
			while(resultado.next()) {
				
				Categoria c = new Categoria(resultado.getInt(1), resultado.getString(2));
				lista.add(c);
				
			}
			
			find.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public String toString() {
		return this.categoria;
	}

}





































