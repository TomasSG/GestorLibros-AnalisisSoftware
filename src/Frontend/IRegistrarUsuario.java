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

import Backend.AppManager;
import Backend.Usuario;

public class IRegistrarUsuario extends JFrame {

	private JPanel contentPane;
	private GridBagLayout layout;
	private GridBagConstraints gbc;

	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasenia;
	private JPasswordField txtContraseniaRepetida;

	private AppManager app;
	private IIniciarSesion padre;

	/**
	 * Create the frame.
	 */
	public IRegistrarUsuario(AppManager app, IIniciarSesion padre) {

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

		JLabel lblRegistrarUsuario = new JLabel("Registrar Usuario");
		lblRegistrarUsuario.setFont(new Font("Arial", Font.BOLD, 24));
		lblRegistrarUsuario.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario: ");
		lblNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setBounds(308, 16, 130, 30);

		JLabel lblContraseña = new JLabel("Contrasenia: ");
		lblContraseña.setFont(new Font("Arial", Font.PLAIN, 17));
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblContraseñaRepetida = new JLabel("Repita Contrasenia: ");
		lblContraseñaRepetida.setFont(new Font("Arial", Font.PLAIN, 17));
		lblContraseñaRepetida.setHorizontalAlignment(SwingConstants.CENTER);

		txtContrasenia = new JPasswordField(10);
		txtContrasenia.setText("");
		txtContraseniaRepetida = new JPasswordField(10);
		txtContraseniaRepetida.setText("");
		txtNombreUsuario = new JTextField(" ");

		JButton btnVolver = new JButton("Vovler");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 17));
		btnVolver.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Arial", Font.PLAIN, 17));
		btnRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);

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
		
		char[] contrasenia = txtContrasenia.getPassword();
		char[] contraseniaRepetida = txtContraseniaRepetida.getPassword();
		
		if(!Utilitario.esContraseniaCorrecto(contrasenia) || !Utilitario.esContraseniaCorrecto(contraseniaRepetida)) {
			Utilitario.mensajeError("Contraseña Inválida");
			return;
		}
		
		if(!Utilitario.esNombreCorrecto(txtNombreUsuario.getText())) {
			Utilitario.mensajeError("Nombre de usuario Inválido");
			return;
		}
		
		if(!Arrays.equals(contrasenia, contraseniaRepetida)) {
			Utilitario.mensajeError("No coinciden las contraseñas ingresadas");
			return;
		}
		
		Usuario usuario = new Usuario(txtNombreUsuario.getText(), app.EncriptarContrasenia(contrasenia.toString()));
		
		if(app.RegistrarUsuario(usuario) == false) {
			Utilitario.mensajeError("Ya existe el usuario ingresado");
			return;
		} else {
			Utilitario.mensajeExito("Usuario registrado exitosamente!");
			return;
		}
	}

}
