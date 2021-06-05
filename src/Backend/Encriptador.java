package Backend;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Encriptador {

	public String encriptarSHA256(String plainText) {
		String contraseniaSegura = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance(Constantes.ALGORITMO_SHA256);
			byte[] salt = getSalt();
			
			md.update(salt);
			byte[] bytes = md.digest(plainText.getBytes());
			
			contraseniaSegura = new String(bytes);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		return contraseniaSegura;
	}
	
	private byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance(Constantes.ALGORITMO_NUMERO_RANDOM);
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}
}
