package Frontend;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Backend.Constantes;
import Backend.FileManager;

public class IAyuda extends MyFrame {

	private JFrame padre;

	public IAyuda(JFrame padre) {

		super(Utilitario.ANCHO_LIBROS, Utilitario.LARGO_LIBROS);
		this.padre = padre;

		FileManager fm = new FileManager();
		ArrayList<String> textoAyuda = null;
		try {
			textoAyuda = fm.leerArchivoAyuda(Constantes.PATH_AYUDA);
		} catch (FileNotFoundException e1) {
			mensajeError(Utilitario.MSJ_ERROR_BD);
			volver(padre);
		}
		
		
		
		// Elementos
		MyLabel lblTitulo = new MyLabel(":-: AYUDA :-:", Utilitario.FONT_TITULOS);
		
		MyButton btnVoler = new MyButton("Volver");

		JTextArea ayuda = new JTextArea();
		ayuda.setEditable(false);
		ayuda.setPreferredSize(new Dimension(500, 500));
		for(String linea : textoAyuda) {
			ayuda.append(linea + "\n");
		}
		JScrollPane areaAyuda = new JScrollPane(ayuda);
		

		// Disponer elementos
		anadirObjeto(lblTitulo, contentPane, layout, gbc, 0, 0, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);
		
		anadirObjeto(Box.createVerticalStrut(50), contentPane, layout, gbc, 0, 1, 5, 1, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH);

		anadirObjeto(areaAyuda, contentPane, layout, gbc, 0, 2, 5, 1, GridBagConstraints.PAGE_START,
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
		this.pack();
	}
}
