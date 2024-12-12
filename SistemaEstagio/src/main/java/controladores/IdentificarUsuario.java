package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import camadaDados.UsuarioGateway;
import camadaDominio.UsuarioMTE;
import entidades.Usuario;

/**
 * Servlet implementation class IdentificarUsuario
 */
@WebServlet("/IdentificarUsuario")
public class IdentificarUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdentificarUsuario() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém os parâmetros de email e senha
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Validação básica dos parâmetros
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            request.setAttribute("errorMessage", "Email e senha são obrigatórios.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        // Validação dos dados
        boolean dadosValidos = UsuarioMTE.verificarDados(email, senha);
        if (dadosValidos) {
            // Busca o usuário no banco de dados
            Usuario usuario = new UsuarioGateway().buscarUsuario(email, senha);

            if (usuario != null) {
                // Adiciona o usuário à sessão
                request.getSession().setAttribute("usuario", usuario);
                // Redireciona para a página inicial ou dashboard
                response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
                return;
            }
        }

        // Caso a autenticação falhe
        request.setAttribute("errorMessage", "Credenciais inválidas. Tente novamente.");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
