package paquetepeticion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccesoBD {
static Connection conexion=null;
static Statement stmt=null;
static String ruta_conexion="jdbc:mysql://localhost:3306/bd_provincias?serverTimezone=UTC";
	private static void conectar()
	{
		try {
			conexion=DriverManager.getConnection(ruta_conexion, "root","");
			stmt=conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static ArrayList<Provincia> recuperarProvincias() {
		ArrayList<Provincia> lista_provincias=new ArrayList<>();
		//-Conectar
		conectar();
		String sql="SELECT * FROM provincias ORDER BY provincia ASC";
		try {
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String nombre_provincia=rs.getString("provincia");
				int id_provincia=rs.getInt("id_provincia");
				Provincia p=new Provincia(nombre_provincia, id_provincia);
				lista_provincias.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Lanzar select * from t_provincias
		//Rerllenar arraylist y devolverlo
		return lista_provincias;
	}
	public static ArrayList<Municipio> recuperarMunicipiosPorProvincia(String id_provincia) {
		ArrayList<Municipio> municipios=new ArrayList<>();
		String sql="SELECT * FROM municipios WHERE id_provincia="+id_provincia;
		try {
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String nombre=rs.getString("nombre");
				int id_municipio=rs.getInt("cod_municipio");
				Municipio m=new Municipio(nombre, id_municipio);
				municipios.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return municipios;
	}

}
