package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BeneficiarioDao;
import dao.DoacaoDao;
import negocio.Doacao;

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
		request.setAttribute("doacoes", DoacaoDao.obterLista());
		request.getRequestDispatcher("doacaoLista.jsp").forward(request, response);
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

		request.setAttribute("mensagem", doacao.toString());
		request.setAttribute("titulo", "Doação");			
		request.setAttribute("controller", "DoacaoController");
		
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
