package paquetepeticion;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Provincia> lista_provincias=AccesoBD.recuperarProvincias();//Provincia con id y nombre
		
		String id_provincia=EntradaSalida.pedirProvincia(lista_provincias);
		ArrayList<Municipio> lista_municipios=AccesoBD.recuperarMunicipiosPorProvincia(id_provincia);//SELECT...WHERE
		String id_municipio=EntradaSalida.pedirMunicipio(lista_municipios);
		
		//Necesito que provincia tenga 2 dígitos
		if(id_provincia.length()<2) {id_provincia="0"+id_provincia;}
		//Necesito que el municipio tenga 3 dígitos*/
		while(id_municipio.length()<3)
		{
			id_municipio="0"+id_municipio;
		}
		String codigo=id_provincia+id_municipio;
		
		SAXBuilder builder=new SAXBuilder();
		// TODO Auto-generated method stub
		String texto=PeticionWeb.hacerPeticion("http://www.aemet.es/xml/municipios/localidad_"+codigo+".xml");
		//abcdef
		//ab->Codigo provincia
		//cde->Codigo municipio
		InputStream stream;
		try {
			stream = new ByteArrayInputStream(texto.getBytes("UTF-8"));
			Document documento=builder.build(stream);
			ArrayList<Clima> lista_climas=ParseoXML.parsear(documento);
			String html=PintaHTML.crearPagina(lista_climas);
			AccesoFichero.grabarHML(html);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
