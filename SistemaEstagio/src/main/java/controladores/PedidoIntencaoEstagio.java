package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import camadaDados.PedidoEstagioGateway;
import camadaDominio.PedidoEstagioMTE;
import camadaDominio.SituacaoDiscente;
import entidades.ResultSet.ResultSet;

/**
 * Servlet implementation class PedidoIntencaoEstagio
 */
public class PedidoIntencaoEstagio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoIntencaoEstagio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       String nome = request.getParameter("nome");
       String matricula = request.getParameter("matricula");
       float IRA = Float.parseFloat(request.getParameter("IRA"));
       int cargaHorariaCumprida = Integer.parseInt(request.getParameter("cargaHorariaCumprida"));
       String endereco = request.getParameter("endereco");
       boolean primeiroEstagio = Integer.parseInt(request.getParameter("primeiroEstagio")) == 1;
       String nomeEmpresa = request.getParameter("nomeEmpresa");
       String enderecoEmpresa = request.getParameter("enderecoEmpresa");
       String modalidadeEstagio = request.getParameter("modalidadeEstagio");
       int cargaHorariaSemanal = Integer.parseInt(request.getParameter("cargaHorariaSemanal"));
       float valorBolsa = Float.parseFloat(request.getParameter("valorBolsa"));
       String resumo = request.getParameter("resumo");
       String relacaoConteudo = request.getParameter("relacaoConteudo");
       String motivoEstagio = request.getParameter("motivoEstagio");
       
       SituacaoDiscente st = PedidoEstagioMTE.verificarSituacaoDiscente(IRA, cargaHorariaCumprida);
       if (st != SituacaoDiscente.APROVADO) {    	   
    	   PrintWriter pw = response.getWriter();
    	   pw.println("<script type=\"text/javascript\">");
    	   pw.println("alert('" + st.toString() + "');");
    	   pw.println("</script>");
       }
       boolean stIntencao = PedidoEstagioMTE.verificaIntencaoEstagio(nome, matricula, IRA, cargaHorariaCumprida, 
    		   endereco, primeiroEstagio, nomeEmpresa, enderecoEmpresa, 
    		   modalidadeEstagio, cargaHorariaSemanal, valorBolsa, resumo, 
    		   relacaoConteudo, motivoEstagio);
       
       if (stIntencao) {
    	   ResultSet rs = new PedidoEstagioGateway().insert(nome, matricula, IRA, 
    			   cargaHorariaCumprida, endereco, primeiroEstagio, 
    			   nomeEmpresa, enderecoEmpresa, modalidadeEstagio, 
    			   cargaHorariaSemanal, valorBolsa, resumo, relacaoConteudo, motivoEstagio);
    	   if (!rs.isEmpty()) {
    		   PrintWriter pw = response.getWriter();
        	   pw.println("<script type=\"text/javascript\">");
        	   pw.println("alert('Pedido criado');");
        	   pw.println("</script>");
    	   }
       }
	}

}
