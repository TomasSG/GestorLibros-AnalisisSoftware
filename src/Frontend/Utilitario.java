package Frontend;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JOptionPane;

public class Utilitario {
	
	// Titulos ventanas
	public static final String TITULO_CERRAR_VENTANA = "Cerrar Ventana";
	public static final String TITULO_ERROR = "Error";
	public static final String TITULO_EXITO = "Operación Completada Exitosamente";
	
	// Msj de errores
	public static final String MSJ_CERRAR_VENTANA = "¿Deseas cerrar la ventana?";
	public static final String MSJ_CONTRASENIA_INVALIDA = "Contraseña Inválida";
	public static final String MSJ_NO_COINCIDEN_CONTRASENIAS = "No coinciden las contraseñas ingresadas";
	public static final String MSJ_CONTRASENIA_ERRONEA = "Contraseña erronea";
	public static final String MSJ_NOMBRE_INVALIDO = "Nombre de usuario Inválido";
	public static final String MSJ_EXISTE_USUARIO = "Ya existe el usuario ingresado";
	public static final String MSJ_NO_EXISTE_USUARIO = "No existe el usuario ingresado";
	
	// Msjs de éxito
	public static final String MSJ_USUARIO_REGISTRADO = "Usuario registrado exitosamente!";
	
	
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
	
	public static boolean esContraseniaCorrecto(String contrasenia) {
		return contrasenia.length() > 0; 
	}
}
