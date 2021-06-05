package Backend;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Encriptador {

	public byte[] encriptarSHA256(String plainText) {
		byte[] contraseniaSegura = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance(Constantes.ALGORITMO_SHA256);
			contraseniaSegura = md.digest(plainText.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return contraseniaSegura;
	}
	

}
