package Frontend;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyLabel extends JLabel{

	public MyLabel(String texto, Font font) {
		super(texto);
		this.setFont(font);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
