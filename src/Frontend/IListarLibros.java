package Frontend;

import java.awt.GridBagConstraints;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.rmi.CORBA.Util;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Backend.GestorLibros;
import Backend.Libro;

public class IListarLibros extends MyFrame {

	private GestorLibros gl;
	private JFrame padre;

	public IListarLibros(GestorLibros gl, JFrame padre) {
		super(Utilitario.ANCHO_LIBROS, 700);

		this.gl = gl;
		this.padre = padre;

		// Elemetos
		MyLabel lblTitulo = new MyLabel(":-: LISTA DE LIBROS REGISTRADOS :-:", Utilitario.FONT_TITULOS);

		MyButton btnVoler = new MyButton("Volver");

		// Para la tabla
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable tabla = new JTable(modeloTabla);
		tabla.setBounds(0, 0, 200, 200);
		llenarTabla(modeloTabla);
		JScrollPane scroll = new JScrollPane(tabla);

		// Disposición elementos

		anadirObjeto(lblTitulo, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(scroll, contentPane, layout, gbc, 0, 2, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 14, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnVoler, contentPane, layout, gbc, 0, 15, 5, 1, GridBagConstraints.PAGE_START,
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
	}

	private void llenarTabla(DefaultTableModel modeloTabla) {
		Vector<Libro> libros = gl.listarLibros();

		modeloTabla.setColumnIdentifiers(Utilitario.CAMPOS_LIBROS);

		if (libros.isEmpty()) {
			mensajeError(Utilitario.MSJ_LISTA_VACIA);
			return;
		}

		for (Libro libro : libros) {
			Object[] registro = new Object[] { libro.getIsbn(), libro.getTitulo(), libro.getAutor(),
					libro.getEditorial(), String.valueOf(libro.getEdicion()),
					String.valueOf(libro.getAnioPublicacion()) };
			modeloTabla.addRow(registro);
		}

	}

}
