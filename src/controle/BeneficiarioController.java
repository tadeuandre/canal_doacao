package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BeneficiarioDao;
import negocio.Beneficiario;

public class BeneficiarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeneficiarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("beneficiarios", BeneficiarioDao.obterLista());
		request.getRequestDispatcher("beneficiarioLista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String tipo = request.getParameter("tipo");

		Beneficiario beneficiario = new Beneficiario();
		beneficiario.setNome(nome);
		beneficiario.setEndereco(endereco);
		beneficiario.setTipo(tipo);

		BeneficiarioDao.incluir(beneficiario);			
	}

}
