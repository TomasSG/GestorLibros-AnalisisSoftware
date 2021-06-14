package Frontend;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.GestorLibros;
import Backend.Libro;

public class IConsultarActualizarEliminarLibro extends MyFrame {
	private GestorLibros gl;
	private JFrame padre;

	private JComboBox<String> comboIsbn;
	private JTextField txtAnioLibro;
	private JTextField txtEdicionLibro;
	private JTextField txtEditorialLibro;
	private JTextField txtAutorLibro;
	private JTextField txtTitluoLibro;

	public IConsultarActualizarEliminarLibro(GestorLibros gl, JFrame padre) {
		super(750, Utilitario.LARGO_LIBROS);

		this.gl = gl;
		this.padre = padre;

		// Elementos
		MyLabel lblTitulo = new MyLabel(":-: CONSULTAR/ACTUALIZAR/ELIMINAR LIBRO :-:", Utilitario.FONT_TITULOS);
		MyLabel lblElegirOpcion = new MyLabel(":-:  ELIJA UN ISBN  :-:", Utilitario.FONT_TITULOS);
		MyLabel lblIsbn = new MyLabel("ISBN: ", Utilitario.FONT_CAMPOS);
		MyLabel lblTituloLibro = new MyLabel("Título: ", Utilitario.FONT_CAMPOS);
		MyLabel lblAutorLibro = new MyLabel("Autor: ", Utilitario.FONT_CAMPOS);
		MyLabel lblEditorialLibro = new MyLabel("Editorial: ", Utilitario.FONT_CAMPOS);
		MyLabel lblEdicionLibro = new MyLabel("Edicion: ", Utilitario.FONT_CAMPOS);
		MyLabel lblAnioLibro = new MyLabel("Año Publicación: ", Utilitario.FONT_CAMPOS);

		MyButton btnVoler = new MyButton("Volver");
		MyButton btnActualizar = new MyButton("Modificar Libro");
		MyButton btnEliminar = new MyButton("Eliminar Libro");

		comboIsbn = new JComboBox<String>();
		llenarCombo();

		txtTitluoLibro = new JTextField("");
		txtAutorLibro = new JTextField("");
		txtEditorialLibro = new JTextField("");
		txtEdicionLibro = new JTextField("");
		txtAnioLibro = new JTextField("");

		// Disponer elementos
		anadirObjeto(lblTitulo, contentPane, layout, gbc, 0, 0, 7, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		anadirObjeto(lblElegirOpcion, contentPane, layout, gbc, 0, 1, 7, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 2, 7, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblIsbn, contentPane, layout, gbc, 1, 3, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(comboIsbn, contentPane, layout, gbc, 4, 3, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 4, 7, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblTituloLibro, contentPane, layout, gbc, 1, 5, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtTitluoLibro, contentPane, layout, gbc, 4, 5, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 6, 7, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblAutorLibro, contentPane, layout, gbc, 1, 7, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtAutorLibro, contentPane, layout, gbc, 4, 7, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 8, 7, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblEditorialLibro, contentPane, layout, gbc, 1, 9, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtEditorialLibro, contentPane, layout, gbc, 4, 9, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 10, 7, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblEdicionLibro, contentPane, layout, gbc, 1, 11, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtEdicionLibro, contentPane, layout, gbc, 4, 11, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 12, 7, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(lblAnioLibro, contentPane, layout, gbc, 1, 13, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(txtAnioLibro, contentPane, layout, gbc, 4, 13, 3, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 14, 7, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnVoler, contentPane, layout, gbc, 0, 15, 1, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createHorizontalStrut(75), contentPane, layout, gbc, 1, 15, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(btnActualizar, contentPane, layout, gbc, 2, 15, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createHorizontalStrut(75), contentPane, layout, gbc, 4, 15, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(btnEliminar, contentPane, layout, gbc, 5, 15, 2, 1, GridBagConstraints.PAGE_START,
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

		comboIsbn.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					consultarLibro(e.getItem().toString());
				}
			}
		});

		btnActualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String isbn = comboIsbn.getSelectedItem().toString();
				String titulo = txtTitluoLibro.getText();
				String autor = txtAutorLibro.getText();
				String editorial = txtEditorialLibro.getText();
				String edicion = txtEdicionLibro.getText();
				String anio = txtAnioLibro.getText();
				actualizarLibro(isbn, titulo, autor, editorial, edicion, anio);
			}
		});

		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarLibro(comboIsbn.getSelectedItem().toString());
			}
		});

		consultarLibro(comboIsbn.getItemAt(0).toString());
	}

	protected void eliminarLibro(String isbn) {

		// Pedimos una confirmación por parte del usuario
		if (mensajeRealizarOperacion() == JOptionPane.NO_OPTION) {
			return;
		}
		
		// Lo eleminamos de los registros
		gl.eliminarLibro(isbn);
		
		// Registramos en el log
		gl.registrarLog("Libro Eliminado: " + isbn);
		
		// Mostramos un msj de éxito
		mensajeExito(Utilitario.MSJ_LIBRO_BORRADO);
		
		// Volvemos a la pantalla previa
		volver(padre);
	}

	protected void actualizarLibro(String isbn, String titulo, String autor, String editorial, String edicion,
			String anioPublicacion) {

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
		if (!gl.esEdicion(edicion)) {
			// Damos un mensaje de error para el usuario
			mensajeError(Utilitario.MSJ_ERROR_EDICION);
			// Retornamos para no realizar la operacaion
			return;
		}

		// Validacion de que el año sea valido
		if (!gl.esAnioPublicacion(anioPublicacion)) {
			// Damos un mensaje de error para el usuario
			mensajeError(Utilitario.MSJ_ERROR_ANIO);
			// Retornamos para no realizar la operacaion
			return;
		}

		// No validamos que exista el libro porque el ISBN es elegido dentro de la lista
		
		// Actualizamos el libro
		gl.actualizarLibro(isbn, titulo, autor, editorial, Integer.valueOf(edicion), Integer.valueOf(anioPublicacion));

		// Mostramos un mensaje de exito al autor
		mensajeExito(Utilitario.MSJ_LIBRO_ACTUALIZADO);
		
		// Registramos en el log
		gl.registrarLog("Libro Actualizado: " + new Libro(isbn, titulo, autor, editorial, Integer.valueOf(edicion),
				Integer.valueOf(anioPublicacion)));
		
		// Volvemos a la pantalla previa
		volver(padre);
	}

	protected void consultarLibro(String isbn) {
		
		// Como el ISBN se carga de un combobox no es posible que no exista el libro previamente
		Libro libro = gl.consultarLibro(isbn);

		// Rellenamos los campos con los datos del libro
		establecerCampos(libro.getTitulo(), libro.getAutor(), libro.getEditorial(), String.valueOf(libro.getEdicion()),
				String.valueOf(libro.getAnioPublicacion()));
	}

	private void establecerCampos(String titulo, String autor, String editorial, String edicion, String anioPublicacion) {
		txtTitluoLibro.setText(titulo);
		txtAutorLibro.setText(autor);
		txtEditorialLibro.setText(editorial);
		txtEdicionLibro.setText(edicion);
		txtAnioLibro.setText(anioPublicacion);
	}

	private void llenarCombo() {
		Vector<Libro> libros = gl.listarLibros();

		if (libros.isEmpty()) {
			mensajeError(Utilitario.MSJ_ERROR_LISTA_LIBROS_VACIA);
			return;
		}

		for (Libro libro : libros) {
			comboIsbn.addItem(libro.getIsbn());
		}
	}
}
