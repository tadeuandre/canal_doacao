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
       
    public BeneficiarioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("tela") != null) {
			request.getRequestDispatcher("beneficiarioDetalhe.jsp").forward(request, response);
		} else {
			request.setAttribute("beneficiarios", BeneficiarioDao.obterLista());
			request.getRequestDispatcher("beneficiarioLista.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idBeneficiario") != null) {
			int id = Integer.valueOf(request.getParameter("idBeneficiario"));
			
			BeneficiarioDao.excluir(id);
			
			request.setAttribute("mensagem", "Beneficiario deletado!");
		} else {
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String tipo = request.getParameter("tipo");

			Beneficiario beneficiario = new Beneficiario();
			beneficiario.setNome(nome);
			beneficiario.setEndereco(endereco);
			beneficiario.setTipo(tipo);

			BeneficiarioDao.incluir(beneficiario);

			request.setAttribute("mensagem", beneficiario.toString());
		}
		request.setAttribute("titulo", "Beneficiario");			
		request.setAttribute("controller", "BeneficiarioController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
