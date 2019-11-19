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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrinquedoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("brinquedos", BrinquedoDao.obterLista());
		request.getRequestDispatcher("brinquedoLista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String faixaEtaria = request.getParameter("faixaEtaria");
		String genero = request.getParameter("genero");
		String tipo = request.getParameter("tipo");

		Brinquedo brinquedo = new Brinquedo();
		brinquedo.setFaixaEtaria(faixaEtaria);
		brinquedo.setGenero(genero);
		brinquedo.setTipo(tipo);

		BrinquedoDao.incluir(brinquedo);

		request.setAttribute("mensagem", brinquedo.toString());
		request.setAttribute("titulo", "Brinquedo");			
		request.setAttribute("controller", "BrinquedoController");
		
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
