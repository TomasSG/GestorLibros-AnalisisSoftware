package Frontend;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import Backend.GestorLibros;

public class IIngresoDatos extends MyFrame {

	private GestorLibros gl;

	public IIngresoDatos(GestorLibros gl, JFrame padre) {

		super(Utilitario.ANCHO_LIBROS, Utilitario.LARGO_LIBROS);

		this.gl = gl;

		// Elementos
		MyLabel lblTitulo = new MyLabel(":-: CENTRO GESTIÓN DE LIBROS :-:", Utilitario.FONT_TITULOS);
		MyLabel lblElegirOpcion = new MyLabel(":-:  Eija la opción deseada  :-:", Utilitario.FONT_TITULOS);

		MyButton btnAltaLibro = new MyButton("Alta Libro");
		MyButton btnConsultarActualizarEliminarLibro = new MyButton("Consultar/Actualizar/Eliminar Libro");
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

		anadirObjeto(btnConsultarActualizarEliminarLibro, contentPane, layout, gbc, 0, 5, 5, 1, GridBagConstraints.CENTER,
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

		btnConsultarActualizarEliminarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abriraPantalla(2);
			}
		});

		btnListarLibros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abriraPantalla(3);
			}
		});
		
		btnOrdenarLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gl.ordenarLibros();
				gl.registrarLog("Libros ordenados");
				mensajeExito(Utilitario.MSJ_LIBROS_ORDENADOS);
			}
		});
	}

	public void abriraPantalla(int opcion) {
		JFrame pantalla = null;

		if (opcion == 1) {
			pantalla = new IAltaLibro(gl, this);
		} else if (opcion == 2) {
			pantalla = new IConsultarActualizarEliminarLibro(gl, this);
		} else if (opcion == 3) {
			pantalla = new IListarLibros(gl, this);
		}

		pantalla.setLocationRelativeTo(null);
		pantalla.setVisible(true);
		this.setVisible(false);
	}
}
