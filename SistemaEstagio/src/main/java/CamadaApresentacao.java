import java.util.Scanner;

import camadaDominio.GerenciarUsuarioRT;
import entidades.UsuarioDTO;

public class CamadaApresentacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciarUsuarioRT roteiro = new GerenciarUsuarioRT();
        UsuarioDTO usuario;

        System.out.println("Informe o email do usuário:");
        String email = scanner.nextLine();

        System.out.println("Informe a senha:");
        String senha = scanner.nextLine();

        // Início da identificação do usuário
        usuario = roteiro.identificarUsuario(email, senha);

        if (usuario != null) {
            System.out.println("Usuário identificado com sucesso!");
            System.out.println("Nome: " + usuario.getNome());
            // Outras operações baseadas nos resultados dos DSS e DSF
        } else {
            System.out.println("Usuário não encontrado ou dados inválidos.");
        }

        scanner.close();
    }
}
