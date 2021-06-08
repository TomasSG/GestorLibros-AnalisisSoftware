package Frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

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
	private IMenu padre;

	public IIngresoDatos(GestorLibros gl, IMenu padre) {

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
		
		JButton btnActualizarrLibro = new JButton("Actualizar Libro");
		btnActualizarrLibro.setFont(new Font("Arial", Font.PLAIN, 17));
		btnActualizarrLibro.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		// Acciones de los botones
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int resultado = Utilitario.mensajeCerrarVentana();
				
				if(resultado == JOptionPane.YES_OPTION) {
					cerrarVentana(we.getWindow());
				}
			}
		});
	}
	
	public void cerrarVentana(Window w) {
		padre.setVisible(true);
		this.dispose();
	}

}
