package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import utils.Conexion;
import utils.Fecha;

public class Combate {
	
	public Integer idcombate;
	public Integer esquina_azul;
	public Integer esquina_roja;
	public Integer idestadio;
	public Integer idcategoria;
	public Integer idcampeonato;
	public Fecha hora;
	public Integer ganador;
	
	private Combate(Integer id, Integer azul, Integer rojo, Integer estadio, Integer cate, Integer camp, Fecha h, Integer g) {
		
		this.idcombate=id;
		this.esquina_azul=azul;
		this.esquina_roja=rojo;
		this.idestadio=estadio;
		this.idcategoria=cate;
		this.idcampeonato=camp;
		this.hora=h;
		this.ganador=g;
		
	}
	
	public static Combate crearCombate(Integer azul, Integer rojo, Integer estadio, Integer cate, Integer camp, Fecha h) {
		
		Conexion.open();
		
		PreparedStatement insert;
		ResultSet resultado;
		
		String strInsert = "Insert into combates (esquina_azul, esquina_roja, idestadio, idcategoria, idcampeonato, hora) values (?,?,?,?,?,?)";
		
		try {
			
			insert=Conexion.con.prepareStatement(strInsert,Statement.RETURN_GENERATED_KEYS);
			insert.setInt(1, azul);
			insert.setInt(2, rojo);
			insert.setInt(3, estadio);
			insert.setInt(4, cate);
			insert.setInt(5, camp);
			insert.setDate(6, h.getFechaMysql());
			
			insert.executeUpdate();
			resultado=insert.getGeneratedKeys();
			
			if(resultado.next()) {
				Combate c = new Combate(resultado.getInt(1), azul, rojo, estadio, cate, camp, h, null);
				insert.close();
				return c;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static Combate load(Integer id) {
		
		Conexion.open();
		
		PreparedStatement load;
		ResultSet resultado;
		
		String strLoad = "Select * from combates where idcombate=?";
		
		try {
			
			load=Conexion.con.prepareStatement(strLoad);
			load.setInt(1, id);
			
			resultado=load.executeQuery();
			
			if(resultado.next()) {
				
				Fecha f = new Fecha(resultado.getDate(7));
				Combate c = new Combate(resultado.getInt(1), resultado.getInt(2), resultado.getInt(3), resultado.getInt(4), resultado.getInt(5), resultado.getInt(6), f, resultado.getInt(8));
				load.close();
				return c;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void delete(Integer id) {
		
		Conexion.open();
		
		PreparedStatement delete;
		
		String strDelete = "Delete from combates where idcombate=?";
		
		try {
			
			delete=Conexion.con.prepareStatement(strDelete);
			delete.setInt(1, id);
			
			delete.executeUpdate();
			
			delete.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete() {
		
		delete(this.idcombate);
		
	}
	
	public void update() {
		
		Conexion.open();
		
		PreparedStatement update;
		
		String strUpdate = "Update combates set esquina_azul=?, esquina_roja=?, resultado=? where idcombate=?";
		
		try {
			
			update=Conexion.con.prepareStatement(strUpdate);
			update.setInt(1, this.esquina_azul);
			update.setInt(2, this.esquina_roja);
			update.setInt(3, this.ganador);
			update.setInt(4, this.idcombate);
			
			update.executeUpdate();
			
			update.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static LinkedList<Combate> find(Integer estadio, Integer categoria, Integer campeonato) {
		
		LinkedList<Combate> lista = new LinkedList<Combate>();
		
		Conexion.open();
		
		PreparedStatement find;
		ResultSet resultado;
		int x = 1;
		
		String strFind = "Select * from combates where ";
		if(estadio!=null) strFind+=" idestadio=? and ";
		if(categoria!=null) strFind+=" idcategoria=? and ";
		if(campeonato!=null) strFind+=" idcampeonato=? and";
		strFind+=" 1=1 ";
		
		try {
			
			find=Conexion.con.prepareStatement(strFind);
			if(estadio!=null) {find.setInt(x, estadio); x++;}
			if(categoria!=null) {find.setInt(x, categoria); x++;}
			if(campeonato!=null) {find.setInt(x, campeonato); x++;}
			
			resultado=find.executeQuery();
			
			while(resultado.next()) {
				
				Fecha f = new Fecha(resultado.getDate(7));
				Combate c = new Combate(resultado.getInt(1), resultado.getInt(2), resultado.getInt(3), resultado.getInt(4), resultado.getInt(5), resultado.getInt(6), f, resultado.getInt(8));
				lista.add(c);
				
			}
			
			find.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}

}





























