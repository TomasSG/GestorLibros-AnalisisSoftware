package Backend;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import java.util.Vector;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Encriptador {

	private static final SecureRandom RAND = new SecureRandom();
	
	private Optional<String> hashContrasenia(String contrasenia, String salt) {

		char[] chars = contrasenia.toCharArray();
		byte[] bytes = salt.getBytes();
		PBEKeySpec spec = new PBEKeySpec(chars, bytes, Constantes.ITERACIONES, Constantes.LARGO_LLAVE);

		// Limpiar el vector con la contraseña
		Arrays.fill(chars, Character.MIN_VALUE);

		try {
			SecretKeyFactory fac = SecretKeyFactory.getInstance(Constantes.ALGORITMO);
			byte[] contraseniaSegura = fac.generateSecret(spec).getEncoded();
			return Optional.of(Base64.getEncoder().encodeToString(contraseniaSegura));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			System.out.println("Excepción encontrada al aplicar la operación de hash");
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
		if (!opt.isPresent()) {
			return false;
		}
		return opt.get().equals(contraseniaSegura);
	}

	public Vector<String> encriptarContrasenia(String contrasenia, int saltNro) {
		String salt = generarSalt(saltNro).get();
		String contraseniaSegura = hashContrasenia(contrasenia, salt).get();
		
		
		Vector<String> resultado = new Vector<String>();
		resultado.add(contraseniaSegura);
		resultado.add(salt);
		
		return resultado;
	}
}
