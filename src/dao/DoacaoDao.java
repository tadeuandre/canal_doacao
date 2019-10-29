package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
