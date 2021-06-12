package Backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class GestorUsuarios implements Gestor{
	
	private Vector<Usuario> usuarios;
	private FileManager fileManager;
	private Encriptador encriptador;
	
	public GestorUsuarios() {
		this.usuarios = new Vector<Usuario>();
		this.encriptador = new Encriptador();
		this.fileManager = new FileManager();
	}
	
	public void iniciar() throws FileNotFoundException{
		usuarios = fileManager.leerArchivoUsuarios(Constantes.PATH_BASE_DATOS_USUARIOS);
	}
	
	public void finalizar() throws IOException {
		fileManager.escribirArchivoUsuarios(Constantes.PATH_BASE_DATOS_USUARIOS, usuarios);
	}

	public Vector<String> encriptarContrasenia(String contrasenia, int salt) {
		return encriptador.encriptarContrasenia(contrasenia, salt);
	}

	public boolean existeUsuario(Usuario usuario) {
		
		// Se verifica de que no este vacia la lsita y que contenga al usuario.
		if (usuarios.isEmpty() || !usuarios.contains(usuario)) {
			// Se retorna falso porque no existe el usuario
			return false;
		}
		// Si no es verdadero
		return true;
	}
	
	public boolean existeUsuario(String nombre) {
		
		Usuario usuario = new Usuario(nombre);
		
		if (usuarios.isEmpty() || !usuarios.contains(usuario)) {
			return false;
		}
		return true;
	}

	public boolean registrarUsuario(Usuario usuario) {		
		// Se verifica la existencia del usuario
		if (existeUsuario(usuario)) {
			// Como existe se retorna falso
			return false;
		}
		// Si no existe se lo añade a la lsita
		usuarios.add(usuario);
		// Se retorna true porque se completo la operación
		return true;
	}
	
	public boolean verificarContrasenia(String nombre, String contraseniaPlana) {
		
		Usuario usuarioValidar = new Usuario(nombre);
		Usuario usuarioBD = usuarios.get(usuarios.indexOf(usuarioValidar));
		
		if(!encriptador.verificarContrasenia(contraseniaPlana, usuarioBD.getContraseniaHash(), usuarioBD.getSalt())) {
			return false;
		}
		
		return true;
	}

	@Override
	public void registrarLog(String detalle) {
		fileManager.anadirRegistroLog(Constantes.PATH_LOG, detalle);
	}
}
