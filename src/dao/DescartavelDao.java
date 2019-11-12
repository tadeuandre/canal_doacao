package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Descartavel;

public class DescartavelDao {

	public static boolean incluir(Descartavel descartavel) {
		try {
			PreparedStatement ps = Conexao.obterConexao()
					.prepareStatement("INSERT into TDescartavel (unidade_medida, data_validade, nome, aberto, novo) values (?,?,?,?,?)");
			ps.setString(1, descartavel.getUnidadeMedida());
			ps.setDate(2, new java.sql.Date(descartavel.getValidade().getTime()));
			ps.setString(3, descartavel.getNome());
			ps.setString(4, descartavel.isAberto() ? "S" : "N");
			ps.setString(5, descartavel.isNovo() ? "S" : "N");
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Descartavel> obterLista() {
		List<Descartavel> lista = new ArrayList<Descartavel>();

		String sql = "SELECT * FROM TBrinquedo ORDER BY nome";

		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Descartavel descartavel = new Descartavel();
				descartavel.setId(rs.getInt("id"));
				descartavel.setNome(rs.getString("nome"));
				descartavel.setUnidadeMedida(rs.getString("unidade_medida"));
				descartavel.setQuantidade(rs.getFloat("quantidade"));
				descartavel.setAberto("S".equals(rs.getString("aberto")));
				descartavel.setNovo("S".equals(rs.getString("novo")));
				lista.add(descartavel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public static Descartavel recuperar(int id) {
		Descartavel descartavel = new Descartavel();
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("SELECT * FROM TDescartavel ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				descartavel.setId(rs.getInt("id"));
				descartavel.setNome(rs.getString("nome"));
				descartavel.setUnidadeMedida(rs.getString("unidade_medida"));
				descartavel.setQuantidade(rs.getFloat("quantidade"));
				descartavel.setAberto("S".equals(rs.getString("aberto")));
				descartavel.setNovo("S".equals(rs.getString("novo")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return descartavel;
	}

	public static void excluir(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement("DELETE * FROM TDescartavel WHERE id = ?");
			ps.setInt(0, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
