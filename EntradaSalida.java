package paquetepeticion;

import java.util.ArrayList;
import java.util.Scanner;

public class EntradaSalida {



	public static String pedirProvincia(ArrayList<Provincia> lista_provincias) {
		for (Provincia provincia : lista_provincias) {
			String texto=provincia.getId_provincia()+".-"+provincia.getNombre();
			System.out.println(texto);
		}
		Scanner sc=new Scanner(System.in);
		String opcion=sc.nextLine();
		return opcion;
	}

	public static String pedirMunicipio(ArrayList<Municipio> lista_municipios) {
		System.out.println("********************ELIJA MUNICIPIO************************");
		for (Municipio municipio : lista_municipios) {
			String texto=municipio.getId_muncipio()+".-"+municipio.getNombre();
			System.out.println(texto);
		}
		Scanner sc=new Scanner(System.in);
		String opcion=sc.nextLine();
		return opcion;
	}

}
