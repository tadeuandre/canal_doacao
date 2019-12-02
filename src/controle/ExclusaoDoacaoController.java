package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoacaoDao;

public class ExclusaoDoacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExclusaoDoacaoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("emprestimos", DoacaoDao.obterLista());
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DoacaoDao.excluir(Integer.valueOf(request.getParameter("id")));
		
		request.setAttribute("mensagem", "Emprestimo cancelado com sucesso!");

		request.setAttribute("titulo", "Empr�stimo");
			
		request.setAttribute("controller", "ExclusaoEmprestimoController");
	
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}
}