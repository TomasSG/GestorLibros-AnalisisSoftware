package Frontend;


import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Backend.GestorLibros;
import Backend.Usuario;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class IIniciarSesion extends JFrame {

	private JPanel contentPane;
	private GridBagLayout layout;
	private GridBagConstraints gbc;
	private GestorLibros app;
	
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
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IIniciarSesion() {
		
		app = new GestorLibros();
		try {
			app.iniciarAplicacion();
		} catch (FileNotFoundException e1) {
			Utilitario.mensajeError("No se logro acceder a la base datos");
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


		JLabel lblIniciarSesion = new JLabel("Iniciar Sesi\u00F3n");
		lblIniciarSesion.setFont(new Font("Arial", Font.BOLD, 24));
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);	

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario: ");
		lblNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setBounds(308, 16, 130, 30);
		
		txtNombreUsuario = new JTextField(" ");
		
		JLabel lblContraseña = new JLabel("Contrasenia: ");
		lblContraseña.setFont(new Font("Arial", Font.PLAIN, 17));
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtContrasenia = new JPasswordField(10);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setFont(new Font("Arial", Font.PLAIN, 17));
		btnIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Arial", Font.PLAIN, 17));
		btnRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);

		
		Utilitario.anadirObjeto(lblIniciarSesion, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(lblNombreUsuario, contentPane, layout, gbc, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(txtNombreUsuario, contentPane, layout, gbc, 1, 2, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 3, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(lblContraseña, contentPane, layout, gbc, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(txtContrasenia, contentPane, layout, gbc, 1, 4, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 5, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(btnIniciarSesion, contentPane, layout, gbc, 0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(btnRegistrarse, contentPane, layout, gbc, 2, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
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
				
				if(resultado == JOptionPane.YES_OPTION) {
					try {
						app.finalizarAplicacion();
					} catch (FileNotFoundException e) {
						Utilitario.mensajeError("No se logro acceder a la base datos");
						we.getWindow().dispose();
					}
					we.getWindow().dispose();
				}
			}
		});
	}
	
	public void iniciarSesion() {
		
		String nombre = txtNombreUsuario.getText();
		byte[] contraseniaHash = app.EncriptarContrasenia(txtContrasenia.getPassword().toString());
		
		if(!Utilitario.esContraseniaCorrecto(txtContrasenia.getPassword())) {
			Utilitario.mensajeError("Contraseña Inválida");
			return;
		}
		
		if(!Utilitario.esNombreCorrecto(txtNombreUsuario.getText())) {
			Utilitario.mensajeError("Nombre de usuario Inválido");
			return;
		}
		
		Usuario usuario = new Usuario(nombre, contraseniaHash);		
		
		
		if(app.IniciarSesion(usuario)) {
			
			// Validacion de que coincidan las contraseñas
			if(usuario.getContraseniaHash().equals(contraseniaHash)) {
				System.out.println("LOGEADO");
				return;
			} else {
				Utilitario.mensajeError("Contraseña Incorrecta");
				return;
			}
				
		} else {
			Utilitario.mensajeError("No Existe el Usuario");
			return;
		}
		
	}
	
	public void registrarUsuario() {
		new IRegistrarUsuario(this.app, this).setVisible(true);
		this.setVisible(false);
	}
}
