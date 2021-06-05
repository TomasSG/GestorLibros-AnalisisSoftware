package Backend;

public class Usuario implements Comparable<Usuario>{
	
	private String nombre;
	private byte[] contraseniaHash;
	
	public Usuario(String nombre, byte[] contraseniaHash) {
		this.nombre = nombre;
		this.contraseniaHash = contraseniaHash;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getContraseniaHash() {
		return contraseniaHash;
	}

	public void setContraseniaHash(byte[] contraseniaHash) {
		this.contraseniaHash = contraseniaHash;
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
