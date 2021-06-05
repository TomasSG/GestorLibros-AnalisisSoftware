package Backend;

import java.io.*;
import java.util.*;

public class AppManager {

	/* Hay que sacarlas */
	public static Scanner teclado = new Scanner(System.in);
	public static PrintStream out = System.out;
	
	private Vector<Libro> libros;
	
	public AppManager() {
		libros = new Vector<Libro>();
	}
	
	public void iniciarAplicacion() {

		Funcion<Libro> imprimirEnArchivo = new Funcion<Libro>() {
			@Override
			public void funcion(Libro libro, Object parametros) {
				PrintStream archivo = (PrintStream) parametros;
				archivo.print(libro.getISBN() + "\t");
				archivo.print(libro.getTitulo() + "\t");
				archivo.print(libro.getAutor() + "\t");
				archivo.print(libro.getEditorial() + "\t");
				archivo.print(libro.getEdicion() + "\t");
				archivo.print(libro.getAnno_de_publicacion() + "\n");
			}
		};

		
		int i, n;
		Libro dato = null, libro;
		int[] contador = { 0 };
		int opcion, subopcion;

		// Leemos de la BD los registros existentes
		FileManager fileManager = new FileManager();
		libros = fileManager.leerArchivo(Constantes.PATH_BASE_DATOS_LIBROS);

		libro = new Libro();
		do {
			out.println("MEN\u00DA");
			out.println("1.- Altas");
			out.println("2.- Consultas");
			out.println("3.- Actualizaciones");
			out.println("4.- Bajas");
			out.println("5.- Ordenar registros");
			out.println("6.- Listar registros");
			out.println("7.- Salir");
			
			
			// Verificación de que el vector no este vacío
			if (vector.isEmpty() && opcion != 1 && opcion != 7) {
				pausar("No hay registros.\n");
				continue;
			}
			
			// Verificacion de que no exista el libro
			if (opcion < 5) {
				libro.setISBN(leer_cadena("Ingrese el ISBN del libro"));
				i = vector.indexOf(libro);
				dato = i < 0 ? null : vector.get(i);
				if (dato != null) {
					out.println();
					imprimir.funcion(dato, contador);
				}
			}
			
			
			if (opcion == 1 && dato != null)
				out.println("El registro ya existe.");
			else if (opcion >= 2 && opcion <= 4 && dato == null)
				out.println("\nRegistro no encontrado.");
			else
				switch (opcion) {
				case 3:
					out.println("Men\u00FA de modificaci\u00F3n de campos");
					out.println("1.- titulo");
					out.println("2.- autor");
					out.println("3.- editorial");
					out.println("4.- edicion");
					out.println("5.- anno de publicacion");
					do {
						subopcion = leer_entero("Seleccione un n\u00FAmero de campo a modificar");
						if (subopcion < 1 || subopcion > 5)
							out.println("Opci\u00F3n no v\u00E1lida.");
					} while (subopcion < 1 || subopcion > 5);
					switch (subopcion) {
					case 1:
						dato.setTitulo(leer_cadena("Ingrese el nuevo titulo"));
						break;
					case 2:
						dato.setAutor(leer_cadena("Ingrese el nuevo autor"));
						break;
					case 3:
						dato.setEditorial(leer_cadena("Ingrese el nuevo editorial"));
						break;
					case 4:
						dato.setEdicion(leer_entero("Ingrese el nuevo edicion"));
						break;
					case 5:
						dato.setAnno_de_publicacion(leer_entero("Ingrese el nuevo anno de publicacion"));
						break;
					}
					out.println("\nRegistro actualizado correctamente.");
					break;
				case 4:
					vector.remove(dato);
					out.println("Registro borrado correctamente.");
					break;
				case 5:
					Collections.sort(vector);
					out.println("Registros ordenados correctamente.");
					break;
				case 6:
					n = vector.size();
					contador[0] = 0;
					for (i = 0; i < n; i++)
						imprimir.funcion(vector.get(i), contador);
					out.println("Total de registros: " + contador[0] + ".");
					break;
				}
			if (opcion < 7 && opcion >= 1)
				pausar("");
		} while (opcion != 7);
		try {
			PrintStream salida = new PrintStream(PATH_BASE_DATOS_LIBROS);
			n = vector.size();
			for (i = 0; i < n; i++)
				imprimirEnArchivo.funcion(vector.get(i), salida);
			salida.close();
		} catch (FileNotFoundException e) {
		}
	}
	
	/*
	 * Genera un nuevo registro con la información del libro.
	 * Si se genero el registro retorna true.
	 * Si el libro ya existe retorna false.
	 */
	
	public boolean altaLibro(String isbn, String titulo, String autor, String editorial, int edicion, int anioPublicacion) {
		
		Libro libro = new Libro(isbn);
		
		// Verificamos que no exista el libro
		if(this.libros.indexOf(libro) >= 0) {
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
	 * Busca el libro consultado usando el ISBN.
	 * Si existe el libro lo retorna.
	 * Si no existe el libro retorna null.
	 */
	
	public Libro consultarLibro(String isbn) {
		
		// Buscamos el libro usando el ISBN.
		int indice = this.libros.indexOf(new Libro(isbn));
		
		// Verificamos la existencia del libro.
		if(indice <= 0) {
			return null;
		} else {
			return this.libros.get(indice);
		}
	}
}