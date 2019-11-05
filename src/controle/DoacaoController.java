package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BeneficiarioDao;
import dao.DoacaoDao;
import negocio.Doacao;

/**
 * Servlet implementation class DoacaoController
 */
@WebServlet("/DoacaoController")
public class DoacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoacaoController() {
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
		String faixaEtaria = request.getParameter("faixaEtaria");
		String genero = request.getParameter("genero");
		String tipo = request.getParameter("tipo");
		int idBeneficiario = Integer.valueOf(request.getParameter("idBeneficiario"));
		String produtos = request.getParameter("produtos");

		Doacao doacao = new Doacao();
		doacao.setBeneficiario(BeneficiarioDao.recuperar(idBeneficiario));
//		doacao.setProdutos(Beneficiario.pesquisa(produtos));

		DoacaoDao.incluir(doacao);
	}

}
