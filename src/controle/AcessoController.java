package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoacaoDao;
import dao.UsuarioDao;
import negocio.Usuario;

public class AcessoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcessoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Usuario usuario = UsuarioDao.validar(email, senha);
		
		if(usuario != null) {			
			request.getSession().setAttribute("user", usuario);
			request.setAttribute("doacoes", DoacaoDao.obterLista());
			request.getRequestDispatcher("main.jsp").forward(request, response);		
		} else {			
			request.setAttribute("invalido", true);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
