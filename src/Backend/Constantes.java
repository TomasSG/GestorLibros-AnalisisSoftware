package Backend;

public class Constantes {
	
	// PATH ARCHIVOS
	final public static String PATH_BASE_DATOS_LIBROS = "./libros.tsv";
	final public static String PATH_BASE_DATOS_USUARIOS = "./usuarios.csv";
	final public static String PATH_AYUDA = "./ayuda.txt";
	final public static String PATH_LOG = "./log.txt";
	
	// CONSTANTES DE CARACTERES
	final public static String TABULACION = "\t";
	final public static String NUEVA_LINEA = "\n";
	final public static String PUNTO_COMA = ";";
	
	// CONSTANTES CIFRAD
	final public static int SALT = 512;
	final public static int ITERACIONES = 65536;
	final public static int LARGO_LLAVE = 512;
	final public static String ALGORITMO = "PBKDF2WithHmacSHA512";

}
