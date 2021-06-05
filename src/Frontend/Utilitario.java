package Frontend;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JOptionPane;

public class Utilitario {
	
	private static final String TITULO_CERRAR_VENTANA = "Cerrar Ventana";
	private static final String MSJ_CERRAR_VENTANA = "¿Deseas cerrar la ventana?";
	
	private static final String TITULO_ERROR = "Error";
	private static final String TITULO_EXITO = "Operación Completada Exitosamente";
	

	public static void anadirObjeto(Component componente, Container container, GridBagLayout layout, GridBagConstraints gbc,
			int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill) {
		
		gbc.anchor = anchor;
		gbc.fill = fill;
		
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		
		
		layout.setConstraints(componente, gbc);
		container.add(componente);
	}
	
	public static int mensajeCerrarVentana() {
		return JOptionPane.showConfirmDialog(null, MSJ_CERRAR_VENTANA, TITULO_CERRAR_VENTANA, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int mensajeError(String msj) {
		return JOptionPane.showConfirmDialog(null, msj, TITULO_ERROR, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
	}
	
	public static int mensajeExito(String msj) {
		return JOptionPane.showConfirmDialog(null, msj, TITULO_EXITO, JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static boolean esNombreCorrecto(String nombre) {
		return!nombre.trim().equals("") && nombre.trim().length() < 25; 
	}
	
	public static boolean esContraseniaCorrecto(char[] contrasenia) {
		return contrasenia.length > 0; 
	}
}
