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
import javax.swing.JPanel;
import javax.swing.JTextField;

import Backend.GestorLibros;
import Backend.Libro;

public class IConsultarActualizarEliminarLibro extends MyFrame {
	private GestorLibros gl;
	private JFrame padre;

	private JComboBox<String> comboIsbn;
	private JFormattedTextField txtAnioLibro;
	private JFormattedTextField txtEdicionLibro;
	private JTextField txtEditorialLibro;
	private JTextField txtAutorLibro;
	private JTextField txtTitluoLibro;

	public IConsultarActualizarEliminarLibro(GestorLibros gl, JFrame padre) {
		super(750, Utilitario.LARGO_LIBROS);

		this.gl = gl;
		this.padre = padre;

		// Para solo aceptar nros como input
		MyNumberFormatter formatter = new MyNumberFormatter(NumberFormat.getIntegerInstance());
		formatter.setValueClass(Long.class);
		formatter.setAllowsInvalid(false);

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
		txtEdicionLibro = new JFormattedTextField(formatter);
		txtAnioLibro = new JFormattedTextField(formatter);

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
				actualizarLibro();
			}
		});

		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarLibro();

			}
		});

		consultarLibro(comboIsbn.getItemAt(0).toString());
	}

	protected void eliminarLibro() {

		gl.eliminarLibro(comboIsbn.getSelectedItem().toString());
		mensajeExito(Utilitario.MSJ_LIBRO_BORRADO);
		volver(padre);
	}

	protected void actualizarLibro() {
		String isbn = comboIsbn.getSelectedItem().toString();
		String titulo = txtTitluoLibro.getText();
		String autor = txtAutorLibro.getText();
		String editorial = txtEditorialLibro.getText();

		if (esVacio(titulo) || esVacio(autor) || esVacio(editorial) || txtEdicionLibro.getValue() == null
				|| txtAnioLibro.getValue() == null) {
			mensajeError(Utilitario.MSJ_CAMPOS_VACIOS);
			return;
		}

		int edicion = ((Number) txtEdicionLibro.getValue()).intValue();
		int anioPublicacion = ((Number) txtAnioLibro.getValue()).intValue();

		if (gl.actualizarLibro(isbn, titulo, autor, editorial, edicion, anioPublicacion)) {
			mensajeExito(Utilitario.MSJ_LIBRO_ACTUALIZADO);
			volver(padre);
		} else {
			mensajeError(Utilitario.MSJ_LIBRO_ACTUALIZAR_ERROR);
		}
	}

	protected void consultarLibro(String isbn) {
		Libro libro = gl.consultarLibro(isbn);

		if (libro == null) {
			mensajeError(Utilitario.MSJ_LIBRO_NO_ENCONTRADO);
			return;
		}

		establecerCampos(libro.getTitulo(), libro.getAutor(), libro.getEditorial(), libro.getEdicion(),
				libro.getAnioPublicacion());

	}

	private void establecerCampos(String titulo, String autor, String editorial, int edicion, int anioPublicacion) {
		txtTitluoLibro.setText(titulo);
		txtAutorLibro.setText(autor);
		txtEditorialLibro.setText(editorial);
		txtEdicionLibro.setValue(edicion);
		txtAnioLibro.setValue(anioPublicacion);
	}

	private void llenarCombo() {
		Vector<Libro> libros = gl.listarLibros();

		if (libros.isEmpty()) {
			mensajeError(Utilitario.MSJ_LISTA_VACIA);
			return;
		}

		for (Libro libro : libros) {
			comboIsbn.addItem(libro.getIsbn());
		}
	}
}
