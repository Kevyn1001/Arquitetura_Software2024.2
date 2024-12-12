package camadaDominio;

import entidades.UsuarioDTO;

public class GerenciarUsuarioRT {

    public UsuarioDTO identificarUsuario(String email, String senha) {
        // Simulating database access logic
        // This would typically involve calling a method from a Data Access Object (DAO) class
        // For demonstration, we assume a user exists if the password contains "secure" and email contains "@"
        if (email.contains("@") && senha.contains("secure")) {
            return new UsuarioDTO("John Doe", email, senha);
        }
        return null;
    }
}
