package Frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Gestor;
import Backend.GestorUsuarios;

public class MyFrame extends JFrame {

	protected JPanel contentPane;
	protected GridBagLayout layout;
	protected GridBagConstraints gbc;

	public MyFrame(int ancho, int largo) {
		setResizable(false);
		setBackground(Color.WHITE);

		// Operación al cerrar la aplicación
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// Límites
		setBounds(100, 100, ancho, largo);

		// layout
		layout = new GridBagLayout();
		gbc = new GridBagConstraints();

		// contentPane
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(layout);
		setContentPane(contentPane);
	}

	protected void anadirObjeto(Component componente, Container container, GridBagLayout layout, GridBagConstraints gbc,
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

	protected int mensajeCerrarVentana() {
		return JOptionPane.showConfirmDialog(null, Utilitario.MSJ_CERRAR_VENTANA, Utilitario.TITULO_CERRAR_VENTANA,
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}

	protected int mensajeError(String msj) {
		return JOptionPane.showConfirmDialog(null, msj, Utilitario.TITULO_ERROR, JOptionPane.CLOSED_OPTION,
				JOptionPane.ERROR_MESSAGE);
	}

	protected int mensajeExito(String msj) {
		return JOptionPane.showConfirmDialog(null, msj, Utilitario.TITULO_EXITO, JOptionPane.CLOSED_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
	}

	protected boolean esNombreCorrecto(String nombre) {
		return !nombre.trim().equals("") && nombre.trim().length() < 25;
	}

	protected boolean esContraseniaCorrecto(String contrasenia) {
		return contrasenia.length() > 0;
	}

	protected void cerrarVentana(Window w, Gestor g) {
		try {
			g.finalizar();
		} catch (FileNotFoundException e) {
			mensajeError(Utilitario.MSJ_ERROR_BD);
			w.dispose();
		}
		w.dispose();
	}

	protected void volver(JFrame padre) {
		padre.setVisible(true);
		this.dispose();
	}

}
