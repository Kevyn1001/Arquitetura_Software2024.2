package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import camadaDados.PerfilGateway;
import entidades.Perfil;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
