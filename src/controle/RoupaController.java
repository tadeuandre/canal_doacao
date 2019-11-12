package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoacaoDao;
import dao.RoupaDao;
import negocio.Roupa;

/**
 * Servlet implementation class RoupaController
 */
public class RoupaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoupaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("roupas", DoacaoDao.obterLista());
		request.getRequestDispatcher("roupaLista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String faixaEtaria = request.getParameter("faixaEtaria");
		String genero = request.getParameter("genero");
		String tipo = request.getParameter("tipo");
		String tamanho = request.getParameter("tamanho");
		String marca = request.getParameter("marca");
		boolean isNovo = "S".equals(request.getParameter("novo"));
		String nome = request.getParameter("tipo");

		Roupa roupa = new Roupa();
		roupa.setFaixaEtaria(faixaEtaria);
		roupa.setTamanho(tamanho);
		roupa.setTipo(tipo);
		roupa.setMarca(marca);
		roupa.setNovo(isNovo);
		roupa.setNome(nome);

		RoupaDao.incluir(roupa);

		request.setAttribute("mensagem", roupa.toString());
		request.setAttribute("titulo", "Roupa");			
		request.setAttribute("controller", "RoupaController");
		
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
