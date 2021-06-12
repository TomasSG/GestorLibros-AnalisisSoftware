package Frontend;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Backend.GestorUsuarios;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

public class IIniciarSesion extends MyFrame {

	private GestorUsuarios gu;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IIniciarSesion frame = new IIniciarSesion();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IIniciarSesion() {

		super(Utilitario.ANCHO_USUARIOS, Utilitario.LARGO_USUARIOS);

		gu = new GestorUsuarios();
		try {
			gu.iniciar();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Elementos del a GUI
		MyLabel lblIniciarSesion = new MyLabel("Iniciar Sesi\u00F3n", Utilitario.FONT_TITULOS);
		MyLabel lblNombreUsuario = new MyLabel("Nombre Usuario: ", Utilitario.FONT_CAMPOS);
		MyLabel lblContraseña = new MyLabel("Contrasenia: ", Utilitario.FONT_CAMPOS);

		txtNombreUsuario = new JTextField("");
		txtContrasenia = new JPasswordField(10);

		MyButton btnIniciarSesion = new MyButton("Iniciar Sesión");
		MyButton btnRegistrarse = new MyButton("Registrarse");

		// Ubicarlos en el espacio
		anadirObjeto(lblIniciarSesion, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblNombreUsuario, contentPane, layout, gbc, 0, 2, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		anadirObjeto(txtNombreUsuario, contentPane, layout, gbc, 1, 2, 2, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 3, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblContraseña, contentPane, layout, gbc, 0, 4, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		anadirObjeto(txtContrasenia, contentPane, layout, gbc, 1, 4, 2, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 5, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnIniciarSesion, contentPane, layout, gbc, 0, 6, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		anadirObjeto(btnRegistrarse, contentPane, layout, gbc, 2, 6, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		// Acciones de los votoes
		btnIniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarSesion();
			}
		});

		btnRegistrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				registrarUsuario();

			}
		});

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int resultado = mensajeCerrarVentana();

				if (resultado == JOptionPane.YES_OPTION) {
					cerrarVentana(we.getWindow(), gu);
				}
			}
		});
	}

	public void iniciarSesion() {

		String nombre = txtNombreUsuario.getText();
		String contraseniaHash = String.valueOf(txtContrasenia.getPassword());

		// Validaciones sobre los campos de entrada
		if (!esContraseniaCorrecto(contraseniaHash)) {
			mensajeError(Utilitario.MSJ_CONTRASENIA_INVALIDA);
			return;
		}

		if (!esNombreCorrecto(txtNombreUsuario.getText())) {
			mensajeError(Utilitario.MSJ_NOMBRE_INVALIDO);
			return;
		}

		// Validamos de que exista el usuario
		if (!gu.existeUsuario(nombre)) {
			mensajeError(Utilitario.MSJ_NO_EXISTE_USUARIO);
			return;
		}

		// Validamos que las contrasenia coinciden
		if (!gu.verificarContrasenia(nombre, contraseniaHash)) {
			mensajeError(Utilitario.MSJ_CONTRASENIA_ERRONEA);
			return;
		}
		
		gu.registrarLog("Inicio Sesión de " + nombre);

		IMenu pantallaMenu = new IMenu();
		pantallaMenu.setLocationRelativeTo(null);
		pantallaMenu.setVisible(true);
		cerrarVentana(this, gu);

	}

	public void registrarUsuario() {
		txtContrasenia.setText("");
		txtNombreUsuario.setText("");

		IRegistrarUsuario pantallaRegistrar = new IRegistrarUsuario(this.gu, this);
		pantallaRegistrar.setLocationRelativeTo(null);
		pantallaRegistrar.setVisible(true);
		this.setVisible(false);
	}
}
