package Frontend;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JOptionPane;

public class Utilitario {
	
	// Titulos ventanas
	public static final String TITULO_CERRAR_VENTANA = "Cerrar Ventana";
	public static final String TITULO_ERROR = "Error";
	public static final String TITULO_EXITO = "Operación Completada Exitosamente";
	
	// Msj de errores
	public static final String MSJ_ERROR_BD = "No se logro acceder a la base datos";
	
	public static final String MSJ_CERRAR_VENTANA = "¿Deseas cerrar la ventana?";
	
	public static final String MSJ_CAMPOS_VACIOS = "Todos los campos deben estar completos";
	public static final String MSJ_LISTA_VACIA = "Parece que no hay registros aún";
	
	public static final String MSJ_CONTRASENIA_INVALIDA = "Contraseña Inválida";
	public static final String MSJ_NO_COINCIDEN_CONTRASENIAS = "No coinciden las contraseñas ingresadas";
	public static final String MSJ_CONTRASENIA_ERRONEA = "Contraseña erronea";
	public static final String MSJ_NOMBRE_INVALIDO = "Nombre de usuario Inválido";
	public static final String MSJ_EXISTE_USUARIO = "Ya existe el usuario ingresado";
	public static final String MSJ_NO_EXISTE_USUARIO = "No existe el usuario ingresado";
	
	public static final String MSJ_LIBRO_EXISTE = "Ya existe el ISBN introducido";
	public static final String MSJ_LIBRO_ERROR = "No se logro registrar el libro";
	
	// Msjs de éxito
	public static final String MSJ_USUARIO_REGISTRADO = "Usuario registrado exitosamente!";
	public static final String MSJ_LIBRO_REGISTRADO = "Libro registrado exitosamente!";
	
	
	// Fonts
	public static final Font FONT_TITULOS = new Font("Arial", Font.BOLD, 24);
	public static final Font FONT_CAMPOS = new Font("Arial", Font.PLAIN, 17);
	
	// Anchos y largos
	public static final int ANCHO_USUARIOS = 300;
	public static final int LARGO_USUARIOS = 400;
	public static final int ANCHO_LIBROS = 500;
	public static final int LARGO_LIBROS = 500;
	
	// Campos Libros
	public static final String[] CAMPOS_LIBROS = {"ISBN", "Titulo", "Autor", "Editorial", "Edicion", "Anio"};
	
}
