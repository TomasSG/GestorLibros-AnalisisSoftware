package Backend;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Encriptador {
	
	private static final SecureRandom RAND = new SecureRandom();
	private static final int ITERACIONES = 65536;
	private static final int LARGO_LLAVE = 512;
	private static final String ALGORITMO = "PBKDF2WithHmacSHA512";

	private Optional<String> hashContrasenia(String contrasenia, String salt) {
		
		char[] chars = contrasenia.toCharArray();
		byte[] bytes = salt.getBytes();
		PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERACIONES, LARGO_LLAVE);
		
		// Limpiar el vector con la contrase�a
		Arrays.fill(chars, Character.MIN_VALUE);
		
		try {
			SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITMO);
			byte[] contraseniaSegura = fac.generateSecret(spec).getEncoded();
			return Optional.of(Base64.getEncoder().encodeToString(contraseniaSegura));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			System.out.println("Excepci�n encontrada al aplicar la operaci�n de hash");
			return Optional.empty();
		} finally {
			spec.clearPassword();
		}
	}
	
	private Optional<String> generarSalt(int len) {
		byte[] salt = new byte[len];
		RAND.nextBytes(salt);
		return Optional.of(Base64.getEncoder().encodeToString(salt));
	}
	
	public boolean verificarContrasenia(String contrasenia, String contraseniaSegura, String salt) {
		Optional<String> opt = hashContrasenia(contrasenia, salt);
		return opt.get().equals(contraseniaSegura);
	}
	
	public String encriptarContrasenia(String contrasenia, int saltNro) {
		String salt = generarSalt(saltNro).get();
		String contraseniaSegura = hashContrasenia(contrasenia, salt).get();
		return contraseniaSegura;
	}
}
