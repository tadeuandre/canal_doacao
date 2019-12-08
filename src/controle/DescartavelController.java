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

public class DescartavelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DescartavelController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("tela") != null) {
			request.getRequestDispatcher("descartavelDetalhe.jsp").forward(request, response);
		} else {
			request.setAttribute("descartaveis", DescartavelDao.obterLista());
			request.getRequestDispatcher("descartavelLista.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("idDescartavel") != null) {
			int id = Integer.valueOf(request.getParameter("idDescartavel"));

			DescartavelDao.excluir(id);

			request.setAttribute("mensagem", "Game deletado!");
		} else {
			String nome = request.getParameter("nome");
			Float quantidade = Float.valueOf((String) request.getParameter("quantidade"));
			boolean isAberto = "S".equals(request.getParameter("aberto"));
			boolean isNovo = !isAberto;
			boolean isRemedio = "S".equals(request.getParameter("remedio"));
			String unidadeMedida = request.getParameter("unidadeMedida");
			Date validade = null;
			try {
				validade = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("validade"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Descartavel descartavel = new Descartavel();
			descartavel.setNovo(isNovo);
			descartavel.setAberto(isAberto);
			descartavel.setRemedio(isRemedio);
			descartavel.setUnidadeMedida(unidadeMedida);
			descartavel.setValidade(validade);
			descartavel.setNome(nome);
			descartavel.setQuantidade(quantidade);

			DescartavelDao.incluir(descartavel);

			request.setAttribute("mensagem", descartavel.toString());
		}
		request.setAttribute("titulo", "Descartavel");
		request.setAttribute("controller", "DescartavelController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
