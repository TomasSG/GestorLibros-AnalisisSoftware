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
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Backend.GestorLibros;

public class IAltaLibro extends MyFrame {

	private JTextField txtIsbn;
	private JFormattedTextField txtAnioLibro;
	private JFormattedTextField txtEdicionLibro;
	private JTextField txtEditorialLibro;
	private JTextField txtAutorLibro;
	private JTextField txtTitluoLibro;

	private GestorLibros gl;
	private JFrame padre;

	public IAltaLibro(GestorLibros gl, JFrame padre) {

		super(Utilitario.ANCHO_LIBROS, Utilitario.LARGO_LIBROS);

		this.gl = gl;
		this.padre = padre;

		// Para solo aceptar nros como input
		MyNumberFormatter formatter = new MyNumberFormatter(NumberFormat.getIntegerInstance());
		formatter.setValueClass(Long.class);
		formatter.setAllowsInvalid(false);

		// Elementos
		MyLabel lblTitulo = new MyLabel(":-: ALTA LIBRO :-:", Utilitario.FONT_TITULOS);
		MyLabel lblElegirOpcion = new MyLabel(":-:  COMPLETE LOS CAMPOS  :-:", Utilitario.FONT_TITULOS);
		MyLabel lblIsbn = new MyLabel("ISBN: ", Utilitario.FONT_CAMPOS);
		MyLabel lblTituloLibro = new MyLabel("Título: ", Utilitario.FONT_CAMPOS);
		MyLabel lblAutorLibro = new MyLabel("Autor: ", Utilitario.FONT_CAMPOS);
		MyLabel lblEditorialLibro = new MyLabel("Editorial: ", Utilitario.FONT_CAMPOS);
		MyLabel lblEdicionLibro = new MyLabel("Edicion: ", Utilitario.FONT_CAMPOS);
		MyLabel lblAnioLibro = new MyLabel("Año Publicación: ", Utilitario.FONT_CAMPOS);

		MyButton btnVoler = new MyButton("Volver");
		MyButton btnAnadir = new MyButton("Añadir");

		txtIsbn = new JTextField("");
		txtTitluoLibro = new JTextField("");
		txtAutorLibro = new JTextField("");
		txtEditorialLibro = new JTextField("");
		txtEdicionLibro = new JFormattedTextField(formatter);
		txtAnioLibro = new JFormattedTextField(formatter);

		// Disponer elementos
		anadirObjeto(lblTitulo, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		anadirObjeto(lblElegirOpcion, contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 2, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblIsbn, contentPane, layout, gbc, 0, 3, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtIsbn, contentPane, layout, gbc, 3, 3, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 4, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblTituloLibro, contentPane, layout, gbc, 0, 5, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtTitluoLibro, contentPane, layout, gbc, 3, 5, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 6, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblAutorLibro, contentPane, layout, gbc, 0, 7, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtAutorLibro, contentPane, layout, gbc, 3, 7, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 8, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblEditorialLibro, contentPane, layout, gbc, 0, 9, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtEditorialLibro, contentPane, layout, gbc, 3, 9, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 10, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblEdicionLibro, contentPane, layout, gbc, 0, 11, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtEdicionLibro, contentPane, layout, gbc, 3, 11, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 12, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblAnioLibro, contentPane, layout, gbc, 0, 13, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtAnioLibro, contentPane, layout, gbc, 3, 13, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 14, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnVoler, contentPane, layout, gbc, 0, 15, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createHorizontalStrut(200), contentPane, layout, gbc, 1, 15, 3, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);

		anadirObjeto(btnAnadir, contentPane, layout, gbc, 4, 15, 1, 1, GridBagConstraints.CENTER,
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

		btnAnadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});

	}

	public void registrar() {

		String isbn = txtIsbn.getText();
		String titulo = txtTitluoLibro.getText();
		String autor = txtAutorLibro.getText();
		String editorial = txtEditorialLibro.getText();

		if (esVacio(isbn) || esVacio(titulo) || esVacio(autor) || esVacio(editorial)
				|| txtEdicionLibro.getValue() == null || txtEdicionLibro.getValue() == null) {
			mensajeError(Utilitario.MSJ_CAMPOS_VACIOS);
			return;
		}
		
		int edicion = ((Number)txtEdicionLibro.getValue()).intValue();
		int anioPublicacion = ((Number)txtEdicionLibro.getValue()).intValue();

		if (gl.existeLibro(isbn)) {
			mensajeError(Utilitario.MSJ_LIBRO_EXISTE);
			return;
		}

		if (gl.altaLibro(isbn, titulo, autor, editorial, edicion, anioPublicacion)) {
			mensajeExito(Utilitario.MSJ_LIBRO_REGISTRADO);
			return;
		} else {
			mensajeError(Utilitario.MSJ_LIBRO_ERROR);
			return;
		}

	}
}
