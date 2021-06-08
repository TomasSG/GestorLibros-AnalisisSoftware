package Frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Backend.GestorLibros;

public class IAltaLibro extends JFrame {

	private JPanel contentPane;
	private GridBagLayout layout;
	private GridBagConstraints gbc;
	
	private JTextField txtIsbn;
	private JTextField txtAnioLibro;
	private JTextField txtEdicionLibro;
	private JTextField txtEditorialLibro;
	private JTextField txtAutorLibro;
	private JTextField txtTitluoLibro;

	private GestorLibros gl;
	private JFrame padre;

	public IAltaLibro(GestorLibros gl, JFrame padre) {

		this.gl = gl;
		this.padre = padre;

		// Estética
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 500);

		// Para layout
		layout = new GridBagLayout();
		gbc = new GridBagConstraints();

		// JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(layout);
		setContentPane(contentPane);

		// Elementos
		JLabel lblTitulo = new JLabel(":-: ALTA LIBRO :-:");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblElegirOpcion = new JLabel(":-:  COMPLETE LOS CAMPOS  :-:");
		lblElegirOpcion.setFont(new Font("Arial", Font.BOLD, 24));
		lblElegirOpcion.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnVoler = new JButton("Volver");
		btnVoler.setFont(new Font("Arial", Font.PLAIN, 17));
		btnVoler.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.setFont(new Font("Arial", Font.PLAIN, 17));
		btnAnadir.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblIsbn = new JLabel("ISBN: ");
		lblIsbn.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsbn.setBounds(308, 16, 130, 30);
		
		txtIsbn = new JTextField("");
		
		JLabel lblTituloLibro = new JLabel("Título: ");
		lblTituloLibro.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTituloLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLibro.setBounds(308, 16, 130, 30);
		
		txtTitluoLibro = new JTextField("");
		
		JLabel lblAutorLibro = new JLabel("Autor: ");
		lblAutorLibro.setFont(new Font("Arial", Font.PLAIN, 17));
		lblAutorLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutorLibro.setBounds(308, 16, 130, 30);
		
		txtAutorLibro = new JTextField("");
		
		JLabel lblEditorialLibro = new JLabel("Editorial: ");
		lblEditorialLibro.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEditorialLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditorialLibro.setBounds(308, 16, 130, 30);
		
		txtEditorialLibro = new JTextField("");
		
		JLabel lblEdicionLibro = new JLabel("Edicion: ");
		lblEditorialLibro.setFont(new Font("Arial", Font.PLAIN, 17));
		lblEditorialLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditorialLibro.setBounds(308, 16, 130, 30);
		
		txtEdicionLibro = new JTextField("");
		
		JLabel lblAnioLibro = new JLabel("Año Publicación: ");
		lblEditorialLibro.setFont(new Font("Arial", Font.PLAIN, 1));
		lblEditorialLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditorialLibro.setBounds(308, 16, 130, 30);
		
		txtAnioLibro = new JTextField("");
		

		// Disponer elementos
		Utilitario.anadirObjeto(lblTitulo, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(lblElegirOpcion, contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 2, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(lblIsbn, contentPane, layout, gbc, 0, 3, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(txtIsbn, contentPane, layout, gbc, 3, 3, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 4, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(lblTituloLibro, contentPane, layout, gbc, 0, 5, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(txtTitluoLibro, contentPane, layout, gbc, 3, 5, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 6, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(lblAutorLibro, contentPane, layout, gbc, 0, 7, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(txtAutorLibro, contentPane, layout, gbc, 3, 7, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 8, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(lblEditorialLibro, contentPane, layout, gbc, 0, 9, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(txtEditorialLibro, contentPane, layout, gbc, 3, 9, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 10, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(lblEdicionLibro, contentPane, layout, gbc, 0, 11, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(txtEdicionLibro, contentPane, layout, gbc, 3, 11, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 12, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(lblAnioLibro, contentPane, layout, gbc, 0, 13, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(txtAnioLibro, contentPane, layout, gbc, 3, 13, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 14, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(btnVoler, contentPane, layout, gbc, 0, 15, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createHorizontalStrut(200), contentPane, layout, gbc, 1, 15, 3, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(btnAnadir, contentPane, layout, gbc, 4, 15, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		// Acciones de los botones
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				cerrarVentana(we.getWindow());
			}
		});

		btnVoler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVentana(IAltaLibro.this);
			}
		});

	}

	public void cerrarVentana(Window w) {
		padre.setVisible(true);
		this.dispose();
	}

}
