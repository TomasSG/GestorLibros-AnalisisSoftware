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

public class IIniciarSesion extends JFrame {

	private JPanel contentPane;
	private GridBagLayout layout;
	private GridBagConstraints gbc;
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

		gu = new GestorUsuarios();

		try {
			gu.iniciar();
		} catch (FileNotFoundException e1) {
			Utilitario.mensajeError(Utilitario.MSJ_ERROR_BD);
			this.dispose();
		}

		setResizable(false);
		setBackground(Color.WHITE);

		// Operación al cerrar la aplicación
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// Límites
		setBounds(100, 100, 300, 400);

		// layout
		layout = new GridBagLayout();
		gbc = new GridBagConstraints();

		// contentPane
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(layout);
		setContentPane(contentPane);

		// Elementos del a GUI
		MyLabel lblIniciarSesion = new MyLabel("Iniciar Sesi\u00F3n", Utilitario.FONT_TITULOS);
		MyLabel lblNombreUsuario = new MyLabel("Nombre Usuario: ", Utilitario.FONT_CAMPOS);
		MyLabel lblContraseña = new MyLabel("Contrasenia: ", Utilitario.FONT_CAMPOS);
		
		txtNombreUsuario = new JTextField("");
		txtContrasenia = new JPasswordField(10);

		MyButton btnIniciarSesion = new MyButton("Iniciar Sesión");
		MyButton btnRegistrarse = new MyButton("Registrarse");
		

		// Ubicarlos en el espacio
		Utilitario.anadirObjeto(lblIniciarSesion, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 1, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(lblNombreUsuario, contentPane, layout, gbc, 0, 2, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(txtNombreUsuario, contentPane, layout, gbc, 1, 2, 2, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 3, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(lblContraseña, contentPane, layout, gbc, 0, 4, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(txtContrasenia, contentPane, layout, gbc, 1, 4, 2, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 5, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(btnIniciarSesion, contentPane, layout, gbc, 0, 6, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(btnRegistrarse, contentPane, layout, gbc, 2, 6, 1, 1, GridBagConstraints.CENTER,
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
				int resultado = Utilitario.mensajeCerrarVentana();

				if (resultado == JOptionPane.YES_OPTION) {
					cerrarVentana(we.getWindow());
				}
			}
		});
	}

	public void iniciarSesion() {

		String nombre = txtNombreUsuario.getText();
		String contraseniaHash = String.valueOf(txtContrasenia.getPassword());

		// Validaciones sobre los campos de entrada
		if (!Utilitario.esContraseniaCorrecto(contraseniaHash)) {
			Utilitario.mensajeError(Utilitario.MSJ_CONTRASENIA_INVALIDA);
			return;
		}

		if (!Utilitario.esNombreCorrecto(txtNombreUsuario.getText())) {
			Utilitario.mensajeError(Utilitario.MSJ_NOMBRE_INVALIDO);
			return;
		}

		// Validamos de que exista el usuario
		if (!gu.existeUsuario(nombre)) {
			Utilitario.mensajeError(Utilitario.MSJ_NO_EXISTE_USUARIO);
			return;
		}

		// Validamos que las contrasenia coinciden
		if (!gu.verificarContrasenia(nombre, contraseniaHash)) {
			Utilitario.mensajeError(Utilitario.MSJ_CONTRASENIA_ERRONEA);
			return;
		}

		IMenu pantallaMenu = new IMenu();
		pantallaMenu.setLocationRelativeTo(null);
		pantallaMenu.setVisible(true);
		cerrarVentana(this);

	}

	public void registrarUsuario() {
		txtContrasenia.setText("");
		txtNombreUsuario.setText("");

		IRegistrarUsuario pantallaRegistrar = new IRegistrarUsuario(this.gu, this);
		pantallaRegistrar.setLocationRelativeTo(null);
		pantallaRegistrar.setVisible(true);
		this.setVisible(false);
	}

	public void cerrarVentana(Window w) {
		try {
			gu.finalizar();
		} catch (FileNotFoundException e) {
			Utilitario.mensajeError(Utilitario.MSJ_ERROR_BD);
			w.dispose();
		}
		w.dispose();
	}
}
