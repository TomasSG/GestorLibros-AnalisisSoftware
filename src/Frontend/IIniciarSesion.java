package Frontend;


import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class IIniciarSesion extends JFrame {

	private JPanel contentPane;
	private GridBagLayout layout;
	private GridBagConstraints gbc;

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
		setResizable(false);
		setBackground(Color.WHITE);

		// Operación al cerrar la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		
		JTextField txtNombreUsuario = new JTextField(" ");
		
		JLabel lblContraseña = new JLabel("Contrasenia: ");
		lblContraseña.setFont(new Font("Arial", Font.PLAIN, 17));
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPasswordField txtContrasenia = new JPasswordField(10);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setFont(new Font("Arial", Font.PLAIN, 17));
		btnIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Arial", Font.PLAIN, 17));
		btnRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);

		
		anadirObjeto(lblIniciarSesion, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		anadirObjeto(lblNombreUsuario, contentPane, layout, gbc, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		anadirObjeto(txtNombreUsuario, contentPane, layout, gbc, 1, 2, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 3, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		anadirObjeto(lblContraseña, contentPane, layout, gbc, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		anadirObjeto(txtContrasenia, contentPane, layout, gbc, 1, 4, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 5, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		anadirObjeto(btnIniciarSesion, contentPane, layout, gbc, 0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		anadirObjeto(btnRegistrarse, contentPane, layout, gbc, 2, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("BOTON PRESIONADO");
				
			}
		});
	}

	private void anadirObjeto(Component componente, Container container, GridBagLayout layout, GridBagConstraints gbc,
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
}
