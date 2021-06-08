package Backend;

import java.io.*;
import java.util.*;

import javax.swing.text.PlainDocument;

public class GestorLibros {

	private Vector<Libro> libros;
	private FileManager fileManager;

	public GestorLibros() {
		this.libros = new Vector<Libro>();
		this.fileManager = new FileManager();
	}

	/*
	 * Carga los registros a memoria.
	 */

	public void iniciar() throws FileNotFoundException {
		libros = fileManager.leerArchivoLibros(Constantes.PATH_BASE_DATOS_LIBROS);
	}

	/*
	 * Guarda los vectores en las BD.
	 */

	public void finalizar() throws FileNotFoundException {
		fileManager.escribirArchivoLibros(Constantes.PATH_BASE_DATOS_LIBROS, libros);
	} 

	/*
	 * Genera un nuevo registro con la informaci�n del libro. Si se genero el
	 * registro retorna true. Si el libro ya existe retorna false.
	 */

	public boolean altaLibro(String isbn, String titulo, String autor, String editorial, int edicion,
			int anioPublicacion) {

		Libro libro = new Libro(isbn);

		// Verificamos que no exista el libro
		if (this.libros.indexOf(libro) >= 0) {
			return false;
		}

		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setEditorial(editorial);
		libro.setEdicion(edicion);
		libro.setAnioPublicacion(anioPublicacion);

		this.libros.add(libro);
		return true;
	}

	/*
	 * Busca el libro consultado usando el ISBN. Si existe el libro lo retorna. Si
	 * no existe el libro retorna null.
	 */

	public Libro consultarLibro(String isbn) {

		// Verificamos que el vector este vac�o
		if (this.libros.isEmpty()) {
			return null;
		}

		// Buscamos el libro usando el ISBN.
		int indice = this.libros.indexOf(new Libro(isbn));

		// Verificamos la existencia del libro.
		if (indice <= 0) {
			return null;
		}

		return this.libros.get(indice);

	}

	/*
	 * Modifica el registro usando como el indice el ISBN. Si existe el libro pisa
	 * el registro y retorna true. Si no existe el libro retorna false.
	 */

	public boolean actualizarLibro(String isbn, String titulo, String autor, String editorial, int edicion,
			int anioPublicacion) {

		// Verificamos que el vector este vac�o
		if (this.libros.isEmpty()) {
			return false;
		}

		// Buscamos el libro usando el ISBN.
		Libro libro = new Libro(isbn);
		int indice = this.libros.indexOf(libro);

		// Verificamos la existencia del libro
		if (indice < 0) {
			return false;
		}

		// Como existe el libro volcamos los datos en un nuevo objeto
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setEditorial(editorial);
		libro.setEdicion(edicion);
		libro.setAnioPublicacion(anioPublicacion);

		// Borramos el registro previo e ingresamos el nuevo
		this.libros.remove(indice);
		this.libros.add(libro);

		return true;
	}

	/*
	 * Elimina el registro de la colecci�n.
	 */

	public void eliminarLibro(String isbn) {
		this.libros.remove(new Libro(isbn));
	}

	/*
	 * Ordena el vector. Si esta vac�o no hace nada. Si tiene elementos los ordena.
	 */

	public void ordenarLibros() {

		// Verificamos si esta vacio el vector
		if (this.libros.isEmpty()) {
			return;
		} else {
			Collections.sort(this.libros);
		}
	}

	/*
	 * Retornamos el vector con los libros para que la GUI los muestre.
	 */

	public Vector<Libro> listarLibros() {
		return this.libros;
	}
}