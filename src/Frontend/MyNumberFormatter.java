package Frontend;

import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.text.NumberFormatter;

public class MyNumberFormatter extends NumberFormatter{

	public MyNumberFormatter(NumberFormat nf) {
		super(nf);
	}
	
	@Override
	public Object stringToValue(String text) throws ParseException {
		if(text.isEmpty()) {
			return null;
		} else {
			return super.stringToValue(text);
		}		
	}
}
