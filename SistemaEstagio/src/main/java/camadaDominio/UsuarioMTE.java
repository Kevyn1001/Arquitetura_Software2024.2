package camadaDominio;

public class UsuarioMTE {
	public static boolean verificarDados(String email, String senha) {
		return email != null && !email.isBlank() && senha != null && !senha.isBlank();
	}
}
