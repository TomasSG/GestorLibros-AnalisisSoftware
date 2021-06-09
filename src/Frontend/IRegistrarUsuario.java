package Frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Backend.Constantes;
import Backend.GestorLibros;
import Backend.GestorUsuarios;
import Backend.Usuario;

public class IRegistrarUsuario extends JFrame {

	private JPanel contentPane;
	private GridBagLayout layout;
	private GridBagConstraints gbc;

	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasenia;
	private JPasswordField txtContraseniaRepetida;

	private GestorUsuarios app;
	private IIniciarSesion padre;


	public IRegistrarUsuario(GestorUsuarios app, IIniciarSesion padre) {

		this.app = app;
		this.padre = padre;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

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
		
		// Elementos
		MyLabel lblRegistrarUsuario = new MyLabel("Registrar Usuario", Utilitario.FONT_TITULOS);
		MyLabel lblNombreUsuario = new MyLabel("Nombre Usuario: ", Utilitario.FONT_CAMPOS);
		MyLabel lblContraseña = new MyLabel("Contrasenia: ", Utilitario.FONT_CAMPOS);
		JLabel lblContraseñaRepetida = new MyLabel("Repita Contrasenia: ", Utilitario.FONT_CAMPOS);

		txtContrasenia = new JPasswordField(10);
		txtContrasenia.setText("");
		txtContraseniaRepetida = new JPasswordField(10);
		txtContraseniaRepetida.setText("");
		txtNombreUsuario = new JTextField("");

		MyButton btnVolver = new MyButton("Vovler");
		MyButton btnRegistrarse = new MyButton("Registrarse");
	
		// Posición de objetos
		Utilitario.anadirObjeto(lblRegistrarUsuario, contentPane, layout, gbc, 0, 0, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

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

		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 5, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(lblContraseñaRepetida, contentPane, layout, gbc, 0, 6, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(txtContraseniaRepetida, contentPane, layout, gbc, 1, 6, 2, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 7, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(btnRegistrarse, contentPane, layout, gbc, 0, 8, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(btnVolver, contentPane, layout, gbc, 2, 8, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				volver();
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
					volver();
				}
			}
		});
	}

	private void volver() {
		padre.setVisible(true);
		this.dispose();
	}

	public void registrarUsuario() {

		String contrasenia = String.valueOf(txtContrasenia.getPassword());
		String contraseniaRepetida = String.valueOf(txtContraseniaRepetida.getPassword());

		// Verificaciones sobre los campos de entrada
		if (!Utilitario.esContraseniaCorrecto(contrasenia) || !Utilitario.esContraseniaCorrecto(contraseniaRepetida)) {
			Utilitario.mensajeError(Utilitario.MSJ_CONTRASENIA_INVALIDA);
			return;
		}

		if (!Utilitario.esNombreCorrecto(txtNombreUsuario.getText())) {
			Utilitario.mensajeError(Utilitario.MSJ_NOMBRE_INVALIDO);
			return;
		}

		if (!contrasenia.equals(contraseniaRepetida)) {
			Utilitario.mensajeError(Utilitario.MSJ_NO_COINCIDEN_CONTRASENIAS);
			return;
		}

		// Ciframos la contrasenia
		Vector<String> resultados = app.encriptarContrasenia(contrasenia, Constantes.SALT);
		Usuario usuario = new Usuario(txtNombreUsuario.getText(), resultados.get(0), resultados.get(1));

		
		// Validaciones sobre el usuario
		if (app.registrarUsuario(usuario) == false) {
			Utilitario.mensajeError(Utilitario.MSJ_EXISTE_USUARIO);
			return;
		} else {
			Utilitario.mensajeExito(Utilitario.MSJ_USUARIO_REGISTRADO);
			return;
		}

	}

}
