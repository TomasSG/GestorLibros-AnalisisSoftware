package Backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class FileManager {

	public Vector<Libro> leerArchivo(String path) throws FileNotFoundException {

		// Variables que vamos a usar
		Vector<Libro> libros = new Vector<Libro>();
		Scanner entrada = new Scanner(new FileReader(path));
		String[] campos = null;
		
		while (entrada.hasNextLine()) {
			campos = entrada.nextLine().split("\t");
			
			// De la linea obtenemos los valores que buscamos
			String isbn = campos[0];
			String titulo = campos[1];
			String autor = campos[2];
			String editorial = campos[3];
			int edicion = Integer.parseInt(campos[4]);
			int anioPublicacion = Integer.parseInt(campos[5]);
			
			// Creamos el objeto libro y lo añadimos al vector
			Libro libro = new Libro(isbn, titulo, autor, editorial, edicion, anioPublicacion);
			libros.add(libro);
		}
		
		// Cerrar el scanner
		entrada.close();

		return libros;
	}
	
	public void escribirArchivo(String path) {
		
	}

}
