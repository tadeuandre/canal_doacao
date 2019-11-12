package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Beneficiario;

public class BeneficiarioDao {

	public static List<Beneficiario> obterLista() {
		List<Beneficiario> lista = new ArrayList<Beneficiario>();

		String sql = "SELECT * FROM TBeneficiario ORDER BY nome";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Beneficiario beneficiario = new Beneficiario();
				beneficiario.setId(rs.getInt("id"));
				beneficiario.setTipo(rs.getString("tipo"));
				beneficiario.setEndereco(rs.getString("endereco"));
				beneficiario.setNome(rs.getString("nome"));
				lista.add(beneficiario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static boolean incluir(Beneficiario beneficiario) {
		try {
			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TBeneficiario (nome, endereco, tipo) values (?,?,?)");
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

	public static Beneficiario recuperar(int id) {
		Beneficiario beneficiario = new Beneficiario();
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("SELECT * FROM TBeneficiario ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				beneficiario.setId(rs.getInt("id"));
				beneficiario.setNome(rs.getString("nome"));
				beneficiario.setTipo(rs.getString("tipo"));
				beneficiario.setEndereco(rs.getString("endereco"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return beneficiario;
	}
	
	public static void excluir(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("DELETE FROM TBeneficiario ID = ?");
			ps.setInt(0, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
