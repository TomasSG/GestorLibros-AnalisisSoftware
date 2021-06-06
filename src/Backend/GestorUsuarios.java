package Backend;

import java.io.FileNotFoundException;
import java.util.Vector;

public class GestorUsuarios {
	
	private Vector<Usuario> usuarios;
	private FileManager fileManager;
	private Encriptador encriptador;
	
	public GestorUsuarios() {
		this.usuarios = new Vector<Usuario>();
		this.encriptador = new Encriptador();
		this.fileManager = new FileManager();
	}
	
	public void iniciar() throws FileNotFoundException {
		usuarios = fileManager.leerArchivoUsuarios(Constantes.PATH_BASE_DATOS_USUARIOS);
	}
	
	public void finalizar() throws FileNotFoundException {
		fileManager.escribirArchivoUsuarios(Constantes.PATH_BASE_DATOS_USUARIOS, usuarios);
	}

	public Vector<String> encriptarContrasenia(String contrasenia, int salt) {
		return encriptador.encriptarContrasenia(contrasenia, salt);
	}

	public boolean existeUsuario(Usuario usuario) {

		if (usuarios.isEmpty() || !usuarios.contains(usuario)) {
			return false;
		}
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
		if (existeUsuario(usuario)) {
			return false;
		}
		usuarios.add(usuario);
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
}
