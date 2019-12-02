package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import negocio.Usuario;

public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idParaAlterar = (String) request.getParameter("idUsuarioParaAlterar");
		String idParaExcluir = (String) request.getParameter("idUsuarioParaExcluir");

		if (idParaAlterar != null) {
			int idUsuario = Integer.valueOf(idParaAlterar);
			for (Usuario u : UsuarioDao.obterLista()) {
				if (u.getId() == idUsuario) {
					request.setAttribute("usuarioSelecionado", u);
					break;
				}
			}
			request.getRequestDispatcher("usuarioCadastro.jsp").forward(request, response);
		} else if (idParaExcluir != null) {
			if (UsuarioDao.excluir(Integer.valueOf(idParaExcluir))) {
				request.setAttribute("usuarios", UsuarioDao.obterLista());
				request.getRequestDispatcher("usuarioLista.jsp").forward(request, response);				
			}
		} else {
			request.setAttribute("usuarios", UsuarioDao.obterLista());
			request.getRequestDispatcher("usuarioLista.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operacao = (String) request.getParameter("operacao");
		Usuario usuario = new Usuario(
			request.getParameter("nome"), 
			request.getParameter("email"),
			request.getParameter("senha")
		);

		if (operacao != null && "alterar".equals(operacao)) {
			usuario.setId(Integer.valueOf(request.getParameter("id")));
			if (UsuarioDao.alterar(usuario)) {
				this.doGet(request, response);
			}
		} else {
			if (UsuarioDao.incluir(usuario)) {

				this.doGet(request, response);

			} else {
				request.setAttribute("msg", "Problemas na inclusão!!!");

				request.getRequestDispatcher("usuarioCadastro.jsp").forward(request, response);
			}			
		}


	}
}