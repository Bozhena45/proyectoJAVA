package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {
	
	public static String bd;
	public static String login;
	public static String pass;
	public static String host;
	public static String url;
	
	public static Connection con = null; //Cable que conecta a la base de datos
	
	public static void open() {
		
		try {
			if ((con==null) || (con.isClosed())) {
				if(url==null) loadProperties();
				url="jdbc:mysql://"+host+"/"+bd+"?useSSL=false";
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url, login, pass);
			}
		} catch (Exception e) {
			System.out.println("No se puede conectar");
			e.printStackTrace();
		}
		
	}
	
	public static void close() {
		
		try {
			if(!con.isClosed()) {
				con.close();
			}
		} catch (Exception e) {
			
		}
		
	}
	
	public static void loadProperties() {
		
		Properties prop = new Properties();
		InputStream is = null;
		
		try {
			is=new FileInputStream("config.prop");
			prop.load(is);
			bd=prop.getProperty("bbdd");
			login=prop.getProperty("user");
			pass=prop.getProperty("pass");
			host=prop.getProperty("host");
			is.close();
		} catch (Exception e) {
			System.out.println("No se ha podido leer");
		}
		
	}

}
















