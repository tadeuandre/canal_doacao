package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BrinquedoDao;
import negocio.Brinquedo;

public class BrinquedoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BrinquedoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("tela") != null) {
			request.getRequestDispatcher("brinquedoDetalhe.jsp").forward(request, response);
		} else {
			request.setAttribute("brinquedos", BrinquedoDao.obterLista());
			request.getRequestDispatcher("brinquedoLista.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idGame") != null) {
			int id = Integer.valueOf(request.getParameter("idGame"));
			
			BrinquedoDao.excluir(id);
			
			request.setAttribute("mensagem", "Brinquedo deletado!");
		} else {
			Brinquedo brinquedo = new Brinquedo(
					request.getParameter("nome"),
					Float.valueOf(request.getParameter("quantidade")),
					Boolean.valueOf(request.getParameter("isNovo")),
					request.getParameter("tipo"),
					request.getParameter("faixaEtaria"),
					request.getParameter("genero")
				);
		
			BrinquedoDao.incluir(brinquedo);
			
			request.setAttribute("mensagem", brinquedo.toString());
		}
		request.setAttribute("titulo", "Brinquedo");
			
		request.setAttribute("controller", "BrinquedoController");

		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
