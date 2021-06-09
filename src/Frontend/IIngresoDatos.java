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

public class IIngresoDatos extends MyFrame {

	private GestorLibros gl;
	private JFrame padre;

	public IIngresoDatos(GestorLibros gl, JFrame padre) {

		super(Utilitario.ANCHO_LIBROS, Utilitario.LARGO_LIBROS);

		this.gl = gl;
		this.padre = padre;

		// Elementos
		MyLabel lblTitulo = new MyLabel(":-: CENTRO GESTIÓN DE LIBROS :-:", Utilitario.FONT_TITULOS);
		MyLabel lblElegirOpcion = new MyLabel(":-:  Eija la opción deseada  :-:", Utilitario.FONT_TITULOS);

		MyButton btnAltaLibro = new MyButton("Alta Libro");
		MyButton btnConsultarLibro = new MyButton("Consultar Libro");
		MyButton btnActualizarLibro = new MyButton("Actualizar Libro");
		MyButton btnEliminarLibro = new MyButton("Eliminar Libro");
		MyButton btnOrdenarLibro = new MyButton("Ordenar Libros");
		MyButton btnListarLibros = new MyButton("Listar Libros");
		MyButton btnVoler = new MyButton("Volver");

		// Disponer elementos
		anadirObjeto(lblTitulo, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		anadirObjeto(lblElegirOpcion, contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 2, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnAltaLibro, contentPane, layout, gbc, 0, 3, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 4, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnConsultarLibro, contentPane, layout, gbc, 0, 5, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 6, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnActualizarLibro, contentPane, layout, gbc, 0, 7, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 8, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnEliminarLibro, contentPane, layout, gbc, 0, 9, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);
		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 10, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnOrdenarLibro, contentPane, layout, gbc, 0, 11, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 12, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnListarLibros, contentPane, layout, gbc, 0, 13, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 14, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnVoler, contentPane, layout, gbc, 0, 15, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		// Acciones de los botones
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				volver(padre);

			}
		});

		btnVoler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				volver(padre);
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
