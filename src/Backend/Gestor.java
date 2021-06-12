package Backend;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Gestor {
	
	public void iniciar() throws FileNotFoundException;
	public void finalizar() throws IOException;
	public void registrarLog(String detalle);
}
