package Frontend;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import Backend.GestorLibros;
import Backend.Libro;

public class IAltaLibro extends MyFrame {

	private JTextField txtIsbn;
	private JTextField txtAnioLibro;
	private JTextField txtEdicionLibro;
	private JTextField txtEditorialLibro;
	private JTextField txtAutorLibro;
	private JTextField txtTitluoLibro;

	private GestorLibros gl;

	public IAltaLibro(GestorLibros gl, JFrame padre) {

		super(Utilitario.ANCHO_LIBROS, Utilitario.LARGO_LIBROS);

		this.gl = gl;

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
		txtEdicionLibro = new JTextField("");
		txtAnioLibro = new JTextField("");

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
				// Bloque de inicialización de variables
				String isbn = txtIsbn.getText();
				String titulo = txtTitluoLibro.getText();
				String autor = txtAutorLibro.getText();
				String editorial = txtEditorialLibro.getText();
				String edicion = txtEdicionLibro.getText();
				String anioPublicacion = txtAnioLibro.getText();

				registrar(isbn, titulo, autor, editorial, edicion, anioPublicacion);
			}
		});

	}

	public void registrar(String isbn, String titulo, String autor, String editorial, String edicion,
			String anioPublicacion) {

		// Validacion de que el ISBN sea valido
		if (!gl.esIsbn(isbn)) {
			// Damos un mensaje de error para el usuario
			mensajeError(Utilitario.MSJ_ERROR_ISBN);
			// Retornamos para no realizar la operacaion
			return;
		}

		// Validacion de que el Titulo sea valido
		if (!gl.esTexto(titulo)) {
			// Damos un mensaje de error para el usuario
			mensajeError(Utilitario.MSJ_ERROR_TITULO);
			// Retornamos para no realizar la operacaion
			return;
		}

		// Validacion de que el Autor sea valido
		if (!gl.esTexto(autor)) {
			// Damos un mensaje de error para el usuario
			mensajeError(Utilitario.MSJ_ERROR_AUTOR);
			// Retornamos para no realizar la operacaion
			return;
		}

		// Validacion de que la editorial sea valida
		if (!gl.esTexto(editorial)) {
			// Damos un mensaje de error para el usuario
			mensajeError(Utilitario.MSJ_ERROR_EDITORIAL);
			// Retornamos para no realizar la operacaion
			return;
		}

		// Validacion de que la edición sea valida
		if (!gl.esNumero(edicion)) {
			// Damos un mensaje de error para el usuario
			mensajeError(Utilitario.MSJ_ERROR_EDICION);
			// Retornamos para no realizar la operacaion
			return;
		}

		// Validacion de que el año sea valido
		if (!gl.esNumero(anioPublicacion)) {
			// Damos un mensaje de error para el usuario
			mensajeError(Utilitario.MSJ_ERROR_ANIO);
			// Retornamos para no realizar la operacaion
			return;
		}

		// Validacion de que el libro no exista previamente
		if (gl.existeLibro(isbn)) {
			// Damos un mensaje de error para el usuario
			mensajeError(Utilitario.MSJ_ERROR_ISBN_DUPLICADO);
			// Retornamos para no realizar la operacaion
			return;
		}

		// Damos de alta el libro porque todos los campso son correcrtos
		gl.altaLibro(isbn, titulo, autor, editorial, Integer.valueOf(edicion),
				Integer.valueOf(anioPublicacion));
		// Le damos un mensaje de éxito al usuario
		mensajeExito(Utilitario.MSJ_LIBRO_REGISTRADO);
		// Generamos una entrada en el log por si ocurre alguna falla
		gl.registrarLog("Alta Libro: " + new Libro(isbn, titulo, autor, editorial, Integer.valueOf(edicion),
				Integer.valueOf(anioPublicacion)));
	}
}
