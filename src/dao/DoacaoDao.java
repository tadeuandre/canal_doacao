package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import modelo.Produto;
import negocio.Doacao;

public class DoacaoDao {

	public static boolean incluir(Doacao doacao) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"INSERT into TDoacao (dataDivulgacao) values (?)");
			ps.setDate(1, new Date(doacao.getDataDivulgacao().getTime()));
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Doacao> obterLista() {
		List<Doacao> lista = new ArrayList<Doacao>();

		String sql = "SELECT * FROM TDoacao";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Doacao doacao = new Doacao();
				doacao.setId(rs.getInt("id"));
				doacao.setBeneficiario(BeneficiarioDao.recuperar(rs.getInt("idBeneficiario")));
				doacao.setProdutos(ProdutoDao.obterListaPorDoacao(rs.getInt("idDoacao")));
				doacao.setDataDivulgacao(rs.getDate("dataDivulgacao"));
				lista.add(doacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static Doacao recuperar(int id) {
		Doacao doacao = new Doacao();
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("SELECT * FROM TDoacao ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				doacao.setId(rs.getInt("id"));
				doacao.setBeneficiario(BeneficiarioDao.recuperar(rs.getInt("idDoacao")));
//				doacao.setProdutos((rs.getString("endereco"));
				doacao.setDataDivulgacao(rs.getDate("nome"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return doacao;
	}

	public static void excluir(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("DELETE FROM TDoacao ID = ?");
			ps.setInt(0, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean doar(int idDoacao, int idProduto) {
		try {

			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT INTO TDoacaoProduto (idDoacao, idProduto) VALUES (?,?)");

			ps.setInt(1, idDoacao);
			ps.setInt(2, idProduto);

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static Doacao associarBeneficiario(Doacao doacao) {
		try {
			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("UPDATE TEmprestimo SET idSolicitante = ? WHERE id = ?");

			ps.setInt(1, doacao.getBeneficiario().getId());
			ps.setInt(2, doacao.getId());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return doacao;
	}

	private static boolean cancelarDoacao(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("DELETE FROM TDoacao WHERE id = ?");

			ps.setInt(1, id);

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
