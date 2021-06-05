package Backend;

public class Usuario implements Comparable<Usuario>{
	
	private String nombre;
	private String contraseniaHash;
	
	public Usuario(String nombre, String contraseniaHash) {
		this.nombre = nombre;
		this.contraseniaHash = contraseniaHash;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseniaHash() {
		return contraseniaHash;
	}

	public void setContraseniaHash(String contraseniaHash) {
		this.contraseniaHash = contraseniaHash;
	}

	@Override
	public int compareTo(Usuario o) {
		return this.nombre.compareTo(o.getNombre());
	}

}
