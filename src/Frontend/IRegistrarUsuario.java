package Frontend;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Backend.Constantes;
import Backend.GestorUsuarios;
import Backend.Usuario;

public class IRegistrarUsuario extends MyFrame {

	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasenia;
	private JPasswordField txtContraseniaRepetida;

	private GestorUsuarios gu;
	private JFrame padre;

	public IRegistrarUsuario(GestorUsuarios gu, JFrame padre) {

		super(Utilitario.ANCHO_USUARIOS, Utilitario.LARGO_USUARIOS);

		this.gu = gu;
		this.padre = padre;

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
		anadirObjeto(lblRegistrarUsuario, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START,
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

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 5, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblContraseñaRepetida, contentPane, layout, gbc, 0, 6, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		anadirObjeto(txtContraseniaRepetida, contentPane, layout, gbc, 1, 6, 2, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 7, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnRegistrarse, contentPane, layout, gbc, 0, 8, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		anadirObjeto(btnVolver, contentPane, layout, gbc, 2, 8, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				volver(padre);
			}
		});

		btnRegistrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombreUsuario.getText();
				String contrasenia = String.valueOf(txtContrasenia.getPassword());
				String contraseniaRepetida = String.valueOf(txtContraseniaRepetida.getPassword());
				registrarUsuario(nombre, contrasenia, contraseniaRepetida);
			}
		});

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				volver(padre);
			}
		});
	}

	public void registrarUsuario(String nombre, String pass, String passD) {

		// Verificacion las contraseñas son válidas
		if (!gu.esContrasenia(pass) || !gu.esContrasenia(passD)) {
			mensajeError(Utilitario.MSJ_ERROR_CONTRASENIA_INVALIDA);
			return;
		}

		// Verificación el nombre deusuario es válido
		if (!gu.esNombre(nombre)) {
			mensajeError(Utilitario.MSJ_ERROR_NOMBRE_INVALIDO);
			return;
		}

		// Verificación las contraseñas coincidan
		if (!pass.equals(passD)) {
			mensajeError(Utilitario.MSJ_ERROR_NO_COINCIDEN_CONTRASENIAS);
			return;
		}

		// Validacion que el usuario no exista previamente
		if (gu.existeUsuario(nombre)) {
			mensajeError(Utilitario.MSJ_ERROR_EXISTE_USUARIO);
			return;
		}

		// Ciframos la contrasenia
		Vector<String> resultados = gu.encriptarContrasenia(pass, Constantes.SALT);
		Usuario usuario = new Usuario(nombre, resultados.get(0), resultados.get(1));

		// Registramos el usuario porque es válido
		gu.registrarUsuario(usuario);

		// Mostramos que se logro registrar al usuario correctamente
		mensajeExito(Utilitario.MSJ_USUARIO_REGISTRADO);

		// Registramos en el log
		gu.registrarLog("Usuario Registrado " + txtNombreUsuario.getText());

		// Volvemos a la pantalla previa
		volver(padre);
	}

}
