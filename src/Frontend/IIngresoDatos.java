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
import java.io.FileNotFoundException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Backend.GestorLibros;

public class IIngresoDatos extends JFrame {

	private JPanel contentPane;
	private GridBagLayout layout;
	private GridBagConstraints gbc;

	private GestorLibros gl;
	private JFrame padre;

	public IIngresoDatos(GestorLibros gl, JFrame padre) {

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
		JLabel lblTitulo = new JLabel(":-: CENTRO GESTIÓN DE LIBROS :-:");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblElegirOpcion = new JLabel(":-:  Eija la opción deseada  :-:");
		lblElegirOpcion.setFont(new Font("Arial", Font.BOLD, 24));
		lblElegirOpcion.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnAltaLibro = new JButton("Alta Libro");
		btnAltaLibro.setFont(new Font("Arial", Font.PLAIN, 17));
		btnAltaLibro.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnConsultarLibro = new JButton("Consultar Libro");
		btnConsultarLibro.setFont(new Font("Arial", Font.PLAIN, 17));
		btnConsultarLibro.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnActualizarLibro = new JButton("Actualizar Libro");
		btnActualizarLibro.setFont(new Font("Arial", Font.PLAIN, 17));
		btnActualizarLibro.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnEliminarLibro = new JButton("Eliminar Libro");
		btnEliminarLibro.setFont(new Font("Arial", Font.PLAIN, 17));
		btnEliminarLibro.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnOrdenarLibro = new JButton("Ordenar Libros");
		btnOrdenarLibro.setFont(new Font("Arial", Font.PLAIN, 17));
		btnOrdenarLibro.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnListarLibros = new JButton("Listar Libros");
		btnListarLibros.setFont(new Font("Arial", Font.PLAIN, 17));
		btnListarLibros.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnVoler = new JButton("Volver");
		btnVoler.setFont(new Font("Arial", Font.PLAIN, 17));
		btnVoler.setHorizontalAlignment(SwingConstants.CENTER);
		
		

		// Disponer elementos
		Utilitario.anadirObjeto(lblTitulo, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(lblElegirOpcion, contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 2, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(btnAltaLibro, contentPane, layout, gbc, 0, 3, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 4, 2, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(btnConsultarLibro, contentPane, layout, gbc, 0, 5, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 6, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(btnActualizarLibro, contentPane, layout, gbc, 0, 7, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 8, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(btnEliminarLibro, contentPane, layout, gbc, 0, 9, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 10, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(btnOrdenarLibro, contentPane, layout, gbc, 0, 11, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 12, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(btnListarLibros, contentPane, layout, gbc, 0, 13, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 14, 5, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		Utilitario.anadirObjeto(btnVoler, contentPane, layout, gbc, 0, 15, 5, 1, GridBagConstraints.CENTER,
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
				cerrarVentana(IIngresoDatos.this);
			}
		});

		btnAltaLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abriraPantalla(1);
			}
		});

		btnConsultarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abriraPantalla(2);
			}
		});

		btnActualizarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abriraPantalla(3);
			}
		});

		btnEliminarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abriraPantalla(4);
			}
		});

		btnListarLibros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abriraPantalla(5);
			}
		});
	}

	public void cerrarVentana(Window w) {
		padre.setVisible(true);
		this.dispose();
	}

	public void abriraPantalla(int opcion) {
		JFrame pantalla = null;

		if (opcion == 1) {
			pantalla = new IAltaLibro(gl, this);
		} else if (opcion == 2) {
			// pantalla = new IConsultarLibro(gl, this);
		} else if (opcion == 3) {
			// pantalla = new IActualizarLibro(gl, this);
		} else if (opcion == 4) {
			// pantalla = new IEliminarLibro(gl, this);
		} else if (opcion == 5) {
			// pantalla = new IListarLibros(gl, this);
		}

		pantalla.setLocationRelativeTo(null);
		pantalla.setVisible(true);
		this.setVisible(false);
	}
}
