package paquetepeticion;

public class Provincia {
private String nombre;
private int id_provincia;
public Provincia(String nombre, int id_provincia) {
	super();
	this.nombre = nombre;
	this.id_provincia = id_provincia;
}
public String getNombre() {
	return nombre;
}
public int getId_provincia() {
	return id_provincia;
}

}
