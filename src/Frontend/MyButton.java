package Frontend;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MyButton extends JButton{

	public MyButton(String texto) {
		super(texto);
		this.setFont(new Font("Arial", Font.PLAIN, 17));
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
