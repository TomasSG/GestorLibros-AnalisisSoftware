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

public class IMenu extends JFrame {

	private JPanel contentPane;
	private GridBagLayout layout;
	private GridBagConstraints gbc;
	
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
		
		gl = new GestorLibros();
		try {
			gl.iniciar();
		} catch (FileNotFoundException e) {
			Utilitario.mensajeError(Utilitario.MSJ_ERROR_BD);
			this.dispose();
		}
		
		
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
		
		JButton btnIngresoDatos = new JButton("Ingreso de Datos");
		btnIngresoDatos.setFont(new Font("Arial", Font.PLAIN, 17));
		btnIngresoDatos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setFont(new Font("Arial", Font.PLAIN, 17));
		btnAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 17));
		btnSalir.setHorizontalAlignment(SwingConstants.CENTER);

		
		// Disponer elementos 
		Utilitario.anadirObjeto(lblTitulo, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		Utilitario.anadirObjeto(lblElegirOpcion, contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 2, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(btnIngresoDatos, contentPane, layout, gbc, 0, 3, 5, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 4, 2, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(btnAyuda, contentPane, layout, gbc, 0, 5, 5, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(Box.createVerticalStrut(10), contentPane, layout, gbc, 0, 6, 5, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH);
		
		Utilitario.anadirObjeto(btnSalir, contentPane, layout, gbc, 0, 7, 5, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH); 
		
		// Acciones de los botones
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int resultado = Utilitario.mensajeCerrarVentana();
				
				if(resultado == JOptionPane.YES_OPTION) {
					cerrarVentana(we.getWindow());
				}
			}
		});
		
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resultado = Utilitario.mensajeCerrarVentana();
				
				if(resultado == JOptionPane.YES_OPTION) {
					cerrarVentana(IMenu.this);
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

	
	public void cerrarVentana(Window w) {
		try {
			gl.finalizar();
		} catch (FileNotFoundException e) {
			Utilitario.mensajeError(Utilitario.MSJ_ERROR_BD);
			w.dispose();
		}
		w.dispose();
	}
	
	public void ayuda() {
		// TODO: Implementar ayuda
	}
	
	public void ingresarDatos() {
		IIngresoDatos pantallaIngreso = new IIngresoDatos(gl, this);
		pantallaIngreso.setLocationRelativeTo(null);
		pantallaIngreso.setVisible(true);
		this.setVisible(false);
	}
}
