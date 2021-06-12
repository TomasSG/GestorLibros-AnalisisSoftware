package Backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class FileManager {

	public Vector<Libro> leerArchivoLibros(String path) throws FileNotFoundException {

		// Variables que vamos a usar
		Vector<Libro> libros = new Vector<Libro>();
		String[] campos = null;
		Scanner entrada;

		// Verificamos que exista el archivo
		File file = new File(path);

		// Si no existe simplemente retornamos la lista vacia
		if (!file.exists()) {
			return libros;
		}

		// Creamos el scanner para leer el archivo
		entrada = new Scanner(new FileReader(path));
		while (entrada.hasNextLine()) {

			// Leemos la linea y separamos por el delimitador
			campos = entrada.nextLine().split(Constantes.TABULACION);

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

	public void escribirArchivoLibros(String path, Vector<Libro> libros) throws IOException {

		PrintStream salida;

		// Verificamos que el archivo exista
		File file = new File(path);

		// Si no existe lo creamos para poder trabajar con el
		if (!file.exists()) {
			file.createNewFile();
		}

		// Lo abrimos y escribimos lo que queremos
		salida = new PrintStream(path);
		for (Libro libro : libros) {
			escribirRegistroLibro(libro, salida);
		}

		salida.close();
	}

	private void escribirRegistroLibro(Libro libro, PrintStream salida) {
		salida.print(libro.getIsbn() + Constantes.TABULACION);
		salida.print(libro.getTitulo() + Constantes.TABULACION);
		salida.print(libro.getAutor() + Constantes.TABULACION);
		salida.print(libro.getEditorial() + Constantes.TABULACION);
		salida.print(libro.getEdicion() + Constantes.TABULACION);
		salida.print(libro.getAnioPublicacion() + Constantes.NUEVA_LINEA);
	}

	public Vector<Usuario> leerArchivoUsuarios(String path) throws FileNotFoundException {

		// Variables que vamos a usar
		Vector<Usuario> usuarios = new Vector<Usuario>();
		String[] campos = null;
		Scanner entrada;

		// Verificamos que exista el archivo
		File file = new File(path);

		// Si no existe simplemente retornamos la lista vacia
		if (!file.exists()) {
			return usuarios;
		}

		entrada = new Scanner(new FileReader(path));
		while (entrada.hasNextLine()) {
			campos = entrada.nextLine().split(Constantes.PUNTO_COMA);

			// De la linea obtenemos los valores que buscamos
			String nombre = campos[0];
			String contraseniaHash = campos[1];
			String salt = campos[2];

			// Creamos el objeto Usuario y lo añadimos al vector
			Usuario usuario = new Usuario(nombre, contraseniaHash, salt);
			usuarios.add(usuario);
		}

		// Cerrar el scanner
		entrada.close();

		return usuarios;
	}

	public void escribirArchivoUsuarios(String path, Vector<Usuario> usuarios) throws IOException {
		PrintStream salida;

		// Verificamos que el archivo exista
		File file = new File(path);

		// Si no existe lo creamos para poder trabajar con el
		if (!file.exists()) {
			file.createNewFile();
		}
		salida = new PrintStream(path);
		for (Usuario usuario : usuarios) {
			escribirRegistroUsuario(usuario, salida);
		}

		salida.close();
	}

	private void escribirRegistroUsuario(Usuario usuario, PrintStream salida) {
		salida.print(usuario.getNombre() + Constantes.PUNTO_COMA);
		salida.print(usuario.getContraseniaHash() + Constantes.PUNTO_COMA);
		salida.print(usuario.getSalt() + Constantes.NUEVA_LINEA);
	}

	public ArrayList<String> leerArchivoAyuda(String path) {

		// Variables que vamos a usar
		ArrayList<String> ayuda = new ArrayList<String>();
		Scanner entrada;
		try {
			entrada = new Scanner(new FileReader(path));

			while (entrada.hasNextLine()) {
				ayuda.add(entrada.nextLine());
			}

			// Cerrar el scanner
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ayuda;
	}

	public void anadirRegistroLog(String path, String linea) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date ahora = new Date();
		try {
			FileWriter fw = new FileWriter(path, true);
			fw.write("[" + format.format(ahora) + "] " + linea + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
