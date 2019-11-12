package controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DescartavelDao;
import negocio.Descartavel;

/**
 * Servlet implementation class DescartavelController
 */
public class DescartavelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DescartavelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("descartaveis", DescartavelDao.obterLista());
		request.getRequestDispatcher("descartavelLista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String faixaEtaria = request.getParameter("faixaEtaria");
		String genero = request.getParameter("genero");
		String tipo = request.getParameter("tipo");
		boolean isAberto = "S".equals(request.getParameter("aberto"));
		boolean isRemedio = "S".equals(request.getParameter("remedio"));
		String unidadeMedida = request.getParameter("unidadeMedida");
		Date validade = null;
		try {
			validade = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("validade"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Descartavel descartavel = new Descartavel();
		descartavel.setAberto(isAberto);
		descartavel.setRemedio(isRemedio);
		descartavel.setUnidadeMedida(unidadeMedida);
		descartavel.setValidade(validade);

		DescartavelDao.incluir(descartavel);

		request.setAttribute("mensagem", descartavel.toString());
		request.setAttribute("titulo", "Descartavel");			
		request.setAttribute("controller", "DescartavelController");
		
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
