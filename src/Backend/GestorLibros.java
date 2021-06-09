package Backend;

import java.io.*;
import java.util.*;

import javax.swing.text.PlainDocument;

public class GestorLibros implements Gestor {

	private Vector<Libro> libros;
	private FileManager fileManager;

	public GestorLibros() {
		this.libros = new Vector<Libro>();
		this.fileManager = new FileManager();
	}

	public void iniciar() throws FileNotFoundException {
		libros = fileManager.leerArchivoLibros(Constantes.PATH_BASE_DATOS_LIBROS);
	}

	public void finalizar() throws FileNotFoundException {
		fileManager.escribirArchivoLibros(Constantes.PATH_BASE_DATOS_LIBROS, libros);
	} 
	
	public boolean existeLibro(String isbn) {
		return !libros.isEmpty() && libros.contains(new Libro(isbn)); 
	}

	public boolean altaLibro(String isbn, String titulo, String autor, String editorial, int edicion,
			int anioPublicacion) {

		// Verificamos que no exista el libro
		if (existeLibro(isbn)) {
			return false;
		}

		this.libros.add(new Libro(isbn, titulo, autor, editorial, edicion, anioPublicacion));
		return true;
	}

	public Libro consultarLibro(String isbn) {
		if (!existeLibro(isbn)) {
			return null;
		}
		return this.libros.get(this.libros.indexOf(new Libro(isbn)));

	}


	public boolean actualizarLibro(String isbn, String titulo, String autor, String editorial, int edicion,
			int anioPublicacion) {

		// Verificamos la existencia
		if (!existeLibro(isbn)) {
			return false;
		}

		Libro libro = libros.get(libros.indexOf(new Libro(isbn)));

		// Como existe el libro volcamos los datos en un nuevo objeto
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setEditorial(editorial);
		libro.setEdicion(edicion);
		libro.setAnioPublicacion(anioPublicacion);

		return true;
	}

	public void eliminarLibro(String isbn) {
		this.libros.remove(new Libro(isbn));
	}

	public void ordenarLibros() {

		// Verificamos si esta vacio el vector
		if (this.libros.isEmpty()) {
			return;
		} else {
			Collections.sort(this.libros);
		}
	}

	public Vector<Libro> listarLibros() {
		return this.libros;
	}
}