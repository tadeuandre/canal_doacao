package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import negocio.Beneficiario;

public class BeneficiarioDao {

	public static boolean incluir(Beneficiario beneficiario) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
					"INSERT into TBeneficiario (nome, endereco, tipo) values (?,?,?)");
			ps.setString(1, beneficiario.getNome());
			ps.setString(2, beneficiario.getEndereco());
			ps.setString(3, beneficiario.getTipo());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
