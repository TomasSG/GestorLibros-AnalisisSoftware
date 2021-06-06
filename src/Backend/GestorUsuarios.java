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

	public byte[] encriptarContrasenia(String contrasenia) {
		return this.encriptador.encriptarSHA256(contrasenia);
	}

	public boolean existeUsuario(Usuario usuario) {

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
	
	public boolean iniciarSesion(Usuario usuario) {
		if(!existeUsuario(usuario)) {
			return false;
		}
		
		int indice = usuarios.indexOf(usuario);
		
		if(!usuarios.get(indice).getContraseniaHash().equals(usuario.getContraseniaHash())) {
			return false;
		}
		
		return true;
	}
}
