package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import camadaDominio.PedidoEstagioRT;
import camadaDominio.SituacaoDiscente;
import entidades.PedidoEstagioDTO;

/**
 * Servlet implementation class PedidoIntencaoEstagio
 */
@WebServlet("/PedidoIntencaoEstagio")
public class PedidoIntencaoEstagio extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PedidoEstagioRT pedidoEstagioRT;

    public PedidoIntencaoEstagio() {
        super();
        this.pedidoEstagioRT = new PedidoEstagioRT(); // Instância do gerenciador de pedidos
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Extraindo parâmetros do request
            String nomeEmpresa = request.getParameter("nomeEmpresa");
            String enderecoEmpresa = request.getParameter("enderecoEmpresa");
            String modalidadeEstagio = request.getParameter("modalidadeEstagio");
            int cargaHorariaSemanal = Integer.parseInt(request.getParameter("cargaHorariaSemanal"));
            float valorBolsa = Float.parseFloat(request.getParameter("valorBolsa"));
            String resumo = request.getParameter("resumo");
            String relacaoConteudo = request.getParameter("relacaoConteudo");
            String motivoEstagio = request.getParameter("motivoEstagio");

            int numeroPedido = Integer.parseInt(request.getParameter("numeroPedido")); // Identificador do pedido

            // Criando o DTO do pedido
            PedidoEstagioDTO pedido = new PedidoEstagioDTO(
                numeroPedido, nomeEmpresa, enderecoEmpresa, modalidadeEstagio,
                cargaHorariaSemanal, valorBolsa, resumo, relacaoConteudo, motivoEstagio
            );

            // Validando e criando o pedido de estágio
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
