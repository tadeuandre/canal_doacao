package controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if (request.getParameter("tela") != null) {
			request.getRequestDispatcher("doacaoDetalhe.jsp").forward(request, response);
		} else {
			request.setAttribute("doacoes", DoacaoDao.obterLista());
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("idDoacao") != null) {
//			int id = Integer.valueOf(request.getParameter("idEmprestimo"));
//			
//			EmprestimoProdutoDao.excluir(id);
//			
//			request.setAttribute("mensagem", "Empr�stimo deletado!");
//			request.setAttribute("titulo", "Empr�stimo");
//			request.setAttribute("controller", "EmprestimoController");
//			request.getRequestDispatcher("finaliza.jsp").forward(request, response);
		} else {
			Doacao doacao = new Doacao();
			try {
				doacao.setDataDivulgacao(new SimpleDateFormat("dd/MM/yyyy").parse((String) request.getParameter("tipo")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			DoacaoDao.incluir(doacao);

			request.setAttribute("mensagem", doacao.toString());
			request.setAttribute("titulo", "Doação");
			request.setAttribute("controller", "DoacaoController");
			request.getRequestDispatcher("finaliza.jsp").forward(request, response);
		}
	}

}
