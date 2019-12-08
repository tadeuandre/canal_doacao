package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoupaDao;
import negocio.Roupa;

public class RoupaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoupaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("tela") != null) {
			request.getRequestDispatcher("roupaDetalhe.jsp").forward(request, response);
		} else {
			request.setAttribute("roupas", RoupaDao.obterLista());
			request.getRequestDispatcher("roupaLista.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idRoupa") != null) {
			int id = Integer.valueOf(request.getParameter("idRoupa"));
			
			RoupaDao.excluir(id);
			
			request.setAttribute("mensagem", "Roupa deletada!");
		} else {
			String faixaEtaria = request.getParameter("faixaEtaria");
			String tipo = request.getParameter("tipo");
			String tamanho = request.getParameter("tamanho");
			String marca = request.getParameter("marca");
			boolean isNovo = "S".equals(request.getParameter("novo"));
			String nome = request.getParameter("nome");
			Float quantidade = Float.valueOf((String) request.getParameter("quantidade"));

			Roupa roupa = new Roupa();
			roupa.setFaixaEtaria(faixaEtaria);
			roupa.setTamanho(tamanho);
			roupa.setTipo(tipo);
			roupa.setMarca(marca);
			roupa.setNovo(isNovo);
			roupa.setNome(nome);
			roupa.setQuantidade(quantidade);

			RoupaDao.incluir(roupa);

			request.setAttribute("mensagem", roupa.toString());
		}
		request.setAttribute("titulo", "Roupa");			
		request.setAttribute("controller", "RoupaController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

}
