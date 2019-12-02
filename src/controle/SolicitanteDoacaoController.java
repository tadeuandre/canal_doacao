package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BeneficiarioDao;
import dao.DoacaoDao;
import negocio.Beneficiario;
import negocio.Doacao;

public class SolicitanteDoacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Doacao doacao;
       
    public SolicitanteDoacaoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doacao = DoacaoDao.recuperar(Integer.valueOf(request.getParameter("id")));
		
		request.setAttribute("doacao", doacao);
		request.setAttribute("beneficiarios", BeneficiarioDao.obterLista());

		request.getRequestDispatcher("solicitanteEmprestimo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doacao.setBeneficiario(new Beneficiario(Integer.valueOf(request.getParameter("idBeneficiario"))));
		
		DoacaoDao.associarBeneficiario(doacao);
		
		request.setAttribute("emprestimos", DoacaoDao.obterLista());
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}
}