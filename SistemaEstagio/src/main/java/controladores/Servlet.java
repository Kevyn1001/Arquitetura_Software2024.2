package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import camadaDados.PerfilGateway;
import camadaDados.UsuarioGateway;
import camadaDominio.GerenciarUsuarioRT;
import camadaDominio.PedidoEstagioRT;
import entidades.Perfil;
import entidades.PedidoEstagioDTO;
import entidades.UsuarioDTO;

@WebServlet(urlPatterns = {"/IdentificarUsuario", "/Index", "/PedidoIntencaoEstagio"})
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private GerenciarUsuarioRT gerenciarUsuarioRT;
    private PedidoEstagioRT pedidoEstagioRT;

    public Servlet() {
        super();
        this.gerenciarUsuarioRT = new GerenciarUsuarioRT(); // Instância de lógica de domínio
        this.pedidoEstagioRT = new PedidoEstagioRT(); // Instância do gerenciador de pedidos
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/Index":
                tratarIndex(request, response);
                break;
            default:
                request.getRequestDispatcher("/WEB-INF/jsps/Login.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/IdentificarUsuario":
                tratarIdentificarUsuario(request, response);
                break;
            case "/PedidoIntencaoEstagio":
                tratarPedidoIntencaoEstagio(request, response);
                break;
            default:
                response.sendRedirect("/login.jsp");
                break;
        }
    }

    private void tratarIdentificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
                request.setAttribute("errorMessage", "Email e senha são obrigatórios.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }

            UsuarioDTO usuario = gerenciarUsuarioRT.identificarUsuario(email, senha);

            if (usuario != null) {
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
                return;
            }

            request.setAttribute("errorMessage", "Credenciais inválidas. Tente novamente.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erro interno. Por favor, tente novamente mais tarde.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void tratarIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Perfil perfil = (Perfil) request.getSession().getAttribute("perfil");
            if (new PerfilGateway().verificarPerfilAtivo().isEmpty()) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsps/Login.jsp");
                dispatcher.forward(request, response);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsps/CriarPedidoIntencaoEstagio.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/jsps/Login.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void tratarPedidoIntencaoEstagio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String nomeEmpresa = request.getParameter("nomeEmpresa");
            String enderecoEmpresa = request.getParameter("enderecoEmpresa");
            String modalidadeEstagio = request.getParameter("modalidadeEstagio");
            int cargaHorariaSemanal = Integer.parseInt(request.getParameter("cargaHorariaSemanal"));
            float valorBolsa = Float.parseFloat(request.getParameter("valorBolsa"));
            String resumo = request.getParameter("resumo");
            String relacaoConteudo = request.getParameter("relacaoConteudo");
            String motivoEstagio = request.getParameter("motivoEstagio");

            int numeroPedido = Integer.parseInt(request.getParameter("numeroPedido"));

            PedidoEstagioDTO pedido = new PedidoEstagioDTO(
                numeroPedido, nomeEmpresa, enderecoEmpresa, modalidadeEstagio,
                cargaHorariaSemanal, valorBolsa, resumo, relacaoConteudo, motivoEstagio
            );

            boolean criado = pedidoEstagioRT.criarPedidoEstagio(pedido);

            if (criado) {
                enviarMensagem(out, "Pedido de estágio criado com sucesso!");
            } else {
                enviarMensagem(out, "Erro ao criar o pedido de estágio. Verifique os dados.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace(out);
            enviarMensagem(out, "Erro: Verifique se todos os valores numéricos estão corretos.");
        } catch (Exception e) {
            e.printStackTrace(out);
            enviarMensagem(out, "Erro no processamento do pedido. Tente novamente.");
        }
    }

    private void enviarMensagem(PrintWriter out, String mensagem) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('" + mensagem + "');");
        out.println("location='formulario.html';");
        out.println("</script>");
    }
}
