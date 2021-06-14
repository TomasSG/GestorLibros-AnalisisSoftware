package Frontend;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JPasswordField;
import Backend.GestorUsuarios;

import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
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
				String nombre = txtNombreUsuario.getText();
				String contraseniaHash = String.valueOf(txtContrasenia.getPassword());
				iniciarSesion(nombre, contraseniaHash);
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

	public void iniciarSesion(String nombre, String contraseniaHash) {

		// Validacion que la contraseña es correcta
		if (!gu.esContrasenia(contraseniaHash)) {
			mensajeError(Utilitario.MSJ_ERROR_CONTRASENIA_INVALIDA);
			return;
		}
		
		// Validación de que el nombre es válido
		if (!gu.esNombre(nombre)) {
			mensajeError(Utilitario.MSJ_ERROR_NOMBRE_INVALIDO);
			return;
		}

		// Validamos de que exista el usuario
		if (!gu.existeUsuario(nombre)) {
			mensajeError(Utilitario.MSJ_ERROR_NO_EXISTE_USUARIO);
			return;
		}

		// Validamos que las contrasenia coinciden
		if (!gu.verificarContrasenia(nombre, contraseniaHash)) {
			mensajeError(Utilitario.MSJ_ERROR_CONTRASENIA_ERRONEA);
			return;
		}
		
		// Registramos en el log
		gu.registrarLog("Inicio Sesión de " + nombre);

		// Pasamos a la próxima ventana
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
