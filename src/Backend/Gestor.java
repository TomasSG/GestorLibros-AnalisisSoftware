package Backend;

import java.io.FileNotFoundException;

public interface Gestor {
	
	public void iniciar() throws FileNotFoundException;
	public void finalizar() throws FileNotFoundException;
	public void registrarLog(String detalle);
}
