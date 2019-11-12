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
			for (Produto produto : doacao.getProdutos()) {
				PreparedStatement ps = Conexao.obterConexao().prepareStatement(
						"INSERT into TDoacao (id_beneficiario, id_doacao_produto, dt_divulgacao) values (?,?,?)");
				ps.setInt(1, doacao.getBeneficiario().getId());
				ps.setInt(2, produto.getId());
				ps.setDate(3, new Date(doacao.getDataDivulgacao().getTime()));
				ps.execute();
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Doacao> obterLista() {
		List<Doacao> lista = new ArrayList<Doacao>();

		String sql = "SELECT * FROM TDoacao ORDER BY nome";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Doacao doacao = new Doacao();
				doacao.setId(rs.getInt("id"));
				doacao.setBeneficiario(BeneficiarioDao.recuperar(rs.getInt("id_beneficiario")));
//				doacao.setProdutos((rs.getString("endereco"));
				doacao.setDataDivulgacao(rs.getDate("nome"));
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
				doacao.setBeneficiario(BeneficiarioDao.recuperar(rs.getInt("id_doacao")));
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

}
