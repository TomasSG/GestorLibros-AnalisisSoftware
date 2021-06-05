package Backend;

import java.io.*;
import java.util.*;

import javax.swing.text.PlainDocument;

public class AppManager {

	private Vector<Libro> libros;
	private Vector<Usuario> usuarios;
	private FileManager fileManager;
	private Encriptador encriptador;

	public AppManager() {
		this.libros = new Vector<Libro>();
		this.usuarios = new Vector<Usuario>();
		this.encriptador = new Encriptador();
		this.fileManager = new FileManager();
	}

	/*
	 * Carga las BD en los vectores.
	 */

	public void iniciarAplicacion() throws FileNotFoundException {
		libros = fileManager.leerArchivoLibros(Constantes.PATH_BASE_DATOS_LIBROS);
		usuarios = fileManager.leerArchivoUsuarios(Constantes.PATH_BASE_DATOS_USUARIOS);
	}

	/*
	 * Guarda los vectores en las BD.
	 */

	public void finalizarAplicacion() throws FileNotFoundException {
		fileManager.escribirArchivoLibros(Constantes.PATH_BASE_DATOS_LIBROS, this.libros);
		fileManager.escribirArchivoUsuarios(Constantes.PATH_BASE_DATOS_USUARIOS, usuarios);
	}

	/*
	 * Genera un nuevo registro con la información del libro. Si se genero el
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

		// Verificamos que el vector este vacío
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

		// Verificamos que el vector este vacío
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
	 * Elimina el registro de la colección.
	 */

	public void eliminarLibro(String isbn) {
		this.libros.remove(new Libro(isbn));
	}

	/*
	 * Ordena el vector. Si esta vacío no hace nada. Si tiene elementos los ordena.
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

	public String EncriptarContrasenia(String contrasenia) {
		return this.encriptador.encriptarSHA256(contrasenia);
	}

	public boolean IniciarSesion(Usuario usuario) {

		// Si no hay registros es que no esta registrado
		if (usuarios.isEmpty()) {
			return false;
		}

		int indice = usuarios.indexOf(usuario);

		// Si no existe en el registro el índice es menor a 0
		if (indice < 0) {
			return false;
		}

		return true;
	}

	public boolean RegistrarUsuario(Usuario usuario) {
		int indice = usuarios.indexOf(usuario);
		
		// Si existe en el registro el índice es por lo menos 0
		if (indice >= 0) {
			return false;
		}

		usuarios.add(usuario);
		return true;
	}
}