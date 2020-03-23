package paquetepeticion;

import java.io.FileWriter;
import java.io.IOException;

public class AccesoFichero {

	public static void grabarHML(String html) {
		// TODO Auto-generated method stub
		FileWriter fw;
		try {
			fw = new FileWriter("D:\\tabla_clima.html");
			fw.write(html);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
