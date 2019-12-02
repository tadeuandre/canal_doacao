package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoacaoDao;
import dao.ProdutoDao;
import negocio.Doacao;

public class ProdutoDoacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Doacao doacao;
       
    public ProdutoDoacaoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doacao = DoacaoDao.recuperar(Integer.valueOf(request.getParameter("id")));
		
		request.setAttribute("emprestimo", doacao);
		request.setAttribute("produtos", ProdutoDao.obterLista(false));

		request.getRequestDispatcher("associaProduto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		for(String idProduto : request.getParameterValues("produtos")){
			DoacaoDao.doar(doacao.getId(), Integer.valueOf(idProduto));
		}
		
		request.setAttribute("emprestimos", DoacaoDao.obterLista());
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}