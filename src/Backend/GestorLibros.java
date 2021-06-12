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

	public void iniciar() throws FileNotFoundException{
		libros = fileManager.leerArchivoLibros(Constantes.PATH_BASE_DATOS_LIBROS);
	}

	public void finalizar() throws IOException {
		fileManager.escribirArchivoLibros(Constantes.PATH_BASE_DATOS_LIBROS, libros);
	}

	public boolean existeLibro(String isbn) {
		return !libros.isEmpty() && libros.contains(new Libro(isbn));
	}

	public boolean esIsbn(String isbn) {
		String[] split = isbn.split("-");
		if (isbn.length() != 17 || split.length != 5) {
			return false;
		}

		for (int i = 0; i < 5; i++) {
			if (!split[i].matches("^[0-9]*$")) {
				return false;
			}
		}

		if (split[0].length() != 3 || split[1].length() != 2 || split[2].length() != 5 || split[3].length() != 2
				|| split[4].length() != 1) {
			return false;
		}

		return true;
	}

	public boolean esTexto(String texto) {
		if (texto.trim().length() > 50 || texto.trim().equals("")) {
			return false;
		}

		return true;
	}

	public boolean altaLibro(String isbn, String titulo, String autor, String editorial, int edicion,
			int anioPublicacion) {

		// Validacion de que sea un ISBN v�lido
		if (!esIsbn(isbn)) {
			// Indicamos que no se completo la operacion
			return false;
		}

		// Validacion de que los campos de texto sean v�lidos
		if (!esTexto(titulo) || !esTexto(autor) || !esTexto(editorial)) {
			// Indicamos que no se completo la operacion
			return false;
		}

		// Validacion de que los campos numericos sean v�lidos
		if (edicion <= 0 || anioPublicacion <= 0) {
			// Indicamos que no se completo la operacion
			return false;
		}

		// Validacion de que no exista previamente el libro
		if (existeLibro(isbn)) {
			// Indicamos que no se completo la operacion
			return false;
		}

		// Creamos el libro con los datos previamente vlidados
		this.libros.add(new Libro(isbn, titulo, autor, editorial, edicion, anioPublicacion));
		
		// Retornamos true indicando el �xito de la operacion
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

	@Override
	public void registrarLog(String detalle) {
		fileManager.anadirRegistroLog(Constantes.PATH_LOG, detalle);
	}
}