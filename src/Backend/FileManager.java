package Backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;

public class FileManager {

	public Vector<Libro> leerArchivoLibros(String path) throws FileNotFoundException {

		// Variables que vamos a usar
		Vector<Libro> libros = new Vector<Libro>();
		Scanner entrada = new Scanner(new FileReader(path));
		String[] campos = null;
		
		while (entrada.hasNextLine()) {
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
	
	public void escribirArchivoLibros(String path, Vector<Libro> libros) throws FileNotFoundException {
		PrintStream salida = new PrintStream(path);
		
		for(Libro libro : libros) {
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
		Scanner entrada = new Scanner(new FileReader(path));
		String[] campos = null;
		
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
	
	public void escribirArchivoUsuarios(String path, Vector<Usuario> usuarios) throws FileNotFoundException {
		PrintStream salida = new PrintStream(path);
		
		for(Usuario usuario : usuarios) {
			escribirRegistroUsuario(usuario, salida);
		}
		
		salida.close();
	}

	private void escribirRegistroUsuario(Usuario usuario, PrintStream salida) {
		salida.print(usuario.getNombre() + Constantes.PUNTO_COMA);
        salida.print(usuario.getContraseniaHash() + Constantes.PUNTO_COMA);
        salida.print(usuario.getSalt() + Constantes.NUEVA_LINEA);
	}

}
