package paquetepeticion;

public class Municipio {
private String nombre;
private int id_muncipio;
public Municipio(String nombre, int id_muncipio) {
	super();
	this.nombre = nombre;
	this.id_muncipio = id_muncipio;
}
public String getNombre() {
	return nombre;
}
public int getId_muncipio() {
	return id_muncipio;
}

}
