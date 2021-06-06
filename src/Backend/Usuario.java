package Backend;

public class Usuario implements Comparable<Usuario>{
	
	private String nombre;
	private String contraseniaHash;
	private String salt;
	
	public Usuario(String nombre, String contraseniaHash, String salt) {
		this.nombre = nombre;
		this.contraseniaHash = contraseniaHash;
		this.salt = salt;
	}
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.contraseniaHash = null;
		this.salt = null;
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
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public int compareTo(Usuario o) {
		return this.nombre.compareTo(o.getNombre());
	}
	
	@Override
    public boolean equals(Object u) {
        return this==u || (u instanceof Usuario && this.nombre.equals(((Usuario)u).nombre));
    }

}
