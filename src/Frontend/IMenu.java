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

public class IMenu extends MyFrame {

	private GestorLibros gl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMenu frame = new IMenu();
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
	public IMenu() {

		super(Utilitario.ANCHO_LIBROS, Utilitario.LARGO_LIBROS);

		gl = new GestorLibros();
		try {
			gl.iniciar();
		} catch (FileNotFoundException e) {
			mensajeError(Utilitario.MSJ_ERROR_BD);
			this.dispose();
		}

		// Elementos
		MyLabel lblTitulo = new MyLabel(":-: CENTRO GESTIÓN DE LIBROS :-:", Utilitario.FONT_TITULOS);
		MyLabel lblElegirOpcion = new MyLabel(":-:  Eija la opción deseada  :-:", Utilitario.FONT_TITULOS);

		MyButton btnIngresoDatos = new MyButton("Ingreso de Datos");
		MyButton btnAyuda = new MyButton("Ayuda");
		MyButton btnSalir = new MyButton("Salir");

		// Disponer elementos
		anadirObjeto(lblTitulo, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		anadirObjeto(lblElegirOpcion, contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 2, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnIngresoDatos, contentPane, layout, gbc, 0, 3, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 4, 2, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnAyuda, contentPane, layout, gbc, 0, 5, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 6, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(btnSalir, contentPane, layout, gbc, 0, 7, 5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH);

		// Acciones de los botones
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int resultado = mensajeCerrarVentana();

				if (resultado == JOptionPane.YES_OPTION) {
					cerrarVentana(we.getWindow(), gl);
				}
			}
		});

		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int resultado = mensajeCerrarVentana();

				if (resultado == JOptionPane.YES_OPTION) {
					cerrarVentana(IMenu.this, gl);
				}

			}
		});

		btnAyuda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ayuda();
			}
		});

		btnIngresoDatos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ingresarDatos();
			}
		});
	}

	public void ayuda() {
		IAyuda pantallaAyuda = new IAyuda(this);
		pantallaAyuda.setLocationRelativeTo(null);
		pantallaAyuda.setVisible(true);
		this.setVisible(false);
	}

	public void ingresarDatos() {
		IIngresoDatos pantallaIngreso = new IIngresoDatos(gl, this);
		pantallaIngreso.setLocationRelativeTo(null);
		pantallaIngreso.setVisible(true);
		this.setVisible(false);
	}
}
