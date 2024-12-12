package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import camadaDados.UsuarioGateway;
import camadaDominio.GerenciarUsuarioRT;
import entidades.UsuarioDTO;

/**
 * Servlet implementation class IdentificarUsuario
 */
@WebServlet("/IdentificarUsuario")
public class IdentificarUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private GerenciarUsuarioRT gerenciarUsuarioRT;

    public IdentificarUsuario() {
        super();
        this.gerenciarUsuarioRT = new GerenciarUsuarioRT(); // Instância de lógica de domínio
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Configuração da resposta
        response.setContentType("text/html");

        try {
            // Obtém os parâmetros de email e senha
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            // Validação básica dos parâmetros
            if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
                request.setAttribute("errorMessage", "Email e senha são obrigatórios.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }

            // Validação e identificação do usuário
            UsuarioDTO usuario = gerenciarUsuarioRT.identificarUsuario(email, senha);

            if (usuario != null) {
                // Adiciona o usuário à sessão
                request.getSession().setAttribute("usuario", usuario);
                // Redireciona para a página inicial ou dashboard
                response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
                return;
            }

            // Caso a autenticação falhe
            request.setAttribute("errorMessage", "Credenciais inválidas. Tente novamente.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        } catch (Exception e) {
            // Lida com exceções e redireciona para a página de erro
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erro interno. Por favor, tente novamente mais tarde.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
